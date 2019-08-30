package Accounts;

public class CheckAccount {
    protected double balance;

    public CheckAccount(double money) {
        balance = money;
    }

    public CheckAccount() {
        this(0.0);
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double money) {
        balance += money;
    }

    public double getMoney(double money) {
        if (money <= balance) {
            balance -= money;
            return  balance;
        } else {
            return 0;
        }
    }

    public void transfer(CheckAccount check, Double moneyToTransfer) {
        if (!(getMoney(moneyToTransfer) == 0)) {
            check.addMoney(moneyToTransfer);
        }
    }
}