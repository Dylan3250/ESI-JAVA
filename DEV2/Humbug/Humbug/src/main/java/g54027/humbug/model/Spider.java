package g54027.humbug.model;

/**
 * Spider is an animal that walks on the board. It can move in one direction as
 * long as the square is not occupied by any other animal or it leaves the
 * board.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Spider extends Animal {

    /**
     * Defines a position for this spider object.
     *
     * @param pos the given position for the animal
     */
    public Spider(Position pos) {
        super(pos);
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Spider() {
        this(null);
    }

    /**
     * Defines future position of spider for the given direction and deals the
     * case where there is a collision or the spider fall in down.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @returnthe the new defined position for spider
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position currentPos;
        Position futurePos;

        do {
            int animalRow = this.getPositionOnBoard().getRow();
            int animalColumn = this.getPositionOnBoard().getColumn();
            currentPos = new Position(animalRow, animalColumn);
            futurePos = moveOneCrawling(board, currentPos, direction, animals);
        } while (futurePos != null && !futurePos.equals(currentPos));

        if (futurePos != null) {
            removeStar(board, futurePos);
        }

        return futurePos;
    }
}
