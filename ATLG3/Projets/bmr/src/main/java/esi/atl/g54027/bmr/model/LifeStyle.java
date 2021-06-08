package esi.atl.g54027.bmr.model;

/**
 * Defines the list of style of life in French and the factor for calories.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public enum LifeStyle {
    SEDENTARY("Sédentaire", 1.2), LITTLE_ACTIVE("Peu actif", 1.375),
    ACTIVE("Actif", 1.55), STRONG_ACTIVE("Fort actif", 1.725),
    EXTREMELY_ACTIVE("Extrêmement actif", 1.9);

    private final String lifeStyle;
    private final double factor;

    /**
     * Defines the life style with given life style, and the factor for computes
     * the number of calories needed.
     *
     * @param lifeStyle the given life style
     * @param factor    the given factor
     */
    LifeStyle(String lifeStyle, double factor) {
        this.lifeStyle = lifeStyle;
        this.factor = factor;
    }

    /**
     * Gets the factor for computes the number of calories needed.
     *
     * @return the factor of the life style
     */
    double getFactor() {
        return factor;
    }

    /**
     * Defines a format to display the life style.
     *
     * @return the life style in French
     */
    @Override
    public String toString() {
        return lifeStyle;
    }
}
