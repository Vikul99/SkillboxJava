package Company;

public interface Employee {
    double getMonthSalary();
    default void calculateSalary(double companyIncome) {
    }
}
