import java.util.*;

public class Main {
    public static void rearrangeArray(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 1; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int T = scanner.nextInt(); // Number of test cases
        System.out.println("Number of test cases: " + T);

        for (int t = 0; t < T; t++) {
            System.out.println("Enter the size of the array for test case " + (t + 1) + ":");
            int N = scanner.nextInt(); // Size of the array
            System.out.println("Array size: " + N);

            int[] A = new int[N];

            System.out.println("Enter " + N + " space-separated integers:");
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            System.out.println("Original array: " + Arrays.toString(A));

            rearrangeArray(A);

            System.out.print("Rearranged array: ");
            // Print the rearranged array
            for (int i = 0; i < N; i++) {
                System.out.print(A[i] + (i == N - 1 ? "\n" : " "));
            }
        }

        scanner.close();
    }
}