import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите размер размер креста: ");
        int markSize = new Scanner(System.in).nextInt();
        System.out.println();

        for (int i = 0; i < markSize; ++i) {
            for (int j = 0; j < markSize; ++j) {
                if (j == i || j == markSize - i - 1) {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
