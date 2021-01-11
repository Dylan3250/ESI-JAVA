package esi.atl.g54027.td01;

public final class ImmutableCircle2 {

    private final double radius;
    private final ImmutablePoint center;

    public ImmutableCircle2(ImmutablePoint center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive"
                    + ", received: " + radius);
        }
        this.radius = radius;
        this.center = new ImmutablePoint(center.getX(), center.getY()); //copie défensive .
    }

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public ImmutablePoint getCenter() {
        return new ImmutablePoint(center.getX(), center.getY()); //copie défensive
    }
 
    public ImmutableCircle2 scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive"
                    + ", received: " + factor);
        }
        return new ImmutableCircle2(center, radius * factor);
    }

    @Override
    public String toString() {
        return "Circle : [" + center + ", " + radius + "]";
    }
}

class TestImmutableCircle2 {

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

class TestDefensiveCopyImmutableCircle2 {

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
