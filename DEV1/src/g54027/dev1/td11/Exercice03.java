package g54027.dev1.td11;

public class Exercice03 {

    public static void afficheTableau(String[] mots) {
        if (mots == null || mots.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide ou null.");
        }

        for (String mot : mots) {
            System.out.print(mot + " ");
        }
        System.out.println("");
    }

    public static void afficherTailles(String[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide ou null.");
        }

        for (String value : tab) {
            System.out.print(value.length() + " ");
        }
        System.out.println("");
    }

    public static String plusLongMot(String[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide ou null.");
        }

        String plugLong = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (plugLong.length() < tab[i].length()) {
                plugLong = tab[i];
            }
        }
        return plugLong;
    }

    public static void main(String[] args) {
        String[] mots = {"the", "quick", "brown", "fox", "jumps", "over", "the",
            "lazy", "dog"};

        String[] test = new String[10];
        afficheTableau(test);

        for (String mot : mots) { // pour chaque mot dans le tableau ’mots’
            System.out.print(mot + " "); // affiche le mot suivi d’un espace.
        }
        System.out.println("");

        afficherTailles(mots);
        afficheTableau(mots); // la même chose mais dans une méthode.
        afficherTailles(mots);
        System.out.println(plusLongMot(mots));
    }
}
