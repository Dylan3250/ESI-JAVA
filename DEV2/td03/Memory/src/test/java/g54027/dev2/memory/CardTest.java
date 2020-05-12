package g54027.dev2.memory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCard_NotPositive() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(-1);
        });
    }

    @Test
    public void testCard_isEquals() {
        Card card1 = new Card(1);
        Card card2 = new Card(1);
        assertTrue(card1.equals(card2));
    }
    
    @Test
    public void testCard_isNotEquals() {
        Card card1 = new Card(2);
        Card card2 = new Card(1);
        assertFalse(card1.equals(card2));
    }
}
