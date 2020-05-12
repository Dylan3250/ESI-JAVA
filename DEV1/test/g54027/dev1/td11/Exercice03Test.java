package g54027.dev1.td11;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice03Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAfficheTableau_IsNull() {
        String[] tab = null;

        Exercice03.afficheTableau(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAfficheTableau_IsEmpty() {
        String[] tab = {};

        Exercice03.afficheTableau(tab);
    }

    @Test
    public void testAfficheTableau_Normal() {
        String[] tab = {"mot1", "mot2", "mot3"};

        Exercice03.afficheTableau(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAfficherTailles_IsNull() {
        String[] tab = null;

        Exercice03.afficherTailles(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAfficherTailles_IsEmpty() {
        String[] tab = {};

        Exercice03.afficherTailles(tab);
    }

    @Test
    public void testAfficherTailles_SameSizeElements() {
        String[] tab = {"a", "a", "b", "k"};

        Exercice03.afficherTailles(tab);
    }

    @Test
    public void testAfficherTailles_DiffertSizeElements() {
        String[] tab = {"abc", "aa", "b", "", "test"};

        Exercice03.afficherTailles(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlusLongMot_IsNull() {
        String[] tab = null;

        Exercice03.plusLongMot(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlusLongMot_IsEmpty() {
        String[] tab = {};

        Exercice03.plusLongMot(tab);
    }

    @Test
    public void testPlusLongMot_FindWordInTab() {
        String[] tab = {"ptit", "grand", "ultragrand", "petit", "a"};

        assertEquals("ultragrand", Exercice03.plusLongMot(tab));
    }

    @Test
    public void testPlusLongMot_FindWordAtBegin() {
        String[] tab = {"ptitetgrand", "grand", "ultragrand", "petit", "a"};

        assertEquals("ptitetgrand", Exercice03.plusLongMot(tab));
    }

    @Test
    public void testPlusLongMot_FindWordAtEnd() {
        String[] tab = {"petit", "grand", "ultragrand", "petit", "apeutpresgrand"};

        assertEquals("apeutpresgrand", Exercice03.plusLongMot(tab));
    }

    @Test
    public void testPlusLongMot_SameSize() {
        String[] tab = {"grand", "petit", "taile", "12345"};

        assertEquals("grand", Exercice03.plusLongMot(tab));
    }

    @Test
    public void testPlusLongMot_AllEmpty() {
        String[] tab = {"", "", "", ""};

        assertEquals("", Exercice03.plusLongMot(tab));
    }   
}