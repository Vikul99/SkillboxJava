import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void printEmails(HashSet<String> emails) {
        if (emails.size() != 0) {
            for (String email: emails) {
                System.out.println(email);
            }
        } else {
            System.out.println("Email - адреса отсутсвуют");
            printHelp();
        }
    }

    public static void printHelp() {
        System.out.println("\tДля добавления email - адреса воспользуйтесь командой ADD email\n" +
                "\tДля просмотра email - адресов оспользуйтесь командой LIST");
    }

    public static boolean isEmailValid(String email) {
        return email.matches("\\w+@\\w+\\.\\w{2,6}");
    }


    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        while (true) {
            System.out.println("Введите команду: ");
            String[] input = new Scanner(System.in).nextLine().split(" ");

            String command;
            String email = "";
            if (input.length == 2) {
                command = input[0];
                email = input[1];
            } else {
                command = input[0];
            }

            if (command.equals("LIST")) {
                printEmails(emails);
            } else if (command.equals("ADD") && isEmailValid(email)) {
                emails.add(email);
            } else {
                System.out.println("Неверный формат");
                printHelp();
            }
        }
    }
}
