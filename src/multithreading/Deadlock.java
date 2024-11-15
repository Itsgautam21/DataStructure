package multithreading;

public class Deadlock {

    public static void main(String[] args) {

        final Object resource1 = new Object();
        final Object resource2 = new Object();
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("resource 1 main");
                synchronized (resource2) {
                    System.out.println("resource 2 nested");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("resource 2 main");
                synchronized (resource1) {
                    System.out.println("resource 1 nested");
                }
            }
        }).start();
        // Another example with pen and paper.
        Paper paper = new Paper();
        Pen pen = new Pen();
        new Thread(() -> paper.writeWithPenAndPaper(pen), "paper").start();
        new Thread(() -> {
            // resolved deadlocking
            synchronized (paper) {
                pen.writeWithPenAndPaper(paper);
            }
        }, "pen").start();
    }

    static class Pen {

        public synchronized void writeWithPenAndPaper(Paper paper) {

            System.out.println(Thread.currentThread().getName() + " is using pen and writing with paper");
            paper.finishWriting();
        }

        public synchronized void finishWriting() {

            System.out.println(Thread.currentThread().getName() + " finished using pen");
        }
    }

    static class Paper {

        public synchronized void writeWithPenAndPaper(Pen pen) {

            System.out.println(Thread.currentThread().getName() + " is using paper and writing with pen");
            pen.finishWriting();
        }

        public synchronized void finishWriting() {

            System.out.println(Thread.currentThread().getName() + " finished using paper");
        }
    }
}


