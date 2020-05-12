package g54027.dev1.java;

import java.util.Random;
import java.util.Scanner;

public class CountOccurenceI2_04 {

    public static void afficherTitre(String nom, String prenom, String matricule) {
        System.out.println("Simulation d'une marche aléatoire 1D");
        System.out.println(nom + "-" + prenom + "-" + matricule);
    }

    public static int pasAleatoire(double p) {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("La probabilité doit être"
                    + " comprise entre 0 et 1 !");
        }

        Random r = new Random();
        double randomValue = r.nextDouble();
        int pas = -1;

        if (randomValue <= p) {
            pas = 1;
        }
        return pas;
    }

    /**
     * Simule le nombre de pas qu'il faudra faire vers la gauche ou la droite
     *
     * @param x0 position initale
     * @param n nombre de pas à effecuter
     * @param p probabilité d'aller vers la gauche ou la droite
     * @return nouvelle position
     */
    public static int simulation(int x0, int n, double p) {
        int position = x0;
        for (int i = 0; i < n; i++) {
            position += pasAleatoire(p);
        }
        return position;
    }

    public static int distance(int x0, int x1) {
        return Math.abs(x0) + Math.abs(x1);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        afficherTitre("Bricar", "Dylan", "G54027");
        System.out.print("Combien de pas voulez-vous ? : ");
        int nPas = keyboard.nextInt();
        System.out.print("Quel est le x0 (nombre de départ) ? : ");
        int x0 = keyboard.nextInt();
        System.out.print("Quel est la probabilité (entre 0 & 1 compris) ? : ");
        double p = keyboard.nextDouble();
        
        int distanceTotale = simulation(x0, nPas, p);
        System.out.println("Position finale : " + distanceTotale);
        System.out.println("Distance parcourue : " + distance(x0, distanceTotale));

    }
}
