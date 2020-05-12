package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice06 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int positif = 0;
        int negatif = 0;
        int nul = 0;

        System.out.println("Veuillez indiquer le nombre de nombre que vous souhaitez insérer :");
        int nbNumber = clavier.nextInt();

        while (i <= nbNumber) {
            System.out.println("Veuillez entrer un nombre n°" + i + " :");
            int nb = clavier.nextInt();

            if (nb == 0) {
                nul++;
            } else if (nb > 0) {
                positif++;
            } else {
                negatif++;
            }
            i++;
        }

        System.out.println("Il y a au total " + positif + " nombre(s) positif(s).");
        System.out.println("Il y a au total " + negatif + " nombre(s) negatif(s).");
        System.out.println("Il y a au total " + nul + " nombre(s) nul(s).");
    }

}