package Company;

public class TopManager implements Employee {

    private final double salary;
    private double prize = 0.0;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    @Override
    public double getMonthSalary(Company company) {
        if (company.getCompanyIncome() > 5000000.0 && company.getCompanyIncome() < 10000000.0) {
            prize = 150000.0 + Math.random() * 300000.0;
        }
        if (company.getCompanyIncome() > 10000000.0 ) {
            prize = 50000.0 + Math.random() * 450000.0;
        }
        return salary + prize;
    }
}
