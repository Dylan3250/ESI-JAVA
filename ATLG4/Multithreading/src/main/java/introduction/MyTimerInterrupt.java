package introduction;

public class MyTimerInterrupt extends Thread {
    private int laps;

    public MyTimerInterrupt(int laps) {
        this.laps = laps;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                System.out.println("introduction.MyTimer: not interrupted");
                sleep(laps);
            } catch (InterruptedException e) {
                System.out.println("introduction.MyTimer: exception " + e);
                return; // essayer avec et sans ce return !
            }
        }
    }
}
