package g54027.dev1.java;

public class SearchMultipleMinimas {

    public static String display(int[] array) {
        String displayArray = "[";

        for (int i = 0; i < array.length - 1; i++) {
            displayArray += array[i] + ", ";
        }

        return displayArray + array[array.length - 1] + "]";
    }

    public static int[] searchMaxima(double[] ds) {
        double max = ds[0];
        int countMax = 0;

        for (int i = 1; i < ds.length; i++) {
            if (ds[i] >= max) {
                max = ds[i];
                countMax += 1;
            }
        }

        int[] indexes = new int[countMax];
        int i = 0;
        int countMaxChanged = 0;

        while (i < ds.length && countMaxChanged < countMax) {
            if (max == ds[i]) {
                indexes[countMaxChanged] = i;
                countMaxChanged++;
            }
            i++;
        }

        return indexes;
    }

    public static void main(String[] args) {
        double[] ds = {-1, 10.0, 1.5, 2.0, 10.0, 2.0};
        System.out.println(display(searchMaxima(ds)));
    }
}
