package g54027.dev1.td10;

public class MonMath {

    public static double abs(double nombre) {
        double solution = nombre;

        if (nombre < 0) {
            solution = -nombre;
        }
        return solution;
    }

    public static double perimetre(double rayon) {
        if (rayon < 0) {
            throw new IllegalArgumentException("Vous devez rentrer une valeur"
                    + " positive comme rayon : " + rayon);
        }
        return 2 * Math.PI * rayon;
    }

    public static void main(String[] args) {
        System.out.println(abs(4));
        System.out.println(perimetre(0));
    }
}
