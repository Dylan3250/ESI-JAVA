package esi.atl.g54027.td02;

public class Point implements Movable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point move(double dx, double dy) {
        x += dx;
        y += dy;
        return this;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
