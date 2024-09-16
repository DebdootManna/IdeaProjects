import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Conversion rate
        double exchangeRate = 100.0;

        // Method 1: Using command line arguments
        if (args.length > 0) {
            try {
                double pounds = Double.parseDouble(args[0]);
                double rupees = pounds * exchangeRate;
                System.out.println(pounds + " Pounds = " + rupees + " Rupees");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for Pounds.");
            }
        }

        // Method 2: Using Scanner class
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in Pounds: ");
        double pounds = scanner.nextDouble();

        double rupees = pounds * exchangeRate;
        System.out.println(pounds + " Pounds = " + rupees + " Rupees");
    }
}