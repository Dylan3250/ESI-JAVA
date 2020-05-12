package g54027.dev1.td06;

import java.util.Scanner;

public class CercleApp {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer un rayon afin de calculer l'aire et le permimètre : ");
        while (!keyboard.hasNextDouble()) {
            System.out.print("Erreur : veuillez rentrer un nombre pour ce rayon : ");
            keyboard.next();
        }
        double rayon = keyboard.nextDouble();

        System.out.println("Le périmètre d'un cercle de rayon " + rayon + " est de " + MathUtil.perimetreCercle(rayon));
        System.out.println("L'air d'un cercle de rayon " + rayon + " est de " + MathUtil.aireCercle(rayon));
    }

}
