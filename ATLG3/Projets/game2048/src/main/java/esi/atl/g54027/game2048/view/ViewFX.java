package esi.atl.g54027.game2048.view;

import esi.atl.g54027.game2048.controller.ControllerFX;
import esi.atl.g54027.game2048.model.Direction;
import esi.atl.g54027.game2048.model.GameStatus;
import esi.atl.g54027.game2048.model.Square;
import esi.atl.g54027.game2048.view.components.ActionsList;
import esi.atl.g54027.game2048.view.components.Board;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Objects;

/**
 * The main class of the view. The player will communicate with this class to
 * progress in the game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ViewFX implements PropertyChangeListener {

    private ControllerFX controller;

    private final VBox root = new VBox(10);
    private final HBox gameContainer = new HBox(10);
    private final Board board = new Board();
    private final ActionsList actionsList = new ActionsList();
    private final HBox bottomContainer = new HBox(10);
    private final Region separator = new Region();
    private final Label score = new Label();
    private final Label displacement = new Label();
    private final VBox buttonsContainer = new VBox(5);
    private final Scene scene = new Scene(root, 600, 480);
    private final ImageView imgAgain = new ImageView(new Image(Objects.requireNonNull(
            getClass().getClassLoader().getResourceAsStream("again.png"))));
    private final Button restartButton = new Button("Recommencer", imgAgain);
    private final ImageView imgInfo = new ImageView(new Image(Objects.requireNonNull(
            getClass().getClassLoader().getResourceAsStream("info.png"))));
    private final Button infoButton = new Button("Comment jouer ?", imgInfo);

    /**
     * Defines the controller of the game.
     *
     * @param controller the given controller of the game
     */
    public void setController(ControllerFX controller) {
        this.controller = controller;
    }

    /**
     * Defines the alert to display when the player needs help.
     */
    private void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Comment jouer ?");
        alert.setHeaderText("Informations sur le jeu");
        alert.setContentText("Le but du jeu est d'atteindre 2048. "
                + "Des cases avec 2 ou 4 apparaissent aléatoirement.\n\n"
                + "- Flèche gauche : glisse tout vers la gauche.\n"
                + "- Flèche droite : glisse tout vers la droite.\n"
                + "- Flèche haut : glisse tout vers le haut.\n"
                + "- Flèche bas : glisse tout vers le bas.\n");
        alert.showAndWait();
    }

    /*
     * Makes the principal view of Application with the board, buttons, etc.
     *
     * @param stage the principal stage of JavaFX
     */
    public void makeView(Stage stage) {
        root.getStyleClass().add("body");
        root.setPadding(new Insets(20, 10, 20, 10));

        // -----------------------------
        // ------ DEFINE CHILDREN AND CLASS
        // -----------------------------
        gameContainer.getChildren().addAll(board, actionsList);
        HBox.setHgrow(separator, Priority.ALWAYS);

        score.getStyleClass().add("score");
        displacement.getStyleClass().add("displacement");

        buttonsContainer.getChildren().addAll(restartButton, infoButton);
        bottomContainer.getChildren().addAll(
                score, displacement, separator, buttonsContainer);

        // -----------------------------
        // ------ GLOBAL CONFIGURATION
        // -----------------------------
        root.getChildren().addAll(gameContainer, bottomContainer);
        stage.setTitle("2048 - BRICAR Dylan 54027");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass()
                .getClassLoader().getResourceAsStream("icon.png"))));
        URL css = getClass().getResource("/styles.css");
        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();

        // -----------------------------
        // ------ DEFINE ACTIONS
        // -----------------------------
        restartButton.setOnAction(e -> controller.start());
        infoButton.setOnAction(e -> showHelp());

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                case DOWN:
                case LEFT:
                case RIGHT:
                    controller.makeAction(e.getCode());
                    break;
            }
        });

        scene.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                root.requestFocus();
            }
        });
    }

    /**
     * Defines actions when de model changed to update the view.
     *
     * @param pce the given name of the changement with old/new values, etc
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "updateSquare":
                board.updateBoard((Square[][]) pce.getNewValue());
                break;
            case "updateScore":
                score.setText((int) pce.getNewValue() > 0 ? "Score : "
                        + pce.getNewValue() : "Score à venir");
                break;
            case "addDisplacementList":
                displacement.setText((int) pce.getNewValue() > 0 ? "Déplacement : "
                        + pce.getNewValue() : "Déplacement à venir");
                break;
            case "addEventList":
                actionsList.updateDisplacement((Direction) pce.getNewValue());
                break;
            case "updateStatus":
                actionsList.updateStatus((GameStatus) pce.getNewValue());
                root.requestFocus();
                break;
            default:
                break;
        }
    }
}
