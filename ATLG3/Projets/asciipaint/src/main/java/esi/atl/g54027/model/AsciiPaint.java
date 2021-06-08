package esi.atl.g54027.model;

import java.util.List;

/**
 * The principal class of the mechanic of application. Here is the making of
 * shapes.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class AsciiPaint {
    
    private final Drawing drawing;

    /**
     * Makes a paint with given width and given height to makes shapes.
     *
     * @param width the given width
     * @param height the given height
     */
    public AsciiPaint(int width, int height) {
        drawing = new Drawing(width, height);
    }

    /**
     * Gets the current drawing with shapes.
     *
     * @return the current drawing
     */
    public Drawing getDrawing() {
        return drawing;
    }

    /**
     * Gets the list of shapes in the drawing.
     *
     * @return list of shapes in the drawing
     */
    public List<Shape> getShapes() {
        return drawing.getShapes();
    }

    /**
     * Makes new circle in the drawing with given informations.
     *
     * @param x the x coordinate of the new shape
     * @param y the y coordinate of the new shape
     * @param radius the radius size of the new shape
     * @param color the symbol to print of the new shape
     */
    private void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Makes new rectangle in the drawing with given informations.
     *
     * @param x the x coordinate of the new shape
     * @param y the y coordinate of the new shape
     * @param width the width size of the new shape
     * @param height the height size of the new shape
     * @param color the symbol to print of the new shape
     */
    private void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Makes new square in the drawing with given informations.
     *
     * @param x the x coordinate of the new shape
     * @param y the y coordinate of the new shape
     * @param side the side size of the new shape
     * @param color the symbol to print of the new shape
     */
    private void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

    /**
     * Chooses which shape to add in the drawing after asked the user.
     *
     * @param tasks the array of information given by user to print the shape
     */
    public void makeShape(String[] tasks) {
        // tasks[0] = show|add|delete|stop|move...
        switch (tasks[1].toLowerCase()) { // shape
            case "rectangle":
                newRectangle(
                        Integer.parseInt(tasks[2]), // x
                        Integer.parseInt(tasks[3]), // y
                        Double.parseDouble(tasks[4]), // width
                        Double.parseDouble(tasks[5]), // height
                        tasks[6].charAt(0)); // color
                break;
            case "square":
                newSquare(
                        Integer.parseInt(tasks[2]),
                        Integer.parseInt(tasks[3]),
                        Double.parseDouble(tasks[4]),
                        tasks[5].charAt(0));
                break;
            case "circle":
                newCircle(
                        Integer.parseInt(tasks[2]),
                        Integer.parseInt(tasks[3]),
                        Double.parseDouble(tasks[4]),
                        tasks[5].charAt(0));
                break;
            default:
                throw new IllegalArgumentException(
                        "Given shape not exist : " + tasks[1]);
        }
    }

    /**
     * Moves the choosed shape in the drawing after asked the user.
     *
     * @param tasks the array of information given by user to move the shape
     * @throws IllegalArgumentException choosen shape don't exist
     */
    public void moveShape(String[] tasks) {
        // tasks[0] = show|add|delete|stop|move...
        int id = Integer.parseInt(tasks[1]);
        if (drawing.getShapes().size() - 1 < id) {
            throw new IllegalArgumentException("This shape don't exist");
        }
        Shape shape = drawing.getShapes().get(id);
        shape.getPoint().move(
                Double.parseDouble(tasks[2]),
                Double.parseDouble(tasks[3]));
    }

    /**
     * Deletes the choosed shape in the drawing after asked the user.
     *
     * @param tasks the array of information given by user to delete the shape
     * @throws IllegalArgumentException choosen shape don't exist
     */
    public void deleteShape(String[] tasks) {
        // tasks[0] = show|add|delete|stop|move...
        int id = Integer.parseInt(tasks[1]);
        if (drawing.getShapes().size() - 1 < id) {
            throw new IllegalArgumentException("This shape don't exist");
        }
        drawing.getShapes().remove(id);
    }

    /**
     * Changes the color of the choosed shape in the drawing after asked the
     * user.
     *
     * @param tasks the info's array given by user to change color of the shape
     * @throws IllegalArgumentException choosen shape don't exist
     */
    public void changeColorShape(String[] tasks) {
        // tasks[0] = show|add|delete|stop|move...
        int id = Integer.parseInt(tasks[1]);
        if (drawing.getShapes().size() - 1 < id) {
            throw new IllegalArgumentException("This shape don't exist");
        }
        drawing.getShapes().get(id).setColor(tasks[2].charAt(0));
    }
}
