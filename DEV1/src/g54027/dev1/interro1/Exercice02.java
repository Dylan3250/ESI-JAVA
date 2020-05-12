package g54027.dev1.interro1;

import java.util.Scanner;

/**
 *
 * @author g54027
 */
public class Exercice02 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez indiquer un premier nombre : ");
        int nb1 = keyboard.nextInt();
        System.out.print("Veuillez indiquer un deuxième nombre : ");
        int nb2 = keyboard.nextInt();
        System.out.print("Veuillez indiquer un troisième nombre : ");
        int nb3 = keyboard.nextInt();

        if (nb1 != nb2 && nb2 != nb3) {
            if (nb1 > nb2 && nb1 > nb3) {
                System.out.println("Le nombre 2 (" + nb2 + ") et le nombre 3 "
                        + "(" + nb3 + ") sont plus petit que le nombre 1 : " + nb1);
            } else if (nb2 > nb3) {
                System.out.println("Le nombre 1 (" + nb1 + ") et le nombre 3 "
                        + "(" + nb3 + ") sont plus petit que le nombre 2 : " + nb2);
            } else if (nb3 > nb2) {
                System.out.println("Le nombre 1 (" + nb1 + ") et le nombre 2 "
                        + "(" + nb2 + ") sont plus petit que le nombre 3 : " + nb3);
            }
        } else {
            System.err.println("Au moins deux des nombres sont identiques,"
                    + " il ne peut donc pas y avoir deux nombes plus petit que "
                    + "le troisième!");
        }
    }

}
