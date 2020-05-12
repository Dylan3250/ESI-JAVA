package g54027.dev2.td02;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54027
 */
public class MomentTest {

    @Test
    public void testConstructor_MinDay() {
        new Moment(0, 0, 0);
    }

    @Test
    public void testConstructor_MaxDay() {
        new Moment(23, 59, 59);
    }

    @Test
    public void testConstructor_NegativeHour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(-20, 0, 0);
        });
    }

    @Test
    public void testConstructor_NegativeMinute() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(0, -20, 0);
        });
    }

    @Test
    public void testConstructor_NegativeSecond() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(0, 0, -20);
        });
    }

    @Test
    public void testConstructor_OutOfBoundMaxHour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(24, 0, 0);
        });
    }

    @Test
    public void testConstructor_OutOfBoundMaxMinute() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(0, 60, 0);
        });
    }

    @Test
    public void testConstructor_OutOfBoundMaxSecond() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moment(0, 0, 60);
        });
    }

    @Test
    public void testCompareTo_Equals() {
        Moment actual = new Moment(0, 0, 0);
        Moment other = new Moment(0, 0, 0);
        assertTrue(actual.compareTo(other) == 0);
    }
    
    @Test
    public void testCompareTo_isGreater() {
        Moment actual = new Moment(0, 0, 1);
        Moment other = new Moment(0, 0, 0);
        assertTrue(actual.compareTo(other) > 0);
    }
    
    @Test
    public void testCompareTo_isSmaller() {
        Moment actual = new Moment(0, 0, 0);
        Moment other = new Moment(0, 0, 1);
        assertTrue(actual.compareTo(other) < 0);
    }

}
