package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice03 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double nbMax = 0;
        double nbInput = 0;

        for (int i = 0; i <= 1; i++) {
            System.out.println("Veuillez entrer un premier nombre à tester :");

            while (!keyboard.hasNextInt()) {
                System.out.println("Erreur, veuillez entrer votre un nombre numérique :");
                keyboard.next();
            }
            nbInput = keyboard.nextInt();

            if (i == 0 || nbMax < nbInput) {
                nbMax = nbInput;
            }
        }

        System.out.println("Le plus grand des nombres est " + nbMax);
    }

}
