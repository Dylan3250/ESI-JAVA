package esi.atl.g54027.game2048.view;

import esi.atl.g54027.game2048.model.GameStatus;
import esi.atl.g54027.game2048.model.Square;

import java.util.Scanner;

/**
 * The main class of the view. The player will communicate with this class to
 * progress in the game.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class View {

    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Shows the board of the game in the console.
     *
     * @param squares the given board of the game
     * @param nbMoves the number of the displacement already did
     * @param score the given score of the game
     */
    public void showBoard(Square[][] squares, int nbMoves, int score) {
        title(nbMoves, score);
        var str = new StringBuilder();
        for (var arraySquares : squares) {
            str.append("|");
            for (int i = 0; i < arraySquares.length; i++) {
                str.append(String.format("%5d", arraySquares[i].getValue()));
                if (i != arraySquares.length - 1) {
                    str.append("    |");
                }
            }
            str.append("    |\n");
        }
        System.out.println(str);

    }

    /**
     * Asks a direction (left, right, bottom, top) of the player.
     *
     * @return the direction in lower case
     */
    public String askDirection() {
        keyboard.useDelimiter("\n");

        System.out.println("Veuillez choisir votre direction : "
                + "top (T), right (R), bottom (B) ou left (L).");
        while (!keyboard.hasNext("(?i)(top|T|right|R|bottom|B|left|L)")) {
            keyboard.next();
            System.err.println("Vous devez rentrer un de ces choix : "
                    + "top (T), right (R), bottom (B) ou left (L)");
        }
        return keyboard.next().toLowerCase();
    }

    /**
     * Asks if the player wants to play again after the end of the game.
     *
     * @return yes or not in lower case
     */
    public String askAgain() {
        keyboard.useDelimiter("\n");

        System.out.println("Voulez-vous rejouer : yes (Y) ou no (N) ?");
        while (!keyboard.hasNext("(?i)(yes|Y|no|N)")) {
            keyboard.next();
            System.err.println("Vous devez rentrer un de ces choix "
                    + ": yes (Y) ou no (N) ?");
        }
        return keyboard.next().toLowerCase();
    }

    /**
     * Shows the message of the end of game.
     *
     * @param nbMoves the given number of moves for the game
     * @param score the given score of the game
     * @param status the status of game (lost of won)
     */
    public void showEndGame(int nbMoves, int score, GameStatus status) {
        System.out.print(status == GameStatus.LOST ? "Vous avez perdu avec "
                + "un score de " + score + " !" : "Vous avez gagné avec une "
                + "case à 2048 et un score de " + score + "!");
        System.out.println(" Vous avez joué " + nbMoves + " mouvements !");
    }

    /**
     * Defines the title to display after chosen moves.
     *
     * @param nbMoves the given number move.
     * @param score the given score of the game
     */
    private void title(int nbMoves, int score) {
        String title = nbMoves == 0 ? "Plateau de départ"
                : "Mouvement n°" + String.format("%0$-5d", nbMoves);
        String displayScore = "Score : " + String.format("%0$-9d", score);
        var str = new StringBuilder();
        int space = nbMoves == 0 ? 11 : 11;
        String line = "-".repeat(title.length() + space * 2);

        // Top border
        str.append("\n");

        str.append("|");
        str.append(line);
        str.append("|");

        // Jump line
        str.append("\n");
        str.append("|");

        // Body
        str.append(" ".repeat(space));
        str.append(title);
        str.append(" ".repeat(space));
        str.append("|");

        // Jump line
        str.append("\n");
        str.append("|");

        // Score
        str.append(" ".repeat(space));
        str.append(displayScore);
        str.append(" ".repeat(space));
        str.append("|");

        // Jump line
        str.append("\n");
        str.append("|");

        // Bottom border
        str.append(line);
        str.append("|");
        str.append("\n");

        System.out.println(str);
    }
}
