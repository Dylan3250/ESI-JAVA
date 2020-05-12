package g54027.dev2.td05;

public class MainApp {

    public static void main(String[] args) {
        MagicSquare ms = new MagicSquare(3);
        ms.displayMagicSquare();
        System.out.println(ms.sumDiag(1));
        System.out.println(ms.sumColumn(2));
        System.out.println(ms.sumDiag(2));
        System.out.println(ms.isMagicSquare());
    }
}