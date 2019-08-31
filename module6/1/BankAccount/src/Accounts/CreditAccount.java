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
        if (money <= balance) {
            balance -= money * (1 + COMMISSION);
            return balance;
        } else {
            return -1;
        }
    }
}
