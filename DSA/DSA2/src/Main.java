import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        String w = lw(input);
        System.out.println("The longest word is: " + w);
        System.out.println("Number of characters in the longest word: " + w.length());
    }

    public static String lw(String input) {
        String[] words = input.split("\\s+");
        String lw = "";

        for (String w : words) {
            if (w.length() > lw.length()) {
                lw = w;
            }
        }

        return lw;
    }
}
