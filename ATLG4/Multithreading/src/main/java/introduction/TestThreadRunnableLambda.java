package introduction;

public class TestThreadRunnableLambda {

    public static void main(String[] args) {
        // String name = "lambda_";
        new Thread(() -> {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("introduction.syncho.MyThread: lambda: " + i);
            // System.out.println("introduction.syncho.MyThread: " + name + ": " + i);
        }
         }).start();

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("introduction.TestMyThread: " + i);
        }
    }

}