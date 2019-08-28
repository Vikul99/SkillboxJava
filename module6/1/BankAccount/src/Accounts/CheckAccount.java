package Accounts;

public class CheckAccount {
    protected double moneyAmount;

    public CheckAccount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public CheckAccount() {
        this.moneyAmount = 0.0;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void addMoney(double money) {
        this.moneyAmount += money;
    }

    public double getMoney(double money) {
        if (money > moneyAmount) {
            return 0;
        } else {
            moneyAmount -= money;
            return moneyAmount;
        }
    }

    public void transfer(CheckAccount check, Double moneyToTransfer) {
        getMoney(moneyToTransfer);
        check.addMoney(moneyToTransfer);
    }
}
