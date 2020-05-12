package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice06 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer le nombre 1 : ");
        double nb1 = keyboard.nextDouble();
        System.out.print("Veuillez entrer le nombre 2 : ");
        double nb2 = keyboard.nextDouble();
        System.out.print("Veuillez entrer le nombre 3 : ");
        double nb3 = keyboard.nextDouble();

        if (nb1 > nb2 && nb1 > nb3) {
            System.out.println(nb1);
            // } else if (nb2 > nb1 && nb2 > nb3) {
            // Vu que la précédente condition est fausse, nb1 est d'office inférieur à nb2
            // Inutile de tester si nb2 > nb1

        } else if (nb2 > nb3) {
            System.out.println(nb2);
        } else {
            System.out.println(nb3);
        }
    }

}
