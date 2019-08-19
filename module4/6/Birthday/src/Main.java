import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate date =  LocalDate.of(1999,05,19);
        int age = LocalDate.now().getYear() - date.getYear();
        for (int i = 0; i <= age; ++i) {
            System.out.println(i + " - " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - E")));
            date = date.plusYears(1);
        }
    }
}
