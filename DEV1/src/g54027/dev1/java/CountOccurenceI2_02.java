package g54027.dev1.java;

import java.util.Random;

public class CountOccurenceI2_02 {

    public static boolean isBetween(int n, int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Le nombre maximum doit être plus"
                    + "grand que le nombre minimum.");
        }
        return n < max && n > min;
    }

    public static int countOccurences(String word, char letter) {
        int countLetter = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i))
                    == Character.toLowerCase(letter)) {
                countLetter++;
            }
        }
        return countLetter;
    }

    public static String randomStringRandomSize() {
        Random R = new Random();
        int size = R.nextInt(64);
        int leftLimit = 0x61;
        int rightLimit = 0x7A;

        StringBuilder builder = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            builder.append(
                    (char) (leftLimit + R.nextInt(rightLimit - leftLimit)));

        }
        return builder.toString();
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

    public static void print1000WordInRandomString() {
        for (int i = 0; i < 1000; i++) {
            int countVoyelle = 0;
            String word = randomStringRandomSize();

            if (word.length() >= 15 && word.length() <= 20) {
                for (int j = 0; j < word.length(); j++) {
                    if (estVoyelle(word.charAt(j))) {
                        countVoyelle++;
                    }
                }
                System.out.print(word + "(" + countVoyelle + ") ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isBetween(10, 0, 20));
        print1000WordInRandomString();
    }
}
