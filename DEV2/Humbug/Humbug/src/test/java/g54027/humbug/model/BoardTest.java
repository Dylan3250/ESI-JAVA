package g54027.humbug.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static g54027.humbug.model.SquareType.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @authors Pierre Bettens (pbt) <pbettens@he2b.be>
 * and Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class BoardTest {

    private Board board;

    @BeforeEach
    public void SetUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
    }

    @Test
    public void testIsInside_general_true() {
        System.out.println("isInside general");
        Position position = new Position(0, 0);
        boolean expResult = true;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInside_false_null() {
        System.out.println("isInside false null");
        Position position = new Position(1, 0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInside_false_outbound_negative() {
        System.out.println("isInside false out of bound");
        Position position = new Position(-1, 0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInside_false_outbound_positive_row() {
        System.out.println("isInside false out of bound");
        Position position = new Position(10, 1);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInside_false_outbound_positive_column() {
        System.out.println("isInside false out of bound");
        Position position = new Position(2, 23);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist() {
        System.out.println("get square type exist");
        SquareType expResult = GRASS;
        SquareType result = board.getSquareType(new Position(0, 0));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist_star() {
        System.out.println("get square type exist");
        SquareType expResult = STAR;
        SquareType result = board.getSquareType(new Position(2, 2));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_null() {
        System.out.println("get case type illegal argument");
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquareType(new Position(1, 0));
        });
    }

    // New tests by Dylan Bricar (54027)
    @Test
    public void testSetSquareType_posNotInBoard() {
        System.out.println("set case type illegal argument");
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquareType(new Position(3, 3));
        });
    }

    @Test
    public void testSetSquareType_posIsNullInBoard() {
        System.out.println("set null case type in the board");
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquareType(new Position(2, 0));
        });
    }

    @Test
    public void testGetSquareType_grassSquare() {
        System.out.println("get grass case type in the board");
        Position pos = new Position(1, 1);
        board.getSquareType(pos);
        assertEquals(GRASS, board.getSquareType(pos));
    }

    @Test
    public void testGetSquareType_starSquare() {
        System.out.println("set star case type in the board");
        Position pos = new Position(2, 2);
        board.getSquareType(pos);
        assertEquals(STAR, board.getSquareType(pos));
    }

    @Test
    public void testGetSquareType_grassSquareWithWall() {
        System.out.println("get grass case type with wall in the board");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);
        board = new Board(new Square[][]{
            {wall}
        });
        Position pos = new Position(0, 0);
        board.getSquareType(pos);
        assertEquals(GRASS, board.getSquareType(pos));
    }

    @Test
    public void testGetSquareType_starSquareWithWall() {
        System.out.println("get star case type with wall in the board");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);
        board = new Board(new Square[][]{
            {wall}
        });
        Position pos = new Position(0, 0);
        board.getSquareType(pos);
        assertEquals(GRASS, board.getSquareType(pos));
    }

    @Test
    public void testSetSquareType_grassSquareConserveWall() {
        System.out.println("get grass case type with walls in the board");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);
        wall.setNorthWall(true);
        wall.setWestWall(true);
        wall.setSouthWall(true);
        board = new Board(new Square[][]{
            {wall}
        });
        Position pos = new Position(0, 0);
        board.setSquareType(pos, STAR);
        assertEquals(STAR, board.getSquareType(pos));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.EAST));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.NORTH));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.WEST));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.SOUTH));
    }

    @Test
    public void testSetSquareType_grassStarConserveWall() {
        System.out.println("get star case type with walls in the board");
        Square wall = new Square(STAR);
        wall.setEastWall(true);
        wall.setNorthWall(true);
        wall.setWestWall(true);
        wall.setSouthWall(true);
        board = new Board(new Square[][]{
            {wall}
        });
        Position pos = new Position(0, 0);
        board.setSquareType(pos, GRASS);
        assertEquals(GRASS, board.getSquareType(pos));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.EAST));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.NORTH));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.WEST));
        assertTrue(board.getSquares()[0][0].hasWall(Direction.SOUTH));
    }

    @Test
    public void testSetSquareType_posIsStarInBoard() {
        System.out.println("set star case type in the board");
        Position pos = new Position(2, 2);
        board.setSquareType(pos, GRASS);
        assertEquals(GRASS, board.getSquareType(pos));
    }

    @Test
    public void testSetSquareType_posIsGrassInBoard() {
        System.out.println("set grass case type in the board");
        Position pos = new Position(0, 0);
        board.setSquareType(pos, GRASS);
        assertEquals(GRASS, board.getSquareType(pos));
    }

    @Test
    public void testIsInside_posIsNull() {
        System.out.println("position is inside is null");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            board.isInside(null);
        });
    }

    @Test
    public void testIsInside_topLeft() {
        System.out.println("position at the top left is inside");
        boolean isInside = board.isInside(new Position(0, 0));
        Assertions.assertTrue(isInside);
    }

    @Test
    public void testIsInside_bottomRight() {
        System.out.println("position at the bottom right is inside");
        boolean isInside = board.isInside(new Position(2, 2));
        Assertions.assertTrue(isInside);
    }

    @Test
    public void testIsInside_bottomLeftIsNotInside() {
        System.out.println("position at the bottom left is not inside");
        boolean isInside = board.isInside(new Position(2, 0));
        Assertions.assertFalse(isInside);
    }

    @Test
    public void testIsInside_topRightIsNotInside() {
        System.out.println("position at the top right is not inside");
        boolean isInside = board.isInside(new Position(0, 2));
        Assertions.assertFalse(isInside);
    }
}
