public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";

        String[] colors = text.split(",?\\s+");
        for (int i = 0; i < colors.length; ++i) {
            System.out.println(colors[colors.length - i - 1]);
        }
    }
}
