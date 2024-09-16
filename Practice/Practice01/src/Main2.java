public class Main2 {
    public static int array_count9(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 9) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(array_count9(new int[]{1, 2, 9})); // → 1
        System.out.println(array_count9(new int[]{1, 9, 9})); // → 2
        System.out.println(array_count9(new int[]{1, 9, 9, 3, 9})); // → 3
    }
}