public class Main {
    private static final int BUFFER_SIZE = 5;
    private static final int[] buffer = new int[BUFFER_SIZE];
    private static int count = 0;
    private static int in = 0;
    private static int out = 0;
    private static final Object lock = new Object();

    static class Producer extends Thread {
        public void run() {
            while (true) {
                int item = (int)(Math.random() * 100);
                synchronized (lock) {
                    while (count == BUFFER_SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    buffer[in] = item;
                    in = (in + 1) % BUFFER_SIZE;
                    count++;

                    System.out.println("Produced: " + item + " | Buffer Count: " + count);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    static class Consumer extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    int item = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    count--;

                    System.out.println("Consumed: " + item + " | Buffer Count: " + count);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.start();
        consumer.start();

        try {
            Thread.sleep(10000);
            producer.interrupt();
            consumer.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}