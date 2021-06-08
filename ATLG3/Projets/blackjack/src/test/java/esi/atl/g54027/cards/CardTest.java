package esi.atl.g54027.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testGetColor() {
        Card testCard = new Card(Color.DIAMOND, Value.EIGHT);
        assertEquals(Color.DIAMOND, testCard.getColor());
    }

    @Test
    public void testGetValue() {
        Card testCard = new Card(Color.HEART, Value.JACK);
        assertEquals(Value.JACK, testCard.getValue());
    }

    @Test
    public void testGetNumberValue() {
        Card testCard = new Card(Color.SPADE, Value.NINE);
        assertEquals(9, testCard.getValue().getNumberValue());
    }

    @Test
    public void testToString() {
        Card testCard = new Card(Color.CLUB, Value.KING);
        assertEquals("Roi de trèfle", testCard.toString());
    }

    @Test
    public void testValueIsNull() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Card(Color.CLUB, null));
    }

    @Test
    public void testColorIsNull() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Card(null, Value.FIVE));
    }

    @Test
    public void testCardIsNull() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Card(null, null));
    }
}
