package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice05 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre A :");
        int a = clavier.nextInt();
        System.out.println("Veuillez entrer un nombre B :");
        int b = clavier.nextInt();

        System.out.println("a+b = " + (a + b) + "\n");
        System.out.println("a-b = " + (a - b) + "\n");
        System.out.println("a*b = " + (a * b) + "\n");
        System.out.println("a/b = " + (a / b) + "\n");
        System.out.println("a%b = " + (a % b) + "\n");
        System.out.println("a*a+b*b = " + (a * a + b * b) + "\n");
    }
    
}
