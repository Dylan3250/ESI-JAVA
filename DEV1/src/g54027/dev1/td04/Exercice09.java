package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice09 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;
        int minNb = 0;
        int maxNb = 0;

        System.out.println("Veuillez indiquer le nombre de nombre que vous souhaitez insérer :");
        int nbNumber = clavier.nextInt();

        while (i <= nbNumber) {
            System.out.println("Veuillez entrer un nombre n°" + i + " :");
            int nb = clavier.nextInt();

            if (nb > maxNb) {
                maxNb = nb;
            }

            if (nb < minNb) {
                minNb = nb;
            }
            i++;
        }

        System.out.println("Le plus petit nombre indiqué est " + minNb + ".");
        System.out.println("Le plus grand nombre indiqué est " + maxNb + ".");
    }

}
