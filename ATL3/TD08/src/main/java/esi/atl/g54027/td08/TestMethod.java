package esi.atl.g54027.td08;

import java.util.ArrayList;
import java.util.List;

public class TestMethod {

    public static <T> List<T> arrayToList(T[] t) {
        List<T> list = new ArrayList<>();
        for(T element : t) list.add(element);
        return list;
    }
    public static void main(String[] args) {
        Point[] points = {new Point(), new Point(1,2)};
        List<Point> list = TestMethod.<Point>arrayToList(points);
        // var list = arrayToList(points); -- fonctionne aussi très bien

    }
}