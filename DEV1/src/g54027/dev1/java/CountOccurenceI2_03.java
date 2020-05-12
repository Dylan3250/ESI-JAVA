package g54027.dev1.java;

import java.util.Scanner;

public class CountOccurenceI2_03 {

    public static void presentezVous(String titre, String groupe,
            String identifiant, String nom, String prenom) {
        System.out.println("- " + titre);
        System.out.println("- " + groupe);
        System.out.println("- " + identifiant);
        System.out.println("- " + nom);
        System.out.println("- " + prenom);
    }

    public static String defFigure(String figure) {
        String definition = "Parallélogramme avec les proprétés du rectangle"
                + "et du losange";

        switch (figure) {
            case "quadrilatère":
                definition = "4 cotés";
                break;
            case "parallélogramme":
                definition = "Quadrilatère atant des côtés parallèles 2 à 2";
                break;
            case "rectangle":
                definition = "Parallélogramme ayant des angles droits";
                break;
            case "losange":
                definition = "Parallélogramme ayant 4 côtés égaux";
                break;
            case "carré":
                break;
            default:
                throw new IllegalArgumentException("Le nom de la figure"
                        + " n'est pas connu.");
        }
        return definition;
    }

    public static int countOccurence(String originalWord) {
        int maxOccurence = 0;
        String word = originalWord.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            int countChar = 0;

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    countChar++;
                }

            }

            if (countChar > maxOccurence) {
                maxOccurence = countChar;
            }

        }
        return maxOccurence;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word;
        int totalWords = 0;
        int maxOccurence = 0;
        
        presentezVous("Interrogation 2, en date du 21 novembre 2019",
                "groupe A112", "G54027", "Bricar", "Dylan");

        /*
        System.out.print("Veuillez indiquer le nom d'une figure : ");
        String figure = keyboard.nextLine();
        System.out.println(defFigure(figure));
         */

        do {
            System.out.print("Veuillez indiquer un mot : ");
            word = keyboard.nextLine();
            if (!word.equals("S")) {
                System.out.println("La plus grande occurence de " + word
                        + " est " + countOccurence(word) + " !");

                totalWords++;
                if (maxOccurence < countOccurence(word)) {
                    maxOccurence = countOccurence(word);
                }
            }
        } while (!word.equals("S"));

        System.out.println("Le total de mot entré est de " + totalWords
                + " et la plus grande occurence est de " + maxOccurence);
    }
}
