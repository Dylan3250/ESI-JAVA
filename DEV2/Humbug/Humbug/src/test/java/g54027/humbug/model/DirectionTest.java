package g54027.humbug.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class DirectionTest {

    @Test
    public void testDirection_oppositeNorth() {
        assertEquals(Direction.NORTH.opposite(), Direction.SOUTH);
    }

    @Test
    public void testDirection_oppositeSouth() {
        assertEquals(Direction.SOUTH.opposite(), Direction.NORTH);
    }

    @Test
    public void testDirection_oppositeWest() {
        assertEquals(Direction.WEST.opposite(), Direction.EAST);
    }

    @Test
    public void testDirection_oppositeEast() {
        assertEquals(Direction.EAST.opposite(), Direction.WEST);
    }
}
