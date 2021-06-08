package g54027.humbug.model;

/**
 * Ladybird is an animal that walks on the board. It can move in one direction
 * as long as two squares is not occupied by any other animal or it leaves the
 * board.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Ladybird extends Animal {

    /**
     * Defines a position for this ladybird object.
     *
     * @param pos the given position for the animal
     */
    public Ladybird(Position pos) {
        super(pos);
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Ladybird() {
        this(null);
    }

    /**
     * Defines future position of ladybird for the given direction and deals the
     * case where there is a collision or the ladybird fall in down.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @returnthe the new defined position for ladybird
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (!board.isInside(this.getPositionOnBoard())) {
            return null;
        }

        Position currentPos, futurePos;
        int countMove = 0;

        do {
            int animalRow = this.getPositionOnBoard().getRow();
            int animalColumn = this.getPositionOnBoard().getColumn();
            currentPos = new Position(animalRow, animalColumn);

            futurePos = moveOneCrawling(board, currentPos, direction, animals);
            countMove++;
        } while (countMove < 2 && futurePos != null &&
                !futurePos.equals(currentPos));

        if (futurePos != null) {
            removeStar(board, futurePos);
        }

        return futurePos;
    }
}
