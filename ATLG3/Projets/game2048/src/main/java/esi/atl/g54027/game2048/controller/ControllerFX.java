package esi.atl.g54027.game2048.controller;

import esi.atl.g54027.game2048.model.Game;
import esi.atl.g54027.game2048.model.GameStatus;
import esi.atl.g54027.game2048.model.Model;
import esi.atl.g54027.game2048.view.ViewFX;
import esi.atl.g54027.game2048.view.ViewScoreFX;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * Defines the controller of the game. The controller links the view, and the
 * model and to treat the mechanics of the game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ControllerFX {

    private final ViewFX view;
    private final ViewScoreFX viewScore;
    private final Model model;
    private final Stage stage;
    private final Stage stageScore = new Stage();

    /**
     * Defines the controller of the Application.
     *
     * @param stage the principal given stage of the JavaFX Application
     */
    public ControllerFX(Stage stage) {
        this.stage = stage;
        model = new Game();
        view = new ViewFX();
        viewScore = new ViewScoreFX();
    }

    /**
     * Makes the principal view of Application (with its controller), defines
     * listeners and starts the application.
     */
    public void run() {
        model.addPropertyChangeListener(view);
        model.addPropertyChangeListener(viewScore);
        view.setController(this);
        view.makeView(stage);
        viewScore.makeView(stageScore);
        start();
    }

    /**
     * Starts the Application and defines the initial values of the game.
     */
    public void start() {
        model.initGame();
    }

    /**
     *
     * Performs the given move and update the game to check if there is an
     * ending (player won or lost).
     *
     * @param event the given pressed key to choose the action
     */
    public void makeAction(KeyCode event) {
        if (model.getStatus() == GameStatus.STARTED) {
            switch (event) {
                case UP:
                    model.top();
                    break;
                case DOWN:
                    model.bottom();
                    break;
                case LEFT:
                    model.left();
                    break;
                case RIGHT:
                    model.right();
                    break;
            }
            boolean isAdded = model.addRdmNumber();
            boolean isMaxScore = model.isMaxScore();

            if (isMaxScore || (!isAdded && !model.checkAllAdjacent())) {
                model.setStatus(isMaxScore ? GameStatus.WON : GameStatus.LOST);
            }
        }
    }
}
