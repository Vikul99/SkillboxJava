public class CreditAccount extends CheckAccount {
    private static final double COMMISSION = 0.01;

    public CreditAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public CreditAccount() {
        super();
    }

    public double getMoney(double money) {
        if (money > moneyAmount) {
            return 0;
        } else {
            moneyAmount = moneyAmount - money - COMMISSION * money;
            return moneyAmount;
        }
    }
}
