package Accounts;

import java.time.LocalDate;

public class DepositAccount extends  CheckAccount {
    private static final int DEPOSIT_MONTH_PERIOD = 1;
    private LocalDate addDate;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
        addDate = LocalDate.now();
    }

    public DepositAccount() {
        this(0);
    }

    public void addMoney(double money) {
        moneyAmount += money;
        addDate = LocalDate.now();
    }

    public double getMoney(double money, LocalDate date) {
        if (checkDate(date) && money <= moneyAmount) {
            moneyAmount -= money;
            return moneyAmount;
        } else {
            return 0;
        }
    }

    public boolean checkDate (LocalDate date) {
        return date.isAfter(addDate.plusMonths(DEPOSIT_MONTH_PERIOD));
    }

    public void transfer(CheckAccount check, Double moneyToTransfer, LocalDate date) {
        if (moneyToTransfer <= moneyAmount) {
            check.addMoney(getMoney(moneyToTransfer, date));
        }
    }
}
