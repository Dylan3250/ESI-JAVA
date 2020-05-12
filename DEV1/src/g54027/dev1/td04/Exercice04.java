package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice04 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i = 1;

        while (i <= 10) {
            System.out.println("Veuillez entrer un nombre n°" + i + " :");
            int nb = clavier.nextInt();

            if (nb % 2 == 0) {
                System.out.println("Le nombre n°" + i + " qui est " + nb + " est pair !");
            } else {
                System.out.println("Le nombre n°" + i + " qui est " + nb + " est impair !");
            }
            i++;
        }
    }

}
