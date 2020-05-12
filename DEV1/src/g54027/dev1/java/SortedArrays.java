package g54027.dev1.java;

public class SortedArrays {

    /**
     * Displays an array with format " [x, x] "
     *
     * @param array the array given
     * @param logicalSize the logical size of array given
     * @return the formated array like " [x, x] "
     */
    public static String display(int[] array, int logicalSize) {
        String displayArray = "[";

        for (int i = 0; i < logicalSize; i++) {
            displayArray += array[i] + ", ";
        }

        return displayArray.substring(0, displayArray.length() - 2) + "]";
    }

    /**
     * Finds the index of a value in array or where it will be
     *
     * @param array the array given
     * @param value the value to search in array
     * @param logicalSize the logical size of array given
     * @return the index of value or max index + 1 if it don't find
     */
    public static int indexOf(int[] array, int value, int logicalSize) {
        int i = 0;

        while (logicalSize > i && value > array[i]) {
            i++;
        }

        return i;
    }

    /**
     * Checks if the index is present in array
     *
     * @param array the array given
     * @param index the supposed index recupered in array
     * @param logicalSize the logical size of array given
     * @return true if the index is in array, false otherwise
     */
    public static boolean isExist(int[] array, int index, int logicalSize) {
        return index != logicalSize;
    }

    /**
     * Removes a value in sorted array
     *
     * @param array the array given
     * @param value the value to remove in array
     * @param logicalSize the logical size of array given
     * @return the new logical size of array (-1)
     */
    public static int delete(int[] array, int value, int logicalSize) {
        int index = indexOf(array, value, logicalSize);

        if (isExist(array, index, logicalSize)) {
            for (int i = index; i < logicalSize; i++) {
                array[i] = array[i + 1];
            }

            logicalSize -= 1;
        }

        return logicalSize;
    }

    /**
     * Adds a value in sorted array
     *
     * @param array the array given
     * @param value the new value desired in array
     * @param logicalSize the logical size of array given
     * @return the new logical size of array (+1)
     */
    public static int add(int[] array, int value, int logicalSize) {
        int index = indexOf(array, value, logicalSize);

        if (logicalSize != index) {
            for (int i = logicalSize + 1; i > index; i--) {
                array[i] = array[i - 1];
            }
        }
        array[index] = value;

        return logicalSize + 1;
    }

    /**
     * Searches a value in sorted array with dichotomic method
     *
     * @param array the array given
     * @param value the value searched in array
     * @param logicalSize the logical size of array given
     * @return the index of searched value or -1 if it is not found
     */
    public static int dichotomicSearch(int[] array, int value, int logicalSize) {
        int begin = 0;
        int end = logicalSize - 1;
        int center = (begin + end) / 2;
        boolean isFound = false;

        while (!isFound && begin <= end) {
            center = (begin + end) / 2;
            if (array[center] == value) {
                isFound = true;
            } else if (array[center] > value) {
                end = center - 1;
            } else {
                begin = center + 1;
            }
        }

        return isFound ? center : -1;
    }

    /**
     * Inserts a new value in array with insert method
     *
     * @param array the array given
     * @param logicalSize the logical size of array given
     */
    public static void insertSort(int[] array, int logicalSize) {
        for (int i = 1; i < logicalSize; i++) {
            int j = i - 1;
            int value = array[i];

            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }

    /**
     * Inserts a new value in array with selection method
     *
     * @param array the array given
     * @param logicalSize the logical size of array given
     */
    public static void selectionSort(int[] array, int logicalSize) {
        for (int i = 0; i < logicalSize; i++) {
            int min = i;

            for (int j = min + 1; j < logicalSize; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int save = array[i];
            array[i] = array[min];
            array[min] = save;
        }
    }

    /**
     * Inserts a new value in array with bubble method
     *
     * @param array the array given
     * @param logicalSize the logical size of array given
     */
    public static void bubbleSort(int[] array, int logicalSize) {
        for (int i = logicalSize - 1; i > 0; i--) {
            for (int j = logicalSize - i; j >= i; j--) {
                if (array[j] < array[j - 1]) {
                    int save = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = save;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        array[0] = 20;
        array[1] = 10;
        array[2] = 40;
        array[3] = 30;
        int logicalSize = 4;

        System.out.print("Voici le tableau de base non trié : ");
        System.out.println(display(array, logicalSize));

        System.out.print("Voici le tableau de trié : ");
        // insertSort(array, logicalSize);
        selectionSort(array, logicalSize);
        // bubbleSort(array, logicalSize);
        System.out.println(display(array, logicalSize));
        System.out.println();

        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
        System.out.println("L'index de 10 est : " + indexOf(array, 10, logicalSize));
        System.out.println("La valeur 1315 existe-t-elle : "
                + isExist(array, indexOf(array, 1315, logicalSize), logicalSize));
        System.out.println();

        logicalSize = delete(array, 1315, logicalSize);
        System.out.println("Après avoir tenté de supprimé un nombre qui"
                + " n'existe pas (1315) :");
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize + " et"
                + " sa taille physique : " + array.length);
        System.out.println();

        logicalSize = delete(array, 30, logicalSize);
        System.out.println("Après avoir tenté de supprimé un nombre qui existe (10) :");
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
        System.out.println();

        logicalSize = add(array, 25, logicalSize);
        System.out.println("Après avoir ajouté un nombre (25) :");
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize + ""
                + " et sa taille physique : " + array.length);
        System.out.println();

        System.out.println("D'après la recherche dichotomique, 25 se trouve en"
                + " position : " + dichotomicSearch(array, 40, logicalSize));
        System.out.println("D'après la recherche dichotomique, 3121 (n'existe pas)"
                + " se trouve en position : " + dichotomicSearch(array, 3121, logicalSize));
    }
}
