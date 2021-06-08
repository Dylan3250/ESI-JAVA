package esi.atl.g54027.model;

/**
 * Makes a new Shape : the rectangle with given informations.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
class Rectangle extends ColoredShape {

    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Makes new rectangle with given informations.
     *
     * @param upperLeft the upper left point (x,y) of the new rectangle
     * @param width the width width of the new rectangle
     * @param height the height width of the new rectangle
     * @param color the symbol to print of the new rectangle throws
     * @throws IllegalArgumentException given point/size are not valid
     *
     */
    Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (upperLeft == null) {
            throw new IllegalArgumentException("Given point is null");
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Given size are minder than 1");
        }
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isInside(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Given point is null");
        }
        // checks all corner of the rectangle
        return p.getX() >= upperLeft.getX()
                && p.getX() < upperLeft.getX() + width
                && p.getY() >= upperLeft.getY()
                && p.getY() < upperLeft.getY() + height;
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public Point getPoint() {
        return upperLeft;
    }
}
