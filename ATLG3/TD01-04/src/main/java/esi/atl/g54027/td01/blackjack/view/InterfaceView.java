package esi.atl.g54027.td01.blackjack.view;

import esi.atl.g54027.td01.blackjack.model.Status;
import esi.atl.g54027.td01.cards.Card;
import java.util.List;

/**
 * InterfaceView calls all elements to make the view. This is the method of
 * communicating with view's method.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface InterfaceView {

    /**
     * Asks if the player wants hit new card.
     *
     * @return true if player wants, false otherwise
     */
    public boolean askNewHit();

    /**
     * Asks if player wants continue to game.
     *
     * @return true if player wants, false otherwise
     */
    public boolean askAgain();

    /**
     * Asks on the player how money he wants to bet in the round.
     *
     * @param playerMoney the player's money
     * @return the number of money that the player's wants to bet between 1 and
     * his money.
     */
    public double askBet(double playerMoney);

    /**
     * Displays the message on the end of round (win, lost and equality).
     *
     * @param playerScore the player's sum of cards
     * @param bankScore the bank's sum of cards
     * @param status the status of the player (win, lost, equality)
     * @throws IllegalArgumentException the given status is not correct
     */
    public void displayFinish(int playerScore, int bankScore, Status status);

    /**
     * Displays the message when the sum of player is more than 21.
     */
    public void displayPlayerOut();

    /**
     * Displays the sum of player's cards.
     *
     * @param playerCards the number of player's cards
     */
    public void displaySum(int playerCards);

    /**
     * Displays selected cards and format the display.
     * @param cards the given cards choosen
     */
    public void displayCards(List<Card> cards);

    /**
     * Displays a recap on the game (money lost/win, rounds, etc.).
     *
     * @param playerMoney the player's money
     * @param oldPlayerMoney the prevous round player's money
     * @param rounds the number of round played.
     */
    public void displayEnd(double playerMoney, double oldPlayerMoney, int rounds);

    /**
     * Formats the given rounds with borders.
     *
     * @param rounds the given number of rounds
     */
    public void displayRound(int rounds);
}
