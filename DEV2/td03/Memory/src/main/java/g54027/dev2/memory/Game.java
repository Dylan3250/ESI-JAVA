package g54027.dev2.memory;

import java.util.Arrays;

public class Game {

    private Card[] cards;

    /**
     * Defines the game with the number of card to make the game
     *
     * @param nbPairs the number of card (x2 by per)
     */
    public Game(int nbPairs) {
        if (nbPairs <= 1 || nbPairs >= 20) {
            throw new IllegalArgumentException("Nombre de carte trop grand");
        }

        this.cards = new Card[2 * nbPairs];

        for (int i = 0; i < this.cards.length; i++) {
            this.cards[i] = new Card(i / 2 + 1);
        }
    }

    /**
     * Shuffles the card array with external method
     */
    void shuffle() {
        ArrayUtil.shuffle(this.cards);
    }

    /**
     * Gives the number of cards in the game
     *
     * @return the number of cards
     */
    public int getSize() {
        return cards.length;
    }

    /**
     * Gets the vision of the card (marked or not)
     *
     * @param pos the given position of card
     * @return true if the card is hidden, false otherwise
     */
    public boolean isHidden(int pos) {
        return cards[pos].isHidden();
    }

    /**
     * Gets the value of the card
     *
     * @param pos the given position of card
     * @return the value of the card
     */
    public int getCardValue(int pos) {
        return cards[pos].getValue();
    }

    /**
     * Checks positions if the two cards are same
     *
     * @param pos1 the first given card
     * @param pos2 the second given card
     * @return true if cards are identical, false otherwise
     */
    public boolean checkPositions(int pos1, int pos2) {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("Les choix doivent être différents");
        }

        if (this.cards[pos1].equals(this.cards[pos2])) {
            this.cards[pos1].reveal();
            this.cards[pos2].reveal();
        }

        return this.cards[pos1].equals(this.cards[pos2]);
    }

    /**
     * Checks if there are still hidden cards
     *
     * @return true if there are hidden cards, false otherwise
     */
    public boolean isGameOver() {
        boolean isAllShow = true;
        int i = 0;

        while (isAllShow && this.cards.length > i) {
            if (this.cards[i].isHidden()) {
                isAllShow = false;
            }
            i++;
        }
        return isAllShow;
    }

    /**
     * Defines the format to show all cards
     *
     * @return "?" if hidden, the value otherwise
     */
    @Override
    public String toString() {
        String allCards = "";

        for (Card card : this.cards) {
            allCards += card.toString() + " ";
        }
        return allCards;
    }

    /**
     * Returns a hash code for this
     *
     * @return a hash code value for this object, equal to the primitive Card
     * value represented by this Card object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Arrays.deepHashCode(this.cards);
        return hash;
    }

    /**
     * Compares this object to the specified object.
     *
     * @param obj the object to compare with.
     * @return true if the objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        return Arrays.deepEquals(this.cards, other.cards);
    }

}
