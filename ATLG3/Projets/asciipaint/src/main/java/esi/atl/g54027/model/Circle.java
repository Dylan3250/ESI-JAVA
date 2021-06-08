package esi.atl.g54027.model;

/**
 * Makes a new Shape : the circle with given informations.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Circle extends ColoredShape {

    private final Point center;
    private final double radius;

    /**
     * Makes new circle with given informations.
     *
     * @param center the point (x,y) of the new circle
     * @param radius the radius size of the new circle
     * @param color the symbol to print of the new circle
     * @throws IllegalArgumentException given point/radius is not valid
     */
    Circle(Point center, double radius, char color) {
        super(color);
        if (center == null) {
            throw new IllegalArgumentException("Given point is null");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Given radius is minder than 1");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Given point is null");
        }
        // the equation of the circle with given point
        double eqCircle = Math.pow(p.getX() - center.getX(), 2)
                + Math.pow(p.getY() - center.getY(), 2);
        return eqCircle <= Math.pow(radius, 2);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public Point getPoint() {
        return center;
    }
}
