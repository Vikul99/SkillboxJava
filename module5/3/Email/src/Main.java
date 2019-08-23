import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
       Matcher emailMatcher = Pattern.compile("(?<email>^[a-zA-z0-9._%+-]+@[a-zA-z0-9._]+\\.[a-zA-Z]{2,6}$)").matcher(email);
       if (emailMatcher.find()) {
           return true;
       } else {
           return false;
       }
    }


    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        while (true) {
            String command;
            String email = "";

            System.out.println("Введите команду: ");
            String[] input = new Scanner(System.in).nextLine().split(" ");
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
