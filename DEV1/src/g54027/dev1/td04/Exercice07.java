package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice07 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int nb = 0;
        int firstNb = 0;
        int lastNb = 0;

        while (nb != -1) {
            System.out.println("Veuillez entrer un nombre n°" + i + " [-1 arrête] :");
            nb = clavier.nextInt();

            if (i == 1) {
                firstNb = nb;
            }

            if (nb != -1) {
                lastNb = nb;
            }

            i++;
        }

        System.out.println("Le premier nombre est " + firstNb + ".");
        System.out.println("Le dernier nombre est " + lastNb + ".");
    }

}
