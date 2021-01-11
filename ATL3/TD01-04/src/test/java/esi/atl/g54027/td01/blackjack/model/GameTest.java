package esi.atl.g54027.td01.blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGameReset() {
        Model game = new Game();
        game.resetGame();
        assertTrue(game.getBankTotalCards() == 0);
        assertTrue(game.getGameStatus() == Status.IN_PROGRESS);
        assertTrue(game.getOldPlayerMoney() == 1000);
        assertTrue(game.getPlayerMoney() == 1000);
        assertTrue(game.getPlayerTotalCards() == 0);
        assertTrue(game.getRound() == 1);
    }

    @Test
    public void testGameMultipeHitLost() {
        Model game = new Game();
        game.resetGame();
        game.playerHit(10);
        assertTrue(game.getPlayerTotalCards() <= 100);
        assertTrue(game.getGameStatus() == Status.LOST);
    }

    @Test
    public void testGameEgality() {
        Model game = new Game();

        do {
            int count = 0;
            game.resetGame();
            game.deckShuffle();
            while (count < 30 && (game.getPlayerTotalCards() < 17
                    || game.getPlayerTotalCards() > 21)) {
                count++;
                game.playerHit(1);
            }
            game.bankHit();
        } while (game.getBankTotalCards() != game.getPlayerTotalCards());

        game.setBetedMoney(1);
        game.updateWinner();
        assertTrue(game.getGameStatus() == Status.EQUALITY);
        assertTrue(game.getPlayerMoney() == game.getOldPlayerMoney());
    }

    @Test
    public void testGameLost() {
        Model game = new Game();

        do {
            game.resetGame();
            game.deckShuffle();
            game.playerHit(1);
            game.bankHit();
        } while (game.getBankTotalCards() <= game.getPlayerTotalCards()
                || game.getBankTotalCards() > 21);

        game.setBetedMoney(1);
        game.updateWinner();
        assertTrue(game.getGameStatus() == Status.LOST);
        assertTrue(game.getPlayerMoney() < game.getOldPlayerMoney());
    }

    @Test
    public void testGameWin() {
        Model game = new Game();

        do {
            game.resetGame();
            game.deckShuffle();
            game.playerHit(3);
            game.bankHit();
        } while (game.getBankTotalCards() >= game.getPlayerTotalCards()
                || game.getPlayerTotalCards() > 21);

        game.setBetedMoney(1);
        game.updateWinner();
        assertTrue(game.getGameStatus() == Status.WIN);
        assertTrue(game.getPlayerMoney() > game.getOldPlayerMoney());
    }
}
