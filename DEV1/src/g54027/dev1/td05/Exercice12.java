package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice12 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer une mot afin de voir si c'est un palindrome ou non ainsi que ses consonnes et voyelles : ");
        String word = keyboard.nextLine();
        int worldLength = word.length();
        String reverseWord = "";
        String isPalindrome = "n'est pas un palindrome";
        int consonne = 0;
        int voyelle = 0;

        while (worldLength > 0) {
            char charSelected = word.charAt(worldLength - 1);
            char minChar = Character.toLowerCase(charSelected);

            if (minChar == 'a'
                    || minChar == 'e'
                    || minChar == 'i'
                    || minChar == 'o'
                    || minChar == 'u'
                    || minChar == 'y') {
                voyelle++;
            } else {
                consonne++;
            }

            reverseWord += charSelected;
            worldLength--;
        }

        if (isPalindrome.equals(reverseWord)) {
            isPalindrome = "est un palindrome";
        }

        System.out.println("Il y a un total de " + consonne + " consonne(s) et " + voyelle
                + " voyelle(s) dans le mot " + word + " qui à l'envers donne "
                + reverseWord + " qui " + isPalindrome + ".");
    }

}
