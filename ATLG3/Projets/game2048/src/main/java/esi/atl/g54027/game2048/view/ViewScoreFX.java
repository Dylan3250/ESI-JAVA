package esi.atl.g54027.game2048.view;

import esi.atl.g54027.game2048.controller.ControllerFX;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ViewScoreFX implements PropertyChangeListener {

    private ControllerFX controller;

    private final VBox root = new VBox(10);
    private final Label score = new Label();
    private final Scene scene = new Scene(root, 120, 60);

    /**
     * Defines the controller of the game.
     *
     * @param controller the given controller of the game
     */
    public void setController(ControllerFX controller) {
        this.controller = controller;
    }

    /*
     * Makes the principal view of Application with the board, buttons, etc.
     *
     * @param stage the principal stage of JavaFX
     */
    public void makeView(Stage stage) {
        root.setPadding(new Insets(20, 10, 20, 10));
        root.getChildren().addAll(score);
        stage.setTitle("Score 2048 - BRICAR Dylan 54027");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }

    /**
     * Defines actions when de model changed to update the view.
     *
     * @param pce the given name of the changement with old/new values, etc
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "updateScore":
                score.setText((int) pce.getNewValue() > 0 ? "Score : "
                        + pce.getNewValue() : "Score à venir");
                break;
            default:
                break;
        }
    }
}
