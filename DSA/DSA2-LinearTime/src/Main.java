public class Main {
    public static void sortAlmostSorted(int[] arr) {
        int n = arr.length;
        int first = -1, second = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                first = i;
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                second = i;
                break;
            }
        }

        if (first != -1 && second != -1) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 8, 6, 7, 5, 9};
        int[] arr2 = {3, 5, 6, 9, 8, 7};
        int[] arr3 = {3, 5, 7, 6, 8, 9};

        System.out.println("Original arrays:");
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);

        sortAlmostSorted(arr1);
        sortAlmostSorted(arr2);
        sortAlmostSorted(arr3);

        System.out.println("\nSorted arrays:");
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}