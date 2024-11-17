// Define the Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the LinkedList class
class LinkedList {
    Node head;

    // Method to insert a node at the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete the last node
    public void deleteLastNode() {
        if (head == null) {
            return; // List is empty
        }
        if (head.next == null) {
            head = null; // Only one node in the list
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null; // Remove the last node
    }

    // Method to delete the n-th node from the end
    public void deleteNthFromEnd(int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (first == null) return; // n is greater than the number of nodes
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Delete the n-th node from the end
        second.next = second.next.next;
        head = dummy.next;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtFront(1);
        list.insertAtFront(2);
        list.insertAtFront(3);
        list.printList(); // Output: 3 -> 2 -> 1 -> null

        list.deleteLastNode();
        list.printList(); // Output: 3 -> 2 -> null

        list.deleteNthFromEnd(1);
        list.printList(); // Output: 3 -> null
    }
}