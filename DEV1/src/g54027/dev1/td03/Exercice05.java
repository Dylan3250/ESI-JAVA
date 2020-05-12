package g54027.dev1.td03;

import java.util.Scanner;

public class Exercice05 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer le nombre A : ");
        int a = keyboard.nextInt();
        System.out.print("Veuillez entrer le nombre B : ");
        int b = keyboard.nextInt();
        System.out.print("Veuillez entrer le nombre C : ");
        int c = keyboard.nextInt();

        System.out.println(a % 2 == 0);
        System.out.println(a % 2 == 1);
        System.out.println(a % b == 0);
        System.out.println(a < b);
        System.out.println((a <= b) && (a <= c));
        System.out.println((a < b && b < c) || (a > b && b > c));
    }

}
