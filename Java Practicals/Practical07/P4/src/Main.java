public class Main {
    private static int counter = 0;
    private static boolean isRunning = true;

    static class CounterThread extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                counter++;
                System.out.println("Counter value: " + counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();

        try {
            Thread.sleep(10000);
            isRunning = false;
            counterThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}