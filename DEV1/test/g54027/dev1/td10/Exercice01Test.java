package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice01Test {

    @Test
    public void testMax_TwoValuesPositives() {
        assertEquals(2, Exercice01.max(1, 2));
    }

    @Test
    public void testMax_WithZero() {
        assertEquals(3, Exercice01.max(3, 0));
    }

    @Test
    public void testMax_LeftRightOneNegativeValue() {
        assertEquals(3, Exercice01.max(-1, 3));
    }

    @Test
    public void testMax_RightLeftOneNegativeValue() {
        assertEquals(3, Exercice01.max(3, -1));
    }

    @Test
    public void testMax_OneNegativeValue() {
        assertEquals(3, Exercice01.max(-1, 3));
    }

    @Test
    public void testMax_TwoNegativesValues() {
        assertEquals(-3, Exercice01.max(-4, -3));
    }

    @Test
    public void testMax_SamePositivesValues() {
        assertEquals(6, Exercice01.max(6, 6));
    }

    @Test
    public void testMax_SameNegativesValues() {
        assertEquals(-16, Exercice01.max(-16, -16));
    }

}
