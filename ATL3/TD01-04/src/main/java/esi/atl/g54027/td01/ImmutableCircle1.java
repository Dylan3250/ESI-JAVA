package esi.atl.g54027.td01;

public final class ImmutableCircle1 {

    private final double radius;
    private final Point center;

    public ImmutableCircle1(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive"
                    + ", received: " + radius);
        }
        this.radius = radius;
        this.center = new Point(center.getX(), center.getY()); //copie défensive .
    }

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY()); //copie défensive
    }

    public ImmutableCircle1 scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive"
                    + ", received: " + factor);
        }
        return new ImmutableCircle1(center, radius * factor);
    }

    @Override
    public String toString() {
        return "Circle : [" + center + ", " + radius + "]";
    }
}

class TestImmutableCircle1 {

    public static void main(String args[]) {
        Point p = new Point();
        Circle c = new Circle(p, 5);
        System.out.println(c);
        c.move(2, 5);
        System.out.println(c);
        c.scale(2);
        System.out.println(c);
    }
}

class TestDefensiveCopyImmutableCircle1 {

    public static void main(String args[]) {
        Point p = new Point();
        Circle c = new Circle(p, 5);
        System.out.println(c);
        p.move(2, 5); //on bouge le point et non pas le cercle.
        System.out.println(c);
        Point p2 = c.getCenter();
        p2.move(-2, -5);
        System.out.println(c);
    }
}
