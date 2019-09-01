package Company;

public class TopManager implements Employee {

    private double salary;

    public TopManager() {
        salary = 250000.0 + Math.random() * 750000.0 ;
    }

    @Override
    public double getMonthSalary() {
        if (Company.companyIncome < 1000000.0) {
            salary -= 250000.0 + Math.random() * 500000.0;
        }
        if (Company.companyIncome > 1000000.0 && Company.companyIncome < 5000000.0) {
            salary -= 150000.0 + Math.random() * 300000.0;
        }
        if (Company.companyIncome > 10000000.0 ) {
            double prize = 50000.0 + Math.random() * 450000.0;
            salary += prize;
        }
        return salary;
    }
}
