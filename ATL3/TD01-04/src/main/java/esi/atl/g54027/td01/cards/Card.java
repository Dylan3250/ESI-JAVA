package esi.atl.g54027.td01.cards;

/**
 * @author Dylan BRICAR 54027
 */
public final class Card {

    /**
     * Color of the card (like Club, Diamond, ...)
     */
    private final Color color;

    /**
     * Value of the card (like ace, two, ... king)
     */
    private final Value value;

    /**
     * Makes a new card with given informations.
     *
     * @param color the given color of the card
     * @param value the given value of the card
     * @throws IllegalArgumentException the color or the value is null
     */
    public Card(Color color, Value value) {
        if (color == null || value == null) {
            throw new IllegalArgumentException("Color/value must not be null");
        }
        this.color = color;
        this.value = value;
    }

    /**
     * Gets the color of the card.
     *
     * @return the color of the card
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the value of the card.
     *
     * @return the value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Defines how the text will be display.
     *
     * @return the formatted text
     */
    @Override
    public String toString() {
        return value + " de " + color;
    }
}
