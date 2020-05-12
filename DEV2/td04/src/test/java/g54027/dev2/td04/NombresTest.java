package g54027.dev2.td04;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g54027
 */
public class NombresTest {

    @Test
    public void testSum_tousStrictementPositifs() {
        Nombres instance = new Nombres();
        instance.add(4);
        instance.add(12);
        instance.add(52);
        Integer expResult = 68;
        Integer result = instance.sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveDuplicate_Any() {
        Nombres instance = new Nombres();
        instance.add(1);
        instance.add(4);
        instance.add(2);
        instance.add(0);

        List<Integer> expected = List.of(1, 4, 2, 0);
        instance.removeDuplicate();

        assertEquals(instance.getNombres(), expected);
    }

    @Test
    public void testRemoveDuplicate_Full() {
        Nombres instance = new Nombres();
        instance.add(1);
        instance.add(1);
        instance.add(1);
        instance.add(1);

        List<Integer> expected = List.of(1);
        instance.removeDuplicate();

        assertEquals(instance.getNombres(), expected);
    }

    @Test
    public void testRemoveDuplicate_EmptyList() {
        Nombres instance = new Nombres();

        List<Integer> expected = List.of();
        instance.removeDuplicate();

        assertEquals(instance.getNombres(), expected);
    }

    @Test
    public void testRemoveDuplicate_Max() {
        Nombres instance = new Nombres();
        instance.add(0);
        instance.add(1);
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(3);

        List<Integer> expected = List.of(0, 1, 2, 3);
        instance.removeDuplicate();

        assertEquals(instance.getNombres(), expected);
    }

    @Test
    public void testRemoveDuplicate_Min() {
        Nombres instance = new Nombres();
        instance.add(-1);
        instance.add(-1);
        instance.add(1);
        instance.add(2);
        instance.add(3);

        List<Integer> expected = List.of(-1, 1, 2, 3);
        instance.removeDuplicate();

        assertEquals(instance.getNombres(), expected);
    }

}
