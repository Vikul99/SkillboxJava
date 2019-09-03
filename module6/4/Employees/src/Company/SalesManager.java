package Company;

public class SalesManager implements Employee {

    private static final double PERCENT_OF_SALE = 0.05;

    private double salary;

    public SalesManager() {
        salary = 100000.0 + Math.random() * 250000.0 ;
    }


    public void saleProduct(Company company) {
        double productPrice = 100000.0 + Math.random() * 900000.0;
        company.companyIncome += productPrice;
        salary += productPrice * PERCENT_OF_SALE;
    }

    @Override
    public double getMonthSalary(Company company) {
        return salary;
    }
}
