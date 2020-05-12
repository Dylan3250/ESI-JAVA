package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice09 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer une phrase : ");
        String sentence = keyboard.nextLine();

        char firstLetter = sentence.charAt(0);
        char lastLetter = sentence.charAt(sentence.length() - 1);

        if (Character.isUpperCase(firstLetter) && lastLetter == '.') {
            System.out.println("C'est bien une phrase : " + sentence);
        }
    }

}
