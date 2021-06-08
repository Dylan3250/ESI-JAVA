package synchroProblem;

public class Test {

    public static void main(String[] args) {
        ToujoursPair tp = new ToujoursPair();
        MyThread t = new MyThread(tp);
        t.start();
        while (true) {
            tp.nextI();
            if (tp.getI() % 1000000 == 0) {
                System.out.println(tp.getI());
            }
        }
    }
}
