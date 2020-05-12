/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54027.dev2.td04;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54027
 */
public class TdListesTest {

    @Test
    public void testSupprimerMinEtMax() {
        List<Integer> liste = new ArrayList<>(List.of(1, 4, 2, 0));
        List<Integer> expected = List.of(1, 2);
        TdListes.supprimerMinEtMax(liste);
        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_Doublons() {
        List<Integer> liste = new ArrayList<>(List.of(1, 4, 4, 2, 0));
        List<Integer> expected = List.of(1, 4, 2, 0);
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_Any() {
        List<Integer> liste = new ArrayList<>(List.of(1, 4, 2, 0));
        List<Integer> expected = List.of(1, 4, 2, 0);
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_Full() {
        List<Integer> liste = new ArrayList<>(List.of(1, 1, 1, 1, 1));
        List<Integer> expected = List.of(1);
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_EmptyList() {
        List<Integer> liste = new ArrayList<>(List.of());
        List<Integer> expected = List.of();
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_Max() {
        List<Integer> liste = new ArrayList<>(List.of(0, 1, 2, 3, 3));
        List<Integer> expected = List.of(0, 1, 2, 3);
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicateNewList_Min() {
        List<Integer> liste = new ArrayList<>(List.of(-1, -1, 0, 1, 2, 3, 3));
        List<Integer> expected = List.of(-1, 0, 1, 2, 3);
        List<Integer> newListe = TdListes.removeDuplicateNewList(liste);

        assertEquals(newListe, expected);
    }

    @Test
    public void testRemoveDuplicate_Doublons() {
        List<Integer> liste = new ArrayList<>(List.of(1, 4, 4, 2, 0));
        List<Integer> expected = List.of(1, 4, 2, 0);
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicate_Any() {
        List<Integer> liste = new ArrayList<>(List.of(1, 4, 2, 0));
        List<Integer> expected = List.of(1, 4, 2, 0);
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicate_Full() {
        List<Integer> liste = new ArrayList<>(List.of(1, 1, 1, 1, 1));
        List<Integer> expected = List.of(1);
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicate_EmptyList() {
        List<Integer> liste = new ArrayList<>(List.of());
        List<Integer> expected = List.of();
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicate_Max() {
        List<Integer> liste = new ArrayList<>(List.of(0, 1, 2, 3, 3));
        List<Integer> expected = List.of(0, 1, 2, 3);
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

    @Test
    public void testRemoveDuplicate_Min() {
        List<Integer> liste = new ArrayList<>(List.of(-1, -1, 0, 1, 2, 3, 3));
        List<Integer> expected = List.of(-1, 0, 1, 2, 3);
        TdListes.removeDuplicate(liste);

        assertEquals(liste, expected);
    }

}
