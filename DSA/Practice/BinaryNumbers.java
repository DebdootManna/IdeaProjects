import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {
    public static void main(String[] args) {
        int N = 5; // You can change this value to generate more binary numbers
        generateBinaryNumbers(N);
    }

    public static void generateBinaryNumbers(int N) {
        // Create an empty queue
        Queue<String> queue = new LinkedList<>();

        // Enqueue the first binary number
        queue.add("1");

        // Loop until we generate N binary numbers
        for (int i = 0; i < N; i++) {
            // Dequeue the front of the queue
            String current = queue.poll();
            System.out.print(current + " ");

            // Generate the next two binary numbers and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}