package g54027.dev1.java;

import java.util.Random;
import java.util.Scanner;

public class FourchetteGame {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner keyboard = new Scanner(System.in);

        int currentTry = 0;
        int random = 1 + r.nextInt(99);
        System.out.println(random);
        int getNb;

        do {
            getNb = keyboard.nextInt();
            if (getNb == random) {
                System.out.println("Bravo vous avez trouvez le nombre en "
                        + currentTry + " essais.");
                currentTry = 8;
            } else if (getNb < random) {
                System.out.println("Plus grand");
            } else {
                System.out.println("Plus petit");
            }
            currentTry++;
        } while (currentTry < 8);

        if (getNb != random) {
            System.out.println("Vous n'avez pas trouvez le nombre, le nombre"
                    + " était : " + random);
        }
    }

}
