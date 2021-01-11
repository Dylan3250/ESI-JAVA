package esi.atl.g54027.td01.blackjack.model;

import esi.atl.g54027.td01.cards.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerOneHitSize() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.hit(1);
        assertTrue(player.getTotalCard() <= 10);
        assertTrue(deck.size() == 51);
    }

    @Test
    public void testPlayerMultipleHitSize() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.hit(5);
        assertTrue(player.getTotalCard() <= 50);
        assertTrue(deck.size() == 47);
    }

    @Test
    public void testPlayerMaxHitSize() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.hit(52);
        assertTrue(player.getTotalCard() <= 520);
        assertTrue(deck.size() == 0);
    }

    @Test
    public void testPlayerHitOverSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            Deck deck = new Deck();
            Player player = new Player(deck);
            player.hit(53);
        });
    }
}
