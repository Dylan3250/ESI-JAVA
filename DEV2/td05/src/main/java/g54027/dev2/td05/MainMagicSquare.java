package g54027.dev2.td05;

public class MainMagicSquare {

    public static void main(String[] args) {
        for (int i = 3; i <= 15; i += 2) {
            MagicSquare ms = new MagicSquare(i);
            System.out.println(ms.isMagicSquare());
            ms.displayMagicSquare();
            System.out.println();
        }
    }
}
