package esi.atl.g54027.td08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestBoundedWildcards {

    static <T> void printGreaterThan(List<? extends Comparable<T>> list, T e) {
        for (Comparable<T> n : list) {
            if (n.compareTo(e) > 0) {
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Number> d = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // static <T> void copy(List<? super T> d, List<? extends T> s)
        Collections.copy(d, s);

        // static <T> void sort(List<T> list, Comparator<? super T> c)
        ArrayList<Integer> r = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Collections.sort(r, (Integer o1, Integer o2) -> {
            return o1 - o2;
        });

        list.add(44);
        list.add(42);
        list.add(43);
        list.add(45);
        list.add(39);
        list.add(47);
        printGreaterThan(list, 43);
    }

}
