import java.util.*;

public class Main {
    public static int specialArray(int[] nums) {
        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        // Output
        int result = specialArray(nums);
        System.out.println(result);

        scanner.close();
    }
}