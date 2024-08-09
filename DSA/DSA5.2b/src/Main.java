import java.util.Scanner;

class QueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    void enqueue(int item) {
        Node newNode = new Node(item);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }

    int dequeue() {
        if (this.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return temp.data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

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