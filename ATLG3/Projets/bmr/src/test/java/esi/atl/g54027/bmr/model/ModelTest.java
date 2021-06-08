package esi.atl.g54027.bmr.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ModelTest {

    @Test
    public void testCorrectMenData() {
        Model model = new Model();
        model.computeBMR(175, 78, 25, true, LifeStyle.ACTIVE);
        assertEquals(model.getCalories(), 2851.38);
        assertEquals(model.getBMR(), 1839.6);
    }

    @Test
    public void testCorrectWomenData() {
        Model model = new Model();
        model.computeBMR(160, 65, 22, false, LifeStyle.SEDENTARY);
        assertEquals(model.getCalories(), 1756.32);
        assertEquals(model.getBMR(), 1463.6);
    }

    @Test
    public void testIsNotBetweenMinLimit() {
        Model model = new Model();
        assertFalse(model.isValidValues(9, 9, 4));
    }

    @Test
    public void testIsBetweenMinLimit() {
        Model model = new Model();
        assertTrue(model.isValidValues(10, 10, 5));
    }

    @Test
    public void testIsBetweenMaxLimit() {
        Model model = new Model();
        assertTrue(model.isValidValues(300, 200, 150));
    }

    @Test
    public void testIsNotBetweenMaxLimit() {
        Model model = new Model();
        assertFalse(model.isValidValues(301, 201, 151));
    }

    @Test
    public void testIsBetweenNormalLimit() {
        Model model = new Model();
        assertTrue(model.isValidValues(170, 70, 25));
    }
}
