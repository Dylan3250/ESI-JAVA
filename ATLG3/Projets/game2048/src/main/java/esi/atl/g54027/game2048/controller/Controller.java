package esi.atl.g54027.game2048.controller;

import esi.atl.g54027.game2048.model.GameStatus;
import esi.atl.g54027.game2048.model.Model;
import esi.atl.g54027.game2048.view.View;

/**
 * Defines the controller of the game. The controller links the view, and the
 * model to view and to treat the mechanics of the game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Controller {

    private final Model model;
    private final View view;

    /**
     * Defines the model and the view given by the main class.
     *
     * @param model the given model
     * @param view the given view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Init the game, the board and define the number by default of moves.
     *
     * @return 0 is the number by default of moves
     */
    private int initGame() {
        model.initGame();
        view.showBoard(model.getSquares(), 0, 0);
        return 0;
    }

    /**
     * Runs the game, ask player what action he wants, define the board, add the
     * random value, checks if the game is win, etc.
     */
    public void run() {
        int nbMoves = initGame();

        while (model.getStatus() == GameStatus.STARTED) {
            String asked = view.askDirection();
            if (asked.matches("t|top")) {
                model.top();
            } else if (asked.matches("r|right")) {
                model.right();
            } else if (asked.matches("l|left")) {
                model.left();
            } else if (asked.matches("b|bottom")) {
                model.bottom();
            }
            nbMoves++;
            boolean isAdded = model.addRdmNumber();
            boolean isMaxScore = model.isMaxScore();
            view.showBoard(model.getSquares(), nbMoves, model.getScore());

            if (isMaxScore || (!isAdded && !model.checkAllAdjacent())) {
                model.setStatus(isMaxScore ? GameStatus.WON : GameStatus.LOST);
                view.showBoard(model.getSquares(), nbMoves, model.getScore());
                view.showEndGame(nbMoves, model.getScore(), model.getStatus());
                if (view.askAgain().matches("y|yes")) {
                    nbMoves = initGame();
                }
            }
        }
    }
}
