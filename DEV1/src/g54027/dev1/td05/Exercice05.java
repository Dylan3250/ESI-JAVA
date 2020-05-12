package g54027.dev1.td05;

import java.util.Scanner;

public class Exercice05 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer votre mot : ");
        String word = keyboard.nextLine();

        System.out.print("Le mot " + word + " devient ");
        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
        System.out.println("");
    }

}
