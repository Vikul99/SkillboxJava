import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String operationsFile = "data/movementList.csv";
    private static String dateFormat = "dd.MM.yy";
    private static final String CONSUMPTION_PLACE_REGEX = ".+\\\\";


    public static void main(String[] args) {
        List<BankOperation> operations = loadOperationsFromFile();

        System.out.println("Общий приход: " + operations.stream().mapToDouble(BankOperation::getIncome).sum());
        System.out.println("Общий расход: " + operations.stream().mapToDouble(BankOperation::getConsumption).sum());

        for (BankOperation operation: operations) {
            if (operation.getConsumption() != 0) {
                System.out.println(getConsumptionPlace(operation).trim());
            }
        }

    }

    private static List<BankOperation> loadOperationsFromFile() {
        ArrayList<BankOperation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(operationsFile));
            for (int i = 1; i < lines.size(); ++i) {
                String[] fragments = lines.get(i).split(",");

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
                        fragments[5],
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

    private static String getConsumptionPlace(BankOperation o) {
        String[] fragments = o.getOperationDetails().split(CONSUMPTION_PLACE_REGEX);
        String[] details = fragments[1].split("\\d+");
        String consumptionPlace = details[0];
        return consumptionPlace;
    }
}
