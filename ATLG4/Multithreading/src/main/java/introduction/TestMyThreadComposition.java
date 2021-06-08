package introduction;

public class TestMyThreadComposition {

    public static void main(String[] args) {
        var myThreadComposition = new MyThreadComposition();
        myThreadComposition.start();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 500000; ++j) ;
            System.out.println("introduction.TestMyThread: " + i);
        }
    }
}
