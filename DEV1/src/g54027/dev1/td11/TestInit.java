package g54027.dev1.td11;

public class TestInit {

    public static void main(String[] args) {
        int[] integerTab = new int[10];
        display(integerTab);

        double[] doubleTab = new double[10];
        display(doubleTab);

        boolean[] booleanTab = new boolean[10];
        display(booleanTab);

        String[] stringTab = new String[10];
        display(stringTab);
    }

    public static void display(int[] tab) {
        System.out.print("[");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length - 1] + "]");
    }

    public static void display(double[] tab) {
        System.out.print("[");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length - 1] + "]");
    }

    public static void display(boolean[] tab) {
        System.out.print("[");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length - 1] + "]");
    }

    public static void display(String[] tab) {
        System.out.print("[");
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length - 1] + "]");
    }
}
