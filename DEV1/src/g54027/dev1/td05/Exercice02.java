package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice02 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre mot : ");
        String word = keyboard.nextLine();

        char voyelle = word.charAt(0);
        char minVoyelle = Character.toLowerCase(voyelle);
        boolean isVoyelle = false;

        /* Un peu plus long :
        switch (minVoyelle) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                isVoyelle = true;
                break;
        }
         */
        if (minVoyelle == 'a'
                || minVoyelle == 'e'
                || minVoyelle == 'i'
                || minVoyelle == 'o'
                || minVoyelle == 'u'
                || minVoyelle == 'y') {
            isVoyelle = true;
        }

        if (isVoyelle) {
            System.out.println("La première lettre est une voyelle !");
        } else {
            System.out.println("La première lettre n'est pas une voyelle !");
        }

    }

}
