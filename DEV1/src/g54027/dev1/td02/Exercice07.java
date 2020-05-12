package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice07 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre entre 100 et 999:");
        int nb = clavier.nextInt();

        while (nb > 999 || nb < 100) {
            System.out.println("Veuillez entrer un nombre entre 100 et 999:");
            nb = clavier.nextInt();
        }

        int unites = nb % 10;
        int dizaines = (nb / 10) % 10;
        int centaine = (nb / 100) % 10;
        String nbReversed = unites + "" + dizaines + "" + centaine;

        System.out.println("Le nombe inversé de " + nb + " est " + nbReversed);
    }
    
}
