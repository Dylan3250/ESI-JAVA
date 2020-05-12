package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice07 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        String texte1 = "Bonjour";
        String texte2 = "Bonjour";
        String texte3 = "Bon";
        String texte4 = "jour";
        String texte5 = texte3 + texte4;
        String texte6 = clavier.nextLine(); // Entrez "Bonjour" pour l’expérience

        System.out.println(texte1 + " == " + texte2 + " ? " + (texte1 == texte2)); // true
        // La variable passe a faux sans les parenthèses
        System.out.println(texte1 + " == " + texte5 + " ? " + (texte1 == texte5)); // false
        System.out.println(texte1 + " == " + texte6 + " ? " + (texte1 == texte6)); // false
        System.out.println(texte1 + " equals " + texte2 + " ? " + texte1.equals(texte2)); // true
        System.out.println(texte1 + " equals " + texte5 + " ? " + texte1.equals(texte5)); // true
        System.out.println(texte1 + " equals " + texte6 + " ? " + texte1.equals(texte6)); // true
    }
}
