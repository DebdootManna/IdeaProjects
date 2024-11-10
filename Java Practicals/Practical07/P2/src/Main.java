public class Main {
    private static long totalSum = 0;
    private static final Object lock = new Object();

    static class SumThread extends Thread {
        private final int start;
        private final int end;

        public SumThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            long partialSum = 0;
            for (int i = start; i <= end; i++) {
                partialSum += i;
            }

            synchronized (lock) {
                totalSum += partialSum;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ParallelSum N numberOfThreads");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int numberOfThreads = Integer.parseInt(args[1]);

        if (numberOfThreads > N) {
            numberOfThreads = N;
        }

        Thread[] threads = new Thread[numberOfThreads];
        int numbersPerThread = N / numberOfThreads;
        int remainingNumbers = N % numberOfThreads;

        int start = 1;

        for (int i = 0; i < numberOfThreads; i++) {
            int end = start + numbersPerThread - 1;
            if (i == numberOfThreads - 1) {
                end += remainingNumbers;
            }

            threads[i] = new SumThread(start, end);
            threads[i].start();
            start = end + 1;
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            return;
        }

        System.out.println("Sum of first " + N + " numbers using " + numberOfThreads + " threads is: " + totalSum);
        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}