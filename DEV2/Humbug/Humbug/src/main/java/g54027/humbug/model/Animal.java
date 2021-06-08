package g54027.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static g54027.humbug.model.SquareType.GRASS;
import static g54027.humbug.model.SquareType.STAR;

/**
 * The animal walks on the board and knows where it is. It may fall. It doesn't
 * know if it's on the star.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Butterfly.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar = false;

    /**
     * Defines a position for this animal object.
     *
     * @param pos the given position for this animal
     */
    public Animal(Position pos) {
        positionOnBoard = pos;
    }

    /**
     * Defines position of animal for the given direction.
     *
     * @param board the board with all squares
     * @param direction the desired given direction
     * @param animals the array with animals
     * @return the new position for this animal
     */
    public abstract Position move(Board board, Direction direction,
            Animal... animals);

    /**
     * Gets the animal position on the board represented by this animal object.
     *
     * @return the animal position on the board
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Defines the animal position on the board represented by this animal.
     *
     * @param positionOnBoard the position of animal on the board
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Checks if the animal is on a star.
     *
     * @return true if the animal is on the star, false otherwise
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Defines the state of star (if the animal is on it or not).
     *
     * @param onStar the new state of star
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Removes the star from the board and changes the animal's state about the
     * star if it is on it.
     *
     * @param board the board with all squares
     * @param position the position of the animal
     */
    protected void removeStar(Board board, Position position) {
        if (board.getSquareType(position).equals(STAR)) {
            board.setSquareType(position, GRASS);
            setOnStar(true);
        }
    }

    /**
     * Returns the new position if there are no animals or if there are animals,
     * they have the star. Else returns the old position.
     *
     * @param futurePos the given future position
     * @param animals the given array with all animals
     * @return if there is a animal, the position is identical than given
     * position, otherwise the new position is returned
     */
    protected Position getValidatePos(Position futurePos, Animal... animals) {
        int i = 0;
        boolean isOnPosition = false;

        while (i < animals.length && !isOnPosition
                && animals[i].getPositionOnBoard() != null) {

            if (animals[i].getPositionOnBoard().equals(futurePos)
                    && !animals[i].isOnStar()) {
                isOnPosition = true;
            }
            i++;
        }

        return (!isOnPosition) ? futurePos : this.getPositionOnBoard();
    }

    /**
     * Returns the position of an animal when it is walking. If it encounters
     * another animal or a wall, it stops. It can fall into the void.
     *
     * @param board the given board
     * @param currentPos the current position of animal
     * @param direction the given direction
     * @param animals the given array with all animals
     * @return the new position of animal after moved
     */
    protected Position moveOneCrawling(Board board, Position currentPos,
            Direction direction, Animal... animals) {
        Position futurePos = currentPos.next(direction);
        int col = currentPos.getColumn();
        int row = currentPos.getRow();
        int futureCol = futurePos.getColumn();
        int futureRow = futurePos.getRow();

        if (board.getSquares()[row][col].hasWall(direction)
                || (board.isInside(futurePos)
                && board.getSquares()[futureRow][futureCol]
                        .hasWall(direction.opposite()))) {
            futurePos = currentPos;
        } else if (!board.isInside(futurePos)) {
            futurePos = null;
        } else {
            futurePos = getValidatePos(futurePos, animals);
        }
        setPositionOnBoard(futurePos);

        return futurePos;
    }

    /**
     * Returns the new position of animal when it jump. If there are other
     * animals on the way, it jumps over and gives the first free position.
     *
     * @param futurePos the given future position
     * @param direction the given direction
     * @param animals the given array with all animals
     * @return if there is a animal, the position is identical than given
     * position, otherwise the new position is returned
     */
    protected Position moveOneJumping(Position futurePos,
            Direction direction, Animal... animals) {
        boolean freePosition = false;


        do {
            boolean isOnPosition = false;
            int i = 0;
            while (i < animals.length && !isOnPosition
                    && animals[i].getPositionOnBoard() != null) {
                if (animals[i].getPositionOnBoard().equals(futurePos)
                        && !animals[i].isOnStar()) {
                    isOnPosition = true;
                }
                i++;
            }

            if (getValidatePos(futurePos, animals)
                    .equals(futurePos.next(direction.opposite()))) {
               isOnPosition = true;
            }

            if (isOnPosition) {
                futurePos = futurePos.next(direction);
            } else {
                freePosition = true;
            }
        } while (!freePosition);

        return futurePos;
    }

    /**
     * After jump, checks if there is an animal and jumps on it while the
     * returned position is not equal to the previous one (so that the square is
     * empty). The animal can fly over the void.
     *
     * @param board the given board
     * @param futurePos the future position after the move
     * @param direction the given direction
     * @param animals the array of animals
     * @return the final position of the animal for this move
     */
    protected Position moveOneFlying(Board board, Position futurePos,
            Direction direction, Animal... animals) {
        do {
            futurePos = moveOneJumping(futurePos.next(direction),
                    direction, animals);
            setPositionOnBoard(futurePos);
        } while (!futurePos.equals(futurePos));

        if (!board.isInside(futurePos)) {
            futurePos = null;
            setPositionOnBoard(futurePos);
        }

        if (futurePos != null) {
            removeStar(board, futurePos);
        }
        return futurePos;
    }
}
