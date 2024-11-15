package multithreading;

public class Synchronization {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.getCount());
        BankAccount bankAccount = new BankAccount();
        new Thread(() -> bankAccount.withdraw(50), "Happy").start();
        new Thread(() -> bankAccount.withdraw(100), "Sorrow").start();
    }

    static class Counter {

        private int count = 0;

        // removing synchronized may lead to data inconsistency and would give you incorrect result
        public synchronized void increment() {

            // either use this block or the method synchronized to prevent data inconsistency.
            synchronized (this) {
                count++;
            }
        }

        public int getCount() {

            return count;
        }
    }

    static class BankAccount {

        private int balance = 100;

        private static final Integer THREAD_SLEEP_TIME = 500;

        // removing synchronized may lead to data inconsistency and would give you incorrect result
        public synchronized void withdraw(int amount) {

            System.out.println(Thread.currentThread().getName() + " attempt to withdraw : " + amount);
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " proceeding with withdraw : " + amount);
                try {
                    // assuming this process may take some time.
                    Thread.sleep(THREAD_SLEEP_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                balance = balance - amount;
                System.out.println(Thread.currentThread().getName() + " completed withdraw, remain balance : " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " has Insufficient balance!");
            }
        }
    }
}
