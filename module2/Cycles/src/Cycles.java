public class Cycles {
    public static void main(String[] args) {

        for (int i = 200000; i < 210001; ++i)
            System.out.println(i);

        for (int i = 220000; i < 235001; ++i)
            System.out.println(i);

        int i = 200000;
        while (i != 210001) {
            System.out.println(i);
            ++i;
        }

        i = 220000;
        while (i != 235001) {
            System.out.println(i);
            ++i;
        }
    }
}
