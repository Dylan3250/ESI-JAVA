package g54027.dev1.java;

import java.util.Scanner;

public class FindStringInString {

    public static String translateBoolean(boolean value) {
        String str = "Non";
        if (value) {
            str = "Oui";
        }
        return str;
    }

    public static boolean contains(String s1, String s2) {
        int indice_s1 = 0;
        boolean isGlobalContained = false;

        while (s1.length() - indice_s1 >= s2.length() && !isGlobalContained) {

            if (s1.charAt(indice_s1) == s2.charAt(0)) {
                int indice_s2 = 0;
                boolean isStringContained = true;

                while (s2.length() > indice_s2 && isStringContained) {
                    if (s1.charAt(indice_s1 + indice_s2) != s2.charAt(indice_s2)) {
                        isStringContained = false;
                    }
                    indice_s2++;
                }

                if (isStringContained) {
                    isGlobalContained = true;
                }
            }

            indice_s1++;
        }

        return isGlobalContained;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Veuillez indiquer une chaîne principale : ");
        String globalString = keyboard.nextLine();
        System.out.print("Veuillez indiquer un mot à rechercher dans la "
                + "précédente chaîne : ");
        String searchString = keyboard.nextLine();

        System.out.println("Est-ce que la chaîne \"" + globalString
                + "\" contient \"" + searchString + "\" ? : "
                + translateBoolean(contains(globalString, searchString)));
    }

}