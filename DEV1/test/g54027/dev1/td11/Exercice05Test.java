package g54027.dev1.td11;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice05Test {

    @Test(expected = IllegalArgumentException.class)
    public void testMiroir_IsNull() {
        int[] tab = null;

        Exercice05.miroir(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMiroir_IsEmpty() {
        int[] tab = {};

        Exercice05.miroir(tab);
    }

    public void testMiroir_PerUsage() {
        int[] tab = {-1, 0, 1, 0};
        Exercice05.miroir(tab);
        int[] expectedTab = {0, 1, 0, -1};

        assertArrayEquals(expectedTab, tab);
    }

    public void testMiroir_ImperUsage() {
        int[] tab = {-1, 0, 1};
        Exercice05.miroir(tab);
        int[] expectedTab = {1, 0, -1};

        assertArrayEquals(expectedTab, tab);
    }

    public void testMiroir_SameValues() {
        int[] tab = {1, 1, 1};
        Exercice05.miroir(tab);
        int[] expectedTab = {1, 1, 1};

        assertArrayEquals(expectedTab, tab);
    }   
}