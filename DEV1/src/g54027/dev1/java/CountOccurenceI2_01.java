package g54027.dev1.java;

public class CountOccurenceI2_01 {

    public static void presentation(String titre, String nomPrenom, String matEtGrpe) {
        System.out.println(titre);
        System.out.println(nomPrenom + " - " + matEtGrpe);
    }

    public static int aleatoire(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("Les valeurs maximales et"
                    + "minimales aléatoires doivent être supérieur à zéro");
        }

        if (min >= max) {
            throw new IllegalArgumentException("La valeur maximale doit être plus"
                    + "grande que la valeur minimal pour le choix aléatoire.");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static boolean estVoyelle(char character) {
        boolean estVoyelle = false;

        if (character == 'a'
                || character == 'e'
                || character == 'i'
                || character == 'o'
                || character == 'u'
                || character == 'y') {
            estVoyelle = true;
        }
        return estVoyelle;
    }

    public static boolean estConsonne(char character) {
        return !estVoyelle(character);
    }

    public static String choisirNbVoyelles(String maChaine, int nbVoyelles) {
        int i = 0;
        String totalVoyelles = "";

        while (i < nbVoyelles) {
            int choixAleatoire = aleatoire(0, maChaine.length() - 1);

            if (estVoyelle(maChaine.charAt(choixAleatoire))) {
                totalVoyelles += maChaine.charAt(choixAleatoire);
                i++;
            }
        }
        return totalVoyelles;
    }

    /**
     * Donne le nombre de fois qu'une voyelle choisie est apparu aléatoirement
     * sur base d'une chaîne entrée en paramètre.
     *
     * @param maChaine Où la selection des voyelles doit être effectué
     * @param nbVoyelles Quantité de voyelle à aléatoirement récupérer
     * @param maVoyelle Lettre à compter dans la chaîne de voyelle
     * @return nombre d'occurence de la voyelle choisie dans la chaîne aléatoire
     */
    public static int nombreDeVoyValides(String maChaine, int nbVoyelles, char maVoyelle) {
        String totalVoyelles = choisirNbVoyelles(maChaine, nbVoyelles);
        int countMaVoyelle = 0;

        for (int i = 0; i < totalVoyelles.length(); i++) {
            if (totalVoyelles.charAt(i) == maVoyelle) {
                countMaVoyelle++;
            }
        }
        return countMaVoyelle;
    }

    public static void main(String[] args) {
        presentation("DEV1-JAVAL : Interrogation2", "Bricar Dylan", "G54027 - A31");
        String chaine = "Voici le programme de notre futur cours de langage Python :";
        int nb_de_i_choisis = nombreDeVoyValides(chaine, 10, 'i');
        System.out.println("Parmi les 10 voyelles sélectionnées au hasard dans la chaine,");
        System.out.println("Le nombre de i choisi est = " + nb_de_i_choisis);
    }

}
