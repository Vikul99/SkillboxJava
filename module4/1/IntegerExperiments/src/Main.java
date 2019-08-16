import org.w3c.dom.ls.LSOutput;

public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(129675));

    }

    public static Integer sumDigits(Integer number) {
        //@TODO: write code here
        Integer result = 0;
        for (int i = 0; i < number.toString().length(); ++i) {
            result += Integer.parseInt(Character.toString(number.toString().charAt(i)));
        }
        return result;
    }
}
