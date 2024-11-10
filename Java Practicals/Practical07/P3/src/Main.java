import java.util.Random;

public class Main {
    private static Integer number = null;
    private static final Object lock = new Object();
    private static boolean isRunning = true;

    static class NumberGenerator extends Thread {
        private Random random = new Random();

        public void run() {
            while (isRunning) {
                synchronized (lock) {
                    number = random.nextInt(100);
                    System.out.println("\nGenerated number: " + number);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    static class SquareCalculator extends Thread {
        public void run() {
            while (isRunning) {
                synchronized (lock) {
                    try {
                        while (number == null || number % 2 != 0) {
                            lock.wait();
                        }
                        if (number != null && number % 2 == 0) {
                            System.out.println("Square of " + number + " = " + (number * number));
                            number = null;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    static class CubeCalculator extends Thread {
        public void run() {
            while (isRunning) {
                synchronized (lock) {
                    try {
                        while (number == null || number % 2 == 0) {
                            lock.wait();
                        }
                        if (number != null && number % 2 != 0) {
                            System.out.println("Cube of " + number + " = " + (number * number * number));
                            number = null;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread generator = new NumberGenerator();
        Thread squareCalculator = new SquareCalculator();
        Thread cubeCalculator = new CubeCalculator();

        generator.start();
        squareCalculator.start();
        cubeCalculator.start();

        // Run for 20 seconds then stop
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isRunning = false;
        generator.interrupt();
        squareCalculator.interrupt();
        cubeCalculator.interrupt();

        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}