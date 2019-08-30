package Clients;

public class Entity extends Client {
    private static final double ENTITY_COMMISSION = 0.01;
    @Override
    public void addMoney(Double money) {
        balance += money;
    }

    @Override
    public void getMoney(Double money) {
        if (money < balance) {
            balance -= money * (1 + ENTITY_COMMISSION);
        }
    }
}
