import java.util.Scanner;

class QueueUsingArray {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[this.capacity];
    }

    boolean isFull() {
        return (this.size == this.capacity);
    }

    boolean isEmpty() {
        return (this.size == 0);
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size += 1;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size -= 1;
        return item;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        QueueUsingArray queue = new QueueUsingArray(Q);

        for (int i = 0; i < Q; i++) {
            int queryType = scanner.nextInt();

            if (queryType == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (queryType == 2) {
                System.out.println(queue.dequeue());
            }
        }
        scanner.close();
    }
}