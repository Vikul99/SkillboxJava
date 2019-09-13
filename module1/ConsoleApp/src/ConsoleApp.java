import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleApp
{
    public static void main(String[] args)
    {
        DateFormat format = new SimpleDateFormat("HH:MM dd.MM.yyyy");
        Date date = new Date();
        System.out.println(format.format(date));
    }
}
