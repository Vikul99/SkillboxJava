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

        for (Employee employee : company.getTopSalaryStaff(5)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println();

        int employeesToHire = (int) Math.round(company.getEmployees().size() * HIRE_PERCENT);
        for (int i = 0; i < employeesToHire; ++i) {
            company.fireEmployee(company.getEmployees().get((int)(Math.random() * company.getEmployees().size())));
        }

        for (Employee employee : company.getTopSalaryStaff(5)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println();
    }
}
