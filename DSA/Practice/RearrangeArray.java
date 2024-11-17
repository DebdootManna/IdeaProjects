public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2};
        rearrangeArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rearrangeArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                // If index is even, arr[i] should be less than or equal to arr[i+1]
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                // If index is odd, arr[i] should be greater than or equal to arr[i+1]
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}