import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void printEmails(HashSet<String> emails) {
        if (emails.size() != 0) {
            for (String email : emails) {
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

    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        while (true) {
            String command = new String();

            System.out.println("Введите команду: ");
            String input = new Scanner(System.in).nextLine();

            Matcher m = Pattern.compile("ADD|LIST").matcher(input);
            if (!m.find()) {
                printHelp();
                continue;
            } else {
                command = m.group(0);
            }

            input = input.replaceAll(command, "").trim();

            m = Pattern.compile("^[a-zA-z0-9._%+-]+@[a-zA-z0-9._]+\\.[a-zA-Z]{2,6}$").matcher(input);

            if (command.equals("LIST")) {
                printEmails(emails);
            } else if (command.equals("ADD") && m.find() && !input.equals("")) {
                emails.add(input);
            } else {
                System.out.println("Неверный формат");
                printHelp();
            }
        }
    }
}
