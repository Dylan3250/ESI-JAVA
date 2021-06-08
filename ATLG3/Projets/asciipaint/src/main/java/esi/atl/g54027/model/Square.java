package esi.atl.g54027.model;

/**
 * Makes a new Shape : the rectangle with given informations.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
class Square extends Rectangle {

    /**
     * Makes new square with given informations (calls the rectangle constructor
     * because a square is a rectangle).
     *
     * @param upperLeft the upper left point (x,y) of the new square
     * @param side the side size of the new square
     * @param color the symbol to print of the new square
     */
    Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    @Override
    public String getName() {
        return "Square";
    }
}
