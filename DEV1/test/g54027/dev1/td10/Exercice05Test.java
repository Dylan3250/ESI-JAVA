package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice05Test {

    @Test
    public void testNbOccurences_notExistOccurence() {
        assertEquals(0, Exercice05.nbOccurences('a', "test"));
    }

    @Test
    public void testNbOccurences_ExistOccurence() {
        assertEquals(2, Exercice05.nbOccurences(' ', "je pense pas"));
    }
}