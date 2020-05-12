package g54027.dev1.java;

import java.util.Scanner;

public class CalculMoyenne {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int i = 1;
        double calcul = 0;

        while (i <= 8) {
            System.out.print("Veuillez entrer une note l'interro " + i + " : ");
            double nb = keyboard.nextDouble();
            
            if (i <= 2) {
                calcul += nb * 0.15;
            } else if (i > 2 && i <= 5) {
                calcul += nb * 0.17;
            } else {
                calcul += nb * 0.07;
            }
            
            i++;
        }
        
        
        System.out.println("La moyenne des notes est de " + calcul);
    }
}
