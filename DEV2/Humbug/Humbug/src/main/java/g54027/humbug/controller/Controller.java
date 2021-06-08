package g54027.humbug.controller;

import g54027.humbug.model.Direction;
import g54027.humbug.model.LevelStatus;
import g54027.humbug.model.Model;
import g54027.humbug.model.Position;
import g54027.humbug.view.text.InterfaceView;

/**
 * Controller is responsible for the dynamics of the game and updating the view
 * as the game progresses.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * Defines the game and its view to make dynamics of the game.
     *
     * @param game the given instance of game
     * @param view the given instance of view
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Starts the game with its level, end checks, requests for position and
     * direction and error handling.
     *
     * @param nLevel the given level of game
     */
    public void startGame(int nLevel) {
        int maxLevel = 100;

        do {
            try {
                game.startLevel(nLevel);

                while (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
                    view.displayCurrentLevel(game.getCurrentLevel());
                    view.displayBoard(game.getBoard(), game.getAnimals());
                    view.displayRemainingMoves(game.getRemainingMoves());
                    Position position = view.askPosition();
                    Direction direction = view.askDirection();
                    try {
                        game.move(position, direction);
                    } catch (Exception e) {
                        view.displayError(e.getMessage());
                    }
                    view.displayMsgStatus(game.getLevelStatus());
                }
                view.displayBoard(game.getBoard(), game.getAnimals());

                if (game.getLevelStatus() == LevelStatus.WIN) {
                    nLevel++;
                }
            } catch (Exception e) {
                nLevel++;
            }
        } while (nLevel <= maxLevel);

        if (game.getLevelStatus() == LevelStatus.WIN && nLevel > maxLevel) {
            view.displayEnd();
        }
    }
}
