package esi.atl.g54027.blackjack.view;

import esi.atl.g54027.blackjack.model.Status;
import esi.atl.g54027.cards.Card;
import esi.atl.g54027.utils.Colors;
import java.util.List;
import java.util.Scanner;

/**
 * Views on the game. Multiples methods that are used to display the status of
 * game or interact with player.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class View implements InterfaceView {

    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Converts the answer in boolean expression.
     *
     * @param o, oui, n or non but nothing else
     * @throws IllegalArgumentException the given string is not o/oui/n/non
     * @return true if it is a positive answer, false otherwise
     */
    private boolean convertAnswer(String answer) {
        if (!answer.equals("o") && !answer.equals("oui")
                && !answer.equals("n") && !answer.equals("non")) {
            throw new IllegalArgumentException("Impossible to convert in "
                    + "boolean expression : " + answer);
        }

        switch (answer) {
            case "o":
            case "oui":
                return true;
            default:
                return false;
        }
    }

    /**
     * Repeats question since the answer is valid.
     *
     * @return o, oui, n or non but nothing else
     */
    private String repeatAsk() {
        while (!keyboard.hasNext("^(?i)|o|oui|n|non")) {
            System.err.println(Colors.RED + "Il faut choisir entre O (Oui) ou "
                    + "N (Non) : " + Colors.DEFAULT);
            keyboard.next();
        }
        return keyboard.next().toLowerCase();
    }

    @Override
    public boolean askNewHit() {
        System.out.println(Colors.CYAN + "Voulez-vous piocher une nouvelle "
                + "carte ? O (Oui) ou N (Non) : " + Colors.DEFAULT);
        return convertAnswer(repeatAsk());
    }

    @Override
    public boolean askAgain() {
        System.out.println(Colors.CYAN + "Voulez-vous refaire une partie ? "
                + "O (Oui) ou N (Non) : " + Colors.DEFAULT);
        return convertAnswer(repeatAsk());
    }

    @Override
    public double askBet(double playerMoney) {
        double betted = -1;
        boolean valid = false;

        System.out.println(Colors.GREEN + "Vous avez actuellement "
                + playerMoney + " euros pariable !" + Colors.YELLOW
                + "\nCombien d'euro voulez-vous parier sur cette partie ?"
                + Colors.DEFAULT);
        while (!valid) {
            while (!keyboard.hasNextDouble()) {
                System.err.println(Colors.RED + "Il faut choisir un montant "
                        + "compris entre 1 et " + playerMoney + Colors.DEFAULT);
                keyboard.next();
            }
            betted = keyboard.nextDouble();
            if (betted <= 0 || betted > playerMoney) {
                System.err.println(Colors.RED + "Le montant indiqué ("
                        + betted + ") n'est pas entre 1 et " + playerMoney
                        + "\nMerci de rentrer un montant à parier valide : "
                        + Colors.DEFAULT);
            } else {
                valid = true;
            }
        }
        return betted;
    }

    @Override
    public void displayFinish(int playerScore, int bankScore, Status status) {
        switch (status) {
            case WIN:
                if (bankScore == 0) {
                    System.out.println(Colors.GREEN + "Félicitations ! Vous avez "
                        + "gagné avec " + playerScore + " face à la banque "
                        + "qui n'a même pas eu le temps de jouer !" 
                        + Colors.DEFAULT);
                } else {
                    System.out.println(Colors.GREEN + "Félicitations ! Vous avez "
                        + "gagné avec " + playerScore + " face à la banque qui "
                        + "a eu " + bankScore + Colors.DEFAULT);
                }
                break;

            case LOST:
                System.out.println(Colors.RED + "Dommage ! Vous avez perdu avec "
                        + playerScore + " face à la banque qui a eu "
                        + bankScore + Colors.DEFAULT);
                break;
            case EQUALITY:
                System.out.println(Colors.YELLOW + "Vous avez fait une égalité "
                        + "avec la banque ! Vous avez eu un score de "
                        + playerScore + Colors.DEFAULT);
                break;
            default:
                throw new IllegalArgumentException("The given status is not "
                        + "correct : " + status);
        }
    }

    @Override
    public void displayPlayerOut() {
        System.err.println(Colors.RED + "Vous avez perdu en dépassant le score "
                + "de 21 !" + Colors.DEFAULT);
    }

    @Override
    public void displaySum(int playerCards
    ) {
        System.out.println(Colors.MAGENTA + "Vous avez actuellement une somme "
                + "de carte de " + Colors.GREEN + playerCards + Colors.DEFAULT);
    }

    @Override
    public void displayCards(List<Card> cards
    ) {
        String[] lines = new String[]{"", "", "", "", "", "", ""};
        String numberFormat;
        for (int i = 0; i < cards.size(); i++) {
            String spaceBetweenCards
                    = (i == cards.size() - 1) ? "" : " ".repeat(5);
            Colors colorCarte;

            switch (cards.get(i).getValue()) {
                case JACK:
                    numberFormat = " V";
                    break;
                case QUEEN:
                    numberFormat = " Q";
                    break;
                case KING:
                    numberFormat = " R";
                    break;
                default:
                    numberFormat = String.format("%2d",
                            cards.get(i).getValue().getNumberValue());
            }

            switch (cards.get(i).getColor().getSymbol()) {
                case '\u2663':
                case '\u2660':
                    colorCarte = Colors.BLACK;
                    break;
                default:
                    colorCarte = Colors.RED;
            }

            lines[0] += Colors.BG_LIGHT_GREY + "" + colorCarte + numberFormat
                    + "       " + cards.get(i).getColor().getSymbol() + " "
                    + Colors.DEFAULT + spaceBetweenCards;

            lines[1] += Colors.BG_LIGHT_GREY + "           " + Colors.DEFAULT
                    + spaceBetweenCards;
            lines[2] += Colors.BG_LIGHT_GREY + "           " + Colors.DEFAULT
                    + spaceBetweenCards;
            lines[3] += Colors.BG_LIGHT_GREY + "    " + colorCarte
                    + numberFormat + "     " + Colors.DEFAULT + spaceBetweenCards;
            lines[4] += Colors.BG_LIGHT_GREY + "           " + Colors.DEFAULT
                    + spaceBetweenCards;
            lines[5] += Colors.BG_LIGHT_GREY + "           " + Colors.DEFAULT
                    + spaceBetweenCards;
            lines[6] += Colors.BG_LIGHT_GREY + " " + colorCarte
                    + cards.get(i).getColor().getSymbol() + "      "
                    + numberFormat + " " + Colors.DEFAULT + spaceBetweenCards;
        }

        for (String line : lines) {
            System.out.println(line);
        }

        System.out.println("\nVoici les cartes piochées : " + cards);
    }

    @Override
    public void displayEnd(double playerMoney, double oldPlayerMoney, int rounds
    ) {
        System.out.println(Colors.GREEN + "Le jeu est terminé ! Vous êtes passé de "
                + oldPlayerMoney + " euro(s) à " + playerMoney + " lors du "
                + "dernier round ! Vous avez joué " + rounds + " round(s) !"
                + Colors.DEFAULT);
    }

    @Override
    public void displayRound(int rounds
    ) {
        String title = "Round n°" + rounds;
        var str = new StringBuilder();
        int space = 5;

        // Top border
        str.append("\n");
        str.append(Colors.BG_CYAN);
        str.append(Colors.RED);
        str.append("|");
        str.append("-".repeat(title.length() + space * 2));
        str.append("|");
        str.append(Colors.DEFAULT);

        // Jump line
        str.append("\n");
        str.append(Colors.BG_CYAN);
        str.append(Colors.RED);
        str.append("|");

        // Body
        str.append(" ".repeat(space));
        str.append(title);
        str.append(" ".repeat(space));
        str.append("|");

        // Jump line
        str.append(Colors.DEFAULT);
        str.append("\n");
        str.append(Colors.BG_CYAN);
        str.append(Colors.RED);
        str.append("|");

        // Bottom border
        str.append("-".repeat(title.length() + space * 2));
        str.append("|");
        str.append(Colors.DEFAULT);
        str.append("\n");

        System.out.println(str);
    }
}
