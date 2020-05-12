package g54027.dev1.interro1;

import java.util.Scanner;

/**
 *
 * @author g54027
 */
public class Exercice01 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer un premier nombre (A) : ");
        int a = keyboard.nextInt();
        System.out.print("Veuillez indiquer un deuxième nombre (B) : ");
        int b = keyboard.nextInt();
        System.out.print("Veuillez indiquer un troisième nombre (C) [1 - 4] : ");
        int c = keyboard.nextInt();

        if (c == 1) {
            System.out.println("[A + B] : " + a + " + " + b + " = " + (a + b));
        } else if (c == 2) {
            System.out.println("[A - B] : " + a + " - " + b + " = " + (a - b));
        } else if (c == 3) {
            System.out.println("[A * B] : " + a + " * " + b + " = " + (a * b));
        } else if (c == 4) {
            if (b != 0) {
                System.out.println("[A + B] : " + a + " / " + b + " = " + (a / b));
            } else {
                System.err.println("Erreur : on ne peut pas diviser par 0 !");
            }
        }
    }
    
}
