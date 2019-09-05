package Company;

public class TopManager implements Employee {

    private final double salary;
    private double prize;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    protected void generatePrize(double income) {
        if (income > 5000000.0 && income < 10000000.0) {
            prize = 150000.0 + Math.random() * 300000.0;
        } else if (income > 10000000.0) {
            prize = 50000.0 + Math.random() * 450000.0;
        } else {
            prize = 0.0;
        }
    }

    @Override
    public double getMonthSalary() {
        return salary + prize;
    }
}
