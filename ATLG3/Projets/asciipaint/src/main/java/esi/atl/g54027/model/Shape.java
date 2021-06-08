package esi.atl.g54027.model;

/**
 * For makes new Shape, it is mandatory to have theses methods (like move, get
 * the color, checks if the point is inside of shape, ...).
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface Shape {

    /**
     * Checks if the given point is in the shape.
     *
     * @param p the given poinnt
     * @return true if the point is in the shape, false otherwise
     * @throws IllegalArgumentException given point is null
     */
    boolean isInside(Point p);

    /**
     * Moves the shape taking into account the given delta x and delta y.
     *
     * @param dx the given delta x
     * @param dy the given delta y
     */
    void move(double dx, double dy);

    /**
     * Gets the color of the shape.
     *
     * @return the color of the shape
     */
    char getColor();

    /**
     * Defines the color with new given color.
     *
     * @param color the new given color
     */
    void setColor(char color);

    /**
     * Gets the name of the shape.
     *
     * @return the name of the shape
     */
    String getName();

    /**
     * Gets the principal point of the shape.
     *
     * @return the principal point of the shape
     */
    public Point getPoint();
}
