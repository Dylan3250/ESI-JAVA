package g54027.dev1.td07;

import java.util.Scanner;

public class Lecture {
    
    private static final Scanner KEYBOARD = new Scanner(System.in);
    
    public static int lireEntier(String mesage) {
        System.out.print(mesage);
        while (!KEYBOARD.hasNextInt()) {
            KEYBOARD.next();
            System.out.print(mesage);
        }
        return KEYBOARD.nextInt();

    }

    public static double lireDouble(String mesage) {
        System.out.print(mesage);
        while (!KEYBOARD.hasNextDouble()) {
            KEYBOARD.next();
            System.out.print(mesage);
        }
        return KEYBOARD.nextDouble();
    }

    public static int lireEntier(String mesage, int min, int max) {
        int entier = 0;
        do {
            entier = lireEntier("Veuillez indiquer un nombre entier : ");
        } while (entier > max || entier < min);
        return entier;
    }

    public static void main(String[] args) {
        // System.out.println(lireEntier("Veuillez indiquer un nombre entier : "));
        // System.out.println(lireEntier("Veuillez indiquer un nombre réel : "));
        System.out.println(lireEntier("Veuillez indiquer un nombre entier : ",
                10, 20));
    }
}
