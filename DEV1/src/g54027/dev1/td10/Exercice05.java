package g54027.dev1.td10;

public class Exercice05 {

    public static int nbOccurences(char lettre, String texte) {
        int countNb = 0;

        for (int i = 0; i < texte.length(); i++) {
            if (texte.charAt(i) == lettre) {
                countNb++;
            }
        }

        return countNb;
    }

    public static void main(String[] args) {
        System.out.println(nbOccurences('a', "aaaaa"));
        System.out.println(nbOccurences('b', "test"));
        System.out.println(nbOccurences('t', "test"));
    }
}
