package multithreading;

public class ThreadPriority {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : priority : " + Thread.currentThread().getPriority());
            }
        };
        Thread threadMin = new Thread(runnable, "thread low");
        Thread threadNorm = new Thread(runnable, "thread mid");
        Thread threadMax = new Thread(runnable, "thread high");
        threadMin.setPriority(Thread.MIN_PRIORITY);
        threadNorm.setPriority(Thread.NORM_PRIORITY);
        threadMax.setPriority(Thread.MAX_PRIORITY);
        threadMin.start();
        threadNorm.start();
        threadMax.start();
        // Interrupt thread.
        Thread interruptThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted : " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName());
        }, "interrupt thread");
        interruptThread.start();
        interruptThread.interrupt();
    }
}
