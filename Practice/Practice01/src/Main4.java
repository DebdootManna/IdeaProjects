public class Main4 {
    public static String double_char(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.append(c).append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(double_char("The")); // → 'TThhee'
        System.out.println(double_char("AAbb")); // → 'AAAAbbbb'
        System.out.println(double_char("Hi-There")); // → 'HHii--TThheerree'
    }
}
