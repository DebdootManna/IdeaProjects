public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        Solution solution = new Solution();

        int[] testCases = {3, 13, 34, 61};

        for (int target : testCases) {
            int[] result = solution.searchMatrix(matrix, target);
            if (result[0] == -1) {
                System.out.println("Target " + target + " not found in the matrix.");
            } else {
                System.out.println("Target " + target + " found at position: [" + result[0] + ", " + result[1] + "]");
            }
        }
    }
}

class Solution {
    public int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1};
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int value = matrix[row][col];

            if (value == target) {
                return new int[]{row, col};
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1};
    }
}