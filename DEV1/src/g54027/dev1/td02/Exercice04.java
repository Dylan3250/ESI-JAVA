package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice04 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer le rayon de votre cercle :");
        double rayon = clavier.nextDouble();

        System.out.println("Le périmètre du cercle est de " + (2 * Math.PI * rayon) + "cm !");
        System.out.println("L'air du cercle est de " + (Math.PI * Math.sqrt(rayon)) + "cm^2 !");
    }
    
}
