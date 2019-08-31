package Company;

public class TopManager extends Company implements Employee {

    private double salary;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    @Override
    public double getMonthSalary() {
        if (companyIncome > 10000000.0 ) {
            double prize = 50000.0 + Math.random() * 450000.0;
            salary += prize;
        }
        return salary;
    }
}
