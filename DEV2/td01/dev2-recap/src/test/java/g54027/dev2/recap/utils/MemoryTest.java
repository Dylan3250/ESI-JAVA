/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54027.dev2.recap.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54027
 */
public class MemoryTest {

    @Test
    public void testInitCards_CasGeneral() {
        System.out.println("Cas general");

        int[] getTab = Memory.initCards(4);
        int[] expectedTab = {1, 1, 2, 2, 3, 3, 4, 4};

        assertArrayEquals(getTab, expectedTab);
    }

    @Test
    public void testInitCards_TailleMinimale() {
        System.out.println("Taille Minimale");

        int[] getTab = Memory.initCards(3);
        int[] expectedTab = {1, 1, 2, 2, 3, 3};

        assertArrayEquals(getTab, expectedTab);
    }

    @Test
    public void testInitCards_TailleMaximale() {
        System.out.println("Taille Maximale");

        int[] getTab = Memory.initCards(5);
        int[] expectedTab = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        assertArrayEquals(getTab, expectedTab);
    }

    @Test
    public void testInitCards_TailleTropPetit() {
        System.out.println("Taille trop petit");

        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> {
            //Action
            Memory.initCards(2);
        });
    }

    @Test
    public void testInitCards_TailleTropGrande() {
        System.out.println("Taille trop petit");

        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> {
            //Action
            Memory.initCards(21);
        });
    }

}
