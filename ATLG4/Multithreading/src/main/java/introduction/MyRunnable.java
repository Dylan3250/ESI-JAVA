package introduction;

public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10000000; ++j) ;
            System.out.println("introduction.MyRunnable: " + name + " : " + i);
        }
    }
}