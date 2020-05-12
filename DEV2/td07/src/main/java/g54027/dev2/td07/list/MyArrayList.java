package g54027.dev2.td07.list;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    /*
    public static void main(String[] args) {
        var a = new MyArrayList<Integer>();
        a.add(2);
        a.add(9);
        a.display();

        for (Integer i : a) {
            System.out.println(i);
        }
        
        var b = new MyArrayList<Boolean>();
        b.add(true);
        b.add(false);
        b.display();

        for (Boolean i : b) {
            System.out.println(i);
        }
    }

    public void display() {
        System.out.println(Arrays.toString(list));
    }
    */

    private int logicalSize = 0;
    private Object[] list = new Object[1];

    public void add(E element) {
        if (list.length <= logicalSize) {
            list = Arrays.copyOf(list, list.length * 2);
        }

        list[logicalSize] = element;
        logicalSize++;
    }

    public int size() {
        return logicalSize;
    }

    public E get(int index) {
        return (E) list[index];
    }

    public void clear() {
        logicalSize = 0;
    }

    public boolean contains(E element) {
        int i = 0;
        while (i < logicalSize && list[i] != element) {
            i++;
        }
        return i != logicalSize;
    }

    public boolean isEmpty() {
        return logicalSize == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < logicalSize;
            }

            @Override
            public E next() {
                return (E) list[current++];
            }
        };
    }
}