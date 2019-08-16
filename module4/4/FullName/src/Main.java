import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите полное имя: ");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        int spaceCount = 0;
        if (fullName.length() != 0) {
            for (int i = 0; i < fullName.length(); ++i) {
                if (fullName.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
        }

        if (spaceCount == 2) {
            String surname = fullName.substring(0, fullName.indexOf(' ')).trim();
            String name = fullName.substring(fullName.indexOf(' '), fullName.lastIndexOf(' ')).trim();
            String patronymic = fullName.substring(fullName.lastIndexOf(' ')).trim();
            System.out.println("\tФамилия: " + surname + "\n\tИмя: " + name + "\n\tОтчество: " + patronymic);
        } else {
            System.out.println("Неверный формат");
        }
    }
}
