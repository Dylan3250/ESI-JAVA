package esi.atl.g54027.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class CircleTest {

    @Test
    public void testConstructorValid() {
        new Circle(new Point(0, 0), 5, 'c');
    }

    @Test
    public void testConstructorNullPoint() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Circle(null, 5, 'c'));
    }

    @Test
    public void testConstructorZeroRadius() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Circle(new Point(0, 0), 0, 'c'));
    }

    @Test
    public void testIsInside() {
        Circle circle = new Circle(new Point(50, 50), 10, 'c');
        assertTrue(circle.isInside(new Point(50, 50)));
        assertTrue(circle.isInside(new Point(50, 40)));
        assertTrue(circle.isInside(new Point(50, 60)));
        assertTrue(circle.isInside(new Point(40, 50)));
        assertTrue(circle.isInside(new Point(60, 50)));
    }

    @Test
    public void testIsNotInside() {
        Circle circle = new Circle(new Point(50, 50), 10, '^');
        assertFalse(circle.isInside(new Point(61, 50)));
        assertFalse(circle.isInside(new Point(51, 40)));
        assertFalse(circle.isInside(new Point(51, 60)));
        assertFalse(circle.isInside(new Point(40, 51)));
        assertFalse(circle.isInside(new Point(60, 51)));
    }

    @Test
    public void testIsInsideNullPoint() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Circle(null, 5, '$'));
    }
}
