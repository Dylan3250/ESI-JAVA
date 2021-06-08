package g54027.humbug.model;

import static g54027.humbug.model.SquareType.GRASS;
import static g54027.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 * and Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class SnailTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    @Test
    public void testMove() {
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    // New tests by Dylan Bricar (54027)
    @Test
    public void testMove_stopByEastWall() {
        System.out.println("move stop by east wall");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_stopByWestWall() {
        System.out.println("move stop by west wall");
        Square wall = new Square(GRASS);
        wall.setWestWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_stopByNorthWall() {
        System.out.println("move stop by north wall");
        Square wall = new Square(GRASS);
        wall.setNorthWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_stopBySouthWall() {
        System.out.println("move stop by south wall");
        Square wall = new Square(GRASS);
        wall.setSouthWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_stopByOpposedWallOnNextPos() {
        System.out.println("move stop by wall on the opposed next position");
        Square wall = new Square(GRASS);
        wall.setWestWall(true);

        board = new Board(new Square[][]{
            {new Square(GRASS), wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_stopByWallAndOnStar() {
        System.out.println("move stop by wall and on star");
        Square wall = new Square(STAR);
        wall.setEastWall(true);

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), wall}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 3);
        instance.move(board, Direction.EAST, animals);
        instance.move(board, Direction.EAST, animals);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
    }
}
