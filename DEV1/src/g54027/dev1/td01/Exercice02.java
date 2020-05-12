package g54027.dev1.td01;

public class Exercice02 {

    public static void main(String[] args) {
        // Boucle 5 fois pour faire 5 lignes
        for (int d = 1; d <= 5; d++) {
            // Boucle 5 fois pour aligner 5 étoiles
            for (int i = 1; i <= 5; i++) {
                System.out.print("*");
            }
            // Retour à la ligne pour le visuel
            System.out.println("");
        }
    }

}
