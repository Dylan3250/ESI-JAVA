package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice11 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int nb = 0;
        int lastNb = 0;
        boolean isCroissant = true;

        while (nb > -1) {
            System.out.println("Veuillez entrer un nombre positif n°" + i + " [-1 arrête] :");
            nb = clavier.nextInt();

            if (nb > -1) {
                if (nb < lastNb && isCroissant) {
                    isCroissant = false;
                }
                lastNb = nb;
            }
            i++;
        }
        if (isCroissant) {
            System.out.println("La suite de nombre est croissante.");
        } else {
            System.out.println("La suite de nombre est décroissante.");
        }
    }

}
