package esi.atl.g54027.game2048.model;

/**
 * Defines the Square object. The board is make up of a lot of squares. A square
 * has a number and can be merged with another square.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Square {

    private int value = 0;

    /**
     * Gets the value of the square.
     *
     * @return the value of the square
     */
    public int getValue() {
        return value;
    }

    /**
     * Defines the new value of the square.
     *
     * @param value the new value of the square
     */
    public void setValue(int value) {
        this.value = value;
    }
}
