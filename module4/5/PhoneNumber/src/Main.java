import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("Введите номер телефона: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber= scanner.nextLine();

        phoneNumber = phoneNumber.replaceAll("\\D+", "");
        System.out.println(phoneNumber);

        StringBuilder templatePhoneNumber = new StringBuilder("+7 ");
        if (phoneNumber.charAt(0) == '7' || phoneNumber.charAt(0) == '8') {
            templatePhoneNumber.append(phoneNumber.charAt(1));
            templatePhoneNumber.append(phoneNumber.charAt(2));
            templatePhoneNumber.append(phoneNumber.charAt(3));
            templatePhoneNumber.append(" ");
            templatePhoneNumber.append(phoneNumber.charAt(4));
            templatePhoneNumber.append(phoneNumber.charAt(5));
            templatePhoneNumber.append(phoneNumber.charAt(6));
            templatePhoneNumber.append("-");
            templatePhoneNumber.append(phoneNumber.charAt(7));
            templatePhoneNumber.append(phoneNumber.charAt(8));
            templatePhoneNumber.append("-");
            templatePhoneNumber.append(phoneNumber.charAt(9));
            templatePhoneNumber.append(phoneNumber.charAt(10));
        }

        if (phoneNumber.charAt(0) == '9') {
            templatePhoneNumber.append(phoneNumber.charAt(0));
            templatePhoneNumber.append(phoneNumber.charAt(1));
            templatePhoneNumber.append(phoneNumber.charAt(2));
            templatePhoneNumber.append(" ");
            templatePhoneNumber.append(phoneNumber.charAt(3));
            templatePhoneNumber.append(phoneNumber.charAt(4));
            templatePhoneNumber.append(phoneNumber.charAt(5));
            templatePhoneNumber.append("-");
            templatePhoneNumber.append(phoneNumber.charAt(6));
            templatePhoneNumber.append(phoneNumber.charAt(7));
            templatePhoneNumber.append("-");
            templatePhoneNumber.append(phoneNumber.charAt(8));
            templatePhoneNumber.append(phoneNumber.charAt(9));
        }

        System.out.println(templatePhoneNumber);
    }
}
