package Company;

public class TopManager implements Employee {

    private double salary;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    @Override
    public double getMonthSalary(Company company) {
        if (company.companyIncome < 1000000.0) {
            salary -= 250000.0 + Math.random() * 500000.0;
        }
        if (company.companyIncome > 1000000.0 && company.companyIncome < 5000000.0) {
            salary -= 150000.0 + Math.random() * 300000.0;
        }
        if (company.companyIncome > 10000000.0 ) {
            double prize = 50000.0 + Math.random() * 450000.0;
            salary += prize;
        }
        return salary;
    }
}
