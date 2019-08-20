import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите полное имя: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] fullName = input.split("\\s+");
        if (fullName.length == 3) {
            System.out.println("\tФамилия: " + fullName[0] + "\n\tИмя: " + fullName[1] + "\n\tОтчество: " + fullName[2]);
        } else {
            System.out.println("Неверный формат");
        }
    }
}
