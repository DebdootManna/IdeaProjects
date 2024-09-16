
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Enter a number: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Invalid input");
            return;
        }
        else {
            String f = "";
            if (str.length()>=3) {
                f = str.substring(0, 3);
            }
            else {
                f = str;
            }

            String result = "";
            for (int i = 0; i < n; i++) {
                result += f;
            }
            System.out.println(result);
        }
    }
}