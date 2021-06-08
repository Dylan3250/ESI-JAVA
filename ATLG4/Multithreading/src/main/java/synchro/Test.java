package synchro;

public class Test {
    // TO DO : PAGE 15
    public static void main(String[] args) {
        MyObject mo1 = new MyObject("mo1");
        MyObject mo2 = new MyObject("mo2");
        MyThread mt1 = new MyThread("mt1", mo1);
        MyThread mt2 = new MyThread("mt2", mo2);

        mt1.start();
        mt2.start();
        try {
            Thread.sleep(0L);
        } catch (InterruptedException e) {
        }
        mo1.print();
    }
}
