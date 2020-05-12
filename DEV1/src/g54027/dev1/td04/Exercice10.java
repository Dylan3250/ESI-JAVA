package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice10 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int nb = 0;
        int firstNb = 0;
        int lastNb = 0;

        while (nb > -1) {
            System.out.println("Veuillez entrer un nombre positif n°" + i + " [-1 arrête] :");
            nb = clavier.nextInt();

            if (i == 1) {
                firstNb = nb;
            }

            if (nb > -1) {
                lastNb = nb;
            }

            i++;
        }

        if (firstNb == -1) {
            System.out.println("Le série est vide.");
        } else if (firstNb < lastNb) {
            System.out.println("Le premier est inférieur au dernier.");
        } else if (firstNb == lastNb) {
            System.out.println("Le premier est égal au dernier.");
        } else if (firstNb > lastNb) {
            System.out.println("Le premier est supérieur au dernier.");
        }
    }

}
