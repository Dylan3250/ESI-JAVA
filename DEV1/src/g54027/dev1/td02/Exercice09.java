package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice09 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre de secondes :");
        int nbSec = clavier.nextInt();
        System.out.println("Veuillez entrer un nombre de minutes :");
        int nbMin = clavier.nextInt();
        System.out.println("Veuillez entrer un nombre d'heures :");
        int nbHeure = clavier.nextInt();
        
        int nbHeureToSec = nbHeure * 3600;
        int nbMinToSec = nbMin * 60;

        System.out.println(nbHeure + " heures, " + nbMin + " minutes & " + nbSec + " secondes donne " + (nbHeureToSec + nbMinToSec + nbSec) + " secondes !");
    }
    
}
