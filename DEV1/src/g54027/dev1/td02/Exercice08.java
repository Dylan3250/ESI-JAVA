package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice08 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre de secondes :");
        int nbSec = clavier.nextInt();
        int nbMin = nbSec / 60;

        System.out.println("Le nombre " + nbSec + " en minute donne " + nbMin + " !");
    }
    
}
