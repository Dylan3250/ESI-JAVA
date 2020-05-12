package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice02Test {

    @Test(expected = IllegalArgumentException.class)
    public void testSomme_NumberIsZero() {
        Exercice02.somme(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSomme_NegativeValue() {
        Exercice02.somme(-3);
    }

    @Test
    public void testSomme_PositiveValue() {
        assertEquals(6, Exercice02.somme(3));
    }
}
