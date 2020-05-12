package g54027.dev1.java;

public class CreateRectangle {

    public static void afficherRectangle(int nbLignes, int nbCol) {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbCol; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        afficherRectangle(5, 8);
    }
}
