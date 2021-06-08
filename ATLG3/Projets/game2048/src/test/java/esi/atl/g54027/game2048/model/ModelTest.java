package esi.atl.g54027.game2048.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ModelTest {

    // ---------------------------------------
    // ----------- TEST TOP METHOD
    // ---------------------------------------
    @Test
    public void testTopAllSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(2);
        model.getSquares()[3][0].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[1][0].getValue(), 4);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopUniqueValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(4);
        model.getSquares()[2][0].setValue(16);
        model.getSquares()[3][0].setValue(8);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[1][0].getValue(), 4);
        assertEquals(model.getSquares()[2][0].getValue(), 16);
        assertEquals(model.getSquares()[3][0].getValue(), 8);
    }

    @Test
    public void testTopEmptyBetweenEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopEmptyBetweenNotEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(2);
        model.getSquares()[3][0].setValue(0);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopAllEmpty() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(0);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopFirstAddTop() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[1][0].getValue(), 2);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testTopMultipleLineOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][1].setValue(2);
        model.getSquares()[2][2].setValue(2);
        model.getSquares()[3][3].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[0][1].getValue(), 2);
        assertEquals(model.getSquares()[0][2].getValue(), 2);
        assertEquals(model.getSquares()[0][3].getValue(), 2);
    }

    @Test
    public void testTopMultipleLineMultipleValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[3][0].setValue(4);

        model.getSquares()[1][1].setValue(6);
        model.getSquares()[2][1].setValue(6);

        model.getSquares()[2][2].setValue(8);
        model.getSquares()[3][2].setValue(8);

        model.getSquares()[3][3].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 8);
        assertEquals(model.getSquares()[0][1].getValue(), 12);
        assertEquals(model.getSquares()[0][2].getValue(), 16);
        assertEquals(model.getSquares()[0][3].getValue(), 4);
    }

    @Test
    public void testTopOneFusionSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[1][0].setValue(4);
        model.getSquares()[2][0].setValue(8);
        model.getSquares()[3][0].setValue(2);
        model.top();

        assertEquals(model.getSquares()[0][0].getValue(), 8);
        assertEquals(model.getSquares()[1][0].getValue(), 8);
        assertEquals(model.getSquares()[2][0].getValue(), 2);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    // ---------------------------------------
    // ----------- TEST BOTTOM METHOD
    // ---------------------------------------
    @Test
    public void testBottomAllSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(2);
        model.getSquares()[3][0].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 4);
        assertEquals(model.getSquares()[3][0].getValue(), 4);
    }

    @Test
    public void testBottomUniqueValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(4);
        model.getSquares()[2][0].setValue(16);
        model.getSquares()[3][0].setValue(8);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[1][0].getValue(), 4);
        assertEquals(model.getSquares()[2][0].getValue(), 16);
        assertEquals(model.getSquares()[3][0].getValue(), 8);
    }

    @Test
    public void testBottomEmptyBetweenEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 4);
    }

    @Test
    public void testBottomEmptyBetweenNotEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(2);
        model.getSquares()[3][0].setValue(0);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 4);
    }

    @Test
    public void testBottomAllEmpty() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(0);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 0);
    }

    @Test
    public void testBottomFirstAddBottom() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(2);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 2);
        assertEquals(model.getSquares()[3][0].getValue(), 4);
    }

    @Test
    public void testBottomOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[1][0].setValue(0);
        model.getSquares()[2][0].setValue(0);
        model.getSquares()[3][0].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 0);
        assertEquals(model.getSquares()[2][0].getValue(), 0);
        assertEquals(model.getSquares()[3][0].getValue(), 2);
    }

    @Test
    public void testBottomMultipleLineOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][1].setValue(2);
        model.getSquares()[2][2].setValue(2);
        model.getSquares()[3][3].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[3][0].getValue(), 2);
        assertEquals(model.getSquares()[3][1].getValue(), 2);
        assertEquals(model.getSquares()[3][2].getValue(), 2);
        assertEquals(model.getSquares()[3][3].getValue(), 2);
    }

    @Test
    public void testBottomMultipleLineMultipleValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[3][0].setValue(4);

        model.getSquares()[1][1].setValue(6);
        model.getSquares()[2][1].setValue(6);

        model.getSquares()[2][2].setValue(8);
        model.getSquares()[3][2].setValue(8);

        model.getSquares()[3][3].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.bottom();

        assertEquals(model.getSquares()[3][0].getValue(), 8);
        assertEquals(model.getSquares()[3][1].getValue(), 12);
        assertEquals(model.getSquares()[3][2].getValue(), 16);
        assertEquals(model.getSquares()[3][3].getValue(), 4);
    }

    @Test
    public void testBottomOneFusionSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(8);
        model.getSquares()[2][0].setValue(4);
        model.getSquares()[3][0].setValue(4);
        model.bottom();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[1][0].getValue(), 2);
        assertEquals(model.getSquares()[2][0].getValue(), 8);
        assertEquals(model.getSquares()[3][0].getValue(), 8);
    }

    // ---------------------------------------
    // ----------- TEST LEFT METHOD
    // ---------------------------------------
    @Test
    public void testLeftAllSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[0][1].getValue(), 4);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftUniqueValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(4);
        model.getSquares()[0][2].setValue(16);
        model.getSquares()[0][3].setValue(8);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[0][1].getValue(), 4);
        assertEquals(model.getSquares()[0][2].getValue(), 16);
        assertEquals(model.getSquares()[0][3].getValue(), 8);
    }

    @Test
    public void testLeftEmptyBetweenEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftEmptyBetweenNotEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(2);
        model.getSquares()[0][3].setValue(0);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftAllEmpty() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(0);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftFirstAddLeft() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[0][1].getValue(), 2);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testLeftMultipleLineOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][1].setValue(2);
        model.getSquares()[2][2].setValue(2);
        model.getSquares()[3][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[1][0].getValue(), 2);
        assertEquals(model.getSquares()[2][0].getValue(), 2);
        assertEquals(model.getSquares()[3][0].getValue(), 2);
    }

    @Test
    public void testLeftMultipleLineMultipleValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[3][0].setValue(4);

        model.getSquares()[1][1].setValue(6);
        model.getSquares()[2][1].setValue(6);

        model.getSquares()[2][2].setValue(8);
        model.getSquares()[3][2].setValue(8);

        model.getSquares()[3][3].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 4);
        assertEquals(model.getSquares()[0][1].getValue(), 2);

        assertEquals(model.getSquares()[1][0].getValue(), 6);

        assertEquals(model.getSquares()[2][0].getValue(), 6);
        assertEquals(model.getSquares()[2][1].getValue(), 8);

        assertEquals(model.getSquares()[3][0].getValue(), 4);
        assertEquals(model.getSquares()[3][1].getValue(), 8);
        assertEquals(model.getSquares()[3][2].getValue(), 2);
    }

    @Test
    public void testLeftOneFusionSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[0][1].setValue(4);
        model.getSquares()[0][2].setValue(8);
        model.getSquares()[0][3].setValue(2);
        model.left();

        assertEquals(model.getSquares()[0][0].getValue(), 8);
        assertEquals(model.getSquares()[0][1].getValue(), 8);
        assertEquals(model.getSquares()[0][2].getValue(), 2);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    // ---------------------------------------
    // ----------- TEST RIGHT METHOD
    // ---------------------------------------
    @Test
    public void testRightAllSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 4);
        assertEquals(model.getSquares()[0][3].getValue(), 4);
    }

    @Test
    public void testRightUniqueValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(4);
        model.getSquares()[0][2].setValue(16);
        model.getSquares()[0][3].setValue(8);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 2);
        assertEquals(model.getSquares()[0][1].getValue(), 4);
        assertEquals(model.getSquares()[0][2].getValue(), 16);
        assertEquals(model.getSquares()[0][3].getValue(), 8);
    }

    @Test
    public void testRightEmptyBetweenEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 4);
    }

    @Test
    public void testRightEmptyBetweenNotEven() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(2);
        model.getSquares()[0][3].setValue(0);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 4);
    }

    @Test
    public void testRightAllEmpty() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(0);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 0);
    }

    @Test
    public void testRightFirstAddRight() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 2);
        assertEquals(model.getSquares()[0][3].getValue(), 4);
    }

    @Test
    public void testRightOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(0);
        model.getSquares()[0][2].setValue(0);
        model.getSquares()[0][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 0);
        assertEquals(model.getSquares()[0][2].getValue(), 0);
        assertEquals(model.getSquares()[0][3].getValue(), 2);
    }

    @Test
    public void testRightMultipleLineOneValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][1].setValue(2);
        model.getSquares()[2][2].setValue(2);
        model.getSquares()[3][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][3].getValue(), 2);
        assertEquals(model.getSquares()[1][3].getValue(), 2);
        assertEquals(model.getSquares()[2][3].getValue(), 2);
        assertEquals(model.getSquares()[3][3].getValue(), 2);
    }

    @Test
    public void testRightMultipleLineMultipleValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(4);
        model.getSquares()[3][0].setValue(4);

        model.getSquares()[1][1].setValue(6);
        model.getSquares()[2][1].setValue(6);

        model.getSquares()[2][2].setValue(8);
        model.getSquares()[3][2].setValue(8);

        model.getSquares()[3][3].setValue(2);
        model.getSquares()[0][3].setValue(2);
        model.right();

        assertEquals(model.getSquares()[0][3].getValue(), 2);
        assertEquals(model.getSquares()[0][2].getValue(), 4);

        assertEquals(model.getSquares()[1][3].getValue(), 6);

        assertEquals(model.getSquares()[2][3].getValue(), 8);
        assertEquals(model.getSquares()[2][2].getValue(), 6);

        assertEquals(model.getSquares()[3][3].getValue(), 2);
        assertEquals(model.getSquares()[3][2].getValue(), 8);
        assertEquals(model.getSquares()[3][1].getValue(), 4);
    }

    @Test
    public void testRightOneFusionSameValue() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(8);
        model.getSquares()[0][2].setValue(4);
        model.getSquares()[0][3].setValue(4);
        model.right();

        assertEquals(model.getSquares()[0][0].getValue(), 0);
        assertEquals(model.getSquares()[0][1].getValue(), 2);
        assertEquals(model.getSquares()[0][2].getValue(), 8);
        assertEquals(model.getSquares()[0][3].getValue(), 8);
    }

    // ---------------------------------------
    // ----------- TEST ADD RANDOM NUMBER
    // ---------------------------------------
    @Test
    public void testAddRdmNumberEnd() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(8);
        model.getSquares()[0][1].setValue(8);
        model.getSquares()[0][2].setValue(8);
        model.getSquares()[0][3].setValue(8);

        model.getSquares()[1][0].setValue(8);
        model.getSquares()[1][1].setValue(8);
        model.getSquares()[1][2].setValue(8);
        model.getSquares()[1][3].setValue(8);

        model.getSquares()[2][0].setValue(8);
        model.getSquares()[2][1].setValue(8);
        model.getSquares()[2][2].setValue(8);
        model.getSquares()[2][3].setValue(8);

        model.getSquares()[3][0].setValue(8);
        model.getSquares()[3][1].setValue(8);
        model.getSquares()[3][2].setValue(8);
        model.addRdmNumber();

        assertTrue(model.getSquares()[3][3].getValue() == 2
                || model.getSquares()[3][3].getValue() == 4);
    }

    @Test
    public void testAddRdmNumberBegin() {
        Model model = new Game();
        model.getSquares()[0][1].setValue(8);
        model.getSquares()[0][2].setValue(8);
        model.getSquares()[0][3].setValue(8);

        model.getSquares()[1][0].setValue(8);
        model.getSquares()[1][1].setValue(8);
        model.getSquares()[1][2].setValue(8);
        model.getSquares()[1][3].setValue(8);

        model.getSquares()[2][0].setValue(8);
        model.getSquares()[2][1].setValue(8);
        model.getSquares()[2][2].setValue(8);
        model.getSquares()[2][3].setValue(8);

        model.getSquares()[3][0].setValue(8);
        model.getSquares()[3][1].setValue(8);
        model.getSquares()[3][2].setValue(8);
        model.getSquares()[3][3].setValue(8);
        model.addRdmNumber();

        assertTrue(model.getSquares()[0][0].getValue() == 2
                || model.getSquares()[0][0].getValue() == 4);
    }

    @Test
    public void testAddRdmNumberCenter() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(8);
        model.getSquares()[0][1].setValue(8);
        model.getSquares()[0][2].setValue(8);
        model.getSquares()[0][3].setValue(8);

        model.getSquares()[1][0].setValue(8);
        model.getSquares()[1][1].setValue(8);
        model.getSquares()[1][2].setValue(8);
        model.getSquares()[1][3].setValue(8);

        model.getSquares()[2][1].setValue(8);
        model.getSquares()[2][2].setValue(8);
        model.getSquares()[2][3].setValue(8);

        model.getSquares()[3][0].setValue(8);
        model.getSquares()[3][1].setValue(8);
        model.getSquares()[3][2].setValue(8);
        model.getSquares()[3][3].setValue(8);
        model.addRdmNumber();

        assertTrue(model.getSquares()[2][0].getValue() == 2
                || model.getSquares()[2][0].getValue() == 4);
    }

    // ---------------------------------------
    // ----------- TEST ADJACENT CASE
    // ---------------------------------------
    @Test
    public void testCheckAllAdjacentZero() {
        Model model = new Game();
        assertFalse(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentHorizontalBegin() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(2);
        assertTrue(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentHorizontalEnd() {
        Model model = new Game();
        model.getSquares()[3][2].setValue(2);
        model.getSquares()[3][3].setValue(2);
        assertTrue(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentHorizontalBeginNotExist() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[0][1].setValue(4);
        assertFalse(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentHorizontalEndNotExist() {
        Model model = new Game();
        model.getSquares()[3][2].setValue(2);
        model.getSquares()[3][3].setValue(4);
        assertFalse(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentVerticalBegin() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(2);
        assertTrue(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentVerticalEnd() {
        Model model = new Game();
        model.getSquares()[2][3].setValue(2);
        model.getSquares()[3][3].setValue(2);
        assertTrue(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentVerticalBeginNotExist() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(2);
        model.getSquares()[1][0].setValue(4);
        assertFalse(model.checkAllAdjacent());
    }

    @Test
    public void testCheckAllAdjacentVerticalEndNotExist() {
        Model model = new Game();
        model.getSquares()[2][3].setValue(2);
        model.getSquares()[3][3].setValue(4);
        assertFalse(model.checkAllAdjacent());
    }

    // ---------------------------------------
    // ----------- TEST END GAME
    // ---------------------------------------
    @Test
    public void testEndGameEmpty() {
        Model model = new Game();
        assertFalse(model.isMaxScore());
    }

    @Test
    public void testEndGameLost() {
        Model model = new Game();
        model.getSquares()[0][0].setValue(0);
        model.getSquares()[0][1].setValue(2);
        model.getSquares()[0][2].setValue(4);
        model.getSquares()[0][3].setValue(6);

        model.getSquares()[1][0].setValue(8);
        model.getSquares()[1][1].setValue(10);
        model.getSquares()[1][2].setValue(12);
        model.getSquares()[1][3].setValue(14);

        model.getSquares()[2][1].setValue(16);
        model.getSquares()[2][2].setValue(18);
        model.getSquares()[2][3].setValue(20);

        model.getSquares()[3][0].setValue(22);
        model.getSquares()[3][1].setValue(24);
        model.getSquares()[3][2].setValue(26);
        model.getSquares()[3][3].setValue(28);
        assertFalse(model.isMaxScore() 
                || (!model.addRdmNumber() && !model.checkAllAdjacent()));
    }

    @Test
    public void testEndGameWin() {
        Model model = new Game();
        model.getSquares()[1][3].setValue(2048);
        assertTrue(model.isMaxScore());
    }
}
