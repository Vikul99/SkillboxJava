import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong Format. Correct format: \n" +
                    "\tadd Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        if (!isEmailValid(components[2])) {
            throw new IllegalArgumentException("Wrong Email Format. Correct format: \n" +
                    "\tvasily.petrov@gmail.com");
        }

        if (!isTelephoneNumberValid(components[3])) {
            throw new IllegalArgumentException("Wrong Telephone Number Format. Correct format: \n" +
                    "\t+79215637722");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public boolean isEmailValid(String email) {
        return email.matches("\\w+\\.?\\w+@\\w+\\.\\w{2,6}");
    }

    public boolean isTelephoneNumberValid(String telephoneNumber) {
        return telephoneNumber.matches("^\\+\\d+$");
    }


    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}