public class Main {
    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        RunnableClass runnableClass = new RunnableClass();
        Thread thread = new Thread(runnableClass);
        thread.start();
        System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");
    }
}

class ThreadClass extends Thread {
    public void run() {
        System.out.println("Hello World from Thread class");
    }
}

class RunnableClass implements Runnable {
    public void run() {
        System.out.println("Hello World from Runnable interface");
    }
}