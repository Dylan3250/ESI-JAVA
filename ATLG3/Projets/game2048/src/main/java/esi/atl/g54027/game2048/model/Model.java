package esi.atl.g54027.game2048.model;

import java.beans.PropertyChangeListener;

/**
 * The model class is able to protecting the game with polymorphism. It is only
 * this class will communicate with the controller.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface Model {

    /**
     * Defines listeners to make the link with the view.
     *
     * @param listener the given listener to make the link
     */
    public void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * Gets the array of squares objects.
     *
     * @return the array with all squares objects
     */
    public Square[][] getSquares();

    /**
     * Gives the current score of the game.
     *
     * @return the current score of the game (when 2 squares merging, the score
     * is one of the square.
     */
    public int getScore();

    /**
     * Gets the status of the game.
     *
     * @return the status of the game
     */
    public GameStatus getStatus();

    /**
     * Defines the new status of the game.
     *
     * @param status the new status of the game
     */
    public void setStatus(GameStatus status);

    /**
     * Defines what to do if the game is starting (like edits the gameStatus,
     * starts the board, etc.).
     */
    public void initGame();

    /**
     * Checks if one square achieved the score 2048.
     *
     * @return true if the max score achieved, false otherwise
     */
    public boolean isMaxScore();

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the right side.
     */
    public void right();

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the left side.
     */
    public void left();

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the bottom side.
     */
    public void bottom();

    /**
     * If two same number stick together, they merge on condition that one of
     * the two boxes has not already merged. After merging, moves each square to
     * the top side.
     */
    public void top();

    /**
     * Adds the random number of the board after got an empty Square.
     *
     * @return true if insert was okay, false otherwise
     */
    public boolean addRdmNumber();

    /**
     * Checks if there is adjacent square with same values.
     *
     * @return true if there is square with same value, false otherwise
     */
    public boolean checkAllAdjacent();
}
