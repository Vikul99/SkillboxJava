package Company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    protected double companyIncome;
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double getCompanyIncome() {
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count, Company company) {
        Collections.sort(employees, new MaxSalaryComparator(company));
        return employees.stream().limit(count).collect(Collectors.toList());
    }

    public List<Employee> getLowestSalaryStaff(int count, Company company) {
        Collections.sort(employees, new MinSalaryComparator(company));
        return employees.stream().limit(count).collect(Collectors.toList());
    }
}
