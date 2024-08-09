public class Main {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        head = head.next;
        System.out.println("Node deleted from the beginning successfully.");
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void printList() {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main list = new Main();

        list.insert(69);
        list.insert(420);
        list.insert(96);
        list.insert(24);

        System.out.println("Original List:");
        list.printList();

        list.deleteFromBeginning();
        System.out.println("List after deleting from beginning:");
        list.printList();

        list.deleteFromBeginning();
        System.out.println("List after deleting from beginning again:");
        list.printList();
    }
}