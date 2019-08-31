import Company.*;

public class Main {
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

        for (Employee employee : company.getLowestSalaryStaff(5)) {
            System.out.println(employee.getMonthSalary());
        }
    }
}
