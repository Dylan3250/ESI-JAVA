package g54027.humbug.model;

import static g54027.humbug.model.SquareType.GRASS;
import static g54027.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class GrasshopperTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS),
                new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Grasshopper(new Position(0, 0)),
            new Grasshopper(new Position(1, 2))
        };
    }

    @Test
    public void testMove() {
        System.out.println("move_general");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Grasshopper instance = (Grasshopper) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 2); //jump over
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_JumpOverAnimal() {
        System.out.println("move jump over animal");

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Grasshopper(new Position(0, 0)),
            new Snail(new Position(0, 1))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_JumpOverMultipleAnimal() {
        System.out.println("move jump over multiple animals");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Grasshopper(new Position(0, 0)),
            new Snail(new Position(0, 1)),
            new Spider(new Position(0, 2)),
            new Grasshopper(new Position(0, 3))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
}
