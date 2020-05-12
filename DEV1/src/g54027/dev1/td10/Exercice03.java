package g54027.dev1.td10;

public class Exercice03 {

    public static char formatChar(char letter) {

        switch (letter) {
            case 'à':
                letter = 'a';
                break;
            case 'é':
                letter = 'e';
                break;
            case 'è':
                letter = 'è';
                break;
            case 'ç':
                letter = 'c';
                break;
            case 'ê':
                letter = 'e';
                break;
        }

        return letter;
    }

    public static boolean isAnagram(String mot, String candidate) {

        if (mot.length() != candidate.length()) {
            throw new IllegalArgumentException("Un anagramme doit obligatoirement"
                    + " avoir deux mots au nombre de caractère identique.");
        }

        if (mot.length() < 2 || candidate.length() < 2) {
            throw new IllegalArgumentException("Un anagramme doit obligatoirement"
                    + " avoir au moins deux caractères.");
        }

        if (mot.matches("^.*[0-9].*$") || candidate.matches("^.*[0-9].*$")) {
            throw new IllegalArgumentException("Un anagramme ne peut pas contenir"
                    + " de chiffres.");
        }

        int countCharInWord = 0;
        boolean isCharInWordAndCandidate = true;

        do {
            int countCharInCandidate = 0;
            boolean isCharInCandidate = false;

            while (countCharInCandidate < candidate.length() && isCharInCandidate == false) {
                char charInWord = formatChar(Character.
                        toLowerCase(mot.charAt(countCharInWord)));
                char charInCandidate = formatChar(Character.
                        toLowerCase(candidate.charAt(countCharInCandidate)));

                if (charInWord == charInCandidate) {
                    isCharInCandidate = true;
                }
                countCharInCandidate++;
            }

            if (!isCharInCandidate) {
                isCharInWordAndCandidate = false;
            }

            countCharInWord++;
        } while (countCharInWord < mot.length() && isCharInWordAndCandidate);

        return isCharInWordAndCandidate;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("baab", "abab"));
    }
}
