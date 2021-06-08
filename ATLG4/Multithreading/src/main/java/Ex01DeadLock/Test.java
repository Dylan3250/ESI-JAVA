package Ex01DeadLock;

public class Test {
    public static void main(String[] args) {
        var obj = new SharedObject();
        A a = new A(obj);
        B b = new B(obj);
        a.start();
        b.start();
        System.out.println("Lancement du programme");
    }
}
