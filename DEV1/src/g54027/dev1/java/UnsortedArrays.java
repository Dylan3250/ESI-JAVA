package g54027.dev1.java;

public class UnsortedArrays {

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
     * Adds a value in unsorted array
     *
     * @param array the array given
     * @param value the new value desired in array
     * @param logicalSize the logical size of array given
     * @return the new logical size of array (+1)
     */
    public static int add(int[] array, int value, int logicalSize) {
        array[logicalSize] = value;
        return logicalSize + 1;
    }

    /**
     * Removes a value in unsorted array
     *
     * @param array the array given
     * @param value the value to remove in array
     * @param logicalSize the logical size of array given
     * @return the new logical size of array (-1)
     */
    public static int delete(int[] array, int value, int logicalSize) {
        int index = indexOf(array, value, logicalSize);

        if (index != -1) {
            array[index] = array[logicalSize - 1];
            logicalSize -= 1;
        }

        return logicalSize;
    }

    /**
     * Finds the index of a value in unsorted array
     *
     * @param array the array given
     * @param value the value to search in array
     * @param logicalSize the logical size of array given
     * @return the index of value or -1 if it don't find
     */
    public static int indexOf(int[] array, int value, int logicalSize) {
        int i = 0;

        while (logicalSize > i && value != array[i]) {
            i++;
        }

        return i >= logicalSize ? -1 : i;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        array[0] = 10;
        array[1] = 1;
        array[2] = 20;
        int logicalSize = 3;

        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
        System.out.println("L'index de 10 est : " + indexOf(array, 10, logicalSize));
        System.out.println("L'index d'un nombre qui existe pas (1315) est : "
                + indexOf(array, 1315, logicalSize));
        System.out.println("");

        logicalSize = add(array, 30, logicalSize);
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
        System.out.println("");

        logicalSize = delete(array, 1315, logicalSize);
        System.out.println("Après avoir tenté de supprimé un nombre "
                + "qui n'existe pas (1315) :");
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
        System.out.println("");

        logicalSize = delete(array, 10, logicalSize);
        System.out.println("Après avoir tenté de supprimé un nombre"
                + " qui existe (10) :");
        System.out.println(display(array, logicalSize));
        System.out.println("La taille logique est de : " + logicalSize
                + " et sa taille physique : " + array.length);
    }
}
