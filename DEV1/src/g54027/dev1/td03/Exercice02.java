package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice02 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre à tester :");

        while (!keyboard.hasNextInt()) {
            System.out.println("Erreur, veuillez entrer votre un nombre numérique :");
            keyboard.next();
        }

        int nb = keyboard.nextInt();

        if (nb % 2 == 0) {
            System.out.println("Votre nombre est pair !");
        } else {
            System.out.println("Votre nombre est impair !");
        }
    }

}
