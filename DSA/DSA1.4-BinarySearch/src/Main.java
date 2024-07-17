import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums); // Sorting the array in ascending order
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = nums.length - Arrays.binarySearch(nums, mid);

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
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