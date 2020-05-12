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
public class ArrayUtilTest {

    public ArrayUtilTest() {
    }

    @Test
    public void testSwapGeneralCase() {
        System.out.println("swap general case");
        //Arrange
        int[] array = {10, 11, 12};
        int pos1 = 0;
        int pos2 = 1;
        //Action
        ArrayUtil.swap(array, pos1, pos2);
        //Assert
        int[] expected = {11, 10, 12};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSwapOutsideArrayNegative() {
        System.out.println("swap position négative");
        //Arrange
        int[] array = {10, 11, 12};
        int pos1 = -1;
        int pos2 = 0;
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () 
            -> {
            //Action
            ArrayUtil.swap(array, pos1, pos2);
        });
    }

    /**
     * Test of shuffle method, of class ArrayUtil.
     */
    @org.junit.jupiter.api.Test
    public void testShuffle() {
    }

    /**
     * Test of swap method, of class ArrayUtil.
     */
    @org.junit.jupiter.api.Test
    public void testSwap() {
    }

}
