package g54027.dev1.td11;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice01Test {

    @Test(expected = IllegalArgumentException.class)
    public void testIncrementer_IsNull() {
        int[] basicArray = null;

        Exercice01.incrementer(basicArray);
    }

    @Test
    public void testIncrementer_ValidParams() {
        int[] basicArray = {1, 2, 3};
        Exercice01.incrementer(basicArray);
        int[] incrementedArray = {2, 3, 4};

        assertArrayEquals(incrementedArray, basicArray);
    }

    @Test
    public void testIncrementer_EmptyParams() {
        int[] basicArray = {};
        Exercice01.incrementer(basicArray);
        int[] incrementedArray = {};

        assertArrayEquals(incrementedArray, basicArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplier_IsNull() {
        int[] basicArray = null;

        Exercice01.multiplier(basicArray, 2);
    }

    @Test
    public void testMultiplier_ByPositifNumbers() {
        int[] basicArray = {-1, 0, 6};
        Exercice01.multiplier(basicArray, 2);
        int[] expectedArray = {-2, 0, 12};

        assertArrayEquals(expectedArray, basicArray);
    }

    @Test
    public void testMultiplier_ByNegatifNumbers() {
        int[] basicArray = {-1, 0, 6};
        Exercice01.multiplier(basicArray, -2);
        int[] expectedArray = {2, 0, -12};

        assertArrayEquals(expectedArray, basicArray);
    }

    @Test
    public void testMultiplier_ByZero() {
        int[] basicArray = {-1, 0, 6};
        Exercice01.multiplier(basicArray, 0);
        int[] expectedArray = {0, 0, 0};

        assertArrayEquals(expectedArray, basicArray);
    }

    @Test
    public void testMultiplier_EmptyArray() {
        int[] basicArray = {};
        Exercice01.multiplier(basicArray, 2);
        int[] EmptyArray = {};

        assertArrayEquals(EmptyArray, basicArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAfficherTab_IsNull() {
        int[] basicArray = null;

        Exercice01.afficherTab(basicArray);
    }
}
