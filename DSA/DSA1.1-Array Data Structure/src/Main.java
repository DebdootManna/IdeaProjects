import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        int n = scanner.nextInt();

        // Input array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input k
        int k = scanner.nextInt();

        // Find and print pairs
        findPairs(arr, k);

        scanner.close();
    }

    public static void findPairs(int[] arr, int k) {
        List<String> pairs = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            boolean pairFound = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (!used[j] && (arr[i] + arr[j]) % k == 0) {
                    pairs.add("(" + arr[i] + "," + arr[j] + ")");
                    used[i] = used[j] = true;
                    pairFound = true;
                    break;
                }
            }

            if (!pairFound) {
                System.out.println("-1");
                return;
            }
        }

        for (String pair : pairs) {
            System.out.println(pair);
        }
    }
}