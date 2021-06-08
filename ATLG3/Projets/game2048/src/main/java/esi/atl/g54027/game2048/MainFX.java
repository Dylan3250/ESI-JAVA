package esi.atl.g54027.game2048;

import esi.atl.g54027.game2048.controller.ControllerFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The principal class to make to initialize game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class MainFX extends Application {

    /**
     * Starts the application and calls the controller.
     *
     * @param stage the principal stage of the application
     * @throws Exception errors if there is a problem with application
     */

    @Override
    public void start(Stage stage) throws Exception {
        new ControllerFX(stage).run();
    }

    /**
     * Defines the point of run for the application.
     *
     * @param args the given arguments to start the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
