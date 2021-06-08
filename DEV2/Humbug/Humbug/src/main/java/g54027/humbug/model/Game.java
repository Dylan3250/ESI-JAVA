package g54027.humbug.model;

/**
 * Game takes the necessary elements for the game to makes a facade to the view.
 * The view only interacts with this class for access to the model.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Game implements Model {

    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;
    private LevelStatus levelStatus = LevelStatus.NOT_STARTED;

    /**
     * Gets the board represented by this game object.
     *
     * @return the board with all squares
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Gets animals represented by this game object.
     *
     * @return the array with animals
     */
    @Override
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Checks the status of level (not started, in progress, win, lost).
     *
     * @return the level status (NOT_STARTED, IN_PROGRESS, FAIL, WIN)
     */
    @Override
    public LevelStatus getLevelStatus() {
        return levelStatus;
    }

    /**
     * Gets the number of remaining moves.
     *
     * @return the number of remaining moves
     */
    @Override
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * Gets the current level of the game.
     *
     * @return the current level
     */
    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Defines the board and its animals according to the level requested.
     *
     * @throws IllegalArgumentException level is not possible
     * @param level the number of chosen level
     */
    @Override
    public void startLevel(int level) {
        if (level > 100 || level < 1) {
            throw new IllegalArgumentException("Niveau " + level + " impossible");
        }
        Level lvl = Level.getLevel(level);
        animals = lvl.getAnimals();
        board = lvl.getBoard();
        remainingMoves = lvl.getnMoves();
        currentLevel = level;
        levelStatus = LevelStatus.IN_PROGRESS;
    }

    /**
     * Defines future position of animal for the given direction and take into
     * account the case where there is a collision or the animal fall in down.
     *
     * @param position the animal's position
     * @param direction the desired direction
     * @throws IllegalArgumentException animals or board array is null
     * @throws IllegalStateException the level is not in progress
     */
    @Override
    public void move(Position position, Direction direction) {
        if (getAnimals() == null || getBoard() == null) {
            throw new IllegalArgumentException(""
                    + "Impossible de déplacer sans plateau et/ou animaux !");
        }

        if (levelStatus != LevelStatus.IN_PROGRESS) {
            throw new IllegalStateException("Le niveau n'est pas en cours.");
        }

        boolean isAllowPosition = false;
        int i = 0;

        while (!isAllowPosition && i < getAnimals().length) {
            if (getAnimals()[i].getPositionOnBoard() != null
                    && getAnimals()[i].getPositionOnBoard().equals(position)
                    && !getAnimals()[i].isOnStar()) {
                isAllowPosition = true;
            } else {
                i++;
            }
        }

        if (isAllowPosition) {
            Position oldPos = getAnimals()[i].getPositionOnBoard();
            getAnimals()[i].move(getBoard(), direction, getAnimals());
            Position newPos = getAnimals()[i].getPositionOnBoard();
            if (oldPos != newPos) {
                updateStatus();
            }
        } else {
            throw new IllegalArgumentException(
                    "Impossible de se déplacer si ça n'est pas un animal !");
        }
    }

    /**
     * Updates the status of game after a deplacement.
     */
    private void updateStatus() {
        remainingMoves--;
        int i = 0;
        int maxStar = getAnimals().length;
        boolean isOver = false;

        while (!isOver && i < getAnimals().length) {
            if (animals[i].getPositionOnBoard() == null) {
                isOver = true;
            } else if (getAnimals()[i].isOnStar()) {
                maxStar--;
            }
            i++;
        }
        if (maxStar == 0) {
            levelStatus = LevelStatus.WIN;
        } else if (isOver || remainingMoves == 0) {
            levelStatus = LevelStatus.FAIL;
        } else {
            levelStatus = LevelStatus.IN_PROGRESS;
        }
    }
}
