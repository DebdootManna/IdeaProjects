class StackUsingLinkedList {
    private Node top;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to push an element into the stack
    public void push(int x) {
        Node newNode = new Node(x);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Function to pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
    }
}