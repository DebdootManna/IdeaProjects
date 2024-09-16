public class Main3 {
    public static boolean array_front9(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9 && i < 4) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(array_front9(new int[]{1, 2, 9, 3, 4})); // → true
        System.out.println(array_front9(new int[]{1, 2, 3, 4, 9})); // → false
        System.out.println(array_front9(new int[]{1, 2, 3, 4, 5})); // → false
    }
}
