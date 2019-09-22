import java.time.LocalDate;

public class BankOperation {
    String accountType;
    String accountNumber;
    String value;
    LocalDate operationDate;
    String reference;
    String operationDetails;
    double income;
    double consumption;

    public BankOperation(String accountType, String accountNumber, String value, LocalDate operationDate, String reference, String operationDetails, double income, double consumption) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.value = value;
        this.operationDate = operationDate;
        this.reference = reference;
        this.operationDetails = operationDetails;
        this.income = income;
        this.consumption = consumption;
    }

    public double getIncome() {
        return income;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getOperationDetails() {
        return operationDetails;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getValue() {
        return value;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public String getReference() {
        return reference;
    }
}
