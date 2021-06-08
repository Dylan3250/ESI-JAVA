package g54027.humbug.model;

/**
 * Position on the board. A position has a row and a column, can be compared and
 * calculus are possible to predict the future position.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Defines a position with its row and its column.
     *
     * @param row the given integer for row
     * @param column the given integer for column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Position() {
        this(0, 0);
    }

    /**
     * Gets the number of the row represented by this position object.
     *
     * @return the number of the row
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the number of the column represented by this position object.
     *
     * @return the number of the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Defines a new position with the old position and the direction given.
     *
     * @param pos the given direction (N, S, E, W)
     * @return the new defined position with the direction given
     */
    public Position next(Direction pos) {
        int newColum = getColumn() + pos.getDeltaColumn();
        int newRow = getRow() + pos.getDeltaRow();
        return new Position(newRow, newColum);
    }

    /**
     * Rewrites the way to display informations.
     *
     * @return the row and the column in formatted text
     */
    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }

    /**
     * Computes the hash code value for this position.
     *
     * @return the hashcode for this position
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.row;
        hash = 17 * hash + this.column;
        return hash;
    }

    /**
     * Compares the specified object with this position for equality.
     *
     * @param obj the given object
     * @return true if they are identical, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.getRow()) {
            return false;
        }
        return this.column == other.getColumn();
    }
}
