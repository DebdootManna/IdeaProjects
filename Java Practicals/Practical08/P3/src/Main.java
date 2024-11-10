import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "This is a test. This test is a simple test to count words. " +
                "The program should count each word and display the count in " +
                "alphabetical order of the words.";

        Map<String, Integer> wordCount = new TreeMap<>();

        text = text.toLowerCase().replaceAll("[.,:;!?]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }

        System.out.println("Word count in alphabetical order:");
        System.out.println("Word\t\tOccurrences");
        System.out.println("------------------------");

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-15s%d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nUnique words:");
        Set<String> uniqueWords = wordCount.keySet();
        System.out.println(uniqueWords);

        System.out.println("\nStatistics:");
        System.out.println("Total words: " + words.length);
        System.out.println("Unique words: " + uniqueWords.size());

        String mostFrequent = Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most frequent word: '" + mostFrequent +
                "' (" + wordCount.get(mostFrequent) + " times)");

        Map<Integer, Set<String>> frequencyMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            frequencyMap.computeIfAbsent(entry.getValue(), k -> new TreeSet<>())
                    .add(entry.getKey());
        }

        System.out.println("\nWords by frequency:");
        for (Map.Entry<Integer, Set<String>> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " time(s): " + entry.getValue());
        }

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}