package Accounts;

import java.time.LocalDate;

public class DepositAccount extends  CheckAccount {
    private static final int DEPOSIT_MONTH_PERIOD = 1;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
        MyTime.getInstance().setNow(LocalDate.now());
    }

    public DepositAccount() {
        this(0);
    }

    public void addMoney(double money) {
        balance += money;
        MyTime.getInstance().setNow(LocalDate.now());
    }

    public double getMoney(double money) {
        if (MyTime.getInstance().now().isAfter(LocalDate.now().plusMonths(DEPOSIT_MONTH_PERIOD)) && money <= balance) {
            balance -= money;
            return balance;
        } else {
            return -1;
        }
    }
}
