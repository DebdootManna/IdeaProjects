class DoublyLinkedList {

    // Node class representing each element of the doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    // Method to insert a node at the front of the doubly linked list
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println("Inserted " + data + " at the front.");
        displayList();
    }

    // Method to delete a node from the last of the doubly linked list
    public void deleteAtLast() {
        if (tail == null) {
            System.out.println("The list is empty. Cannot delete from last.");
            return;
        }

        System.out.println("Deleting node " + tail.data + " from the last.");

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }

        displayList();
    }

    // Method to delete all nodes from the doubly linked list
    public void deleteAllNodes() {
        head = null;
        tail = null;
        System.out.println("All nodes have been deleted.");
        displayList();
    }

    // Method to display the content of the doubly linked list
    public void displayList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Test operations
        list.insertAtFront(10);
        list.insertAtFront(20);
        list.insertAtFront(30);

        list.deleteAtLast();
        list.deleteAtLast();
        list.deleteAtLast();

        list.insertAtFront(40);
        list.insertAtFront(50);

        list.deleteAllNodes();
    }
}