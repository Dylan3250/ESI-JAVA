package g54027.dev1.java;

import java.util.Random;

public class CardSort {

    public static String getNumberCard() {
        Random random = new Random();
        int cardNumber = 1 + random.nextInt(13);
        String cardChoose = "";

        switch (cardNumber) {
            case 1:
                cardChoose = "As";
                break;
            case 11:
                cardChoose = "Valet";
                break;
            case 12:
                cardChoose = "Dame";
                break;
            case 13:
                cardChoose = "Roi";
                break;
            default:
                cardChoose += cardNumber;
        }
        return cardChoose;
    }

    public static String getColorCard() {
        Random random = new Random();
        int cardColor = 1 + random.nextInt(4);
        String cardChoose = "";

        switch (cardColor) {
            case 1:
                cardChoose = "coeur";
                break;
            case 2:
                cardChoose = "pique";
                break;
            case 3:
                cardChoose = "carreaux";
                break;
            case 4:
                cardChoose = "trèfle";
                break;
        }
        return cardChoose;
    }

    public static void main(String[] args) {
        System.out.println("Vous avez pioché un(e) " + getNumberCard()
                + " de " + getColorCard() + " !");
    }
}
