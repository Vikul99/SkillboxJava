import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        Integer income = 0;
        Matcher m = Pattern.compile("(?<salary>\\d+)").matcher(text);

        while (m.find()) {
            income += Integer.parseInt(m.group("salary"));
        }

        System.out.printf("Друзья заработали: %d ", income);
    }
}