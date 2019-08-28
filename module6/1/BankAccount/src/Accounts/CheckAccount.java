package Accounts;

import java.time.LocalDate;

public class CheckAccount {
    protected double moneyAmount;

    public CheckAccount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public CheckAccount() {
        this(0.0);
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void addMoney(double money) {
        this.moneyAmount += money;
    }

    public double getMoney(double money) {
        if (money <= moneyAmount) {
            moneyAmount -= money;
            return  moneyAmount;
        } else {
            return 0;
        }
    }

    public double getMoney(double money, LocalDate date) {
        return 0;
    }

    public void transfer(CheckAccount check, Double moneyToTransfer) {
        if (moneyToTransfer <= moneyAmount) {
            check.addMoney(getMoney(moneyToTransfer));
        }
    }
}