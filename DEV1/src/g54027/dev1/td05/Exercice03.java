package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice03 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre mot : ");
        String word = keyboard.nextLine();

        char consonne = word.charAt(0);
        char minConsonne = Character.toLowerCase(consonne);
        
        if (minConsonne != 'a'
                && minConsonne != 'e'
                && minConsonne != 'i'
                && minConsonne != 'o'
                && minConsonne != 'u'
                && minConsonne != 'y') {
            System.out.println("La première lettre est une consonne !");
        } else {
            System.out.println("La première lettre n'est pas une consonne !");
        }
    }

}
