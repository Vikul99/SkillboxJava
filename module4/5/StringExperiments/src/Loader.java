public class Loader {
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        text = text.replaceAll("[^0-9]", " ").trim();
        String[] salary = text.split("\\s+");
        Integer income = 0;
        for (int i = 0; i < salary.length; ++i) {
            income += Integer.parseInt(salary[i]);
        }

        System.out.printf("Друзья заработали: %d ", income);
    }
}