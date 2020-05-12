package g54027.dev2.td07.list;

import java.util.Arrays;

public class IntegerList {

    private int logicalSize = 0;
    private int[] list = new int[1];

    public void add(int element) {
        if (list.length <= logicalSize) {
            list = Arrays.copyOf(list, list.length * 2);
        }

        list[logicalSize] = element;
        logicalSize++;
    }

    public int size() {
        return logicalSize;
    }

    public int get(int index) {
        return list[index];
    }

    public void clear() {
        logicalSize = 0;
    }

    public boolean contains(int element) {
        int i = 0;
        while (i < logicalSize && list[i] != element) {
            i++;
        }

        return i != logicalSize;
    }

    public boolean isEmpty() {
        return logicalSize == 0;
    }
}
