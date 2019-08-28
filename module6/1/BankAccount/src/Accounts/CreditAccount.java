package Accounts;

public class CreditAccount extends CheckAccount {
    private static final double COMMISSION = 0.01;

    public CreditAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public CreditAccount() {
        super();
    }

    public double getMoney(double money) {
        if (money <= moneyAmount) {
            moneyAmount -= money * (1 - COMMISSION);
            return moneyAmount;
        } else {
            return 0;
        }
    }
}
