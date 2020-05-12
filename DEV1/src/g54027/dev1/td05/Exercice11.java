package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice11 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer une mot afin de voir si c'est un palindrome ou non : ");
        String word = keyboard.nextLine();
        String reverseWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverseWord += word.charAt(i);
        }

        if (reverseWord.equals(word)) {
            System.out.println("Le mot " + word + " est bien un palindrome !");
        } else {
            System.out.println("Le mot " + word + " n'est pas un palindrome (" + reverseWord + ") !");
        }
    }

}
