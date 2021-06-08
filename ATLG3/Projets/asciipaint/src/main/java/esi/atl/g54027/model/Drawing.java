package esi.atl.g54027.model;

import java.util.ArrayList;
import java.util.List;

/**
 * All objects about Drawing is here. Every shape to print is added in the
 * defined drawing.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Drawing {

    private final List<Shape> shapes;
    private final int height;
    private final int width;

    /**
     * Defines new Drawing with given size.
     *
     * @param width the given width
     * @param height the given height
     * @throws IllegalArgumentException width or height of drawing too small.
     */
    public Drawing(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width or height of drawing too "
                    + "small.");
        }
        this.width = width;
        this.height = height;
        shapes = new ArrayList<>();
    }

    /**
     * Adds the given shape to the shape's list.
     *
     * @param shape the given shape to
     * @throws IllegalArgumentException Given shape is null
     */
    void addShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Given shape is null");
        }
        shapes.add(shape);
    }

    /**
     * Gets the shape at the given point if there is one, null otherwise.
     *
     * @param p the given point to check if there is a shape
     * @return the shape if there is one, null otherwise
     * @throws IllegalArgumentException Given point is null
     */
    public Shape getShapeAt(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Given point is null");
        }

        int i = 0;
        Shape shape = null;
        int shapesSize = shapes.size();
        while (i < shapesSize && shape == null) {
            if (shapes.get(i).isInside(p)) {
                shape = shapes.get(i);
            }
            i++;
        }
        return shape;
    }

    /**
     * Gets the height of the drawing.
     *
     * @return the height of the drawing
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the drawing.
     *
     * @return the width of the drawing
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the list of shapes.
     *
     * @return list of shapes
     */
    List<Shape> getShapes() {
        return shapes;
    }
}
