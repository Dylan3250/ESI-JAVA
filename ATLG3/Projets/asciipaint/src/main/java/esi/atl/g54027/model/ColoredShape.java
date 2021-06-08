package esi.atl.g54027.model;

/**
 * Defines the coloredshape, it is a shape with color (symbol) possibilites.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Makes new colored Shape with the given color.
     *
     * @param color the given color
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return color;
    }

    @Override
    public void setColor(char color) {
        this.color = color;
    }
}
