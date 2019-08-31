package Company;

public class Clerk extends Company implements Employee {

    private double salary;

    public Clerk() {
        salary = 50000.0 + Math.random() * 100000.0 ;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
