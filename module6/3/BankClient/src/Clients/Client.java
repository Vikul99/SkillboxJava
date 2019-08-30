package Clients;

public abstract class Client {
    protected double balance;

    public abstract void addMoney(Double money);
    public abstract void getMoney(Double money);
    public double getBalance() {
        return balance;
    }

}
