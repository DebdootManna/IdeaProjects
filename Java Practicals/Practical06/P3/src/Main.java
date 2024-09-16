import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        String searchWord = "Java";

        Integer wordCount = searchWordInFile(fileName, searchWord);

        System.out.println("The word '" + searchWord + "' appears " + wordCount + " times in the file.");

        demonstrateWrapperClass();
    }

    public static Integer searchWordInFile(String fileName, String searchWord) {
        Integer count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void demonstrateWrapperClass() {
        Integer num1 = 10;
        Integer num2 = Integer.valueOf(20);

        int sum = num1 + num2;

        System.out.println("\nWrapper Class Example:");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("sum: " + sum);

        System.out.println("Maximum value of int: " + Integer.MAX_VALUE);
        System.out.println("Minimum value of int: " + Integer.MIN_VALUE);
        System.out.println("Binary representation of num1: " + Integer.toBinaryString(num1));
        System.out.println("This Practical is made by 23CS043 Debdoot Manna");
    }
}