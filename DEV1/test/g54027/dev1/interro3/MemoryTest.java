package g54027.dev1.interro3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Dylan BRICAR
 *
 * @author g54027
 */
public class MemoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInitCards_argIsNegative() {
        Memory.initCards(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitCards_argIsZero() {
        Memory.initCards(0);
    }

    @Test
    public void testInitCards_makeOneValueArray() {
        int[] cards = Memory.initCards(1);
        int[] expected = {0, 0};
        assertArrayEquals(expected, cards);
    }

    @Test
    public void testInitCards_makeMultipleValueArray() {
        int[] cards = Memory.initCards(2);
        int[] expected = {0, 0, 1, 1};
        assertArrayEquals(expected, cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitFeedBack_argIsNegative() {
        Memory.initFeedBack(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitFeedBack_argIsZero() {
        Memory.initFeedBack(0);
    }

    @Test
    public void testInitFeedBack_makeOneValueArray() {
        boolean[] cards = Memory.initFeedBack(1);
        boolean[] expected = {false, false};
        assertArrayEquals(expected, cards);
    }

    @Test
    public void testInitFeedBack_makeMultipleValueArray() {
        boolean[] cards = Memory.initFeedBack(2);
        boolean[] expected = {false, false, false, false};
        assertArrayEquals(expected, cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAllReturned_arrayIsNull() {
        boolean[] feedback = null;
        Memory.isAllReturned(feedback);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAllReturned_arrayIsEmpty() {
        boolean[] feedback = {};
        Memory.isAllReturned(feedback);
    }

    @Test
    public void testIsAllReturned_oneValueAndIsReturned() {
        boolean[] feedback = {true, true};
        assertTrue(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_oneValueAndIsNotReturned() {
        boolean[] feedback = {false, false};
        assertFalse(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_allIsReturned() {
        boolean[] feedback = {true, true, true, true};
        assertTrue(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_allIsNotReturned() {
        boolean[] feedback = {false, false, true, true, false, false};
        assertFalse(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_firstReturnedNotAfter() {
        boolean[] feedback = {true, true, false, false};
        assertFalse(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_endIsReturned() {
        boolean[] feedback = {false, false, true, true};
        assertFalse(Memory.isAllReturned(feedback));
    }

    @Test
    public void testIsAllReturned_anyReturned() {
        boolean[] feedback = {false, false, false, false};
        assertFalse(Memory.isAllReturned(feedback));
    }
}
