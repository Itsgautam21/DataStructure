package multithreading;

public class DemonThread {

    public static void main(String[] args) {

        Thread demonThread = new Thread(() -> {
            while (Boolean.TRUE) {
                System.out.println("Demon thread is running...");
            }
        }, "demon thread");
        demonThread.setDaemon(Boolean.TRUE);
        Thread userThread = new Thread(() -> System.out.println("user thread running..."), "user thread");
        demonThread.start();
        userThread.start();
        System.out.println("Main done!");
    }
}
