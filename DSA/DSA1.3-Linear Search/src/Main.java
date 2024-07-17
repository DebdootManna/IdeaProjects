import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        int N = scanner.nextInt();

        // Check constraint
        if (N < 0 || N > 40) {
            System.out.println("Invalid input: N must be between 0 and 40 inclusive.");
            return;
        }

        // Read the array
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Read the search key
        int searchKey = scanner.nextInt();

        // Perform linear search
        int result = linearSearch(arr, searchKey);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1; // Element not found
    }
}