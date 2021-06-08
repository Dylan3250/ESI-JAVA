package esi.atl.g54027.bmr.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The principal class who computes and checks the treatment mechanisms. It is
 * here where the values are update.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Model {

    private final Person person = new Person();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Adds listeners for the PropertyChangeSupport.
     *
     * @param listener the given listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Makes an error to display with the listener.
     */
    public void makeError() {
        pcs.firePropertyChange("error", false, true);
    }

    /**
     * Adds given information on the person who wants calculate BMR/Calories.
     * The information are update on the view only if they are not like the olds.
     *
     * @param size      the given size
     * @param weight    the given weight
     * @param year      the given year int
     * @param isMen     true if it is men, false otherwise
     * @param lifeStyle the enum value of life style
     */
    public void computeBMR(int size, double weight, int year, boolean isMen,
                           LifeStyle lifeStyle) {
        if (!isValidValues(size, weight, year)
                || getBMRArgs(size, weight, year, isMen) <= 0) {
            makeError();
            return;
        }

        double oldBMR = getBMR();
        double oldCalories = getCalories();

        pcs.firePropertyChange("size", person.getSize(), size);
        person.setSize(size);
        pcs.firePropertyChange("weight", person.getWeight(), weight);
        person.setWeight(weight);

        person.setYear(year);
        person.setIsMen(isMen);
        person.setLifeStyle(lifeStyle);

        pcs.firePropertyChange("BMR", oldBMR, getBMR());
        pcs.firePropertyChange("Calories", oldCalories, getCalories());
    }

    /**
     * Makes the calcul of BMR with given values.
     *
     * @param size   the given size of the person
     * @param weight the given weight of the person
     * @param year   the given year of the person
     * @param isMen  true if it is men, false otherwise
     * @return the value of BMR for all given information
     */
    private double getBMRArgs(int size, double weight, int year, boolean isMen) {
        return isMen ? (13.7 * weight + 5 * size - 6.8 * year + 66)
                : (9.6 * weight + 1.8 * size - 4.7 * year + 655);
    }

    /**
     * Makes the calcul of BMR with given values of person.
     *
     * @return the value of BMR for all given information
     */
    public double getBMR() {
        return getBMRArgs(person.getSize(), person.getWeight(),
                person.getYear(), person.isIsMen());
    }

    /**
     * Computes the calories value for the given information by a person.
     *
     * @return the given calories by given person
     */
    public double getCalories() {
        return person.getLifeStyle().getFactor() * getBMR();
    }

    /**
     * Checks if the given values are in possible range (year, weight, size).
     *
     * @param size   the given size of the person
     * @param weight the given weight of the person
     * @param year   the given year of the person
     * @return true if information are possible, false otherwise
     */
    public boolean isValidValues(int size, double weight, int year) {
        return (isBetween(size, 10, 300)
                && isBetween(weight, 10, 200)
                && isBetween(year, 5, 150));
    }

    /**
     * Checks if the given number is between two range (range not understood).
     *
     * @param number   the given number
     * @param minBound the given min range
     * @param maxBound the given max range
     * @return true if the number is between, false otherwise
     */
    private boolean isBetween(double number, int minBound, int maxBound) {
        return minBound <= number && number <= maxBound;
    }
}
