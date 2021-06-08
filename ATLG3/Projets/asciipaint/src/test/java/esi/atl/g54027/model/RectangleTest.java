package esi.atl.g54027.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class RectangleTest {

    @Test
    public void testConstructorValid() {
        new Rectangle(new Point(0, 0), 5, 5, 'r');
    }

    @Test
    public void testConstructorNullPoint() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Rectangle(null, 5, 5, 'r'));
    }

    @Test
    public void testConstructorZeroWidth() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Rectangle(new Point(5, 5), 0, 5, 'r'));
    }

    @Test
    public void testConstructorZeroHeight() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Rectangle(new Point(5, 5), 10, 0, 'r'));
    }

    @Test
    public void testIsInside() {
        Rectangle rect = new Rectangle(new Point(0, 0), 5, 5, 'ù');
        assertTrue(rect.isInside(new Point(0, 0)));
        assertTrue(rect.isInside(new Point(0, 4)));
        assertTrue(rect.isInside(new Point(4, 0)));
        assertTrue(rect.isInside(new Point(4, 4)));
        assertTrue(rect.isInside(new Point(2, 3)));
    }

    @Test
    public void testIsNotInside() {
        Rectangle rect = new Rectangle(new Point(10, 10), 10, 5, '%');
        assertFalse(rect.isInside(new Point(9, 9)));
        assertFalse(rect.isInside(new Point(21, 9)));
        assertFalse(rect.isInside(new Point(21, 16)));
        assertFalse(rect.isInside(new Point(11, 16)));
    }

    @Test
    public void testIsInsideNullPoint() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Rectangle(null, 5, 20, '$'));
    }
}
