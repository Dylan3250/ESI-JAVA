package g54027.dev1.java;

import java.util.Random;
import java.util.Scanner;

public class RollDice {

    public static int rollDice(int n, int value) {
        Random random = new Random();
        int countDice = 0;

        for (int i = 0; i < n; i++) {
            int roll = 1 + random.nextInt(6);

            if (roll == value) {
                countDice++;
            }
        }
        return countDice;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre de lancé : ");
        int nbRoll = keyboard.nextInt();
        System.out.print("Veuillez entrer le nombre à vérifier : ");
        int nbVerif = keyboard.nextInt();

        System.out.println("La valeur " + nbVerif + " est apparue "
                + rollDice(nbRoll, nbVerif) + " fois lors de "
                + nbRoll + " lancés !");
    }
}
