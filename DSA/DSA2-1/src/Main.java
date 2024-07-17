import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter something:");
        String i = s.nextLine();

        String lw = "";
        int l = 0;

        String[] timepass = i.split(" ");

        for (String w : timepass) {
            if (w.length() > l) {
                lw = w;
                l = w.length();
            }
        }

        System.out.println("The longest word is: " + lw);
        System.out.println("Number of characters in the longest word: " + l);
    }
}
