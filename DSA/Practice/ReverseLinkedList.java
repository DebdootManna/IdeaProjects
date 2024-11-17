// Define the Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the ReverseLinkedList class with the reverse function
class ReverseLinkedList {
    Node head;

    // Function to reverse the linked list
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = previous; // Reverse the current node's pointer
            previous = current; // Move the previous pointer one step forward
            current = next; // Move the current pointer one step forward
        }
        head = previous; // Update the head to the new first node
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to add a new node at the end of the list
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original list:");
        list.printList();

        list.reverse();

        System.out.println("Reversed list:");
        list.printList();
    }
}