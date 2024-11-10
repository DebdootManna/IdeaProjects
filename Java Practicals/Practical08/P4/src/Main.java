import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> keywordSet = new HashSet<>(Arrays.asList(
                "abstract", "assert", "boolean", "break", "byte", "case", "catch",
                "char", "class", "const", "continue", "default", "do", "double",
                "else", "enum", "extends", "final", "finally", "float", "for",
                "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while"
        ));

        Map<String, Integer> keywordCount = new TreeMap<>();
        int totalKeywords = 0;

        try {
            System.out.println("Enter the path to Java source file:");
            Scanner input = new Scanner(System.in);
            String filename = input.nextLine();

            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("//") || line.startsWith("/*") ||
                        line.startsWith("*") || line.isEmpty()) {
                    continue;
                }

                String[] words = line.split("[ \\t\\n\\r\\f\\{\\}\\(\\);\\.]");

                for (String word : words) {
                    word = word.trim();
                    if (!word.isEmpty() && keywordSet.contains(word)) {
                        keywordCount.merge(word, 1, Integer::sum);
                        totalKeywords++;
                    }
                }
            }

            reader.close();
            input.close();

            System.out.println("\nKeywords found in the file:");
            System.out.println("Keyword\t\tCount");
            System.out.println("-----------------");

            for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
                System.out.printf("%-12s%d%n", entry.getKey(), entry.getValue());
            }

            System.out.println("\nStatistics:");
            System.out.println("Total keywords found: " + totalKeywords);
            System.out.println("Unique keywords found: " + keywordCount.size());

            String mostUsed = Collections.max(keywordCount.entrySet(),
                    Map.Entry.comparingByValue()).getKey();
            System.out.println("Most used keyword: '" + mostUsed +
                    "' (" + keywordCount.get(mostUsed) + " times)");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}