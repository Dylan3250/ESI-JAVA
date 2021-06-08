package esi.atl.g54027.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class DrawingTest {

    @Test
    public void testConstructorValid() {
        new Drawing(10, 10);
    }

    @Test
    public void testConstructorNullPoint() {
        assertThrows(IllegalArgumentException.class, ()
                -> new Drawing(0, 0));
    }

    @Test
    public void testAddShapeNull() {
        Drawing drawing = new Drawing(10, 10);
        assertThrows(IllegalArgumentException.class, ()
                -> drawing.addShape(null));
    }

    @Test
    public void testAddShape() {
        Drawing drawing = new Drawing(10, 10);
        drawing.addShape(new Circle(new Point(1, 1), 5, '$'));
        drawing.addShape(new Rectangle(new Point(1, 1), 5, 4, 'r'));
        assertTrue(drawing.getShapes().get(0) instanceof Circle);
        assertTrue(drawing.getShapes().get(1) instanceof Rectangle);
        assertEquals(2, drawing.getShapes().size());
    }

    @Test
    public void testGetShapeAtNullPoint() {
        Drawing drawing = new Drawing(10, 10);
        assertThrows(IllegalArgumentException.class, ()
                -> drawing.getShapeAt(null));
    }

    @Test
    public void testGetShape() {
        Drawing drawing = new Drawing(100, 100);
        drawing.addShape(new Square(new Point(25, 25), 25, 'c'));
        drawing.addShape(new Circle(new Point(0, 0), 5, 'd'));
        assertTrue(drawing.getShapeAt(new Point(25, 25)) instanceof Square);
        assertTrue(drawing.getShapeAt(new Point(49, 49)) instanceof Square);
        assertTrue(drawing.getShapeAt(new Point(0, 0)) instanceof Circle);
        assertTrue(drawing.getShapeAt(new Point(100, 100)) == null);
        assertFalse(drawing.getShapeAt(new Point(0, 0)) instanceof Square);
    }
}
