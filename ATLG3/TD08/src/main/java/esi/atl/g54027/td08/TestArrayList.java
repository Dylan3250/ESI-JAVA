package esi.atl.g54027.td08;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(9);
        list.add(7);
        list.add(-1);

        System.out.println("Affichage de mon ArrayList : ");
        list.forEach(System.out::println);

        System.out.println("\nTransformation en ArrayList : ");
        java.util.List<Integer> list2 = ArrayList.copyListUtil(list);
        list2.forEach(System.out::println);
        System.out.println();

        System.out.println("\nTri de mon ArrayList croissant (5 7 2 9 7, -1): ");
        ArrayList.sort(list, (Integer o1, Integer o2) -> o1 - o2);
        list.forEach(System.out::println);
        System.out.println("\nTri de mon ArrayList décroissant (5 7 2 9 7, -1): ");
        ArrayList.sort(list, (Integer o1, Integer o2) -> o2 - o1);
        list.forEach(System.out::println);
    }
}
