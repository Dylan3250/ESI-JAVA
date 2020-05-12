package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice08 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int nb = 0;
        int maxNb = 0;

        while (nb != -1) {
            System.out.println("Veuillez entrer un nombre n°" + i + " [-1 arrête] :");
            nb = clavier.nextInt();

            if (nb > maxNb) {
                maxNb = nb;
            }

            i++;
        }

        System.out.println("Le plus grand nombre rentré est " + maxNb + ".");
    }

}
