package g54027.dev1.td10;

public class Exercice01 {

    public static int max(int nb1, int nb2) {
        int maxValue = nb1;

        if (nb1 < nb2) {
            maxValue = nb2;
        }

        return maxValue;
    }
    
    public static void main(String[] args) {
        System.out.println("Le maximum entre -1 et -10 est : " + max(-1, -10));
    }
}
