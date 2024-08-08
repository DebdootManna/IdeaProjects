import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer (x): ");
            int x = scanner.nextInt();

            System.out.print("Enter the second integer (y): ");
            int y = scanner.nextInt();

            double result = divide(x, y);
            System.out.printf("Result of %d / %d = %.4f%n", x, y, result);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Exception: Input must be integers.");
        } catch (ArithmeticException e) {
            System.out.println("Exception: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }

        System.out.println("This Practical is made by 23CS043 Debdoot Manna");
    }

    public static double divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) x / y;
    }
}