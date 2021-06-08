package Ex01DeadLock;

public class B extends Thread {
    private SharedObject obj;

    public B(SharedObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.showValueB("ThreadB");
    }
}
