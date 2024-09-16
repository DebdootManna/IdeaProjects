import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java LineCounts file1.txt file2.txt ...");
            System.out.println("This Practical is made by 23CS043 Debdoot Manna");
            return;
        }

        for (String filename : args) {
            try {
                int lineCount = countLines(filename);
                System.out.println(filename + ": " + lineCount + " lines");
            } catch (IOException e) {
                System.out.println("Error reading " + filename + ": " + e.getMessage());
            }
        }
    }

    private static int countLines(String filename) throws IOException {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        }
        return lineCount;
    }
}