package esi.atl.g54027.td09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("to the ");
        list.add("hellHole");
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String word1, String word2) {
//                return word1.length() - word2.length();
//            }
//        });
        Collections.sort(list, (String word1, String word2) -> {
            return word1.length() - word2.length();
        });
        // Collections.sort(list, (word1, String word2) -> {return word1.length() - word2.length();}); // 1 param sans type fonctionne pas
        // Collections.sort(list, (String word1, word2) -> {return word1.length() - word2.length();}); // 1 param sans type fonctionne pas
        Collections.sort(list, (word1, word2) -> {
            return word1.length() - word2.length();
        });
        // Collections.sort(list, word1, word2 -> {return word1.length() - word2.length();}); // il faut des parenthèses quand il y a deux paramètres
        // Collections.sort(list, (word1, word2) -> {word1.length() - word2.length();}); // fonctionne pas sans return et avec accolades
        // Collections.sort(list, (word1, word2) -> word1.length() - word2.length();); // fonctionne pas sans return et accolades avec ;
        Collections.sort(list, (word1, word2) -> word1.length() - word2.length());

        System.out.println(list);
    }
}
