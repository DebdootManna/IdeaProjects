import java.util.Arrays;
import java.util.Scanner;
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

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " non-negative integers:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = specialArray(nums);

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + result);

        scanner.close();
    }
}