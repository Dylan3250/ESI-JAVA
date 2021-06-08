package esi.atl.g54027.td01.blackjack.model;

import esi.atl.g54027.td01.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Interactor is the player or bank of the game. It has for example a number of
 * cards and if the interactor lost.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public abstract class Interactor {

    private int totalCard = 0;
    private final List<Card> cardList = new ArrayList();

    /**
     * Gets the total of cards hited.
     *
     * @return the sum of cards hited
     */
    int getTotalCard() {
        return totalCard;
    }

    /**
     * Gets the list of cards hited.
     *
     * @return the list of cards hited
     */
    List getCardList() {
        return cardList;
    }

    void addCard(Card card) {
        if (card.getValue().getNumberValue() > 10 || card.getValue().getNumberValue() < 0) {
            throw new IllegalArgumentException("Given value is not between 1 "
                    + "and 10 : " + card.getValue().getNumberValue());
        }
        totalCard += card.getValue().getNumberValue();
        cardList.add(card);
    }

    /**
     * Checks if the interactor is lost (sum of cards it is more than 21).
     *
     * @return true if the interactor is lost, false otherwise
     */
    boolean isLost() {
        return getTotalCard() > 21;
    }
}
