package g54027.dev1.java;

import java.util.Scanner;

public class ElapsedTime {

    /**
     * Transform hours, minutes and seconds to seconds
     *
     * @param hour hours to add in seconds
     * @param minute minutes to add in seconds
     * @param second seconds to add in seconds
     * @return the sum of second
     */
    public static int toSeconds(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }

    /**
     * Get hours, minutes and seconds to a human readable format
     *
     * @param seconds seconds to convert
     * @return string with humain readable format
     */
    public static String toFormated(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds / 60) % 60;
        int second = seconds % 60;

        return hour + " heure(s) " + minute + " minute(s) et " + second + " seconde(s)";
    }

    /**
     * Get the gap between two times
     *
     * @param time1 First time in seconds converted
     * @param time2 Second time in seconds converted
     * @return elapsed between the both time
     */
    public static int getElapsedTime(int time1, int time2) {
        return Math.abs(time1 - time2);
    }

    /**
     * Request hour, minute and second in non-negative integer from a user
     *
     * @param message message to show at user when he have to give a number
     * @return
     */
    public static int getDate(String message) {
        Scanner keyboard = new Scanner(System.in);
        // Value by default to check if user give not an number < 0
        int valueScanner = -1;

        do {
            System.out.print(message);
            // Use if user don't give a number
            while (!keyboard.hasNextInt()) {
                System.out.print("Erreur : veuillez entrer un nombre entier positif : ");
                keyboard.nextLine();
            }
            valueScanner = keyboard.nextInt();
        } while (valueScanner < 0);

        return valueScanner;
    }

    public static void main(String[] args) {
        // Define variables to get hours, minutes and secondes
        int h1 = getDate("Veuillez entrer une première heure entière positive : ");
        int m1 = getDate("Veuillez entrer des premières minutes entières positives : ");
        int s1 = getDate("Veuillez entrer des premières secondes entières positives : ");

        int h2 = getDate("Veuillez entrer une deuxième heure entière positive : ");
        int m2 = getDate("Veuillez entrer des deuxièmes minutes entières positives : ");
        int s2 = getDate("Veuillez entrer des deuxièmes secondes entières positives : ");

        // Calculate the elapsed time between the two times
        int elapsedTime = getElapsedTime(toSeconds(h1, m1, s1), toSeconds(h2, m2, s2));

        System.out.println("Il y a un écart de " + toFormated(elapsedTime)
                + " entre " + toFormated(toSeconds(h1, m1, s1)) + " et "
                + toFormated(toSeconds(h2, m2, s2)) + " !");
    }

}
