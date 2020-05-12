package g54027.dev1.td06;

public class ChaineUtil {

    public static char premiereLettre(String word) {
        return word.charAt(0);
    }

    public static char derniereLettre(String word) {
        return word.charAt(word.length() - 1);
    }

    public static int countVoyelle(String word) {
        int nbVoyelle = 0;

        for (int i = 0; i < word.length(); ++i) {
            if (word.toLowerCase().charAt(i) == 'a'
                    || word.toLowerCase().charAt(i) == 'e'
                    || word.toLowerCase().charAt(i) == 'i'
                    || word.toLowerCase().charAt(i) == 'o'
                    || word.toLowerCase().charAt(i) == 'u'
                    || word.toLowerCase().charAt(i) == 'y') {
                nbVoyelle++;
            }
        }
        // Ou nbVoyelles = test.length() - test.toLowerCase().replaceAll("a|e|i|o|u|y", "").length();
        return nbVoyelle;
    }

    public static int countConsonnes(String word) {
        int nbConsonnes = 0;

        for (int i = 0; i < word.length(); ++i) {
            if (word.toLowerCase().charAt(i) != 'a'
                    && word.toLowerCase().charAt(i) != 'e'
                    && word.toLowerCase().charAt(i) != 'i'
                    && word.toLowerCase().charAt(i) != 'o'
                    && word.toLowerCase().charAt(i) != 'u'
                    && word.toLowerCase().charAt(i) != 'y') {
                nbConsonnes++;
            }
        }
        return nbConsonnes;
    }

    public static boolean isPalindrome(String word) {
        String reversedWord = "";

        for (int i = word.length(); i > 0; i--) {
            reversedWord += word.charAt(i - 1);
        }

        return word.equals(reversedWord);
    }

    public static void main(String[] args) {
        System.out.println("La première lettre de Java est : "
                + premiereLettre("Java"));
        System.out.println("La dernière lettre de Java est : "
                + derniereLettre("Java"));
        System.out.println("Dans le mot \"Programmation\", il y a "
                + countVoyelle("Programmation") + " voyelles et "
                + countConsonnes("Programmation") + " consonnes");
        System.out.println("Le mot \"été\" est-t-il est un palindrome ? : "
                + isPalindrome("été"));
    }

}
