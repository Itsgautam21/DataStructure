package multithreading;

/**
 * A thread state.  A thread can be in one of the following states:
 * <ul>
 * <li>NEW<br>
 *     A thread that has not yet started is in this state.
 *     </li>
 * <li>RUNNABLE<br>
 *     A thread executing in the Java virtual machine is in this state.
 *     </li>
 * <li>BLOCKED<br>
 *     A thread that is blocked waiting for a monitor lock
 *     is in this state.
 *     </li>
 * <li>WAITING<br>
 *     A thread that is waiting indefinitely for another thread to
 *     perform a particular action is in this state.
 *     </li>
 * <li>TIMED_WAITING<br>
 *     A thread that is waiting for another thread to perform an action
 *     for up to a specified waiting time is in this state.
 *     </li>
 * <li>TERMINATED<br>
 *     A thread that has exited is in this state.
 *     </li>
 * </ul>
 *
 * <p>
 * A thread can be in only one state at a given point in time.
 * These states are virtual machine states which do not reflect
 * any operating system thread states.
 */
public class ThreadLifeCycle {

    public static final Integer MAIN_THREAD_WAITING_TIME = 1000;

    public static final Integer OTHER_THREAD_WAITING_TIME = 2000;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running...");
            try {
                Thread.sleep(OTHER_THREAD_WAITING_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        // Thread would be in NEW state.
        System.out.println(thread.getState());
        thread.start();
        // Thread would be in RUNNING state.
        System.out.println(thread.getState());
        Thread.sleep(MAIN_THREAD_WAITING_TIME);
        // Thread would be in WAITING state.
        System.out.println(thread.getState());
        thread.join();
        // Thread would be in Terminated state.
        System.out.println(thread.getState());
    }
}
