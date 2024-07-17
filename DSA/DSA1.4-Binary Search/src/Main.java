import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        int N = scanner.nextInt();

        // Check constraints
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

        // Sort the array (binary search requires a sorted array)
        Arrays.sort(arr);

        // Perform binary search
        int result = binarySearch(arr, searchKey);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }
}