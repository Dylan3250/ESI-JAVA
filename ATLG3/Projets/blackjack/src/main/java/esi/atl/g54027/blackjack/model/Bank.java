package esi.atl.g54027.blackjack.model;

import esi.atl.g54027.cards.Deck;

/**
 * Makes the new Interactor named Bank. He can hit differently for example.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Bank extends Interactor {

    private final Deck deck;

    /**
     * Makes the new Bank player with the current deck.
     *
     * @param deck the current deck on the game
     */
    Bank(Deck deck) {
        super();
        this.deck = deck;
    }

    /**
     * Hit cards while the sum of cards is less than 17.
     *
     * @throws IllegalArgumentException try to hit card and the deck is empty
     */
    void hit() {
        if (deck.size() <= 0) {
            throw new IllegalArgumentException("The deck is now empty");
        }
        while (getTotalCard() < 17) {
            addCard(deck.hit());
        }
    }
}
