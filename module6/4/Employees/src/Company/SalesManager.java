package Company;

public class SalesManager implements Employee {

    private static final double PERCENT_OF_SALE = 0.05;
    private double salesAmount;

    private double salary;

    public SalesManager() {
        salary = 100000.0 + Math.random() * 250000.0 ;
    }

    public void saleProduct(Company company) {
        double productPrice = 100000.0 + Math.random() * 900000.0;
        salesAmount += productPrice;
    }

    protected double getSalesAmount() {
        return salesAmount;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public void calculateSalary(double companyIncome) {
        salary = salesAmount * PERCENT_OF_SALE;
    }
}
