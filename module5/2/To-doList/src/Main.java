import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
       ToDoList list = new ToDoList();
       String command = new String();
       String str = new String();
       int index = -1;

       while (true) {
           System.out.println("Введите команду: ");
           String input = new Scanner(System.in).nextLine();

           Matcher m = Pattern.compile("(\\d+)").matcher(input);
           if (m.find()) {
               index = Integer.parseInt(m.group(0));
           }

           m = Pattern.compile("ADD|EDIT|DELETE|LIST").matcher(input);
           if (m.find()) {
               command = m.group(0);
           }

           if (index >= 0) {
               str = input.substring(input.indexOf((String.valueOf(index))) + 1).trim();
               index = -1;
           } else {
               str = input.replaceAll(command, "").trim();
           }

           if (command.equals("LIST")) {
               list.list();
           } else if (command.equals("ADD")) {
               if (index > 0) {
                   list.addElement(index, str);
               } else {
                   list.addElement(str);
               }
           } else if (command.equals("EDIT")) {
               list.edit(index, str);
           } else if (command.equals("DELETE")) {
               list.delete(index);
           } else {
               System.out.println("Неверный формат");
           }
       }
    }
}
