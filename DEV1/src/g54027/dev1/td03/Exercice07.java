package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice07 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer la première longeur du triangle : ");
        double long1 = keyboard.nextDouble();
        System.out.print("Veuillez entrer la seconde longeur du triangle : ");
        double long2 = keyboard.nextDouble();
        System.out.print("Veuillez entrer le dernière longeur du triangle : ");
        double long3 = keyboard.nextDouble();

        if (long1 == long2 && long2 == long3){
            System.out.println("Le triangle est équilatéral !");
        } else if (long1 == long2 || long2 == long3 || long3 == long1 ){
            System.out.println("Le triangle est isocèle !");
        } else {
            System.out.println("Le triangle est quelconque !");
        }
    }

}
