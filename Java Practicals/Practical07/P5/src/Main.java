public class Main {
    static class PriorityThread extends Thread {
        public PriorityThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        "Thread: " + getName() +
                                " | Priority: " + getPriority() +
                                " | Iteration: " + i
                );
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + getName() + " interrupted.");
                    return;
                }
            }
            System.out.println("Thread " + getName() + " finished execution.");
        }
    }

    public static void main(String[] args) {
        // Create three threads
        Thread first = new PriorityThread("FIRST");
        Thread second = new PriorityThread("SECOND");
        Thread third = new PriorityThread("THIRD");

        first.setPriority(3);
        third.setPriority(7);

        System.out.println("Starting threads...\n");
        first.start();
        second.start();
        third.start();

        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll threads completed execution.");

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}