package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice11 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer un prix unitaire HT : ");
        double priceHT = keyboard.nextDouble();
        System.out.print("Veuillez indiquer le taux de TVA : ");
        double pourcent = keyboard.nextDouble();
        System.out.print("Veuillez indiquer la quantité de produit : ");
        int quantity = keyboard.nextInt();

        System.out.println(priceHT * ((pourcent / 100) + 1) * quantity);
    }

}
