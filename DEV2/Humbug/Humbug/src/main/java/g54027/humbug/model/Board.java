package g54027.humbug.model;

import static g54027.humbug.model.SquareType.*;

/**
 * Board is constituted by squares (null if there are not). The board don't know
 * if there are animals who walk on it.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Board {

    /**
     * Defines an inital board and makes an new instance of board.
     *
     * @return new board with the level
     */
    public static Board getInitialBoard() {
        Square[][] board = new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        };
        return new Board(board);
    }

    private final Square[][] squares;

    /**
     * Defines squares in the board.
     *
     * @param squares array of squares for level
     */
    Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Board() {
        this(null);
    }

    /**
     * Gets the number of row represented by this board object.
     *
     * @return the number of row in the board
     */
    public int getNbRow() {
        return squares.length;
    }

    /**
     * Gets the number of column represented by this board object.
     *
     * @return the number of column in the board
     */
    public int getNbColumn() {
        return squares[0].length;
    }

    /**
     * Gets the square array with all squares on the board.
     *
     * @return the square array
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Gives the type of square at the given position.
     *
     * @param pos the given position of square
     * @throws IllegalArgumentException the position is not in the board
     * @return the type of square
     */
    public SquareType getSquareType(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException(
                    "La position n'est pas dans le plateau : " + pos);
        }
        return squares[pos.getRow()][pos.getColumn()].getType();
    }

    /**
     * Sets the type of square at the given position.
     *
     * @param pos the given position of square
     * @param type the new type of square
     * @throws IllegalArgumentException the position is not in the board
     */
    public void setSquareType(Position pos, SquareType type) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException(
                    "La position n'est pas dans le plateau : " + pos);
        }
        squares[pos.getRow()][pos.getColumn()].setSquareType(type);
    }

    /**
     * Checks if the given position is in the board.
     *
     * @param pos the given position
     * @throws IllegalArgumentException the given position is null
     * @return true if the position is not null, false otherwise
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("La position est nulle !");
        }
        boolean isBoundedColumn = pos.getColumn() >= 0
                && pos.getColumn() < squares[0].length;
        boolean isBoundedRow = pos.getRow() >= 0
                && pos.getRow() < squares.length;

        return isBoundedColumn && isBoundedRow
                && squares[pos.getRow()][pos.getColumn()] != null;
    }
}
