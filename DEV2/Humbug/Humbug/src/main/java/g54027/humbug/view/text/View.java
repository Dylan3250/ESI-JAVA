package g54027.humbug.view.text;

import g54027.humbug.model.Animal;
import g54027.humbug.model.Board;
import g54027.humbug.model.Bumbelbee;
import g54027.humbug.model.Butterfly;
import g54027.humbug.model.Direction;
import g54027.humbug.model.Grasshopper;
import g54027.humbug.model.Ladybird;
import g54027.humbug.model.LevelStatus;
import g54027.humbug.model.Position;
import g54027.humbug.model.Snail;
import g54027.humbug.model.Spider;
import g54027.humbug.model.Square;
import g54027.utils.TerminalColor;
import java.util.Scanner;

/**
 * Views on the game. Multiples methods that are used to display the board or
 * interact with player.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class View implements InterfaceView {

    /**
     * Displays the board with each element of the game.
     *
     * @param animals the array with animals
     * @param board the board with all squares
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] boardToDisplay = makeConvertedBoard(board, animals);

        for (String[] lg : boardToDisplay) {
            for (int col = 0; col < boardToDisplay[0].length; col++) {
                if (lg[col] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(TerminalColor.BG_GREEN + lg[col]);

                    /* Adds spaces between each elements of these elements is
                    not at the end of board */
                    if (!lg[col].equals("--")
                            && (col < boardToDisplay[0].length - 1
                            && (lg[col + 1] != null
                            || col != boardToDisplay[0].length - 1))) {
                        System.out.print(" ");
                    }
                }
                System.out.print(TerminalColor.DEFAULT);
            }
            System.out.println();
        }
    }

    /**
     * Makes a new String array with each value of board array and animal array
     * to format them according to the element.
     *
     * @param board the board with all squares
     * @param animals the array with animals
     * @return new array of string with each value formated
     */
    private String[][] makeConvertedBoard(Board board, Animal... animals) {
        var boardToDisplay
                = new String[board.getNbRow() * 5][board.getNbColumn() * 5];

        // Creates the array with all squares
        for (int lg = 0; lg < board.getNbRow(); lg++) {
            for (int col = 0; col < board.getNbColumn(); col++) {
                Position pos = new Position(lg, col);
                if (board.isInside(pos)) {
                    String item = colorize(board.getSquareType(pos).name());
                    Square square = board.getSquares()[lg][col];
                    addElement(boardToDisplay, lg, col, square, item);
                }
            }
        }

        // Adds in the array all animals
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard() != null && !animal.isOnStar()) {
                int col = animal.getPositionOnBoard().getColumn();
                int row = animal.getPositionOnBoard().getRow();
                String fromatString = "";

                if (animal instanceof Spider) {
                    fromatString = colorize("SPIDER");
                } else if (animal instanceof Snail) {
                    fromatString = colorize("SNAIL");
                } else if (animal instanceof Grasshopper) {
                    fromatString = colorize("GRASSHOPPER");
                } else if (animal instanceof Ladybird) {
                    fromatString = colorize("LADYBIRD");
                } else if (animal instanceof Bumbelbee) {
                    fromatString = colorize("BUMBELBEE");
                } else if (animal instanceof Butterfly) {
                    fromatString = colorize("BUTTERFLY");
                }
                boardToDisplay[row * 5 + 2][col * 5 + 2] = fromatString;
            }
        }
        return boardToDisplay;
    }

    /**
     * Creates an array 5x5 with separators, walls and the principal element.
     *
     * @param boardToDisplay the future array with all squares and animals
     * @param lg the line currently checked
     * @param col the column currently checked
     * @param square the square currently checked
     * @param item the principal square (GRASS, STAR, ...)
     */
    private void addElement(String[][] boardToDisplay, int lg, int col,
            Square square, String item) {

        // Top separators
        boardToDisplay[lg * 5][col * 5] = "--";
        boardToDisplay[lg * 5][col * 5 + 1] = "--";
        boardToDisplay[lg * 5][col * 5 + 2] = "--";
        boardToDisplay[lg * 5][col * 5 + 3] = "--";
        boardToDisplay[lg * 5][col * 5 + 4] = "-";

        // Vertical separators above the article and the north wall if there is
        boardToDisplay[lg * 5 + 1][col * 5] = "|";
        boardToDisplay[lg * 5 + 1][col * 5 + 1] = " ";
        boardToDisplay[lg * 5 + 1][col * 5 + 2]
                = checkWall(square, Direction.NORTH);
        boardToDisplay[lg * 5 + 1][col * 5 + 3] = " ";
        boardToDisplay[lg * 5 + 1][col * 5 + 4] = "|";

        // Vertical separators, item and walls on the right and left
        boardToDisplay[lg * 5 + 2][col * 5] = "|";
        boardToDisplay[lg * 5 + 2][col * 5 + 1]
                = checkWall(square, Direction.WEST);
        boardToDisplay[lg * 5 + 2][col * 5 + 2] = item;
        boardToDisplay[lg * 5 + 2][col * 5 + 3]
                = checkWall(square, Direction.EAST);
        boardToDisplay[lg * 5 + 2][col * 5 + 4] = "|";

        // Vertical separators bellow the article and the south wall if there is
        boardToDisplay[lg * 5 + 3][col * 5] = "|";
        boardToDisplay[lg * 5 + 3][col * 5 + 1] = " ";
        boardToDisplay[lg * 5 + 3][col * 5 + 2]
                = checkWall(square, Direction.SOUTH);
        boardToDisplay[lg * 5 + 3][col * 5 + 3] = " ";
        boardToDisplay[lg * 5 + 3][col * 5 + 4] = "|";

        // Bottom separators
        boardToDisplay[lg * 5 + 4][col * 5] = "--";
        boardToDisplay[lg * 5 + 4][col * 5 + 1] = "--";
        boardToDisplay[lg * 5 + 4][col * 5 + 2] = "--";
        boardToDisplay[lg * 5 + 4][col * 5 + 3] = "--";
        boardToDisplay[lg * 5 + 4][col * 5 + 4] = "-";
    }

    /**
     * Checks if there is a wall in the given direction
     *
     * @param square the current given square
     * @param direction the given direction
     * @return the symbol and color if there is a wall, space otherwise
     */
    private String checkWall(Square square, Direction direction) {
        return (square.hasWall(direction)) ? TerminalColor.RED
                + Character.toString((char) 0x25A0) : " ";
    }

    /**
     * Changes the color of the item if there is a color and gives it the
     * format.
     *
     * @param element the given string to check
     * @return the string with the color if there is any.
     */
    private String colorize(String element) {
        String item;
        switch (element) {
            case "GRASS":
                item = " ";
                break;
            case "STAR":
                item = TerminalColor.RED + "*";
                break;
            case "SNAIL":
                item = TerminalColor.YELLOW + "E";
                break;
            case "SPIDER":
                item = TerminalColor.BLUE + "A";
                break;
            case "GRASSHOPPER":
                item = TerminalColor.CYAN + "S";
                break;
            case "LADYBIRD":
                item = TerminalColor.RED + "C";
                break;
            case "BUMBELBEE":
                item = TerminalColor.YELLOW + "B";
                break;
            case "BUTTERFLY":
                item = TerminalColor.MAGENTA + "P";
                break;
            default:
                item = element;
                break;
        }
        return item;
    }

    /**
     * Displays an error message in console.
     *
     * @param message the given string
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Asks the player to give a position of animal in console.
     *
     * @return the asked position
     */
    @Override
    public Position askPosition() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez choisir une position [ligne,colonne] : ");

        while (!keyboard.hasNext("([0-9]+),([0-9]+)")) {
            displayError(
                    "Veuillez suivre le format de position [ligne,colonne] : ");
            keyboard.next();
        }

        String[] positions = keyboard.next().split(",");
        return new Position(Integer.parseInt(positions[0]),
                Integer.parseInt(positions[1]));
    }

    /**
     * Asks the player which direction to take to move the chosen animal.
     *
     * @return the borrowed direction
     */
    @Override
    public Direction askDirection() {
        Scanner keyboard = new Scanner(System.in);
        var northArrow = Character.toString((char) 0x2191);
        var southArrow = Character.toString((char) 0x2193);
        var westArrow = Character.toString((char) 0x2190);
        var eastArrow = Character.toString((char) 0x2192);
        var formatCardinaux = "[N " + northArrow + ", S " + southArrow
                + ", W " + westArrow + " ou E " + eastArrow + "]";

        System.out.print("Veuillez choisir une direction "
                + formatCardinaux + " : ");

        while (!keyboard.hasNext("^(?i)\\bN|\\bS|\\bW|\\bE")) {
            displayError("Veuillez indiquer un résultat dans le format "
                    + formatCardinaux + " : ");
            keyboard.next();
        }

        switch (keyboard.next().toLowerCase()) {
            case "n":
                return Direction.NORTH;
            case "s":
                return Direction.SOUTH;
            case "w":
                return Direction.WEST;
            case "e":
                return Direction.EAST;
            default:
                return null;
        }
    }

    /**
     * Displays the number of remaining moves.
     *
     * @param remainingMoves the given number of remaining moves
     */
    @Override
    public void displayRemainingMoves(int remainingMoves) {
        makeTitle("Il vous reste " + remainingMoves + " mouvement"
                + plurial(remainingMoves) + " !");
    }

    /**
     * Displays the current level of the game.
     *
     * @param currentLevel the current level of game
     */
    @Override
    public void displayCurrentLevel(int currentLevel) {
        makeTitle("Vous êtes au niveau n°" + currentLevel + " :");
    }

    /**
     * Displays a message when the player won or failed.
     *
     * @param levelStatus the level status (WIN, FAIL)
     */
    @Override
    public void displayMsgStatus(LevelStatus levelStatus) {
        switch (levelStatus) {
            case FAIL:
                System.out.println(TerminalColor.RED + "\nVous avez perdu, "
                        + "réessayez !\n" + TerminalColor.DEFAULT);
                break;
            case WIN:
                System.out.println(TerminalColor.GREEN + "\nFélicitations, "
                        + "vous avez réussi !\n" + TerminalColor.DEFAULT);
                break;
            default:
                break;
        }
    }

    /**
     * Displays a message when the game is done.
     */
    @Override
    public void displayEnd() {
        System.out.println(TerminalColor.CYAN + "\nBRAVO ! Vous avez terminé "
                + "le jeu !" + TerminalColor.DEFAULT);
    }

    /**
     * Checks if the word should be in the plural (add s).
     *
     * @param nb the number of things
     * @return "s" if number is bigger than 1, nothing otherwise
     */
    private String plurial(int nb) {
        return (nb > 1) ? "s" : "";
    }

    /**
     * Makes the format for titles.
     *
     * @param title the given string like title
     */
    private void makeTitle(String title) {
        var str = new StringBuilder();
        int space = 5;

        // Top border
        str.append("\n");
        str.append(TerminalColor.BG_CYAN);
        str.append(TerminalColor.RED);
        str.append("|");
        str.append("-".repeat(title.length() + space * 2));
        str.append("|");
        str.append(TerminalColor.DEFAULT);

        // Jump line
        str.append("\n");
        str.append(TerminalColor.BG_CYAN);
        str.append(TerminalColor.RED);
        str.append("|");

        // Body
        str.append(" ".repeat(space));
        str.append(title);
        str.append(" ".repeat(space));
        str.append("|");

        // Jump line
        str.append(TerminalColor.DEFAULT);
        str.append("\n");
        str.append(TerminalColor.BG_CYAN);
        str.append(TerminalColor.RED);
        str.append("|");

        // Bottom border
        str.append("-".repeat(title.length() + space * 2));
        str.append("|");
        str.append(TerminalColor.DEFAULT);
        str.append("\n");

        System.out.println(str);
    }
}
