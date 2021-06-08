package g54027.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Level is responsible to give a level for play. A level of play is: a game
 * board, animals and number of trips allowed.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Level {

    /**
     * Gets the board for to the level requested.
     *
     * @param lvl the given requested level
     * @throws IllegalArgumentException the given level is impossible
     * @return the board with animals and max move (the complet level)
     */
    public static Level getLevel(int lvl) {
        if (lvl > 100 || lvl < 1) {
            throw new IllegalArgumentException("Niveau " + lvl + " impossible");
        }
        return readLevel(lvl);
    }

    /**
     * Gets the board for to the level requested.
     *
     * @param lvl the given requested level
     * @return the board with animals and max move (the complet level) or a
     * message of exception
     */
    private static Level readLevel(int lvl) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + lvl + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.err.println("Niveau " + lvl + " introuvable !");
        }
        return null;
    }

    private final Board board;
    private final Animal[] animals;
    private final int nMoves;

    /**
     * Makes the level with given parameters by static methods (factory).
     *
     * @param board the given board
     * @param animals the given array animals
     * @param nMoves the maximum of movements for this level
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Defines constructor without arguments for deserialization with Jakson.
     */
    public Level() {
        this(null, null, 0);
    }

    /**
     * Gets the board of game.
     *
     * @return the board of game
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the array of all animals.
     *
     * @return the array of all animals
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Gets the maximum number of movement.
     *
     * @return the maximum number of movement
     */
    public int getnMoves() {
        return nMoves;
    }
}
