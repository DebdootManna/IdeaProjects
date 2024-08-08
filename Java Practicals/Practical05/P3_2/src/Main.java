import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        try {
            int result = divideByZero(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
        System.out.println("This Practical is made by 23CS043 Debdoot Manna");
    }

    public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
    }

    public static int divideByZero(int a, int b) {
        return a / b;
    }
}