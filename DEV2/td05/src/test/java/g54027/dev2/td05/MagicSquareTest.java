package g54027.dev2.td05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagicSquareTest {

    @Test
    public void testMagicSquare_isPer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MagicSquare(4);
        });
    }

    @Test
    public void testMagicSquare_min3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MagicSquare(2);
        });
    }

    @Test
    public void testMagicSquare_sumLineNumBigger() {
        MagicSquare ms = new MagicSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            ms.sumLine(3);
        });
    }

    @Test
    public void testMagicSquare_sumLineNumSmaller() {
        MagicSquare ms = new MagicSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            ms.sumLine(-1);
        });
    }

    @Test
    public void testMagicSquare_sumLineMin() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumLine(0) == 15);
    }

    @Test
    public void testMagicSquare_sumLineMax() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumLine(ms.getN() - 1) == 15);
    }

    @Test
    public void testMagicSquare_sumLineMiddle() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumLine(ms.getN() / 2) == 15);
    }

    @Test
    public void testMagicSquare_sumColumnNumBigger() {
        MagicSquare ms = new MagicSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            ms.sumColumn(3);
        });
    }

    @Test
    public void testMagicSquare_sumColumnNumSmaller() {
        MagicSquare ms = new MagicSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            ms.sumColumn(-1);
        });
    }

    @Test
    public void testMagicSquare_sumColumnMin() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumColumn(0) == 15);
    }

    @Test
    public void testMagicSquare_sumColumnMax() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumColumn(ms.getN() - 1) == 15);
    }

    @Test
    public void testMagicSquare_sumColumnMiddle() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumColumn(ms.getN() / 2) == 15);
    }

    @Test
    public void testMagicSquare_sumDiagNot1or2() {
        MagicSquare ms = new MagicSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            ms.sumColumn(3);
        });
    }

    @Test
    public void testMagicSquare_sumDiag1() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumDiag(1) == 15);
    }

    @Test
    public void testMagicSquare_sumDiag2() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.sumDiag(2) == 15);
    }

    @Test
    public void testMagicSquare_isMagicSquareCorrect() {
        MagicSquare ms = new MagicSquare();
        assertTrue(ms.isMagicSquare());
    }

    @Test
    public void testMagicSquare_displayMagicSquareSuperior20() {
        MagicSquare ms = new MagicSquare(21);
        assertThrows(IllegalArgumentException.class, () -> {
            ms.displayMagicSquare();
        });
    }
}
