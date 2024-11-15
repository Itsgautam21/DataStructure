package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLock {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        new Thread(() -> bankAccount.withdraw(50), "Happy").start();
        new Thread(() -> bankAccount.withdraw(100), "Sorrow").start();
        // reentrant unfair locks
        ReentrantLocks reentrantLocks = new ReentrantLocks();
        reentrantLocks.outerMethod();
        // reentrant fair lock
        FairReentrantLock fairLock = new FairReentrantLock();
        Runnable runnable = fairLock::accessResource;
        new Thread(runnable, "first").start();
        new Thread(runnable, "second").start();
        new Thread(runnable, "third").start();
    }

    static class BankAccount {

        private int balance = 100;

        private static final Integer THREAD_SLEEP_TIME = 1000;

        // unfair reentrant lock (default : false).
        private final Lock lock = new ReentrantLock(false);

        public void withdraw(int amount) {

            System.out.println(Thread.currentThread().getName() + " attempt to withdraw : " + amount);
            try {
                if (lock.tryLock(2000, TimeUnit.SECONDS)) {
                    if (balance >= amount) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " proceeding with withdraw : " + amount);
                            // assuming this process may take some time.
                            Thread.sleep(THREAD_SLEEP_TIME);
                            balance = balance - amount;
                            System.out.println(Thread.currentThread().getName() + " completed withdraw, remain balance : " + amount);
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " has Insufficient balance!");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire the lock!");
                }
            } catch (InterruptedException e) {
                // interrupt the thread manually to monitor.
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ReentrantLocks {

    private final Lock lock = new ReentrantLock(false);

    public void outerMethod() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    private void innerMethod() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": inner method");
        } finally {
            lock.unlock();
        }
    }
}

class FairReentrantLock {

    private final Lock fairLock = new ReentrantLock(true);

    public void accessResource() {
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : acquired the lock!");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " : released the lock");
            fairLock.unlock();
        }
    }
}
