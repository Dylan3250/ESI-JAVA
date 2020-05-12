package g54027.dev2.td05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tableau2DTest {

    @Test
    public void testTableau2D_anyZero() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {1, 2, 3},
            {3, 1},
            {2, 4, 1, 3}
        };

        assertEquals(tableau2D.proportionNuls(tab), 0);
    }

    @Test
    public void testTableau2D_fullZero() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {0, 0, 0},
            {0, 0}
        };

        assertEquals(tableau2D.proportionNuls(tab), 5);
    }

    @Test
    public void testTableau2D_mixedZero() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {0, 1, 0},
            {0, 1, 2, 0},
            {0}
        };

        assertEquals(tableau2D.proportionNuls(tab), 5);
    }

    @Test
    public void testTableau2D_onlyPositive() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {1, 5},
            {1, 2, 21},
            {121}
        };

        assertTrue(tableau2D.isProportionPositif(tab));
    }

    @Test
    public void testTableau2D_withNegative() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {-1, 5},
            {1, -2, 21},
            {121, -11}
        };

        assertFalse(tableau2D.isProportionPositif(tab));
    }

    @Test
    public void testTableau2D_onlyNegative() {
        Tableau2D tableau2D = new Tableau2D();

        int[][] tab = {
            {-1}
        };

        assertFalse(tableau2D.isProportionPositif(tab));
    }

}
