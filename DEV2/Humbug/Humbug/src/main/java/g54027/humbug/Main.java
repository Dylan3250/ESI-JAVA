package g54027.humbug;

import g54027.humbug.controller.Controller;
import g54027.humbug.model.Game;
import g54027.humbug.view.text.View;

/**
 * Main calls the controller to make the game. This is the main class.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Main {

    /**
     * Starts the game.
     *
     * @param args if empty starts at 0, starts at given level otherwise
     */
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame((args.length <= 0) ? 1 : Integer.valueOf(args[0]));
    }
}
