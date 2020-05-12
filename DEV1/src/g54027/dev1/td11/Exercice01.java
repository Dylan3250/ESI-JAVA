package g54027.dev1.td11;

public class Exercice01 {

    public static void afficherTab(int[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau ne doit pas être null");
        }

        System.out.print("[");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i]);

            if (i < tab.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]"); // on passe à la ligne
    }

    public static void incrementer(int[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau ne doit pas être null");
        }
                
        for (int i = 0; i < tab.length; i++) {
            tab[i]++;
        }
    }

    public static void multiplier(int[] tab, int facteur) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau ne doit pas être null");
        }
        
        for (int i = 0; i < tab.length; i++) {
            tab[i] *= facteur;
        }
    }

    public static void main(String[] args) {
        int[] tab = {1, 2, 3, 4, 5};
        System.out.println("taille: " + tab.length);
        System.out.println("1er élément: " + tab[0]);
        System.out.println("dernier élément: " + tab[tab.length - 1]);
        System.out.println("autre élément: " + tab[2]);
        System.out.println("affiche un drôle de truc: " + tab);

        afficherTab(tab);
        incrementer(tab);
        afficherTab(tab);
        multiplier(tab, 2);
        afficherTab(tab);

        int[] tab2 = new int[10];
        afficherTab(tab2);
    }
}
