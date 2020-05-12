package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice01 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre :");
        int nb = clavier.nextInt();
        int nbInverse = -nb;
        int nbInitial = 1;
        int nbModulo = 1;
        int nbFive = 1;
        int nbMaxMultiple = 1;

        System.out.print("Liste des nombres de 1 à " + nb + " :\n");
        while (nbInitial <= nb) {
            System.out.print(nbInitial + " ");
            nbInitial++;
        }

        System.out.print("\nListe des pairs compris entre 1 et " + nb + " :\n");
        while (nbModulo <= nb) {
            if (nbModulo % 2 == 0) {
                System.out.print(nbModulo + " ");
            }
            nbModulo++;
        }

        System.out.print("\nListe des nombres de " + nbInverse + " à " + nb + " :\n");
        while (nbInverse <= nb) {
            System.out.print(nbInverse + " ");
            nbInverse++;
        }

        System.out.print("\nListe des multiples de 5 compris entre 1 et " + nb + " :\n");
        while (nbFive <= nb) {
            if (nbFive % 5 == 0) {
                System.out.print(nbFive + " ");
            }
            nbFive++;
        }

        System.out.print("\nListe des multiples de n compris entre 1 et 100 :\n");
        while (nbMaxMultiple <= 100) {
            if (nbMaxMultiple % nb == 0) {
                System.out.print(nbMaxMultiple + " ");
            }
            nbMaxMultiple++;
        }
    }

}
