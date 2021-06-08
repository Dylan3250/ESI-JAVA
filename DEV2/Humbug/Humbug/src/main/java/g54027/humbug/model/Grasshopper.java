package g54027.humbug.model;

/**
 * Grasshopper is an animal that walks on the board. It jumps to the next free
 * square while bouncing on other animals possibly in its path. It jump over
 * walls and it can fall on the board.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Grasshopper extends Animal {

    /**
     * Defines a position for this grasshopper object.
     *
     * @param pos the given position for the animal
     */
    public Grasshopper(Position pos) {
        super(pos);
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Grasshopper() {
        this(null);
    }

    /**
     * Defines future position of grasshopper for the given direction and deals
     * the case where there is a collision or the grasshopper fall in down.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @returnthe the new defined position for grasshopper
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (!board.isInside(this.getPositionOnBoard())) {
            return null;
        }

        int animalRow = this.getPositionOnBoard().getRow();
        int animalColumn = this.getPositionOnBoard().getColumn();
        Position currentPos = new Position(animalRow, animalColumn);
        Position futurePos = currentPos.next(direction);

        if (!board.isInside(futurePos)) {
            futurePos = null;
        } else {
            futurePos = moveOneJumping(futurePos, direction, animals);

            if (!board.isInside(futurePos)) {
                futurePos = null;
            } else {
                removeStar(board, futurePos);
            }
        }

        setPositionOnBoard(futurePos);
        return futurePos;
    }
}
