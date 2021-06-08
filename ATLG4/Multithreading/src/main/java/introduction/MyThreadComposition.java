package introduction;

public class MyThreadComposition {
    private Thread thread;

    public MyThreadComposition() {
        thread = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 50000; ++j) ;
                System.out.println("MyThreadCompo : " + i);
            }
        });
    }

    public void start() {
        thread.start();
    }

}
