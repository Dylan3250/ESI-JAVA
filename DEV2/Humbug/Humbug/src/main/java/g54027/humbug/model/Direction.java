package g54027.humbug.model;

/**
 * Direction for a displacement. A displacement is qualified by its direction
 * (north, south, east, west) and can be applied using a delta.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public enum Direction {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Defines a direction with a row delta and a column delta.
     *
     * @param deltaRow the delta of row given
     * @param deltaColumn the delta of column given
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Gets the row delta represented by this direction object.
     *
     * @return the delta of row
     */
    public int getDeltaRow() {
        return this.deltaRow;
    }

    /**
     * Gets the column delta represented by this direction object.
     *
     * @return the delta of column
     */
    public int getDeltaColumn() {
        return this.deltaColumn;
    }

    /**
     * Gives the opposite direction of the given direction.
     *
     * @return the opposite direction
     */
    public Direction opposite() {
        switch (this.name()) {
            case "NORTH":
                return Direction.SOUTH;
            case "SOUTH":
                return Direction.NORTH;
            case "WEST":
                return Direction.EAST;
            case "EAST":
                return Direction.WEST;
        }
        return null;
    }
}
