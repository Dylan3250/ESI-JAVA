package g54027.dev1.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class MiniGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInitCards_argIsNegative() {
        MiniGame.initCards(-1);
    }

    @Test
    public void testInitCards_makeNormalArray() {
        int[] cards = MiniGame.initCards(2);
        int[] expected = {0, 0, 1, 1};

        assertArrayEquals(expected, cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitFeedBack_argIsNegative() {
        MiniGame.initFeedBack(-1);
    }

    @Test
    public void testInitFeedBack_makeNormalArray() {
        boolean[] cards = MiniGame.initFeedBack(2);
        boolean[] expected = {false, false, false, false};

        assertArrayEquals(expected, cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAllReturned_arrayIsNull() {
        boolean[] feedback = null;
        MiniGame.isAllReturned(feedback);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAllReturned_arrayIsEmpty() {
        boolean[] feedback = {};
        MiniGame.isAllReturned(feedback);
    }

    @Test
    public void testIsAllReturned_allIsReturned() {
        boolean[] feedback = {true, true, true, true};
        assertTrue(MiniGame.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_allIsNotReturned() {
        boolean[] feedback = {false, true, true, false};
        assertFalse(MiniGame.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_AnyReturned() {
        boolean[] feedback = {false, false, false, false};
        assertFalse(MiniGame.isAllReturned(feedback));
    }

}
