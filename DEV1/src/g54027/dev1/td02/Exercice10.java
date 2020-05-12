package g54027.dev1.td02;

import java.util.Scanner;

public class Exercice10 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer un prix sur lequel afin d'avoir les 2% d'interet : ");
        double price = keyboard.nextDouble();
        double pourcent = 2;

        System.out.println(price * (pourcent / 100));
    }
    
}
