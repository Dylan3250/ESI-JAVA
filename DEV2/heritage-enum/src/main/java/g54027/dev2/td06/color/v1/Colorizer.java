package g54027.dev2.td06.color.v1;

public class Colorizer {

    public static String color(Color color, String text) {
        String choosedColor = "";

        switch (color) {
            case RED:
                choosedColor = "\033[31m";
                break;
            case GREEN:
                choosedColor = "\033[32m";
                break;
            case BLUE:
                choosedColor = "\033[34m";
                break;
        }

        return choosedColor + text + "\033[m";
    }

    public static void main(String[] args) {
        System.out.println(color(Color.GREEN, "Salut les amis"));
    }
}
