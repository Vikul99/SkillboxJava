import java.time.LocalDate;

public class DepositAccount extends  CheckAccount {
    private LocalDate addDate;
    private boolean wasMoneyAdded = false;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public DepositAccount() {
        super();
    }

    public void addMoney(double money) {
        moneyAmount += money;
        addDate = LocalDate.now();
        wasMoneyAdded = true;
    }

    public double getMoney(double money, LocalDate date) {
        if (money > moneyAmount) {
            return 0;
        }
        if (!wasMoneyAdded) {
            moneyAmount -= money;
            return moneyAmount;
        } else if (date.getMonthValue() - addDate.getMonthValue() >= 1) {
            moneyAmount -= money;
            return moneyAmount;
        } else {
            return moneyAmount;
        }
    }

}
