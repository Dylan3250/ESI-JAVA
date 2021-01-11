package esi.atl.g54027.td01.blackjack.controller;

import esi.atl.g54027.td01.blackjack.model.Model;
import esi.atl.g54027.td01.blackjack.view.InterfaceView;

/**
 * Controller is responsible for the dynamics of the game and updating the view
 * as the game progresses.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public final class Controller {

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
     * Starts the game with the player, the bank and asks questions to progress
     * in the game (like the bet, etc.).
     */
    public void startGame() {
        boolean play = true;

        while (play && game.getPlayerMoney() > 0) {
            game.resetGame();
            view.displayRound(game.getRound());
            game.setBetedMoney(view.askBet(game.getPlayerMoney()));
            game.deckShuffle();
            game.playerHit(2);
            view.displayCards(game.getPlayerCardsList());
            view.displaySum(game.getPlayerTotalCards());

            while (!game.isPlayerLost() && game.getPlayerTotalCards() != 21 && view.askNewHit()) {
                game.playerHit(1);
                view.displayCards(game.getPlayerCardsList());
                view.displaySum(game.getPlayerTotalCards());
            }

            if (game.isPlayerLost()) {
                game.updateWinner();
                view.displayPlayerOut();
            } else {
                if (game.getPlayerTotalCards() != 21) {
                    game.bankHit();
                    view.displayCards(game.getBankCardsList());
                }
                game.updateWinner();
                view.displayFinish(game.getPlayerTotalCards(),
                        game.getBankTotalCards(), game.getGameStatus());
            }
            // Stops the game if the player had less than 1 euro.
            play = (game.getPlayerMoney() > 0) ? view.askAgain() : false;
        }
        view.displayEnd(game.getPlayerMoney(), game.getOldPlayerMoney(),
                game.getRound());
    }
}
