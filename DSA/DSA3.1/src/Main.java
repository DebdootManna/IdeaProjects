public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test operations
        list.insertAtFront(3);
        list.insertAtFront(2);
        list.insertAtFront(1);

        list.deleteAtLast();

        list.insertAtFront(4);
        list.insertAtFront(5);

        list.deleteNthFromEnd(2);

        list.deleteAllNodes();
    }
}

class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // (a) Insert a node at front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at front");
        display();
    }

    // (b) Delete a node at last
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted " + head.data + " from last");
            head = null;
        } else {
            Node second_last = head;
            while (second_last.next.next != null) {
                second_last = second_last.next;
            }
            System.out.println("Deleted " + second_last.next.data + " from last");
            second_last.next = null;
        }
        display();
    }

    // (c) Delete Nth Node From End of List
    public void deleteNthFromEnd(int n) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        // Advance first pointer by n+1 steps
        for (int i = 1; i <= n + 1; i++) {
            if (first == null) {
                System.out.println("N is larger than the list size");
                return;
            }
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("Deleted " + second.next.data + " (Nth node from end)");
        second.next = second.next.next;
        display();
    }

    // (d) Delete all nodes of linked list
    public void deleteAllNodes() {
        head = null;
        System.out.println("Deleted all nodes");
        display();
    }

    // Display content of linked list
    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("List contents: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}