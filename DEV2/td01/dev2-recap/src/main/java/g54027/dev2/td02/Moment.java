package g54027.dev2.td02;

/**
 * Makes an Moment and this moment is defined by hour, minute and second
 *
 * @author g54027
 */
public class Moment {

    private int hour;
    private int minute;
    private int second;

    /**
     * Sets the given values to Moment class attributes
     *
     * @param hour the given hour
     * @param minute the given minute
     * @param second the given second
     * @exception IllegalArgumentException if hour value is not between 0 and 23
     * @exception IllegalArgumentException if minute value is not between 0; 60
     * @exception IllegalArgumentException if second value is not between 0; 60
     */
    public Moment(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("L'heure doit être comprise entre 0 et 23");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Les minutes doivent être comprises entre 0 et 60");
        }

        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Les secondes doivent être comprises entre 0 et 60");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Call the principal constructor with default values (0:0:0)
     */
    public Moment() {
        this(0, 0, 0);
    }

    /**
     * Returns the value of attribute hour
     *
     * @return the hour attribute
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Returns the value of attribute minute
     *
     * @return the minute attribute
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Returns the value of attribute second
     *
     * @return the second attribute
     */
    public int getSecond() {
        return this.second;
    }

    /**
     * Outputs this time as a String, such as 10:15:12.
     *
     * @return the representation of this time formatted
     */
    public String toString() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }

    /**
     * Checks if two moments are identical
     *
     * @param other Other method Moment with others information
     * @return true if are identical, false otherwise
     */
    public boolean equals(Moment other) {
        return this.hour == other.getHour()
                && this.minute == other.getMinute()
                && this.second == other.getSecond();
    }

    /**
     * Converts the moment in seconds
     *
     * @return the moment converted in seconds
     */
    public int toSeconds() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    /**
     * Checks if two moments are identical
     *
     * @param other the other moment to compare
     * @return 0 if two moments are same, 1 if the actual moment is greater
     * or -1 otherwise
     */
    public int compareTo(Moment other) {
        /*
        // FIRST CODE   
        int value = 0;
        if (this.toSeconds() > other.toSeconds()) {
            value = 1;
        } else if (this.toSeconds() < other.toSeconds()) {
            value = -1;
        }
        return value;
        
        // IDEE PROF
        Integer actualMoment = this.toSeconds();
        return actualMoment.compareTo(other.toSeconds());
        */
        
        return this.toSeconds() - other.toSeconds();
    }
}
