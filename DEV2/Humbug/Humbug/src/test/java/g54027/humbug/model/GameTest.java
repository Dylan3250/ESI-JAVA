package g54027.humbug.model;

import static g54027.humbug.model.SquareType.GRASS;
import static g54027.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class GameTest {

    private final Game game = new Game();

    @Test
    public void testStartLevel_levelFound() {
        game.startLevel(1);
        Animal animal[] = new Animal[]{
            new Snail(new Position(0, 0))
        };
        Board board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        assertEquals(animal.length, game.getAnimals().length);
        assertEquals(board.getNbColumn(), game.getBoard().getNbColumn());
        assertEquals(board.getNbRow(), game.getBoard().getNbRow());
        assertEquals(1, game.getCurrentLevel());
        assertEquals(LevelStatus.IN_PROGRESS, game.getLevelStatus());
        assertEquals(game.getRemainingMoves(), 4);
    }

    @Test
    public void testStartLevel_levelNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.startLevel(101);
        });
    }

    @Test
    public void testMove_notAnimalOnBoard() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.move(new Position(0, 0), Direction.EAST);
        });
    }

    @Test
    public void testMove_isNotAnimal() {
        game.startLevel(1);
        assertThrows(IllegalArgumentException.class, () -> {
            game.move(new Position(2, 1), Direction.EAST);
        });
    }

    @Test
    public void testMove_onBoard() {
        game.startLevel(1);
        game.move(new Position(0, 0), Direction.EAST);
    }

    @Test
    public void testMove_animalFall() {
        game.startLevel(1);
        game.move(new Position(0, 0), Direction.NORTH);
    }

    @Test
    public void testStartLevel_updateStatusNormalMove() {
        game.startLevel(1);
        game.move(new Position(0, 0), Direction.EAST);
        assertEquals(1, game.getCurrentLevel());
        assertEquals(LevelStatus.IN_PROGRESS, game.getLevelStatus());
        assertEquals(game.getRemainingMoves(), 3);
    }

    @Test
    public void testStartLevel_updateStatusFailMove() {
        game.startLevel(1);
        game.move(new Position(0, 0), Direction.NORTH);
        assertEquals(1, game.getCurrentLevel());
        assertEquals(LevelStatus.FAIL, game.getLevelStatus());
        assertEquals(game.getRemainingMoves(), 3);
    }

    @Test
    public void testStartLevel_updateStatusWinMove() {
        game.startLevel(1);
        game.move(new Position(0, 0), Direction.EAST);
        game.move(new Position(0, 1), Direction.SOUTH);
        game.move(new Position(1, 1), Direction.EAST);
        game.move(new Position(1, 2), Direction.SOUTH);
        assertEquals(1, game.getCurrentLevel());
        assertEquals(LevelStatus.WIN, game.getLevelStatus());
        assertEquals(game.getRemainingMoves(), 0);
    }
}
