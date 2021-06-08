package esi.atl.g54027.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class PointTest {

    @Test
    public void testMakeRacinePoint() {
        new Point(0, 0);
    }

    @Test
    public void testMovePositivePoint() {
        Point p1 = new Point(0, 0);
        p1.move(2, 3);
        assertEquals(2, p1.getX());
        assertEquals(3, p1.getY());
    }

    @Test
    public void testMoveMinderPoint() {
        Point p1 = new Point(10.5, 10);
        p1.move(-10, -10);
        assertEquals(0.5, p1.getX());
        assertEquals(0, p1.getY());
    }
}
