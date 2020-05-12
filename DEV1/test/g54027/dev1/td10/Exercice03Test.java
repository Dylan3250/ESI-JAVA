package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice03Test {

    @Test
    public void testisAnagram_IsAnagram() {
        assertTrue(Exercice03.isAnagram("aube", "beau"));
    }

    @Test
    public void testisAnagram_NotAnagram() {
        assertFalse(Exercice03.isAnagram("dylan", "zalyd"));
    }

    @Test
    public void testisAnagram_IgnoreAccent() {
        assertTrue(Exercice03.isAnagram("été", "ete"));
    }

    @Test
    public void testisAnagram_IgnoreCase() {
        assertTrue(Exercice03.isAnagram("Ikram", "Karim"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisAnagram_OnlyLetters() {
        Exercice03.isAnagram("a1bc", "a1bc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisAnagram_NotEqualCountLetters() {
        Exercice03.isAnagram("mot", "mots");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisAnagram_FirstArgumentMinTwoLetters() {
        Exercice03.isAnagram("", "année");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisAnagram_SecondArgumentMinTwoLetters() {
        Exercice03.isAnagram("mois", "a");
    }

    @Test
    public void testFormatChar_ValideCharacter() {
        assertEquals('e', Exercice03.formatChar('é'));
    }
}
