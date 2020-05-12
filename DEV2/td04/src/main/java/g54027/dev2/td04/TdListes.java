package g54027.dev2.td04;

import g54027.dev2.td02.Moment;
import java.util.ArrayList;
import java.util.List;

public class TdListes {

    /**
     * Do the first exercise on lists
     */
    public static void ex1() {
        List<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(54);
        list.add(1, 53);
        System.out.println("Liste de base : " + list);

        list.remove(list.size() - 1);
        System.out.println("Supprime l'element en fin de liste : " + list);

        list.remove(Integer.valueOf(42));
        System.out.println("Supprime la valeur 42 : " + list);

        list.clear();
        System.out.println("Vide la liste : " + list);
    }

    /**
     * Computes the sum of elements of the list
     *
     * @param list the given list of integer
     * @return the sum of the list
     */
    public static int sum(List<Integer> list) {
        Integer max = 0;

        for (Integer item : list) {
            max += item;
        }

        return max;
        // ou : return list.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Removes minimum and maximum in the given list
     *
     * @param list the given list
     */
    public static void supprimerMinEtMax(List<Integer> list) {
        int iMin = 0;
        int iMax = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(iMax) < list.get(i)) {
                iMax = i;
            } else if (list.get(iMin) > list.get(i)) {
                iMin = i;
            }
        }

        if (iMax > iMin) {
            list.remove(iMax);
            list.remove(iMin);
        } else {
            list.remove(iMin);
            list.remove(iMax);
        }
    }

    /**
     * Removes the duplicates elements in new sorted list
     *
     * @param list the given sorted list
     * @return the new list without duplicates values
     */
    public static List<Integer> removeDuplicateNewList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean isFound = false;
            int j = 0;

            while (!isFound && j < newList.size()) {
                if (newList.get(j).equals(list.get(i))) {
                    isFound = true;
                }
                j++;
            }

            if (!isFound) {
                newList.add(list.get(i));
            }
        }

        return newList;
    }

    /**
     * Removes the duplicates elements of a sorted list
     *
     * @param list the given sorted list
     */
    public static void removeDuplicate(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int j = 1;

            while (list.size() > i + j && list.get(i).equals(list.get(i + j))) {
                list.remove(i + j);
            }
        }
    }

    /**
     * Gives the earlier moment in the given list
     *
     * @param moment the given Moment list
     * @return the moment that is the earlier
     */
    public static Moment earlier(List<Moment> moment) {
        Moment earlier = moment.get(0);

        for (int i = 1; i < moment.size(); i++) {
            if (moment.get(i).compareTo(earlier) < 0) {
                earlier = moment.get(i);
            }
        }

        return earlier;
    }
    
    public static void main(String[] args) {
        // Exercise 1
        System.out.println("\n-------- EXO 1 --------");
        ex1();

        // Exercise 2
        System.out.println("\n-------- EXO 2 --------");
        System.out.println("Calcul la somme de la liste : "
                + sum(new ArrayList<>(List.of(0, 10, 20, 30))));

        // Exercise 3
        System.out.println("\n-------- EXO 3 --------");
        Nombres num = new Nombres();
        num.add(2);
        num.add(3);
        num.add(-5);
        System.out.println("Ajout dans la liste : " + num.getNombres());

        // Exercise 4
        System.out.println("\n-------- EXO 4 --------");
        List<Integer> newList = List.of(10, 20, 30);
        num.concatenate(newList);
        System.out.println("Listes assemblées : " + num.getNombres());

        // Exercise 5
        System.out.println("\n-------- EXO 5 --------");
        List<Integer> maxMinList = new ArrayList<>(List.of(10, -2, 20, 30, 121));
        System.out.println("Liste de base : " + maxMinList);
        supprimerMinEtMax(maxMinList);
        System.out.println("Liste après avoir supprimé le max et min : " + maxMinList);

        // Exercise 6
        System.out.println("\n-------- EXO 6 --------");
        List<Integer> duplicateList = new ArrayList<>(List.of(1, 3, 3, 7, 8, 8, 8));
        System.out.println("Liste avec les valeurs dupliquées : " + duplicateList);
        List<Integer> newListWithOutDuplicate = removeDuplicateNewList(duplicateList);
        removeDuplicate(duplicateList);
        System.out.println("Sans les valeurs dupliquées - new list : " + newListWithOutDuplicate);
        System.out.println("Sans les valeurs dupliquées - sans new list : " + duplicateList);

        Nombres sortedList = new Nombres();
        sortedList.add(-2);
        sortedList.add(-2);
        sortedList.add(3);
        sortedList.add(6);
        sortedList.add(6);
        sortedList.add(6);
        sortedList.removeDuplicate();
        System.out.println("Liste sans doublon de la classe : " + sortedList.getNombres());

        // Exercise 7
        System.out.println("\n-------- EXO 7 --------");
        Nombres listOne = new Nombres();
        listOne.add(1);
        listOne.add(3);
        listOne.add(7);
        listOne.add(7);
        List<Integer> listTwo = List.of(3, 9, 9, 10);

        System.out.println("Liste 1 (de la classe) : " + listOne.getNombres());
        System.out.println("Liste 2 : " + listTwo);
        List<Integer> fusionList = listOne.merge(listTwo);
        System.out.println("Liste fusionnée : " + fusionList);

        // Exercise 8
        System.out.println("\n-------- EXO 8 --------");
        List<Moment> moment = new ArrayList<>();
        moment.add(new Moment(0, 0, 0));
        moment.add(new Moment(10, 0, 0));
        moment.add(new Moment(0, 0, 10));
        moment.add(new Moment(14, 30, 10));
        Moment earlier = earlier(moment);
        System.out.println("Le moment le plus tôt est : " + earlier.toString());

        // Exercise 9
        System.out.println("\n-------- EXO 9 --------");
        int nbLignes = 3;
        int nbCols = 2;
        boolean stop = false;
        int lg = 0, col = 0;

        while (!stop) {
            System.out.printf("[%d %d]\n", lg, col);
            stop = !(col++ < nbCols) && !(++lg < nbLignes);
        }
    }
}
