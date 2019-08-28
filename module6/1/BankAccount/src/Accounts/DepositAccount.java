package Accounts;

import java.time.LocalDate;

public class DepositAccount extends  CheckAccount {
    private static final int DEPOSIT_MONTH_PERIOD = 1;
    private LocalDate addDate;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public DepositAccount() {
        super();
    }

    public void addMoney(double money) {
        moneyAmount += money;
        addDate = LocalDate.now();
    }

    public double getMoney(double money, LocalDate date) {
        if (money > moneyAmount) {
            return 0;
        }
        if (addDate == null) {
            moneyAmount -= money;
            return moneyAmount;
        } else if (date.isAfter(addDate.plusMonths(DEPOSIT_MONTH_PERIOD))) {
            moneyAmount -= money;
            return moneyAmount;
        } else {
            return moneyAmount;
        }
    }
}
