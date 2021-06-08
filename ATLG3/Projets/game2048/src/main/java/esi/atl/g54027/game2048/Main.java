package esi.atl.g54027.game2048;

import esi.atl.g54027.game2048.controller.Controller;
import esi.atl.g54027.game2048.model.Game;
import esi.atl.g54027.game2048.view.View;

/**
 * The principal class to make to initialize game with model and view.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Main {

    /**
     * Initializes the game with the model and the view.
     *
     * @param args given arguments to run the application (not used here)
     */
    public static void main(String[] args) {
        new Controller(new Game(), new View()).run();
    }
}
