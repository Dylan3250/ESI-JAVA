package g54027.dev1.td04;

import java.util.Scanner;

public class Exercice02 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre de tiret :");
        int nb = clavier.nextInt();
        int i = 1;

        while (i <= nb) {
            System.out.print("-");
            i++;
        }
        System.out.println();
    }

}
