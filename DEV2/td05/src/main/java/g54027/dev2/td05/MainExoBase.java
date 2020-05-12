package g54027.dev2.td05;

public class MainExoBase {

    public static void main(String[] args) {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {1, 2, 3},
            {3, 3},
            {0, 1, 3}
        };

        tableau2D.afficher(tab);
        System.out.println(tableau2D.proportionNuls(tab));
        System.out.println(tableau2D.isProportionPositif(tab));
    }
}
