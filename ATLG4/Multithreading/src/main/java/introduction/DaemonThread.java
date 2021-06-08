package introduction;

public class DaemonThread extends Thread {
    public void run() {
        for (int n = 0; n < 42; ++n) {
            System.out.println("introduction.DaemonThread: run " + n);
            try {
                sleep(420);
            } catch (InterruptedException e) {
                System.out.println("introduction.DaemonThread thread: exception " + e);
            }
        }
    }

    public static void main(String[] args) {
        DaemonThread d;
        d = new DaemonThread();
        d.setDaemon(true);
        d.start();
        try {
            System.out.println("introduction.DaemonThread main: i do nothing during a while");
            sleep(7110);
            // d.join();
        } catch (InterruptedException e) {
            System.out.println("introduction.DaemonThread: exception " + e);
        }
    }
}
