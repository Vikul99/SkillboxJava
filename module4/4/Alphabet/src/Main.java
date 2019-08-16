public class Main {
    public static void main(String[] args) {
        String russianAlphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";
        String latinAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < russianAlphabet.length(); ++i) {
            System.out.println(russianAlphabet.charAt(i) + " : " + (int) russianAlphabet.charAt(i));
        }

        System.out.println();

        for (int i = 0; i < latinAlphabet.length(); ++i) {
            System.out.println(latinAlphabet.charAt(i) + " : " + (int) latinAlphabet.charAt(i));
        }
    }
}
