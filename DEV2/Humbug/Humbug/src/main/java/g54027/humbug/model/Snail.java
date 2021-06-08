package g54027.humbug.model;

/**
 * Snail is an animal that walks on the board. It can move one square if this
 * square is not occupied by any other animal. It can fall on the board.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Snail extends Animal {

    /**
     * Defines a position for this snail object.
     *
     * @param pos the given position for the animal
     */
    public Snail(Position pos) {
        super(pos);
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Snail() {
        this(null);
    }

    /**
     * Defines future position of snail for the given direction and deals the
     * case where there is a collision or the snail fall in down.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @returnthe the new defined position for snail
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (!board.isInside(this.getPositionOnBoard())) {
            return null;
        }

        int animalRow = this.getPositionOnBoard().getRow();
        int animalColumn = this.getPositionOnBoard().getColumn();
        Position currentPos = new Position(animalRow, animalColumn);
        Position futurePos = moveOneCrawling(
                board, currentPos, direction, animals);

        if (futurePos != currentPos && futurePos != null) {
            removeStar(board, futurePos);
        }

        return futurePos;
    }
}
