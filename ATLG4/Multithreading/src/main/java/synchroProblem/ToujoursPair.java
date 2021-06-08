package synchroProblem;

public class ToujoursPair {

    private int i = 0;

    public synchronized void nextI() {
        ++i;
        ++i;
    }

    public synchronized int getI() {
        return i;
    }
}
