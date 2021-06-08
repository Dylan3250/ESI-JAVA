package esi.atl.g54027.td01.blackjack.model;

import esi.atl.g54027.td01.cards.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testBankHit() {
        Deck deck = new Deck();
        Bank bank = new Bank(deck);
        bank.hit();
        assertTrue(bank.getTotalCard() >= 17);
    }

    @Test
    public void testBankHitEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Deck deck = new Deck();
            Bank bank = new Bank(deck);
            int listSize = deck.size();
            for (int i = 0; i < listSize; i++) {
                deck.hit();
            }
            bank.hit();
        });
    }
}
