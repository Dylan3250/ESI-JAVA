package esi.atl.g54027.blackjack.model;

import esi.atl.g54027.cards.Deck;
import java.util.List;

/**
 * Game takes the necessary elements for the game to makes the view. This class
 * only interacts with the view class for access to the model.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Game implements Model {

    private Deck deck;
    private Bank bank;
    private Player player;
    private Status gameStatus;
    private int round = 0;
    private double playerMoney = 1000;
    private double betedMoney;
    private double oldPlayerMoney;

    @Override
    public void resetGame() {
        deck = new Deck();
        bank = new Bank(deck);
        player = new Player(deck);
        gameStatus = Status.IN_PROGRESS;
        oldPlayerMoney = playerMoney;
        betedMoney = 0;
        round += 1;
    }

    @Override
    public int getRound() {
        return round;
    }

    @Override
    public double getPlayerMoney() {
        return playerMoney;
    }

    @Override
    public double getOldPlayerMoney() {
        return oldPlayerMoney;
    }

    @Override
    public int getPlayerTotalCards() {
        return player.getTotalCard();
    }

    @Override
    public int getBankTotalCards() {
        return bank.getTotalCard();
    }

    @Override
    public List getPlayerCardsList() {
        return player.getCardList();
    }

    @Override
    public List getBankCardsList() {
        return bank.getCardList();
    }

    @Override
    public Status getGameStatus() {
        return gameStatus;
    }

    @Override
    public void setBetedMoney(double betedMoney) {
        this.betedMoney = betedMoney;
    }

    @Override
    public void deckShuffle() {
        deck.suffle();
    }

    @Override
    public void playerHit(int number) {
        player.hit(number);
        if (isPlayerLost()) {
            gameStatus = Status.LOST;
        }
    }

    @Override
    public void bankHit() {
        bank.hit();
    }

    @Override
    public boolean isPlayerLost() {
        return player.isLost();
    }

    @Override
    public void updateWinner() {
        if (getPlayerTotalCards() == 21 || (getBankTotalCards() > 0
                && getBankTotalCards() < getPlayerTotalCards() || bank.isLost())) {
            gameStatus = Status.WIN;
            playerMoney += betedMoney;
        } else if (getBankTotalCards() > getPlayerTotalCards() || isPlayerLost()) {
            gameStatus = Status.LOST;
            playerMoney -= betedMoney;
        } else {
            gameStatus = Status.EQUALITY;
        }
    }
}
