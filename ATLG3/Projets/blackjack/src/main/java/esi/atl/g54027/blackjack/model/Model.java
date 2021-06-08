package esi.atl.g54027.blackjack.model;

import java.util.List;

/**
 * Model calls all elements to make the game (like checks if the player lost,
 * hit new cards, etc.). This is the method of communicating with view.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public interface Model {

    /**
     * Resets the game (interactor, status, score, ...) and update the money or
     * the round.
     */
    public void resetGame();

    /**
     * Gets the number of round.
     *
     * @return the number of round
     */
    public int getRound();

    /**
     * Gets the money of the player.
     *
     * @return the money of the player
     */
    public double getPlayerMoney();

    /**
     * Gets the player's money in the previous round.
     *
     * @return the old money of the player
     */
    public double getOldPlayerMoney();

    /**
     * Gets the sum of all the player's cards.
     *
     * @return the sum of player's cards
     */
    public int getPlayerTotalCards();

    /**
     * Gets the sum of all the bank's cards.
     *
     * @return the sum of bank's cards
     */
    public int getBankTotalCards();

    /**
     * Gets all Player's cards for the game
     *
     * @return list of cards of the player
     */
    public List getPlayerCardsList();

    /**
     * Gets all Bank's cards for the game
     *
     * @return list of cards of the bank
     */
    public List getBankCardsList();

    /**
     * Gets the game's status (WIN, LOST, IN_PROGRESS, ...).
     *
     * @return the game's status
     */
    public Status getGameStatus();

    /**
     * Updates the money bet if the player won or lost.
     *
     * @param betedMoney the beted money
     */
    public void setBetedMoney(double betedMoney);

    /**
     * Shuffles the card on the deck for the game.
     */
    public void deckShuffle();

    /**
     * Hits the number of cards on the deck for the player.
     *
     * @param number the number of cards to hit
     */
    public void playerHit(int number);

    /**
     * Hits cards on the deck while the total is less than 17 for the bank.
     */
    public void bankHit();

    /**
     * Checks if the player lost.
     *
     * @return true if the player lost, false otherwise
     */
    public boolean isPlayerLost();

    /**
     * Updates the status of the player (WIN, LOST, IN_PROGRESS, ...) and the
     * money of the player.
     */
    public void updateWinner();
}
