package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice01 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre nombre : ");
        while (!keyboard.hasNextInt()) {
            System.out.print("Erreur - veuillez réessayer avec un nombre entier : ");
            keyboard.next();
        }
        int nb = keyboard.nextInt();

        System.out.print("Voici les nombres de 1 à nb : ");
        for (int i = 1; i <= nb; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\nVoici les nombres pairs compris entre 1 et nb : ");
        for (int i = 2; i <= nb; i += 2) {
            System.out.print(i + " ");
        }

        System.out.print("\nVoici les nombres de -nb à nb : ");
        for (int i = -nb; i <= nb; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\nMultiple de 5 compris entre 1 et nb : ");
        for (int i = 5; i <= nb; i += 5) {
            System.out.print(i + " ");
        }

        System.out.print("\nMultiple de nb compris entre 1 et 100 : ");
        for (int i = nb; i <= 100; i += nb) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

}
