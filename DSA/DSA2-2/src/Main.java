import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        ArrayList<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        String[] words = input.split(" ");

        for (String word : words) {
            if (word.length() > maxLength) {
                longestWords.clear();
                longestWords.add(word);
                maxLength = word.length();
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        System.out.println("The longest word(s) is/are: " + longestWords);
        System.out.println("Number of characters in the longest word(s): " + maxLength);
    }
}
