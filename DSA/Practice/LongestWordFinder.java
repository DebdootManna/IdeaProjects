public class LongestWordFinder {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longestWord = "";
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }

    public static void main(String[] args) {
        String inputString = "The quick brown fox jumps over the lazy dog";
        System.out.println(findLongestWord(inputString));  // Output: "jumps"
    }
}