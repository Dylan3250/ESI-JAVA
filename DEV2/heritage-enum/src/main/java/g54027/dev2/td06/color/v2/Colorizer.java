package g54027.dev2.td06.color.v2;

public class Colorizer {

    public static void main(String[] args) {
        // EXO 1.2
        // System.out.println(Color.RED.color("RED"));

        // EXO 1.3
        for (Color colorEnum : Color.values()) {
            System.out.println(colorEnum.color("Couleur : " + colorEnum.name()));
        }
    }
}
