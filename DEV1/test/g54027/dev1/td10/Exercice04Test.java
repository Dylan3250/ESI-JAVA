package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercice04Test {

    @Test
    public void testEstPalindrome_PalindromeImperLetters() {
        assertTrue(Exercice04.estPalindrome("kayak"));
    }

    @Test
    public void testEstPalindrome_PalindromePerLetters() {
        assertTrue(Exercice04.estPalindrome("apa"));
    }

    @Test
    public void testEstPalindrome_NotPalindromePerLetters() {
        assertFalse(Exercice04.estPalindrome("aza"));
    }

    @Test
    public void testEstPalindrome_NotPalindromeImperLetters() {
        assertFalse(Exercice04.estPalindrome("abze"));
    }
}
