import java.util.ArrayList;

public class Main {
    private ArrayList<Object> list;

    public Main() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return list.get(getSize() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        Object obj = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return obj;
    }

    public void push(Object o) {
        list.add(o);
    }

    static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Main stack = new Main();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("New top element: " + stack.peek());
        System.out.println("Stack size: " + stack.getSize());

        stack.pop();
        stack.pop();

        try {
            stack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            stack.peek();
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}