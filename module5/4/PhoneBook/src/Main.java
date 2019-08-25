import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static final String PHONE_NUMBER_REGEX = "^([7|8])?(\\d{3})(\\d{3})(\\d{2})(\\d{2}$)";
    public static TreeMap<String, String> phoneBook = new TreeMap<>();

    public static void printPhoneBook() {
        if (phoneBook.size() == 0) {
            System.out.println("Телефонная книга пуста");
        } else {
            for (String key: phoneBook.keySet()) {
            System.out.println(key + " : " + phoneBook.get(key));
            }
        }
    }

    public static String getKey(String value) {
        for (String key: phoneBook.keySet()) {
            if (value.equals(phoneBook.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите имя или номер абонента\n" +
                    "Для просмотра телефонной книги введите команду LIST: ");

            String input = scanner.nextLine();

           if (input.equals("LIST")) {
               printPhoneBook();
               continue;
           }

           if (input.matches("(.*[0-9]+.*)")) {
               input = input.replaceAll("\\D", "");
               String phoneNumber = input.replaceFirst(PHONE_NUMBER_REGEX,"+7 $2 $3 $4-$5");
               if (phoneBook.containsValue(phoneNumber)) {
                   System.out.println(getKey(phoneNumber) + " : " + phoneNumber);
               } else {
                   System.out.println("Введите имя абонента: ");
                   String phoneName = scanner.nextLine();
                   phoneBook.put(phoneName, phoneNumber);
               }
           } else if (phoneBook.containsKey(input)) {
               System.out.println(input + " : " + phoneBook.get(input));
           } else {
               System.out.println("Введите номер абонента: ");
               String phoneNumber = scanner.nextLine().replaceAll("\\D", "");
               if (phoneNumber.matches(PHONE_NUMBER_REGEX)) {
                   phoneNumber = phoneNumber.replaceFirst(PHONE_NUMBER_REGEX,"+7 $2 $3 $4-$5");
               } else {
                   System.out.println("Неверный формат номера абонента");
                   continue;
               }
               phoneBook.put(input, phoneNumber);
           }
        }
    }
}
