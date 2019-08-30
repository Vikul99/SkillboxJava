package Clients;

public class Physical extends Client {
    @Override
    public void addMoney(Double money) {
        balance += money;
    }

    @Override
    public void getMoney(Double money) {
        if (money <= balance) {
            balance -= money;
        }
    }
}
