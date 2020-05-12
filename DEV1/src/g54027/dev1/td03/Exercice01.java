package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice01 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Veuillez entrer votre âge :");

        while (!keyboard.hasNextInt()) {
            System.out.println("Erreur, veuillez entrer votre âge en nombre :");
            keyboard.next();
        }

        int years = keyboard.nextInt();

        if (years >= 18) {
            System.out.println("Vous êtes majeur !");
        }
    }

}
