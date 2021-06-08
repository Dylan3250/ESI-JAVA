package esi.atl.g54027.td01;

public class Point {

    private double x;
    private double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(Point p) {
        this(p.x, p.y);
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

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void move(int dx, int dy) {
        System.out.println("méthode move(int, int)");
        x += dx;
        y += dy;
    }

    /* 
    public boolean move(double dx, double dy) {
        x += dx;
        y += dy;
        return true;
    }
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class TestPoint {

    public static void main(String args[]) {
        Point p = new Point();
        System.out.println(p);
        // System.out.println(p.x);
        p.move(2, 2);
        System.out.println(p);
    }
}
