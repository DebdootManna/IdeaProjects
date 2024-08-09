public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original list:");
        list.printList();

        list.deleteFromEnd();
        System.out.println("List after deleting from end:");
        list.printList();
    }

    static class SinglyLinkedList {
        private Node head;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void deleteFromEnd() {
            // If the list is empty, do nothing
            if (head == null) {
                return;
            }

            // If there's only one node, remove it
            if (head.next == null) {
                head = null;
                return;
            }

            // Traverse to the second last node
            Node secondLast = head;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }

            // Remove the last node
            secondLast.next = null;
        }

        // Helper method to add a node to the list
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Helper method to print the list
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}