import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        String input = scanner.nextLine();

        // Split the input string into words
        String[] words = input.split("\\s+");

        // Initialize variables
        String longestWord = "";
        int maxLength = 0;

        // Find the longest word
        for (String word : words) {
            // Remove any non-alphanumeric characters
            word = word.replaceAll("[^a-zA-Z0-9]", "");

            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        // Print the length of the longest word
        System.out.println(maxLength);

        scanner.close();
    }
}