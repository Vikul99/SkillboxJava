package Accounts;

import java.time.LocalDate;

public class DepositAccount extends  CheckAccount {
    private static final int DEPOSIT_PERIOD = 1;
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
        } else if (Math.abs(date.getMonthValue() - addDate.getMonthValue()) >= DEPOSIT_PERIOD) {
            moneyAmount -= money;
            return moneyAmount;
        } else {
            return moneyAmount;
        }
    }
}
