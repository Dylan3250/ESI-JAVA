package esi.atl.g54027.game2048.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The game class is the main class to control the game mechanic (likes to move,
 * sets random squares, etc.).
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Game implements Model {

    private Board board;
    private GameStatus status = GameStatus.NOT_STARTED;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private int oldScore = 0;
    private int displacement;
    private Direction oldMovement;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Updates listeners with new values for the view.
     *
     * @param movement the new given movement on the board
     * @param updated true if the movement changed the board, false otherwise
     */
    private void updateListeners(Direction movement, boolean updated) {
        pcs.firePropertyChange("updateSquare", null, getSquares());
        if (updated) {
            pcs.firePropertyChange("addDisplacementList", 
                    displacement, displacement + 1);
            pcs.firePropertyChange("updateScore", oldScore, getScore());
            displacement += 1;
            oldScore = board.getScore();
            pcs.firePropertyChange("addEventList", null, movement);
        } else {
            movement = Direction.INVALID;
            pcs.firePropertyChange("addEventList", oldMovement, movement);
        }
        oldMovement = movement;
    }

    /**
     * Defines the constructor of the game with the initial board and the
     * initial status of the game.
     */
    public Game() {
        board = new Board();
        status = GameStatus.NOT_STARTED;
    }

    @Override
    public Square[][] getSquares() {
        return board.getSquares();
    }

    @Override
    public int getScore() {
        return board.getScore();
    }

    @Override
    public GameStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(GameStatus status) {
        pcs.firePropertyChange("updateStatus", this.status, status);
        this.status = status;
    }

    @Override
    public boolean isMaxScore() {
        return board.isWon();
    }

    @Override
    public void initGame() {
        board = new Board();
        displacement = 0;
        status = GameStatus.STARTED;
        addRdmNumber();
        pcs.firePropertyChange("updateSquare", null, getSquares());
        pcs.firePropertyChange("updateStatus", null, status);
        pcs.firePropertyChange("addDisplacementList", null, 0);
        pcs.firePropertyChange("updateScore", null, 0);
    }

    @Override
    public void right() {
        updateListeners(Direction.RIGHT, board.right());
    }

    @Override
    public void left() {
        updateListeners(Direction.LEFT, board.left());
    }

    @Override
    public void bottom() {
        updateListeners(Direction.BOTTOM, board.bottom());
    }

    @Override
    public void top() {
        updateListeners(Direction.TOP, board.top());
    }

    @Override
    public boolean addRdmNumber() {
        return board.addRdmNumber();
    }

    @Override
    public boolean checkAllAdjacent() {
        return board.checkAllAdjacent();
    }
}
