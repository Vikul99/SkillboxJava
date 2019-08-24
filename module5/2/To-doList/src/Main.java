import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void printList(ToDoList list) {
        if (list.list().size() != 0) {
            for (int i = 0; i < list.list().size(); ++i) {
                System.out.println(i + " - " + list.list().get(i));
            }
        } else {
            System.out.println("Список пуст, добавьте дело командой ADD");
        }
    }

    public static void printHelp() {
        System.out.println("Ввведите что-нибудь из этого: ADD, EDIT, DELETE, LIST\n" +
                "\t- ADD - добавляет дело в конец списка или на определённое место, если укажите номер\n" +
                "\t- EDIT - заменяет дело с указанным номером\n" +
                "\t- DELETE - удаляет дело с указанным номером\n" +
                "\t- LIST - выводит список дел с их порядковыми номерами\n" +
                "\t- Примеры команд:\n" +
                "\t\tLIST\n" +
                "\t\tADD Какое-то дело\n" +
                "\t\tADD 4 Какое-то дело на четвёртом месте\n" +
                "\t\tEDIT 3 Новое название дела\n" +
                "\t\tDELETE 7");
    }

    public static void main(String[] args) {
        ToDoList list = new ToDoList();

        while (true) {
            System.out.println("Введите команду: ");
            String input = new Scanner(System.in).nextLine();

            Matcher m = Pattern.compile("(?<command>ADD|EDIT|DELETE|LIST)(?<index>\\s+\\d+)?(?<str>\\s+.*)?").matcher(input);
            if (!m.find()) {
                printHelp();
                continue;
            }

            int index;
            String str = "";
            String command = m.group("command");
            if (m.group("index") != null) {
                index = Integer.parseInt(m.group("index").trim());
            } else {
                index = -1;
            }
            if (m.group("str") != null) {
                str = m.group("str").trim();
            }

            if (command.equals("LIST")) {
                printList(list);
            } else if (command.equals("ADD") && !str.equals("")) {
                if (index >= 0) {
                    list.addElement(index, str);
                } else {
                    list.addElement(str);
                }
            } else if (command.equals("EDIT") && index >= 0 && index < list.list().size()) {
                list.edit(index, str);
            } else if (command.equals("DELETE") && index >= 0 && index < list.list().size()) {
                    list.delete(index);
            } else {
                    System.out.println("Неверная команда");
                    printHelp();
            }
        }
    }
}
