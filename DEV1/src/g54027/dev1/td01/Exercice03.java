package g54027.dev1.td01;

public class Exercice03 {

    public static void main(String[] args) {

        String setStars = "";
        int nbMaxStars = 7;
        int posStarsDepart = nbMaxStars / 2;
        int nbActualStars = 1;

        while (nbActualStars <= nbMaxStars) {

            for (int d = 0; d < posStarsDepart; d++) {
                setStars += " ";
            }

            for (int d = 0; d < nbActualStars; d++) {
                setStars += "*";
            }

            System.out.println(setStars);

            posStarsDepart -= 1;
            nbActualStars += 2;
            setStars = "";
        }

        /*
        System.out.println("   *   ");
        System.out.println("  ***  ");
        System.out.println(" ***** ");
        System.out.println("*******");
        */
    }

}
