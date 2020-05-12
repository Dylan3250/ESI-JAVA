package g54027.dev2.td04;

import java.util.ArrayList;
import java.util.List;

public class Nombres {

    private List<Integer> nombres;

    /**
     * Makes empty array list like nombres attribute
     */
    public Nombres() {
        nombres = new ArrayList<>();
    }

    /**
     * Adds the value on the list
     *
     * @param val the given value
     */
    public void add(Integer val) {
        nombres.add(val);
    }

    /**
     * Removes the value on the list
     *
     * @param val the given value
     */
    public void remove(Integer val) {
        nombres.remove(val);
    }

    /**
     * Computes the sum of each value of the list
     *
     * @return the sum of the list
     */
    public int sum() {
        return TdListes.sum(nombres);
    }

    /**
     * Gets the integer list " nombres "
     *
     * @return the integer list " nombres "
     */
    public List<Integer> getNombres() {
        return nombres;
    }

    /**
     * Concatenates the given list with the list on the class
     *
     * @param list the given integer list
     */
    public void concatenate(List<Integer> list) {
//        for (Integer item : list) {
//            nombres.add(item);
//        }
        nombres.addAll(list);
    }

    /**
     * Removes minimum and maximum in the " nombres " list
     */
    public void supprimerMinEtMax() {
        int iMin = 0;
        int iMax = 0;

        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(iMax) < nombres.get(i)) {
                iMax = i;
            } else if (nombres.get(iMin) > nombres.get(i)) {
                iMin = i;
            }
        }

        if (iMax > iMin) {
            nombres.remove(iMax);
            nombres.remove(iMin);
        } else {
            nombres.remove(iMin);
            nombres.remove(iMax);
        }
    }

    /**
     * Removes the duplicates elements of a sorted list
     */
    public void removeDuplicate() {
        for (int i = 0; i < nombres.size() - 1; i++) {
            while (nombres.size() > i + 1 && nombres.get(i).equals(nombres.get(i + 1))) {
                nombres.remove(i + 1);
            }
        }
    }

    /**
     * Makes a merge between two sorted lists
     *
     * @param list the second list
     * @return the new list merged and sorted
     */
    public List<Integer> merge(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < nombres.size(); i++) {
            while (nombres.get(i) > list.get(j)) {
                newList.add(list.get(j));
                j++;
            }
            newList.add(nombres.get(i));
        }

        for (int i = j; i < list.size(); i++) {
            newList.add(list.get(i));
        }

        return newList;
    }
}
