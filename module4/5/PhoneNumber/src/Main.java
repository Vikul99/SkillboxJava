import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите номер телефона: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber= scanner.nextLine();

        phoneNumber = phoneNumber.replaceAll("\\D+", "");
        System.out.println(phoneNumber);
    }
}
