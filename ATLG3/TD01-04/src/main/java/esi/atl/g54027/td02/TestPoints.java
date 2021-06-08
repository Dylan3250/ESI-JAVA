package esi.atl.g54027.td02;

public class TestPoints {

    public static void main(String[] args) {
//        Point p = new ColoredPoint(2, 4, 0xFF0000FF);
//        ColoredPoint p2 = new Point(2, 4);
        Object p3 = new Point(2, 4);
        Object p4 = new ColoredPoint(2, 4, 0xFF0000FF);

        ColoredPoint p = new ColoredPoint(2, 4, 0xFF0000FF);
//        p.notifyAll();
        p.move(1, 2);
        System.out.println(p);
        System.out.println("x: " + p.getX());
        System.out.println("color : " + String.format("%08X", p.getColor()));
    }
}
