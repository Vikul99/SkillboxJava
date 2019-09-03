package Company;

public class Clerk implements Employee {

    protected double salary;

    public Clerk() {
        salary = 50000.0 + Math.random() * 100000.0 ;
    }

    @Override
    public double getMonthSalary(Company company) {
        return salary;
    }
}
