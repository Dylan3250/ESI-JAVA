package g54027.dev1.td11;

public class Exercice05 {

    public static int[] copie(int[] tab) {
        int[] copie = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            copie[i] = tab[i];
        }
        return copie;
    }

    public static int[] pasUneCopie(int[] tab) {
        int[] copie = tab;
        return copie;
    }

    public static void afficherTab(int[] tab) {
        for (int element : tab) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static int[] miroir(int[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide ou null.");
        }

        int[] reversed = new int[tab.length];
        int indiceSize = tab.length - 1;

        for (int i = indiceSize; i >= 0; i--) {
            reversed[indiceSize - i] = tab[i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};
        afficherTab(tableau);
        int[] copie1 = copie(tableau);
        int[] copie2 = pasUneCopie(tableau);
        tableau[0] = 9;

        System.out.print("tableau: ");
        afficherTab(tableau);
        System.out.print("copie1: ");
        afficherTab(copie1);
        System.out.print("copie2: ");
        afficherTab(copie2);
        System.out.print("miroir: ");
        afficherTab(miroir(tableau));
    }
}
