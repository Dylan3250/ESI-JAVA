package introduction;

public class TestMyThread {

    public static void main(String[] args) {
        MyThread t = new MyThread("one");
        t.start(); // appel la méthode et crée un thread
        //t.run(); -- appel une méthode banale (sans multi)
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 500000; ++j) ;
            System.out.println("introduction.TestMyThread: " + i);
        }
    }
}
