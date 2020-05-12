package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice04 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre mot : ");
        String word = keyboard.nextLine();

        char firstCharacter = word.charAt(0);
        char lastCharacter = word.charAt(word.length() - 1);

        if (Character.toLowerCase(firstCharacter) == Character.toLowerCase(lastCharacter)) {
            System.out.println("La première lettre et la dernière sont identiques : " + firstCharacter + " !");
        } else {
            System.out.println("La première lettre et la dernière ne sont pas identiques : " + firstCharacter + " & " + lastCharacter + " !");
        }
    }

}
