package g54027.dev1.td06;

public class MathUtil {

    public static double perimetreCercle(double rayon) {
        return 2 * Math.PI * rayon;
    }

    public static double aireCercle(double rayon) {
        return Math.PI * Math.pow(rayon, 2);
    }

    public static int min2(int nb1, int nb2) {
        int min = nb1;
        if (nb2 < nb1) {
            min = nb2;
        }
        return min;
    }

    public static int min3(int nb1, int nb2, int nb3) {
        return min2(min2(nb1, nb2), nb3);
    }

    public static double moyenne(double nb1, double nb2) {
        return (nb1 + nb2) / 2;
    }

    public static int abs(int number) {
        if (number < 0) {
            number = -number;
        }
        return number;
    }

    public static boolean estDivisible(int nb1, int nb2) {
        return nb1 % nb2 == 0;
    }

    public static int unite(int number) {
        return number % 10;
    }

    public static int dizaine(int number) {
        return (number / 10) % 10;
    }

    public static int centaine(int number) {
        return (number / 100) % 10;
    }

    public static int reverse(int number) {
        int reverseNumber = 0;

        if (number <= 999 && number >= 100) {
            reverseNumber = unite(number) * 100
                    + dizaine(number) * 10
                    + centaine(number);
        }
        return reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println("Le périmètre d'un cercle de rayon 3 est de "
                + perimetreCercle(3));

        System.out.println("L'air d'un cercle de rayon 6 est de "
                + aireCercle(6));

        System.out.println("Le minimum de 10 et 6 est : " + min2(10, 6));

        System.out.println("Le minimum de 10, 1 et 19 est : "
                + min3(10, 1, 19));

        System.out.println("La moyenne de 10.5 et 15.5 est : "
                + moyenne(10.5, 15.5));

        System.out.println("Affiche true si 10 est divisible par 2 : "
                + estDivisible(10, 2));

        System.out.println("La valeur absolue de 9 est : " + abs(9)
                + " et de -9 : " + abs(-9));

        System.out.println("Avec le nombre 312 :\nSes unités sont : \t"
                + unite(312) + "\nSes dizaines sont : \t" + dizaine(312)
                + "\nSes centaines sont : \t" + centaine(312));
        
        System.out.println("Le nombre renversé de 312 est " + reverse(312));
    }

}
