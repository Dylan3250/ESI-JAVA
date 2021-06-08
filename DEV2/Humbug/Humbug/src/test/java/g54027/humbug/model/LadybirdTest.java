package g54027.humbug.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static g54027.humbug.model.SquareType.GRASS;
import static g54027.humbug.model.SquareType.STAR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class LadybirdTest {

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
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    @Test
    public void testMove() {
        System.out.println("move and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_endline() {
        System.out.println("move end line and fall");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Ladybird instance = (Ladybird) animals[0];
        animals[0].setPositionOnBoard(new Position(0, 1));
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_tootheranimal() {
        System.out.println("move to other animal");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals[1] = new Snail(new Position(0, 2));
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_passOnStar() {
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR),
                new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 3))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertFalse(board.getSquareType(new Position(0, 1)) == GRASS);
    }

    @Test
    public void testMove_nextOnStar() {
        System.out.println("move next on star and win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),
                new Square(STAR), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 3))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    @Test
    public void testMove_stopByEastWall() {
        System.out.println("move stop by east wall");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
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
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
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
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
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
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
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
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
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
            new Ladybird(new Position(0, 1))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
    }

    @Test
    public void testMove_twoMoveMax() {
        System.out.println("move walk max two square");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
}
