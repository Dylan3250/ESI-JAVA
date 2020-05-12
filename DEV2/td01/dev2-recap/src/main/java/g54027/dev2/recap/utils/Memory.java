package g54027.dev2.recap.utils;

import java.util.Scanner;

public class Memory {

    /**
     * Initializes game array with default values (1 to n) x2 for pair of cards.
     *
     * @param n the given number of different cards
     * @return twice each card side by side
     */
    public static int[] initCards(int n) {
        if (n < 3 || n > 20) {
            throw new IllegalArgumentException("Le nombre de carte doit être "
                    + "comprise entre 3 et 20");
        }

        int[] tab = new int[n * 2];
        
        for (int i = 0; i < n; i++) {
            tab[i] = i / 2 + 1;
        }
        
        return tab;
    }

    /**
     * Asks card position to return
     *
     * @param cards the given array with each integer cards
     * @param collectedCards the given array with each boolean value of cards
     * @return the value of chosen card
     */
    public static int askPosition(int[] cards, boolean[] collectedCards) {
        Scanner keyboard = new Scanner(System.in);
        int posTab = 0;

        do {
            System.out.print("Veuillez indiquer un numéro de carte pas encore "
                    + "prise [1 - " + cards.length + "] : ");
            while (!keyboard.hasNextInt()) {
                keyboard.next();
                System.out.print("ERREUR : Veuillez indiquer un numéro de carte "
                        + "[1 - " + cards.length + "] : ");
            }
            posTab = keyboard.nextInt() - 1;

            if (collectedCards[posTab]) {
                System.out.println("La carte numéro " + (posTab + 1) + " a déjà "
                        + "été trouvée !");
            }
        } while (posTab > cards.length - 1 || posTab < 0
                || collectedCards[posTab]);

        return posTab;
    }

    /**
     * Checks if the given positions are identical and returns them
     *
     * @param cards the given array with each integer cards
     * @param collectedCards the given array with each boolean value of cards
     * @param pos1 the first given position to return
     * @param pos2 the second given position to return
     */
    public static void checkPositions(int[] cards, boolean[] collectedCards,
            int pos1, int pos2) {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("Les deux choix doivent être "
                    + "différents");
        }

        if (cards[pos1] == cards[pos2]) {
            System.out.println("Félicitations, les cartes en position "
                    + (pos1 + 1) + " & " + (pos2 + 1) + " sont identiques !");
            collectedCards[pos1] = true;
            collectedCards[pos2] = true;
        } else {
            System.out.println("Malheureusement, les cartes en position "
                    + (pos1 + 1) + " & " + (pos2 + 1) + " ne sont pas "
                    + "identiques !");
        }
    }

    /**
     * Checks if there is card that is not returned
     *
     * @param collectedCards the given array with each boolean value of cards
     * @return true if all cards are returned, otherwise false
     */
    public static boolean isGameOver(boolean[] collectedCards) {
        boolean isFinish = true;
        int i = 0;

        while (isFinish && i < collectedCards.length) {
            if (!collectedCards[i]) {
                isFinish = false;
            }
            i++;
        }
        return isFinish;
    }

    /**
     * Run the game with n pair of cards
     *
     * @param n the number of pair of cards
     * @return the number of tries for has won the game
     */
    public static int playMemory(int n) {
        int[] baseCards = initCards(n);
        boolean[] collectedCards = new boolean[n * 2];
        ArrayUtil.shuffle(baseCards);
        int nbTry = 0;

        while (!isGameOver(collectedCards)) {
            MemoryUtil.displayCards(baseCards, collectedCards);
            int pos1 = askPosition(baseCards, collectedCards);
            int pos2 = askPosition(baseCards, collectedCards);
            checkPositions(baseCards, collectedCards, pos1, pos2);
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
        int totalRound = playMemory(nbCards);
        System.out.println("\nFélicitations ! Vous avez terminé le jeu en "
                + totalRound + " coups !");
    }
}
