
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);

        int vasyaSalary = Integer.parseInt(text.substring(text.indexOf('л') + 1, text.indexOf('у') - 1).trim());
        int mashaSalary = Integer.parseInt(text.substring(text.lastIndexOf('-') + 1, text.lastIndexOf(' ')).trim());
        String substring = text.substring(text.indexOf("-"), text.lastIndexOf(","));
        int petyaSalary = Integer.parseInt(substring.substring(substring.indexOf(' '), substring.lastIndexOf(' ')).trim());
        System.out.println("Друзья заработали: " + (vasyaSalary + mashaSalary + petyaSalary));
    }
}