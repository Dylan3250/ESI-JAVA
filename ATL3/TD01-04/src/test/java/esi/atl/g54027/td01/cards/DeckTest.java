package esi.atl.g54027.td01.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckIsNotEmpty() {
        Deck testDeck = new Deck();
        assertFalse(testDeck.isEmpty());
    }

    @Test
    public void testDeckIsEmpty() {
        Deck testDeck = new Deck();
        int listSize = testDeck.size();
        for (int i = 0; i < listSize; i++) {
            testDeck.hit();
        }
        assertTrue(testDeck.isEmpty());
    }

    @Test
    public void testDeckHitIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Deck testDeck = new Deck();
            int listSize = testDeck.size();
            for (int i = 0; i < listSize; i++) {
                testDeck.hit();
            }
            testDeck.hit();
        });
    }

    @Test
    public void testDeckHit() {
        Deck testDeck = new Deck();
        int listSize = testDeck.size();
        testDeck.hit();
        assertEquals(51, testDeck.size());
    }

    @Test
    public void testDeckShuffleIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Deck testDeck = new Deck();
            int listSize = testDeck.size();
            for (int i = 0; i < listSize; i++) {
                testDeck.hit();
            }
            testDeck.suffle();
        });
    }
}
