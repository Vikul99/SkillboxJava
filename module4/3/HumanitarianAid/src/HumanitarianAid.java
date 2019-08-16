import java.util.Scanner;

public class HumanitarianAid {
    private static final int TRUCK_CAPACITY = 12;
    private static final int CONTAINER_CAPACITY = 27;

    private static int boxCount;
    private static int containerCount;
    private static int truckCount;


    public static void main(String[] args) {
        System.out.print("Введите число ящиков: ");
        Scanner scanner = new Scanner(System.in);
        boxCount = scanner.nextInt();

        if (boxCount != 0 && boxCount % CONTAINER_CAPACITY == 0) {
            containerCount = boxCount / CONTAINER_CAPACITY;
        } else {
            containerCount = boxCount / CONTAINER_CAPACITY + 1;
        }

        if (containerCount % TRUCK_CAPACITY == 0) {
            truckCount = containerCount/TRUCK_CAPACITY;
        } else {
            truckCount = containerCount/TRUCK_CAPACITY + 1;
        }

        int c = 1;                                              // Можно ли как-то избежать подобных переменных
        int b = 1;                                              // счётчиков и сделать вывод более понятным в
        for (int i = 1; i <= truckCount; ++i) {                 // плане кода?
            System.out.println("\tГрузовик " + i);
            int j = 0;
            while (j < TRUCK_CAPACITY && c <= containerCount) {
                System.out.println("\t\tКонтейнер " + c);
                c++;
                j++;
                int k = 0;
                while (k < CONTAINER_CAPACITY && b <= boxCount) {
                    System.out.println("\t\t\t\t\tЯщик " + b);
                    k++;
                    b++;
                }
            }
        }
    }
}
