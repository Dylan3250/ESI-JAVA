package esi.atl.g54027.td08;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ArrayList<T> implements Iterable<T> {

    private Object[] list = new Object[10];
    private int logicalSize = 0;

    public T get(int i) {
        if (i > logicalSize) {
            throw new IllegalArgumentException("Given number out of bound");
        }
        return (T) list[i];
    }

    public void set(int i, T value) {
        if (i > logicalSize) {
            throw new IllegalArgumentException("Given number out of bound");
        }
        list[i] = value;
    }

    public void add(T elt) {
        if (logicalSize > list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[logicalSize] = elt;
        logicalSize++;
    }

    public boolean contains(T elt) {
        int i = 0;
        while (i < logicalSize && list[i] != elt) {
            i++;
        }
        return i != logicalSize;
    }

    public int size() {
        return logicalSize;
    }

    public boolean isEmpty() {
        return logicalSize == 0;
    }

    public void clear() {
        logicalSize = 0;
    }

    /**
     * Une méthode statique qui permet d’afficher les éléments d’une de vos
     * listes (esi.atl.ArrayList), qui sont supérieurs à un élément passé en
     * paramètre.
     */
    public static <T> void showSuperiorAt(ArrayList<? extends Comparable> list, T elt) {
        for (Comparable<T> item : list) {
            if (item.compareTo(elt) > 0) {
                System.out.println(item);
            }
        }
    }

    /**
     * Une méthode statique qui permet de copier une de vos listes passée en
     * paramètre dans une java.util.List.
     */
    public static <T> List copyListUtil(ArrayList<T> list) {
        List<T> listUtil = new java.util.ArrayList();
        for (T item : list) {
            listUtil.add(item);
        }
        return listUtil;
    }

    /**
     * Une méthode statique qui permet de trier une liste passée en paramètre en
     * fonction d’un Comparator.
     */
    public static <T> void sort(ArrayList<T> list, Comparator<? super T> comparator) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(i)) > 0) {
                    Object tmp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, (T) tmp);
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < logicalSize;
            }

            @Override
            public T next() {
                return (T) list[current++];
            }
        };
    }
}
