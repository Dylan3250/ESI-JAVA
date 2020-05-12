package g54027.dev1.interro2;

import java.util.Scanner;

/**
 * BRICAR Dylan
 *
 * @author g54027
 */
public class Methodes {

    public static void decompteParDeux(int n) {
        int i = n;

        // CORRECTION
        if (i % 2 != 0) {
            i--;
        }

        while (i >= 0) {
            System.out.print(i + " ");
            i -= 2;
        }

        /*
        while (i >= 0) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i--;
        }
         */
        System.out.println("");
    }

    public static void compteEntre(int borneInf, int borneSup) {
        if (borneSup < borneInf) {
            throw new IllegalArgumentException("Veuillez entrer une borne"
                    + " supérieure à la borne inférieure.");
        }

        for (int i = borneInf; i <= borneSup; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    /**
     * Calcule une moyenne sur base d'une suite de nombres (arrêté par -1)
     *
     * @return moyenne des nombres indiqués
     */
    public static double moyenne() {
        Scanner keyboard = new Scanner(System.in);
        double totalNombre = 0;
        double nombre = 0;
        int countNombre = 0;

        while (nombre != -1) {
            System.out.print("Veuillez indiquer un nombre ou \"-1\" pour"
                    + " arrêter le programme : ");

            while (!keyboard.hasNextDouble()) {
                System.out.print("Ce qui a été rentré n'est pas un nombre,"
                        + " merci de réessayer avec un nombre ou d'utiliser"
                        + " \"-1\" pour arrêter le programme : ");
                keyboard.next();
            }
            nombre = keyboard.nextDouble();

            if (nombre != -1) {
                totalNombre += nombre;
                countNombre++;
                System.out.println("Le nombre " + nombre + " a bien été pris"
                        + " en compte !");
            }
        }
        // ou return (double) totalNombre / countNombre;
        // si les deux valeurs sont en int et qu'il faut les convertir en double
        return totalNombre / countNombre;
    }

    public static void main(String[] args) {
        decompteParDeux(8);
        compteEntre(5, 7);
        System.out.println("La moyenne est de " + moyenne());
    }
}
