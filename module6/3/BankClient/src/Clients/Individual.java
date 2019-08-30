package Clients;

public class Individual extends Client {
    private static double COMMISSION_STEP = 1000.0;
    private static double MIN_COMMISSION = 0.005;
    private static double MAX_COMMISSION = 0.01;

    @Override
    public void addMoney(Double money) {
        if (money < COMMISSION_STEP) {
            balance += money * (1 - MAX_COMMISSION);
        } else {
            balance += money * (1 - MIN_COMMISSION);
        }
    }

    @Override
    public void getMoney(Double money) {
        if (money <= balance) {
            balance -= money;
        }
    }
}
