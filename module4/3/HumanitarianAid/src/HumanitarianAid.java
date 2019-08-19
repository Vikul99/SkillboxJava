import java.util.Scanner;

public class HumanitarianAid {
    private static final int TRUCK_CAPACITY = 12;
    private static final int CONTAINER_CAPACITY = 27;

    public static void main(String[] args) {
        System.out.print("Введите число ящиков: ");
        Scanner scanner = new Scanner(System.in);
        int boxCount = scanner.nextInt();

        int containerCount = (int) Math.ceil( (double) boxCount / CONTAINER_CAPACITY);
        int truckCount = (int) Math.ceil( (double) containerCount/TRUCK_CAPACITY);

        int containerNumber = 1;
        int boxNumber = 1;
        for (int t = 1; t <= truckCount; ++t) {
            System.out.println("\tГрузовик " + t);
            for (int c = 0; c < TRUCK_CAPACITY && containerNumber <= containerCount; c++) {
                System.out.println("\t\tКонтейнер " + containerNumber);
                containerNumber++;
                for (int b = 0; b < CONTAINER_CAPACITY && boxNumber <= boxCount; b++) {
                    System.out.println("\t\t\t\t\tЯщик " + boxNumber);
                    boxNumber++;
                }
            }
        }
    }
}
