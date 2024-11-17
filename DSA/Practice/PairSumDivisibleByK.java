import java.util.ArrayList;
import java.util.List;

public class PairSumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 9, 4};
        int k = 5;
        List<int[]> result = findPairs(arr, k);
        
        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }

    public static List<int[]> findPairs(int[] arr, int k) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % k == 0) {
                    pairs.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return pairs;
    }
}