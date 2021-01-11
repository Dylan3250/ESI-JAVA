package esi.atl.g54027.td01.cards;

/**
 * @author Dylan BRICAR 54027
 */
public enum Value {
    ACE("As", 1), TWO("Deux", 2), THREE("Trois", 3), FOUR("Quatre", 4),
    FIVE("Cinq", 5), SIX("Six", 6), SEVEN("Sept", 7), EIGHT("Huit", 8), NINE("Neuf", 9),
    TEN("Dix", 10), JACK("Vallet", 10), QUEEN("Reine", 10), KING("Roi", 10);

    final private String value;
    final private int numberValue;

    /**
     * Defines the value associed in French.
     *
     * @param value the french value
     */
    private Value(String value, int numberValue) {
        this.value = value;
        this.numberValue = numberValue;
    }

    /**
     * Gets the value converted on number.
     *
     * @return the number value of card
     */
    public int getNumberValue() {
        return numberValue;
    }
    
    /**
     * Defines how the text will be display.
     *
     * @return the formatted text
     */
    @Override
    public String toString() {
        return value;
    }
}
