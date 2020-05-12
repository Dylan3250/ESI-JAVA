package g54027.dev1.java;

import java.util.Scanner;

public class CountOccurenceI2_05 {

    public static boolean verifierBinaire(String mot) {
        boolean isBinary = true;
        int i = 0;

        while (isBinary && mot.length() > i) {
            if (mot.charAt(i) != '0' && mot.charAt(i) != '1') {
                isBinary = false;
            }
            i++;
        }
        return isBinary;
    }

    public static int convertirEnDecimal(String motbin) {
        if (!verifierBinaire(motbin)) {
            throw new IllegalArgumentException("Le mot envoyé n'est pas un"
                    + " mot binaire !");
        }

        int decimal = 0;

        for (int i = motbin.length() - 1; i >= 0; i--) {
            if (motbin.charAt(motbin.length() - 1 - i) == '1') {
                decimal += Math.pow(2, i);
            }
        }
        
        // Ou alors " int decimal = Integer.parseInt(motbin, 2); "
        return decimal;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String binairyValue;
        System.out.println("Veuillez entrer un nombre binaire, ou A pour"
                + " arrêter le programme : ");

        do {
            binairyValue = keyboard.nextLine();

            if (!binairyValue.equals("A")) {
                if (!verifierBinaire(binairyValue)) {
                    System.out.println("Ceci n'est pas un mot binaire ! Veuillez"
                            + " entrer un nombre binaire, ou A pour"
                            + " arrêter le programme : ");
                } else {
                    System.out.println("Le nombre décimal correspond à "
                            + convertirEnDecimal(binairyValue)
                            + " ! Veuillez entrer un nombre binaire,"
                            + " ou A pour arrêter le programme : ");
                }
            } else {
                System.out.println("Au revoir !");
            }
        } while (!binairyValue.equals("A"));
    }
}
