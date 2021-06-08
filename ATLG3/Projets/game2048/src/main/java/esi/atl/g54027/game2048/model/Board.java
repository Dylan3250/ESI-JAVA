package esi.atl.g54027.game2048.model;

import java.util.Arrays;
import java.util.Random;

/**
 * Defines the game board. The board is make up of squares object. The board is
 * a square. This class have methods for aligning the square with selected
 * action, define random value, etc.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Board {

    private static final Random rand = new Random();

    /**
     * Defines the default board with default Square.
     */
    private final Square[][] squares = new Square[][]{
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}
    };

    private int score = 0;

    /**
     * Gets the squares with squares objects.
     *
     * @return the array with all squares objects
     */
    Square[][] getSquares() {
        return squares;
    }

    /**
     * Gives the current score of the game.
     *
     * @return the score of the game.
     */
    int getScore() {
        return score;
    }

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the left side.
     *
     * @return true if the board changed, false otherwise
     */
    boolean left() {
        boolean updated = false;
        for (var lgSquares : squares) {
            // Add values in the left order.
            Square value = null;
            for (var square : lgSquares) {
                if (square.getValue() != 0) {
                    if (value == null) {
                        value = square;
                    } else if (square.getValue() == value.getValue()) {
                        score += value.getValue();
                        value.setValue(value.getValue() * 2);
                        square.setValue(0);
                        value = null;
                    } else {
                        value = square;
                    }
                }
            }

            // Displacement of the boxes for them to be contiguous.
            int indexEmpty = 0;
            for (int col = 0; indexEmpty < lgSquares.length
                    && col < lgSquares.length; col++) {
                if (lgSquares[col].getValue() == 0
                        && lgSquares[indexEmpty].getValue() != 0) {
                    indexEmpty = col;
                    continue;
                }

                while (indexEmpty < lgSquares.length
                        && lgSquares[indexEmpty].getValue() != 0) {
                    indexEmpty++;
                }

                if (indexEmpty < col && lgSquares[col].getValue() != 0) {
                    lgSquares[indexEmpty].setValue(lgSquares[col].getValue());
                    lgSquares[col].setValue(0);
                    updated = true;

                }
            }
        }
        return updated;
    }

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the top side.
     *
     * @return true if the board changed, false otherwise
     */
    boolean top() {
        boolean updated = false;
        for (int col = 0; col < squares.length; col++) {
            // Add values in the top order.
            Square value = null;
            for (var lgSquare : squares) {
                if (lgSquare[col].getValue() != 0) {
                    if (value == null) {
                        value = lgSquare[col];
                    } else if (lgSquare[col].getValue() == value.getValue()) {
                        score += value.getValue();
                        value.setValue(value.getValue() * 2);
                        lgSquare[col].setValue(0);
                        value = null;
                    } else if (lgSquare[col].getValue() != value.getValue()) {
                        value = lgSquare[col];
                    }
                }
            }

            // Displacement of the boxes for them to be contiguous.
            int indexEmpty = 0;
            for (int lgSquare = 0; indexEmpty < squares.length
                    && lgSquare < squares.length; lgSquare++) {

                if (squares[lgSquare][col].getValue() == 0
                        && indexEmpty <= squares.length - 1
                        && squares[indexEmpty][col].getValue() != 0) {
                    continue;
                }

                while (indexEmpty <= squares.length - 1
                        && squares[indexEmpty][col].getValue() != 0) {
                    indexEmpty++;
                }

                if (indexEmpty < lgSquare && squares[lgSquare][col].getValue() != 0) {
                    squares[indexEmpty][col].setValue(squares[lgSquare][col].getValue());
                    squares[lgSquare][col].setValue(0);
                    updated = true;
                }
            }
        }
        return updated;

    }

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the right side.
     *
     * @return true if the board changed, false otherwise
     */
    boolean right() {
        boolean updated = false;
        for (var lgSquare : squares) {
            // Add values in the right order.
            Square value = null;
            for (int col = lgSquare.length - 1; col >= 0; col--) {
                if (lgSquare[col].getValue() != 0) {
                    if (value == null) {
                        value = lgSquare[col];
                    } else if (lgSquare[col].getValue() == value.getValue()) {
                        score += value.getValue();
                        value.setValue(value.getValue() * 2);
                        lgSquare[col].setValue(0);
                        value = null;
                    } else {
                        value = lgSquare[col];
                    }
                }
            }

            // Displacement of the boxes for them to be contiguous.
            int indexEmpty = lgSquare.length - 1;
            for (int col = lgSquare.length - 1;
                    indexEmpty >= 0 && col >= 0; col--) {
                if (lgSquare[col].getValue() == 0
                        && indexEmpty > 0
                        && lgSquare[indexEmpty].getValue() != 0) {
                    continue;
                }

                while (indexEmpty > 0 && lgSquare[indexEmpty].getValue() != 0) {
                    indexEmpty--;
                }

                if (indexEmpty > col && lgSquare[col].getValue() != 0) {
                    lgSquare[indexEmpty].setValue(lgSquare[col].getValue());
                    lgSquare[col].setValue(0);
                    updated = true;

                    if (indexEmpty < lgSquare.length - 1) {
                        indexEmpty++;
                    }
                }
            }
        }
        return updated;
    }

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the bottom side.
     *
     * @return true if the board changed, false otherwise
     */
    boolean bottom() {
        boolean updated = false;
        for (int col = 0; col < squares.length; col++) {
            // Add values in the bottom order.
            Square value = null;
            for (int lgSquare = squares.length - 1; lgSquare >= 0; lgSquare--) {
                if (squares[lgSquare][col].getValue() != 0) {
                    if (value == null) {
                        value = squares[lgSquare][col];
                    } else if (squares[lgSquare][col].getValue() == value.getValue()) {
                        score += value.getValue();
                        value.setValue(value.getValue() * 2);
                        squares[lgSquare][col].setValue(0);
                        value = null;
                    } else if (squares[lgSquare][col].getValue() != value.getValue()) {
                        value = squares[lgSquare][col];
                    }
                }
            }

            // Displacement of the boxes for them to be contiguous.
            int indexEmpty = squares.length - 1;
            for (int lgSquare = squares.length - 1; indexEmpty >= 0
                    && lgSquare >= 0; lgSquare--) {
                if (squares[lgSquare][col].getValue() == 0
                        && indexEmpty > 0
                        && squares[indexEmpty][col].getValue() != 0) {
                    continue;
                }

                while (indexEmpty > 0 && squares[indexEmpty][col].getValue() != 0) {
                    indexEmpty--;
                }

                if (indexEmpty > lgSquare && squares[lgSquare][col].getValue() != 0) {
                    squares[indexEmpty][col].setValue(squares[lgSquare][col].getValue());
                    squares[lgSquare][col].setValue(0);
                    updated = true;

                }
            }
        }
        return updated;
    }

    /**
     * Adds a new number (2 in 80% of chance, else 4) to the Square board if
     * there is a zero. Starts by searching between random given values and the
     * end of the array. Then search between start values and random values.
     *
     * @return true if the insertion was correct, false otherwise
     */
    boolean addRdmNumber() {
        int maxLgSquare = rand.nextInt((squares.length - 1) + 1);
        int maxCol = rand.nextInt((squares.length - 1) + 1);
        int lgSquare = maxLgSquare;
        int col = maxCol;
        int valSquare = rand.nextInt(10 + 1) > 8 ? 4 : 2;

        // Checks the first 0 between random line, column and end of array
        int[] find = findEmpty(lgSquare, col, squares.length);
        lgSquare = find[0];
        col = find[1];

        // Any 0 find in second part of array, search in the first part
        // between 0 and random line and column
        if (lgSquare == 4) {
            lgSquare = 0;
            find = findEmpty(lgSquare, col, maxLgSquare);
            lgSquare = find[0];
            col = find[1];
        }

        if (lgSquare < 4 && squares[lgSquare][col].getValue() == 0) {
            squares[lgSquare][col].setValue(valSquare);
            return true;
        }
        return false;
    }

    /**
     * Checks if there is zero between given range in the board of squares.
     *
     * @param lgSquare given number line to begin
     * @param col given number of column to begin
     * @param maxLgSquare given number of max line to check
     * @return array with new number of line and new number of column, if there
     * are same than given value, any zero found
     */
    private int[] findEmpty(int lgSquare, int col, int maxLgSquare) {
        while (lgSquare < maxLgSquare && squares[lgSquare][col].getValue() != 0) {
            while (col < squares.length && squares[lgSquare][col].getValue() != 0) {
                col++;
            }

            if (col != squares.length && squares[lgSquare][col].getValue() == 0) {
                break;
            } else {
                col = 0;
                lgSquare++;
            }
        }
        return new int[]{lgSquare, col};
    }

    /**
     * Checks adjacents squares if there are same values.
     *
     * @return true if there is same value, false otherwise
     */
    boolean checkAllAdjacent() {
        for (int ln = 0; ln < squares.length; ln++) {
            for (int col = 0; col < squares.length; col++) {
                if (squares[ln][col].getValue() == 0) {
                    continue;
                }
                if ((ln != 0 && squares[ln - 1][col].getValue()
                        == squares[ln][col].getValue()) // top
                        || (ln != 3 && squares[ln + 1][col].getValue()
                        == squares[ln][col].getValue()) // bottom
                        || (col != 0 && squares[ln][col - 1].getValue()
                        == squares[ln][col].getValue()) // left
                        || (col != 3 && squares[ln][col + 1].getValue()
                        == squares[ln][col].getValue())) { // right
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there is a Square with 2048 value or more.
     *
     * @return true if there is a Square with 2048 or more, false otherwise
     */
    boolean isWon() {
        return Arrays.stream(squares)
                .flatMap(Arrays::stream).parallel()
                .anyMatch(x -> x.getValue() >= 2048);
    }
}
