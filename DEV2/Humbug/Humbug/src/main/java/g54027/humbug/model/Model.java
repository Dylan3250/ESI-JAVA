package g54027.humbug.model;

/**
 * Model calls all elements to make the game (like checks when the level is
 * over, which level choose, etc).
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface Model {

    /**
     * Gets the board represented by this game object.
     *
     * @return the board with all squares
     */
    Board getBoard();

    /**
     * Gets animals represented by this game object.
     *
     * @return the array with animals
     */
    Animal[] getAnimals();

    /**
     * Defines the board and its animals according to the level requested.
     *
     * @param level the number of chosen level
     */
    void startLevel(int level);

    /**
     * Checks the status of level (not started, in progress, win, lost).
     *
     * @return the level status (NOT_STARTED, IN_PROGRESS, FAIL, WIN)
     */
    LevelStatus getLevelStatus();

    /**
     * Gets the number of remaining moves.
     *
     * @return the number of remaining moves
     */
    int getRemainingMoves();

    /**
     * Gets the current level of the game.
     *
     * @return the current level
     */
    int getCurrentLevel();

    /**
     * Defines future position of animal for the given direction and take into
     * account the case where there is a collision or the animal fall in down.
     *
     * @param position the animal's position
     * @param direction the desired direction
     */
    void move(Position position, Direction direction);
}
