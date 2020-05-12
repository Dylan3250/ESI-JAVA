package g54027.dev1.td10;

public class Exercice02 {

    public static int somme(int nb) {
        if (nb <= 0) {
            throw new IllegalArgumentException("Veuillez rentrer un nombre"
                    + " supérieur à zéro");
        }

        int valueSomme = 0;

        for (int i = 1; i <= nb; i++) {
            valueSomme += i;
        }

        return valueSomme;
    }

    public static void main(String[] args) {
        System.out.println(somme(3));
    }
}
