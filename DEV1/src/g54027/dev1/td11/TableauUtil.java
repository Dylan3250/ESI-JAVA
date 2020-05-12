package g54027.dev1.td11;

import java.util.Arrays;

public class TableauUtil {

    /**
     * Find the minimal decimal value in array
     *
     * @param tab the given array
     * @return the minimal decimal value in array
     */
    public static double min(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        double min = tab[0];

        for (int i = 1; i < tab.length; i++) {
            if (min > tab[i]) {
                min = tab[i];
            }
        }
        return min;
    }

    /**
     * Find the maximal decimal value in array
     *
     * @param tab the given array
     * @return the maximal decimal value in array
     */
    public static double max(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        double max = tab[0];

        for (int i = 1; i < tab.length; i++) {
            if (max < tab[i]) {
                max = tab[i];
            }
        }
        return max;
    }

    /**
     * Computes the sum between each element of array
     *
     * @param tab the given array
     * @return the sum between each element of array
     */
    public static double sum(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        double sum = tab[0];

        for (int i = 1; i < tab.length; i++) {
            sum += tab[i];
        }
        return sum;
    }

    /**
     * Calculs the average of each element of array
     *
     * @param tab the given array
     * @return average of array
     */
    public static double average(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        return sum(tab) / tab.length;
    }

    /**
     * Makes a copy of the original array
     *
     * @param tab the original given array
     * @return copy of array
     */
    public static double[] copy(double[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau est null");
        }

        double[] copy = new double[tab.length];

        for (int i = 0; i < tab.length; i++) {
            copy[i] = tab[i];
        }

        return copy;
    }

    /**
     * Find the index of the maximal value in array
     *
     * @param tab the given array
     * @return index of the maximal value in array
     */
    public static int maxIndex(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        int i = 0;

        while (tab[i] < max(tab)) {
            i++;
        }

        return i;
    }

    /**
     * Checks if the array is sorted or not
     *
     * @param tab the given array
     * @return true if array is sorted, false otherwise
     */
    public static boolean isSorted(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        int i = 1;

        while (i < tab.length && tab[i - 1] < tab[i]) {
            i++;
        }

        return i == tab.length;
    }

    /**
     * Gives the index of the value given in array
     *
     * @param tab the array given
     * @param value the desired value in array
     * @return if index found, the index ; otherwise the length of array + 1
     */
    public static int indexOf(double[] tab, double value) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        int i = 0;

        while (i < tab.length && tab[i] != value) {
            i++;
        }

        return i;
    }

    /**
     * Checks if the word given is in array given
     *
     * @param tab the given array
     * @param word the word desired in array
     * @return true if the word is in array, false otherwise
     */
    public static boolean isContent(String[] tab, String word) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        int i = 0;

        while (i < tab.length && !tab[i].contentEquals(word)) {
            i++;
        }

        return i != tab.length;
    }

    /**
     * Checks if the value is in array with a margin of error
     *
     * @param tab the given array
     * @param value the value desired in array
     * @param error the marge of error
     * @return true if the value (+- error) is contained in array, false
     * otherwise
     */
    public static boolean isContent(double[] tab, double value, double error) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        int i = 0;

        while (i < tab.length
                && !(tab[i] - error <= value && tab[i] + error >= value)) {
            i++;
        }

        return i != tab.length;
    }

    /**
     * Checks if a value is duplicate in array
     *
     * @param tab the given array
     * @return true if a value is found, false otherwise
     */
    public static boolean isDuplicate(double[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau est null");
        }

        boolean isFind = false;
        int i = 0;

        while (i < tab.length && !isFind) {
            double valueToCheck = tab[i];
            int j = 0;

            while (j < tab.length && !isFind) {
                isFind = i != j && valueToCheck == tab[j];
                j++;
            }
            i++;

        }

        return isFind;
    }

    /**
     * Counts how many are negative numbers in array
     *
     * @param tab the given array
     * @return the number of negative numbers
     */
    public static int countNegative(double[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau est null");
        }

        int count = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < 0) {
                count += 1;
            }
        }

        return count;
    }

    /**
     * Exchanges the value of indice1 by the value of indice2 and vise-versa
     *
     * @param tab the given array
     * @param indice1 the first indice of array
     * @param indice2 the second indice of array
     */
    public static void swapValue(double[] tab, int indice1, int indice2) {

        if (tab == null) {
            throw new IllegalArgumentException("Le tableau est null");
        }

        if (indice2 >= tab.length || indice1 >= tab.length) {
            throw new IllegalArgumentException("L'indice du tableau est trop élevé");
        }

        if (indice2 < 0 || indice1 < 0) {
            throw new IllegalArgumentException("L'indice du tableau est négatif");
        }

        double saveValue = tab[indice1];

        tab[indice1] = tab[indice2];
        tab[indice2] = saveValue;
    }

    /**
     * Reverses all values in array (the beginning becomes the end)
     *
     * @param tab the given array
     */
    public static void reverse(double[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau est null");
        }

        for (int i = 0; i < tab.length / 2; i++) {
            swapValue(tab, i, tab.length - 1 - i);
        }
    }

    /**
     * Gets the indexes of minimal value of array
     *
     * @param tab the given array
     * @return all indexes of minimal value
     */
    public static int[] minIndexes(double[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau est null ou vide");
        }

        double min = tab[0];
        int countIndex = 1;
        int[] minIndexes = new int[tab.length];
        minIndexes[0] = 0;

        for (int i = 1; i < tab.length; i++) {
            if (tab[i] <= min) {
                if (tab[i] < min) {
                    min = tab[i];
                    countIndex = 0;
                }

                minIndexes[countIndex] = i;
                countIndex++;
            }
        }

        int[] totalIndexes = new int[countIndex];

        for (int i = 0; i < totalIndexes.length; i++) {
            totalIndexes[i] = minIndexes[i];
        }

        return totalIndexes;
    }

    public static void main(String[] args) {
        double[] tab = {-2, 5, -1, 0, 1, 3.5, 4, -2, 4.8, -2};
        double[] copy = copy(tab);
        String[] words = {"mot1", "mot2", "test", "arbre", "a", "", "dernier"};

        System.out.println("tab : " + Arrays.toString(tab));
        System.out.println("copy tab : " + Arrays.toString(copy));
        System.out.println("words : " + Arrays.toString(words) + "\n");

        System.out.println("Minimum : " + min(tab));
        System.out.println("Maximum : " + max(tab));
        System.out.println("Index du maximum : " + maxIndex(tab));
        System.out.println("Somme : " + sum(tab));
        System.out.println("Moyenne : " + average(tab));
        System.out.println("Est tiré : " + isSorted(tab));
        System.out.println("Index du premier 0 : " + indexOf(tab, 10));
        System.out.println("Contient \" arbre \" : " + isContent(words, "arbre"));
        System.out.println("Contient \" 1.5 \" avec une marge d'erreur de"
                + " \" 2 \" : " + isContent(tab, 1.5, 2.0));
        System.out.println("Le tableau contient des doublons : " + isDuplicate(tab));
        System.out.println("Eléments négatifs : " + countNegative(tab));

        swapValue(tab, 2, 7);
        System.out.println("Echanger l'indice 2 et 5 : " + Arrays.toString(tab));

        reverse(tab);
        System.out.println("Inverse le tableau tab : " + Arrays.toString(tab));
        System.out.println("Index des minimums : " + Arrays.toString(minIndexes(tab)));
    }
}
