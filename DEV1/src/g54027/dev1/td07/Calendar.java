package g54027.dev1.td07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calendar {

    private static final String HEADERBORDER = "=========================================";

    /**
     * List with each month of the year
     *
     * @param nbMonth number of the month
     * @return name of the month (-1 because it is an array)
     */
    public static String getNameMonth(int nbMonth) {
        String[] month = new String[]{"Janvier", "Février", "Mars", "Avril",
            "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre",
            "Novembre", "Décembre"};
        return month[nbMonth - 1];
    }

    /**
     * Show header with a lot of " = " and title of the month
     *
     * @param nbMonth number of the month desired
     * @param year year of the calendar desired
     */
    public static void showHeaderTitle(int nbMonth, int year) {
        if (nbMonth <= 0 || nbMonth > 12) {
            throw new IllegalArgumentException("Le nombre de mois doit être"
                    + "compris entre 1 et 12");
        }

        String title = getNameMonth(nbMonth) + " " + year;
        int spaceBeforeTitle = (HEADERBORDER.length() - title.length()) / 2;
        String lineWithTitle = "";

        for (int i = 0; i < spaceBeforeTitle; i++) {
            lineWithTitle += " ";
        }
        lineWithTitle += title;

        System.out.println(HEADERBORDER + "\n" + lineWithTitle
                + "\n" + HEADERBORDER);
    }

    /**
     * Show calendar header with each day
     */
    public static void showHeaderDays() {
        String[] TabHeaderCenter = new String[]{"Lu", "Ma", "Me", "Je", "Ve",
            "Sa", "Di"};
        String headerCenter = "";
        int spaceBorder = (HEADERBORDER.length() / 7) - 1;

        for (int i = 0; i < TabHeaderCenter.length; i++) {
            headerCenter += TabHeaderCenter[i];

            if (TabHeaderCenter.length != i + 1) {
                for (int j = 0; j < spaceBorder; j++) {
                    headerCenter += " ";
                }
            }
        }
        System.out.println(headerCenter);
    }

    /**
     * Show each day of the month
     *
     * @param decalage days empty before starting the first day
     * @param maxDays days of the mouth desired
     */
    public static void showMonth(int decalage, int maxDays) {
        if (decalage < 0 || decalage > 6) {
            throw new IllegalArgumentException("Le décalage doit être compris"
                    + " entre 0 et 6");
        }

        if (maxDays < 0 || maxDays > 31) {
            throw new IllegalArgumentException("Le nombre de jour doit être"
                    + " compris entre 1 et 31");
        }

        DecimalFormat formatZero = new DecimalFormat("00");

        String decalageSpace = "";
        int spaceBorder = (HEADERBORDER.length() / 7) - 1;

        for (int i = 0; i < decalage; i++) {
            for (int j = 0; j <= spaceBorder + 1; j++) {
                decalageSpace += " ";
            }
        }

        String spaceBetweenDays = "";
        for (int j = 0; j < spaceBorder; j++) {
            spaceBetweenDays += " ";
        }

        System.out.print(decalageSpace);
        int currentDay = 1;

        while (currentDay <= maxDays) {
            decalageSpace = formatZero.format(currentDay);
            System.out.print(decalageSpace);

            System.out.print(spaceBetweenDays);
            if ((currentDay + decalage) % 7 == 0) {
                System.out.println("");
            }

            currentDay++;
        }

        System.out.println("\n" + HEADERBORDER);
    }

    /**
     * Check if the year is a leap year
     *
     * @param year year to check for the calendar
     * @return true if the year is a leap year
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Define how many days have the month desired
     *
     * @param month number of the month
     * @param year number with the year
     * @return the number of days in the month
     */
    public static int maxDays(int month, int year) {
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("Le mois doit être compris"
                    + " entre 1 et 12");
        }

        int numberDayDefault = 31;
        if (month == 4
                || month == 6
                || month == 9
                || month == 11) {
            numberDayDefault = 30;
        } else if (month == 2) {
            numberDayDefault = 28;
            if (isLeapYear(year)) {
                numberDayDefault = 29;
            }
        }
        return numberDayDefault;
    }

    /**
     * Define what is the first day of the month
     *
     * @param jour days number of the month desired
     * @param month month of the calendar desired
     * @param year years of the month desired
     * @return define spaces before first day
     */
    public static int dayNumber(int jour, int month, int year) {
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("Le mois doit être compris"
                    + " entre 1 et 12");
        }

        if (jour < 0 || maxDays(month, year) > 31) {
            throw new IllegalArgumentException("Le nombre de jour doit être"
                    + " compris entre 1 et 31");
        }

        return (jour + (((month + 1) * 13) / 5) + year % 100 + ((year % 100) / 4)
                + ((year / 100) / 4) + 5 * (year / 100) + 5) % 7;
    }

    /**
     * Generate calendar with imports
     *
     * @param month number of the month desired
     * @param year number of the year desired
     */
    public static void generateCalendar(int month, int year) {
        showHeaderTitle(month, year);
        showHeaderDays();
        showMonth(dayNumber(1, month, year), maxDays(month, year));
    }

    /**
     * Get informations to make calendar like month and year desired
     */
    public static void makeCalendar() {
        Scanner keyboard = new Scanner(System.in);

        String getDate = "";
        do {
            System.out.print("Veuillez indiquer une date au format MM AAAA : ");
            getDate = keyboard.nextLine();
        } while (!getDate.matches("^[0-9]{2} [0-9]{4}$"));

        String[] resultDate = getDate.split(" ");

        int month = Integer.parseInt(resultDate[0]);
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("Le mois doit être compris"
                    + " entre 1 et 12");
        }

        int year = Integer.parseInt(resultDate[1]);
        generateCalendar(month, year);
    }

    /**
     * Run the program to make the calendar
     *
     * @param args nothing necessary send by command
     */
    public static void main(String[] args) {
        makeCalendar();
    }

}
