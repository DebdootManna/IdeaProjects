class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 != 0) {
            return false;
        }

        int[] remainderCount = new int[k];

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }

        if (remainderCount[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (remainderCount[i] % 2 != 0) {
                    return false;
                }
            } else if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {1,2,3,4,5,10,6,7,8,9};
        int k1 = 5;
        System.out.println("Example 1: " + solution.canArrange(arr1, k1));  // Should print true

        int[] arr2 = {1,2,3,4,5,6};
        int k2 = 7;
        System.out.println("Example 2: " + solution.canArrange(arr2, k2));  // Should print true

        int[] arr3 = {1,2,3,4,5,6};
        int k3 = 10;
        System.out.println("Example 3: " + solution.canArrange(arr3, k3));  // Should print false
    }
}