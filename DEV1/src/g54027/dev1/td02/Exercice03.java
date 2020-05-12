package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice03 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer la longeur des côtés du carré :");
        double mesure = clavier.nextDouble();
        
        System.out.println("L'air du carré est de " + (mesure * mesure) + "cm^2 !");
    }

}
