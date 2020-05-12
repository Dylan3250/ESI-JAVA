package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice03 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int somme = 0;

        while (i <= 5) {
            System.out.println("Veuillez entrer un nombre n°" + i + " :");
            int nb = clavier.nextInt();

            somme += nb;
            i++;
        }

        System.out.println("La somme de ces nombres est de " + somme + " !");
        System.out.println("La moyenne de ces nombres est de " + somme / 5.0 + " !");
    }

}
