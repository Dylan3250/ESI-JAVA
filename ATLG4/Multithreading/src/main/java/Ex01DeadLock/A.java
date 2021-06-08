package Ex01DeadLock;

public class A extends Thread {
    private SharedObject obj;

    public A(SharedObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.showValueA("ThreadA");
    }
}
