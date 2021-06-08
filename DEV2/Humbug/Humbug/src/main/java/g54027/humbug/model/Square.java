package g54027.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it’s all. A square
 * doesn’t know where it is on the board.
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 * and Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Square {

    private SquareType type;
    private boolean northWall = false;
    private boolean southWall = false;
    private boolean westWall = false;
    private boolean eastWall = false;

    /**
     * Constructor of Square on board.
     *
     * @param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Square() {
        this(null);
    }

    /**
     * Simple getter of type.
     *
     * @return type of Square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * Sets the type of square.
     *
     * @param type the type of square (GRASS, STAR, ...)
     */
    public void setSquareType(SquareType type) {
        this.type = type;
    }

    /**
     * Sets if there is a wall in the north or not.
     *
     * @param northWall true if there is wall, false otherwise
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Sets if there is a wall in the south or not.
     *
     * @param southWall true if there is wall, false otherwise
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Sets if there is a wall in the west or not.
     *
     * @param westWall true if there is wall, false otherwise
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Sets if there is a wall in the east or not.
     *
     * @param eastWall true if there is wall, false otherwise
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    /**
     * Return if there is a north wall or not.
     *
     * @return true if there is a wall, not otherwise
     */
    public boolean isNorthWall() {
        return northWall;
    }

    /**
     * Return if there is a south wall or not.
     *
     * @return true if there is a wall, not otherwise
     */
    public boolean isSouthWall() {
        return southWall;
    }

    /**
     * Return if there is a west wall or not.
     *
     * @return true if there is a wall, not otherwise
     */
    public boolean isWestWall() {
        return westWall;
    }

    /**
     * Return if there is a east wall or not.
     *
     * @return true if there is a wall, not otherwise
     */
    public boolean isEastWall() {
        return eastWall;
    }

    /**
     * Indicates if there is a wall in the given direction.
     *
     * @param direction the given direction to check
     * @return true if there is a wall, false otherwise
     */
    public boolean hasWall(Direction direction) {
        switch (direction.name()) {
            case "NORTH":
                return northWall;
            case "SOUTH":
                return southWall;
            case "WEST":
                return westWall;
            case "EAST":
                return eastWall;
        }
        return false;
    }
}
