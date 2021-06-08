package esi.atl.g54027.bmr.model;

/**
 * Makes a new person with given information (size, weight, sex, etc).
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
final class Person {

    private int size;
    private double weight;
    private int year;
    private boolean isMen;
    private LifeStyle lifeStyle = LifeStyle.ACTIVE;

    /**
     * Gets the size of the person.
     *
     * @return the size of the person
     */
    int getSize() {
        return size;
    }

    /**
     * Sets the size of the person.
     *
     * @param size the news size of the person
     */
    void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the weight of the person.
     *
     * @return the weight of the person
     */
    double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the person.
     *
     * @param weight the new weight of the person
     */
    void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the year of the person.
     *
     * @return the year of the person
     */
    int getYear() {
        return year;
    }

    /**
     * Sets the new year of the person.
     *
     * @param year the new year of the person
     */
    void setYear(int year) {
        this.year = year;
    }

    /**
     * Checks if the person is a man.
     *
     * @return true if the person is a man, false otherwise
     */
    boolean isIsMen() {
        return isMen;
    }

    /**
     * Defines the sex of the person.
     *
     * @param isMen true if it is a man, false otherwise
     */
    void setIsMen(boolean isMen) {
        this.isMen = isMen;
    }

    /**
     * Gets the live style of the person.
     *
     * @return the value of the life style (value of enum)
     */
    LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    /**
     * Defines the new live style of the person.
     *
     * @param lifeStyle the new live style of the person (value of enum)
     */
    void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }
}
