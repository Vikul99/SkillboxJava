package Company;

public class TopManager implements Employee {

    private double salary;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public void calculateSalary(double companyIncome) {
        double prize = 0.0;
        if (companyIncome > 5000000.0 && companyIncome < 10000000.0) {
            prize = 150000.0 + Math.random() * 300000.0;
        }
        if (companyIncome > 10000000.0) {
            prize = 50000.0 + Math.random() * 450000.0;
        }
        salary += prize;
    }
}
