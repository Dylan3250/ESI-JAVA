package introduction;

public class TestMyTimer {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(4000);
        myTimer.start();
        try {
            Thread.sleep(7011);
        } catch (InterruptedException e) {
            System.out.println("introduction.TestMyTimer: exception " + e);
        }
        myTimer.shouldRun = false;
        System.gc();
        System.out.println("introduction.MyTimer: gc called");
        System.out.println("introduction.MyTimer: end");
    }
}
