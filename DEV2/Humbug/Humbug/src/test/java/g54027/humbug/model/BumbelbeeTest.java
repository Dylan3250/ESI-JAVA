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
public class BumbelbeeTest {

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
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    @Test
    public void testMove() {
        System.out.println("move and fall");
        Bumbelbee instance = (Bumbelbee) animals[0];
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
        Bumbelbee instance = (Bumbelbee) animals[0];
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
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null and fall");
        Bumbelbee instance = (Bumbelbee) animals[0];
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
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 3))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
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
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 3))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    @Test
    public void testMove_NoStopByEastWall() {
        System.out.println("move don't stop by east wall");
        Square wall = new Square(GRASS);
        wall.setEastWall(true);
        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_NoStopByWestWall() {
        System.out.println("move don't stop by west wall");
        Square wall = new Square(GRASS);
        wall.setWestWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_NoStopByNorthWall() {
        System.out.println("move don't stop by north wall");
        Square wall = new Square(GRASS);
        wall.setNorthWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_NoStopBySouthWall() {
        System.out.println("move don't stop by south wall");
        Square wall = new Square(GRASS);
        wall.setSouthWall(true);

        board = new Board(new Square[][]{
            {wall}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_NoStopByOpposedWallOnNextPos() {
        System.out.println("move don't stop by wall on the "
                + "opposed next position");
        Square wall = new Square(GRASS);
        wall.setWestWall(true);

        board = new Board(new Square[][]{
            {new Square(GRASS), wall}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_flyOverAnimal() {
        System.out.println("move fly over animal");

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 1))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_flyOverMultipleAnimal() {
        System.out.println("move fly over multiple animals");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(0, 2)),
            new Spider(new Position(0, 3)),
            new Bumbelbee(new Position(0, 4))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 5);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_twoMoveMax() {
        System.out.println("move walk max two square");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_FlyOverNull() {
        System.out.println("move fly over null square");
        board = new Board(new Square[][]{
            {new Square(GRASS), null, new Square(GRASS)}
        });
        animals = new Animal[]{
            new Bumbelbee(new Position(0, 0))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
}
