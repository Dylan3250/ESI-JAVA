package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice10 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer une mot afin de calculer les voyelles et consonnes : ");
        String word = keyboard.nextLine();
        int consonne = 0;
        int voyelle = 0;

        for (int i = 0; i < word.length(); i++) {
            char minChar = Character.toLowerCase(word.charAt(i));
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
        }
        System.out.println("Il y a au total :");
        System.out.println("Consonne(s) :\t" + consonne);
        System.out.println("Voyelle(s) :\t" + voyelle);
    }

}
