package g54027.dev2.td05;

public class Tableau2D {

    /**
     * Defines how to show the array : line by line
     *
     * @param tab the given 2D array of integers
     */
    public static void afficher(int[][] tab) {
        for (int[] lg : tab) {
            for (int col : lg) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    /**
     * Gives the ratio of zero in the array
     *
     * @param tab the given 2D array of integers
     * @return number of zero in the given array
     */
    public static int proportionNuls(int[][] tab) {
        int countNuls = 0;

        for (int[] lg : tab) {
            for (int col : lg) {
                if (col == 0) {
                    countNuls++;
                }
            }
        }

        return countNuls;
    }

    /**
     * Says if the array contains only positive numbers
     *
     * @param tab the given 2D array of integers
     * @return true if there are only positive numbers, false otherwise
     */
    public static boolean isProportionPositif(int[][] tab) {
        boolean isPositif = true;
        int lg = 0;

        while (isPositif && lg < tab.length) {
            int col = 0;

            while (isPositif && col < tab[lg].length) {
                if (tab[lg][col] <= 0) {
                    isPositif = false;
                }
                col++;
            }
            lg++;
        }

        return isPositif;
    }

    /**
     * Switchs two lines in a given array
     *
     * @param tab the gieven array
     * @param line1 the first index to switch
     * @param line2 the second index to switch
     */
    public static void switchLine(int[][] tab, int line1, int line2) {
        int[][] saveTab = new int[1][];
        saveTab[0] = tab[line1];
        tab[line1] = tab[line2];
        tab[line2] = saveTab[0];
    }

    /**
     * Gives the trangle of Pascal [not rectangular]
     *
     * @param n the number of lines
     * @return array with triangle of Pascal
     */
    public static int[][] trianglePascal(int n) {
        int[][] pascal = new int[n][];
        pascal[0] = new int[1];
        pascal[0][0] = 1;

        for (int lg = 1; lg < n; lg++) {
            pascal[lg] = new int[pascal[lg - 1].length + 1];

            for (int col = 0; col <= lg; col++) {
                if (col == 0 || col == lg) {
                    pascal[lg][col] = 1;
                } else {
                    pascal[lg][col] = pascal[lg - 1][col - 1] + pascal[lg - 1][col];
                }
            }
        }

        return pascal;
    }
}
