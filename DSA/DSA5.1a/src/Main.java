class StackUsingArray {
    private int top;
    private int[] stack;
    private int capacity;

    public StackUsingArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // Function to push an element into the stack
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
    }

    // Function to pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(10);

        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
    }
}