package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice08 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer le texte souhaité : ");
        String texte = keyboard.nextLine();

        if (texte.equals("OK ESI")) {
            // Les accents affichent un false (probablement qu'il faut spécifier l'encodage)
            System.out.println("Je vous écoute !");
        } else {
            System.out.println("Je n'ai pas compris !");
        }
    }

}
