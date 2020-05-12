package g54027.dev2.memory;

class Card {

    private boolean hidden = true;
    private int value;

    /**
     * Makes an Card with his number
     *
     * @param card the given int to make the card
     * @throws IllegalArgumentException the card have to be positive
     */
    public Card(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Valeur illégale : " + value);
        }

        this.value = value;
    }

    /**
     * Changes the vision of the card (the card is marked)
     */
    void reveal() {
        this.hidden = false;
    }

    /**
     * Gets the vision of the card (marked or not)
     *
     * @return true if hidden, false otherwise
     */
    public boolean isHidden() {
        return this.hidden;
    }

    /**
     * Gets the value of the card
     *
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Defines the format to show the card
     *
     * @return "?" if hidden, the value otherwise
     */
    @Override
    public String toString() {
        return hidden ? "?" : Integer.toString(this.value);
    }

    /**
     * Returns a hash code for this
     *
     * @return a hash code value for this object, equal to the primitive Card
     * value represented by this Card object.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.value;
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
        if (!(obj instanceof Card)) {
            return false;
        }

        Card other = (Card) obj;
        return this.value == other.value;
    }
}
