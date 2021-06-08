package esi.atl.g54027.blackjack;

import esi.atl.g54027.blackjack.controller.Controller;
import esi.atl.g54027.blackjack.model.Game;
import esi.atl.g54027.blackjack.view.View;

/*
 * Main calls the controller to make the game. This is the main class.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
