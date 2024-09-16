import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || args[0].length() != 1) {
            System.out.println("Usage: java CharacterCounter <character>");
            System.out.println("This Practical is made by 23CS043 Debdoot Manna");
            System.exit(1);
        }

        char targetChar = args[0].charAt(0);
        String fileName = "xanadu.txt";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c == targetChar) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("The character '" + targetChar + "' appears " + count + " times in " + fileName);
    }
}