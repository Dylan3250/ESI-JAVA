package esi.atl.g54027.blackjack.model;

import esi.atl.g54027.cards.Card;
import esi.atl.g54027.cards.Color;
import esi.atl.g54027.cards.Deck;
import esi.atl.g54027.cards.Value;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InteractorTest {

    @Test
    public void testInteractorTotalCard() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.addCard(new Card(Color.DIAMOND, Value.KING));
        player.addCard(new Card(Color.CLUB, Value.ACE));
        player.addCard(new Card(Color.HEART, Value.FIVE));
        assertTrue(player.getTotalCard() == 16);
    }

    @Test
    public void testInteractorIsLostTrue() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.addCard(new Card(Color.DIAMOND, Value.KING));
        player.addCard(new Card(Color.CLUB, Value.JACK));
        player.addCard(new Card(Color.HEART, Value.FIVE));
        assertTrue(player.isLost());
    }

    @Test
    public void testInteractorIsLostFalse() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        player.addCard(new Card(Color.DIAMOND, Value.KING));
        player.addCard(new Card(Color.CLUB, Value.QUEEN));
        player.addCard(new Card(Color.HEART, Value.ACE));
        assertFalse(player.isLost());
    }
}
