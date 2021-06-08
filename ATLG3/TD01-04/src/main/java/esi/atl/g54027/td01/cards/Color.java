package esi.atl.g54027.td01.cards;

/**
 * @author Dylan BRICAR 54027
 */
public enum Color {
    CLUB("trèfle", '\u2663'), DIAMOND("carreau", '\u2666'), 
    HEART("coeur", '\u2665'), SPADE("pique", '\u2660');

    private final String color;
    private final char symbol;

    /**
     * Defines the color associed in French.
     *
     * @param color the French color
     * @param symbol the symbol of card
     */
    private Color(String color, char symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    /**
     * Gets the symbol of current card.
     *
     * @return the symbol of card
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Defines how the text will be display.
     *
     * @return the formatted text
     */
    @Override
    public String toString() {
        return color;
    }
}
