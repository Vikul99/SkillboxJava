import Clients.Client;
import Clients.Entity;
import Clients.Individual;
import Clients.Physical;

public class Main {
    public static void main(String[] args) {
        Client physical = new Physical();
        physical.addMoney(1000.0);
        System.out.println("Баланс физического лица: " + physical.getBalance());
        physical.getMoney(200.0);
        System.out.println("Баланс физического лица: " + physical.getBalance());
        System.out.println();

        Client entity = new Entity();
        entity.addMoney(100000.0);
        System.out.println("Баланс юридического лица: " + entity.getBalance());
        entity.getMoney(3000.0);
        System.out.println("Баланс юридического лица: " + entity.getBalance());
        System.out.println();

        Client individual = new Individual();
        individual.addMoney(50000.0);
        System.out.println("Баланс индивидуального предпринимателя: " + individual.getBalance());
        individual.getMoney(35000.0);
        System.out.println("Баланс индивидуального предпринимателя: " + individual.getBalance());
    }
}
