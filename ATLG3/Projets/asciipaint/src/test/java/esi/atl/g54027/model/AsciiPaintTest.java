package esi.atl.g54027.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class AsciiPaintTest {

    @Test
    public void testMakeShapeRectangle() {
        String[] tasks = new String[]{
            "add", "rectangle", "0", "0", "3.5", "9.5", "$"};
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.makeShape(tasks);
    }

    @Test
    public void testMakeShapeCircle() {
        String[] tasks = new String[]{
            "add", "circle", "10", "10", "3.5", "c"};
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.makeShape(tasks);
    }

    @Test
    public void testMakeShapeSquare() {
        String[] tasks = new String[]{
            "add", "square", "5", "5", "3", "s"};
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.makeShape(tasks);
    }

    @Test
    public void testMakeShapeNotExist() {
        String[] tasks = new String[]{
            "add", "notExist", "5", "5", "3", "s"};
        AsciiPaint paint = new AsciiPaint(10, 10);
        assertThrows(IllegalArgumentException.class, () -> paint.makeShape(tasks));
    }

    @Test
    public void testMakeShapeEmpty() {
        String[] tasks = new String[]{
            "add", "", "5", "5", "3", "s"};
        AsciiPaint paint = new AsciiPaint(10, 10);
        assertThrows(IllegalArgumentException.class, () -> paint.makeShape(tasks));
    }

    @Test
    public void testNormalMoveShape() {
        String[] tasks = new String[]{
            "add", "square", "0", "0", "3", "s"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        paint.makeShape(tasks);
        tasks = new String[]{
            "move", "0", "10", "5"};
        paint.moveShape(tasks);
        assertEquals(10, paint.getShapes().get(0).getPoint().getX());
        assertEquals(5, paint.getShapes().get(0).getPoint().getY());
    }

    @Test
    public void testMoveShapeEmpty() {
        String[] tasks = new String[]{
            "move", "0", "10", "5"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        assertThrows(IllegalArgumentException.class, () -> paint.moveShape(tasks));
    }

    @Test
    public void testNormalDeleteShape() {
        String[] tasks = new String[]{
            "add", "square", "0", "0", "3", "s"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        paint.makeShape(tasks);
        tasks = new String[]{"delete", "0"};
        paint.deleteShape(tasks);
        assertEquals(0, paint.getShapes().size());
    }

    @Test
    public void testDeleteShapeEmpty() {
        String[] tasks = new String[]{"delete", "0"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        assertThrows(IllegalArgumentException.class, () -> paint.deleteShape(tasks));
    }

    @Test
    public void testNormalChangeColorShape() {
        String[] tasks = new String[]{
            "add", "square", "0", "0", "3", "s"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        paint.makeShape(tasks);
        tasks = new String[]{
            "change", "0", "-"};
        paint.changeColorShape(tasks);
        assertEquals('-', paint.getShapes().get(0).getColor());
    }

    @Test
    public void testChangeColorEmpty() {
        String[] tasks = new String[]{"change", "0", "ù"};
        AsciiPaint paint = new AsciiPaint(30, 30);
        assertThrows(IllegalArgumentException.class, () -> paint.changeColorShape(tasks));
    }
}
