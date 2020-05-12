package g54027.dev2.memory;

import java.util.Scanner;

public class Memory {

    final private Game game;

    public Memory(int nbCard) {
        this.game = new Game(nbCard);
    }

    /**
     * Asks card position to return
     *
     * @return the value of chosen card
     */
    public int askPosition() {
        Scanner keyboard = new Scanner(System.in);
        int posTab = 0;

        do {
            System.out.print("Veuillez indiquer un numéro de carte pas encore "
                    + "pris [1 - " + game.getSize() + "] : ");
            while (!keyboard.hasNextInt()) {
                keyboard.next();
                System.out.print("ERREUR : Veuillez indiquer un numéro de carte "
                        + "[1 - " + game.getSize() + "] : ");
            }
            posTab = keyboard.nextInt() - 1;

            if (!game.isHidden(posTab)) {
                System.out.println("La carte numéro " + (posTab + 1) + " a déjà "
                        + "été trouvée !");
            }
        } while (posTab > game.getSize() - 1 || posTab < 0
                || !game.isHidden(posTab));

        return posTab;
    }

    /**
     * Run the game with n pair of cards
     *
     * @return the number of tries for has won the game
     */
    public int playMemory() {
        this.game.shuffle();
        int nbTry = 0;

        while (!this.game.isGameOver()) {
            System.out.println(this.game.toString());
            int pos1 = askPosition();
            int pos2 = askPosition();
            this.game.checkPositions(pos1, pos2);
            nbTry++;
        }

        return nbTry;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nVeuillez indiquer le nombre de pair avec lequel vous "
                + "souhaitez jouer : ");

        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.print("ERREUR : Veuillez indiquer le nombre de pair avec "
                    + "lequel vous souhaitez jouer : ");
        }

        int nbCards = keyboard.nextInt();
        Memory memory = new Memory(nbCards);

        int totalRound = memory.playMemory();

        System.out.println("\nFélicitations ! Vous avez terminé le jeu en "
                + totalRound + " coups !");
    }
}
