import Company.*;

public class Main {
    public static final double HIRE_PERCENT = 0.10;
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 90; ++i) {
            company.hireEmployee(new TopManager());
            company.hireEmployee(new SalesManager());
            company.hireEmployee(new Clerk());
        }

        company.getEmployees().stream()
                .filter(e -> e instanceof SalesManager)
                .forEach(e -> ((SalesManager) e).saleProduct(company));

        System.out.println("Company income: " + Math.round(company.getCompanyIncome()));
        company.calculateSalaries();
        System.out.println();

        company.getTopSalaryStaff(5).stream().forEach(e -> System.out.println(e.getMonthSalary()));
        System.out.println();

        int employeesToHire = (int) Math.round(company.getEmployees().size() * HIRE_PERCENT);
        for (int i = 0; i < employeesToHire; ++i) {
            company.fireEmployee(company.getEmployees().get((int)(Math.random() * company.getEmployees().size())));
        }

        company.getTopSalaryStaff(5).stream().forEach(e -> System.out.println(e.getMonthSalary()));
        System.out.println();


        SalesManager vasya = new SalesManager();
        TopManager boss = new TopManager();
        // Жили были босс и вася
        company.hireEmployee(boss);
        company.hireEmployee(vasya);
        company.calculateSalaries();

        // Вначале вася ничего не делал
        System.out.println("Company income before Vasya work: " + Math.round(company.getCompanyIncome()));
        System.out.println("Boss income: " + Math.round(boss.getMonthSalary()));

        // Но жизнь взяла своё - пришлось Васе батрачить :)
        for (int i = 0; i < 100; i++) {
            vasya.saleProduct(company);
        }
        company.calculateSalaries();

        // Но где бонус босса?
        System.out.println("Company income after Vasya: " + Math.round(company.getCompanyIncome()));
        System.out.println("Boss income: " + Math.round(boss.getMonthSalary()));
   }
}
