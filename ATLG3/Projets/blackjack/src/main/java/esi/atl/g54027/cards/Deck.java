package esi.atl.g54027.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dylan BRICAR 54027
 */
public class Deck {

    /**
     * List with cards on the game.
     */
    private final List<Card> cards;

    /**
     * Inserts all cards in the game.
     */
    public Deck() {
        cards = new ArrayList<>();
        Arrays.asList(Color.values()).forEach(c -> {
            Arrays.asList(Value.values()).forEach(v -> {
                cards.add(new Card(c, v));
            });
        });
    }

    /**
     * Checks if all cards are hitted.
     *
     * @return true if all cards are hitted, false otherwise
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Shuffles the list of cards.
     *
     * @throws IllegalArgumentException the deck is already empty
     */
    public void suffle() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deck is empty");
        }
        Collections.shuffle(cards);
    }

    /**
     * Hits the first card in the deck.
     *
     * @return the hitted card
     * @throws IllegalArgumentException the deck is already empty
     */
    public Card hit() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deck is already empty");
        }
        return cards.remove(0);
    }

    /**
     * Gives the number of card in the deck.
     *
     * @return the number of card in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Defines how the text will be display.
     *
     * @return the formatted text
     */
    @Override
    public String toString() {
        return cards.toString();
    }
}
