package g54027.dev2.td05;

public class MainExoSup {

    public static void main(String[] args) {
        int[][] tab = {
            {1, 5, 9},
            {2, 6, 10},
            {3, 7, 11}
        };

        Tableau2D.switchLine(tab, 1, 2);
        Tableau2D.afficher(tab);
        
        int[][] triangle = Tableau2D.trianglePascal(10);
        Tableau2D.afficher(triangle);
    }
}