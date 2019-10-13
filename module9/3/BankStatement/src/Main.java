import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static String operationsFile = "data/movementList.csv";
    private static String dateFormat = "dd.MM.yy";


    public static void main(String[] args) {
        List<BankOperation> operations = loadOperationsFromFile();

        System.out.println("Общий приход: " + operations.stream().mapToDouble(BankOperation::getIncome).sum());
        System.out.println("Общий расход: " + operations.stream().mapToDouble(BankOperation::getWithdraw).sum());

        ArrayList<BankOperation> consumptionOperations = new ArrayList<>();
        for (BankOperation operation: operations) {
            if (operation.getWithdraw() != 0) {
                consumptionOperations.add(operation);
            }
        }

        ArrayList<BankOperation> incomeOperations = new ArrayList<>();
        for (BankOperation operation: operations) {
            if (operation.getIncome() != 0) {
                incomeOperations.add(operation);
            }
        }

        System.out.println("\nСводный отчет о приходе: \n" +
                "==============");
        for (String key :  getReport(incomeOperations).keySet()) {
            System.out.println(key + " : " +  getReport(incomeOperations).get(key));
        }

        System.out.println("\nСводный отчет о расходе: \n" +
                "==============");
        for (String key :  getReport(consumptionOperations).keySet()) {
            System.out.println(key + " : " +  getReport(consumptionOperations).get(key));
        }

        System.out.println("\nСводный отчет: \n" +
                "==============");
        operations.stream()
                .collect(Collectors.groupingBy(BankOperation::getDescription,
                        Collectors.mapping(Summary::fromOperation,
                                Collectors.reducing(Summary::merge)
                        )))
                .forEach((s, summary) -> System.out.println(s + ":\t" + summary.get().income + "\t" + summary.get().withdraw));
    }

    private static List<BankOperation> loadOperationsFromFile() {
        ArrayList<BankOperation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(operationsFile));

            for (int i = 1; i < lines.size(); ++i) {
                String[] fragments = lines.get(i).replaceAll("\"([^\"]*),([^\"]*)\"", "$1.$2").split(",");

                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + lines.get(i));
                    continue;
                }

                operations.add(new BankOperation(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        LocalDate.parse(fragments[3], DateTimeFormatter.ofPattern(dateFormat)),
                        fragments[4],
                        getCompanyName(fragments[5]),
                        Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])
                ));
            }
       }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return operations;
    }

    private static String getCompanyName(String str) {
        String[] details = str.split("\\\\|/");
        String[] tmp = details[details.length - 1].split("\\d+\\.");
        String consumptionPlace = tmp[0].trim();
        return consumptionPlace;
    }

    private static TreeMap<String, Double> getReport(List<BankOperation> operations) {
        TreeMap<String, Double> report = new TreeMap<>();
        for (BankOperation operation : operations) {
            String companyName = operation.getDescription();
            double amount = 0.0;
            for (BankOperation o : operations) {
                if (companyName.equals(o.getDescription())) {
                    amount += o.getWithdraw();
                    amount += o.getIncome();
                }
                report.put(companyName.trim(), amount);
            }
        }
        return report;
    }

    private static class Summary {
        double income;
        double withdraw;

        Summary(double income, double withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        static Summary merge(Summary s1, Summary s2) {
            return new Summary(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }

        static Summary fromOperation(BankOperation o) {
            return new Summary(o.getIncome(), o.getWithdraw());
        }
    }
}

