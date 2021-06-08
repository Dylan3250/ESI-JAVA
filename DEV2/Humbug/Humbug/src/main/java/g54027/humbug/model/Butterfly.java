package g54027.humbug.model;

/**
 * Butterfly is an animal that flies on two square (even above the void). If the
 * square is busy, it stops at the next one. It can move in one direction, it
 * jump over walls and it can fall on the board.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Butterfly extends Animal {

    /**
     * Defines a position for this bumbelbee object.
     *
     * @param pos the given position for the animal
     */
    public Butterfly(Position pos) {
        super(pos);
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Butterfly() {
        this(null);
    }

    /**
     * Defines future position of bumbelbee for the given direction and deals
     * the case where there is a collision or the bumbelbee fall in down.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @returnthe the new defined position for bumbelbee
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (!board.isInside(this.getPositionOnBoard())) {
            return null;
        }

        int animalRow = this.getPositionOnBoard().getRow();
        int animalColumn = this.getPositionOnBoard().getColumn();
        Position futurePos = new Position(animalRow, animalColumn)
                .next(direction).next(direction); // Fly on 2 squares

        futurePos = moveOneFlying(board, futurePos, direction, animals);
        return futurePos;
    }
}
