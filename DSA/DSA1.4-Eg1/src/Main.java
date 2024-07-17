import java.util.Arrays;

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
        int[][] testCases = {
                {3, 5},
                {0, 0},
                {0, 4, 3, 0, 4},
                {3, 6, 7, 7, 0},
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int result = specialArray(nums);
            System.out.println("Input: nums = " + Arrays.toString(nums));
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}