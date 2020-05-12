package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice06 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre mot : ");
        String word = keyboard.nextLine();

        for (int i = word.length() - 1; i >= 0; i--) {
            char voyelle = word.charAt(i);
            char minVoyelle = Character.toLowerCase(voyelle);

            if (minVoyelle == 'a'
                    || minVoyelle == 'e'
                    || minVoyelle == 'i'
                    || minVoyelle == 'o'
                    || minVoyelle == 'u'
                    || minVoyelle == 'y') {
                System.out.print(minVoyelle);
            }
        }
        System.out.println("");
    }

}
