import java.time.LocalDate;

public class BankOperation {
    private String accountType;
    private String accountNumber;
    private String value;
    private LocalDate operationDate;
    private String reference;
    private String description;
    private double income;
    private double withdraw;

    public BankOperation(String accountType, String accountNumber, String value, LocalDate operationDate, String reference, String description, double income, double withdraw) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.value = value;
        this.operationDate = operationDate;
        this.reference = reference;
        this.description = description;
        this.income = income;
        this.withdraw = withdraw;
    }

    public double getIncome() {
        return income;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public String getDescription() {
        return description;
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
