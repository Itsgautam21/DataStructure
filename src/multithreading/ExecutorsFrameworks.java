package multithreading;

import java.util.concurrent.*;

public class ExecutorsFrameworks {

    public static void main(String[] args) {

        singleThreadExecutor();
        singleThreadExecutorsWithThreadFactory();
        fixedThreadPool();
        fixedThreadPoolWithThreadFactory();
        newScheduledThreadPool();
        newScheduledThreadPoolWithThreadFactory();
        newCachedThreadPool();
        newCachedThreadPoolWithThreadFactory();
    }

    private static void singleThreadExecutor() {

        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                Thread.sleep(100);
                System.out.println(4);
                return 4 * 4;
            });
        }
        service.shutdown();
    }

    private static void singleThreadExecutorsWithThreadFactory() {

        ExecutorService service = Executors.newSingleThreadExecutor(r -> {
            Thread thread = new Thread(r, "single thread with factory");
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        });
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " - " + 4);
                return 4 * 4;
            });
        }
        service.shutdown();
    }

    private static void fixedThreadPool() {

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : " + 4);
                return 4 * 4;
            });
        }
        service.shutdown();
    }

    private static void fixedThreadPoolWithThreadFactory() {

        ExecutorService service = Executors.newFixedThreadPool(2, r -> {
            Thread thread = new Thread(r, "fixed thread with factory");
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        });
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " - " + 4);
                return 4 * 4;
            });
        }
        service.shutdown();
    }

    private static void newScheduledThreadPool() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " : scheduler runs after given time!");
            return 4 * 4;
        }, 2, TimeUnit.SECONDS);
        // schedule at fixed rate
        service.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " : scheduler runs after given time and periodically irrespective of time taken by each task");
        }, 2, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " : scheduler runs after given time and periodically!");
        }, 2, 2, TimeUnit.SECONDS);
        // manually handles the shutdown part in the fixed rate scheduler.
        service.schedule(service::shutdown, 4, TimeUnit.SECONDS);
    }

    private static void newScheduledThreadPoolWithThreadFactory() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1, runnable -> {
            Thread thread = new Thread(runnable, "new scheduled thread with factory");
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        });
        for (int i = 0; i < 2; i++) {
            service.schedule(() -> {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : scheduler runs after given time!");
                return 4 * 4;
            }, 2, TimeUnit.SECONDS);
        }
        service.shutdown();
    }

    private static void newCachedThreadPool() {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : cached thread running");
                return 4 * 4;
            });
        }
        service.shutdown();
    }

    private static void newCachedThreadPoolWithThreadFactory() {

        ExecutorService service = Executors.newCachedThreadPool(runnable -> {
            Thread thread = new Thread(runnable, "new cached thread with factory");
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        });
        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : cached thread running");
                return 4 * 4;
            });
        }
        service.shutdown();
    }
}
