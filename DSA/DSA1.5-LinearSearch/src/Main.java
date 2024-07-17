import java.util.Scanner;

class Solution {
    public static int[] searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the matrix elements (space-separated):");
        String matrixInput = scanner.nextLine().trim();
        String[] elements = matrixInput.split("\\s+");

        int[][] matrix = new int[3][4];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = Integer.parseInt(elements[index++]);
            }
        }

        System.out.println("Enter the target value:");
        int target = scanner.nextInt();

        int[] result = searchMatrix(matrix, target);
        if (result[0] == -1) {
            System.out.println("-1");
        } else {
            System.out.println("(" + result[0] + "," + result[1] + ")");
        }

        scanner.close();
    }
}