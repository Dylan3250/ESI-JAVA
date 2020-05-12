package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice06 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre :");
        int nb = clavier.nextInt();

        System.out.println("Unités = " + (nb % 10) + "\n");
        System.out.println("Dizaines = " + ((nb / 10) % 10) + "\n");
        System.out.println("Centaines = " + ((nb / 100) % 10) + "\n");
    }
    
}
