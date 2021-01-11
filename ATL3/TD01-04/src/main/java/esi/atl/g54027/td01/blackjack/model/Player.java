package esi.atl.g54027.td01.blackjack.model;

import esi.atl.g54027.td01.cards.Deck;
import java.util.stream.IntStream;

/**
 * Makes the new Interactor named Player. He can hit differently for example.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Player extends Interactor {

    private final Deck deck;

    /**
     * Makes the new Player player with the current deck.
     *
     * @param deck the current deck on the game
     */
    Player(Deck deck) {
        super();
        this.deck = deck;
    }

    /**
     * Hit the given number of cards in the deck.
     *
     * @param number the given number of cards to hit
     * @throws IllegalArgumentException try to hit the given number of cards and
     * the deck have not the number of cards
     */
    void hit(int number) {
        if (deck.size() < number) {
            throw new IllegalArgumentException("The deck have not "
                    + number + " cards");
        }

        IntStream.range(0, number)
            .forEach(d -> {
                this.addCard(deck.hit());
        });
    }
}
