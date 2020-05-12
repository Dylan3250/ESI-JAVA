package g54027.dev1.java;

import java.util.Random;
import java.util.Scanner;

public class MiniGame {

    /**
     * Makes an array with cards' values
     *
     * @param n number of card possible in game
     * @return all cards and their binomial
     */
    public static int[] initCards(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de carte doit être positif");
        }

        int[] cards = new int[2 * n];
        int cardValue = 0;

        for (int i = 0; i < cards.length; i += 2) {
            cards[i] = cardValue;
            cards[i + 1] = cardValue;
            cardValue++;
        }

        return cards;
    }

    /**
     * Makes an array with cards was found or not
     *
     * @param n number of card possible in game
     * @return all cards found or not (true found, false otherwise)
     */
    public static boolean[] initFeedBack(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de carte doit être positif");
        }
        boolean[] cards = new boolean[2 * n];

        return cards;
    }

    public static void showGame(int[] cards, boolean[] feedback) {
        for (int i = 0; i < feedback.length; i++) {
            if (feedback[i]) {
                System.out.print(cards[i] + " ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }

    public static boolean toReturn(int[] cards, boolean[] feedback, int i, int j) {
        if (cards[i] == cards[j] && j != i) {
            feedback[i] = true;
            feedback[j] = true;
        }

        return cards[i] == cards[j] && j != i;
    }

    /**
     * Checks if all cards are found
     *
     * @param feedback the given array with cards found
     * @return true if all cards are found, false otherwise
     */
    public static boolean isAllReturned(boolean[] feedback) {
        if (feedback == null || feedback.length == 0) {
            throw new IllegalArgumentException("Le tableau est null"
                    + " ou n'a pas d'éléments");
        }

        int i = 0;

        while (i < feedback.length && feedback[i]) {
            i++;
        }

        return i == feedback.length;
    }

    public static void mixCards(int[] cards) {
        Random r = new Random();
        int n = cards.length - 1;

        for (int cpt = 0; cpt < n; cpt++) {
            int i = r.nextInt(n + 1);
            int j = r.nextInt(n + 1);
            int saveValue = cards[i];

            cards[i] = cards[j];
            cards[j] = saveValue;
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean[] feedback = initFeedBack(3);
        int[] cards = initCards(3);
        mixCards(cards);

        while (!isAllReturned(feedback)) {
            showGame(cards, feedback);

            System.out.print("Veuillez indiquer le premier indice : ");
            int index1 = keyboard.nextInt();
            System.out.print("Veuillez indiquer le second indice : ");
            int index2 = keyboard.nextInt();

            if (toReturn(cards, feedback, index1, index2)) {
                System.out.println("Bravo !");
            } else {
                System.out.println("Raté !");
            }
        }

    }
}
