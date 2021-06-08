package esi.atl.g54027.model;

/**
 * Gestion of point, it is possible to make new point and move it, get
 * informations about it, etc.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public final class Point {

    private double x;
    private double y;

    /**
     * Makes new point at given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x coordinate
     *
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y coordinate
     *
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Moves the point to delta x and delta y given.
     *
     * @param dx the given delta x
     * @param dy the given delta y
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
