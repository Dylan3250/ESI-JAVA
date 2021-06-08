package g54027.humbug.view.text;

import g54027.humbug.model.Animal;
import g54027.humbug.model.Board;
import g54027.humbug.model.Direction;
import g54027.humbug.model.LevelStatus;
import g54027.humbug.model.Position;

/**
 * InterfaceView has all the methods that must in the view for a correct
 * progress in the game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface InterfaceView {

    /**
     * Displays the board with each element of the game.
     *
     * @param animals the array with animals
     * @param board the board with all squares
     */
    void displayBoard(Board board, Animal... animals);

    /**
     * Asks the player to give a position of animal in console.
     *
     * @return the asked position
     */
    Position askPosition();

    /**
     * Asks the player which direction to take to move the chosen animal.
     *
     * @return the borrowed direction
     */
    Direction askDirection();

    /**
     * Displays an error message in console.
     *
     * @param message the given string
     */
    void displayError(String message);

    /**
     * Displays the number of remaining moves.
     *
     * @param remainingMoves the given number of remaining moves
     */
    void displayRemainingMoves(int remainingMoves);

    /**
     * Displays the current level of the game.
     *
     * @param currentLevel the current level of game
     */
    void displayCurrentLevel(int currentLevel);

    /**
     * Displays a message when the game is done.
     */
    void displayEnd();

    /**
     * Displays a message when the player won or failed.
     *
     * @param levelStatus the level status (WIN, FAIL)
     */
    void displayMsgStatus(LevelStatus levelStatus);
}
