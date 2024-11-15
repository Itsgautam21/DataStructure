package multithreading;

public class MyThread {

    public static void main(String[] args) {
        // creating a thread with thread class
        ThreadUsingThread myThread = new ThreadUsingThread("Thread class");
        myThread.start();
        // creating a thread with runnable interfaces.
        Thread thread = new Thread(new ThreadUsingRunnable(), "Runnable Interface");
        thread.start();
        // creating a thread with lambda expression.
        Thread lambdaThread = new Thread(() ->
                System.out.println("Thread using lambda expression : " + Thread.currentThread().getName()), "Lambda Runnable");
        lambdaThread.start();
    }
}

class ThreadUsingThread extends Thread {

    ThreadUsingThread(String name) {

        super(name);
    }

    @Override
    public void run() {

        System.out.println("Thread using Thread class : " + Thread.currentThread().getName());
    }
}

class ThreadUsingRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("Thread using runnable Interface : " + Thread.currentThread().getName());
    }
}
