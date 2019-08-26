import java.util.*;

public class Main {
    public static final String CAR_NUMBER_REGEX = "^\\w\\d{3}\\w{2}\\d{1,3}$";

    public static void main(String[] args) {
        ArrayList<String> carNumbers = new ArrayList<>();
        String[] carNumberChar = new String[] {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        for (int c = 0; c < carNumberChar.length; ++c) {
            for (int region = 1; region <= 199; ++region) {
                for (int firstNum = 1; firstNum < 10; ++firstNum) {
                    for (int secondNum = 0; secondNum < 10; ++secondNum ) {
                        for (int thirdNum = 0; thirdNum < 10; ++thirdNum) {
                            String character = carNumberChar[c];
                            String carNumber = String.format("%s%d%d%d%s%s%d", character, firstNum, secondNum, thirdNum, character, character, region);
                            carNumbers.add(carNumber);
                        }
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите номер автомобиля для поиска: ");
            String inputCarNumber = scanner.nextLine();
            if (!inputCarNumber.matches(CAR_NUMBER_REGEX)) {
                System.out.println("Неверный формат номера");
                continue;
            }

            long start = System.nanoTime();
            carNumbers.contains(inputCarNumber);
            long duration = System.nanoTime() - start;
            System.out.println("Время поиска прямым перебором: " + duration);

            start = System.nanoTime();
            Collections.binarySearch(carNumbers, inputCarNumber);
            duration = System.nanoTime() - start;
            System.out.println("Время бинарного поиска: " + duration);

            HashSet<String> hashCarNumbers = new HashSet<>();
            hashCarNumbers.addAll(carNumbers);

            start = System.nanoTime();
            hashCarNumbers.contains(inputCarNumber);
            duration = System.nanoTime() - start;
            System.out.println("Время поиска с помощью HashSet: " + duration);

            TreeSet<String> treeCarNumbers = new TreeSet<>();
            treeCarNumbers.addAll(carNumbers);

            start = System.nanoTime();
            treeCarNumbers.contains(inputCarNumber);
            duration = System.nanoTime() - start;
            System.out.println("Время поиска с помощью TreeSet: " + duration);
        }
    }
}
