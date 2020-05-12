package g54027.dev1.td11;

import org.junit.Test;
import static org.junit.Assert.*;

public class TableauUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void testMin_IsEmpty() {
        double[] tab = {};
        TableauUtil.min(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMin_IsNull() {
        double[] tab = null;
        TableauUtil.min(tab);
    }

    @Test
    public void testMin_OneValue() {
        double[] tab = {1};
        assertEquals(1, TableauUtil.min(tab), .001);
    }

    @Test
    public void testMin_AtBegin() {
        double[] tab = {-2, 2, 3};
        assertEquals(-2, TableauUtil.min(tab), .001);
    }

    @Test
    public void testMin_AtEnd() {
        double[] tab = {1, -10, 2, 3, -4, -100};
        assertEquals(-100, TableauUtil.min(tab), .001);
    }

    @Test
    public void testMin_InTab() {
        double[] tab = {10, 2, 1, 3};
        assertEquals(1, TableauUtil.min(tab), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax_IsEmpty() {
        double[] tab = {};
        TableauUtil.max(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax_IsNull() {
        double[] tab = null;
        TableauUtil.max(tab);
    }

    @Test
    public void testMax_OneValue() {
        double[] tab = {10};
        assertEquals(10, TableauUtil.max(tab), .001);
    }

    @Test
    public void testMax_AtBegin() {
        double[] tab = {10, 2, 3};
        assertEquals(10, TableauUtil.max(tab), .001);
    }

    @Test
    public void testMax_AtEnd() {
        double[] tab = {1, -10, 2, 3, -4, 100};
        assertEquals(100, TableauUtil.max(tab), .001);
    }

    @Test
    public void testMax_InTab() {
        double[] tab = {10, 21, 1, 3};
        assertEquals(21, TableauUtil.max(tab), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSum_IsEmpty() {
        double[] tab = {};
        TableauUtil.sum(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSum_IsNull() {
        double[] tab = null;
        TableauUtil.sum(tab);
    }

    @Test
    public void testSum_OneValue() {
        double[] tab = {10};
        assertEquals(10, TableauUtil.sum(tab), .001);
    }

    @Test
    public void testSum_EqualsZero() {
        double[] tab = {-10, 0, 10};
        assertEquals(0, TableauUtil.sum(tab), .001);
    }

    @Test
    public void testSum_NegativeAndPositive() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertEquals(17.3, TableauUtil.sum(tab), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_IsEmpty() {
        double[] tab = {};
        TableauUtil.average(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_IsNull() {
        double[] tab = null;
        TableauUtil.average(tab);
    }

    @Test
    public void testAverage_OneValue() {
        double[] tab = {10};
        assertEquals(10, TableauUtil.average(tab), .001);
    }

    @Test
    public void testAverage_EqualsZero() {
        double[] tab = {-10, 0, 10};
        assertEquals(0, TableauUtil.average(tab), .001);
    }

    @Test
    public void testAverage_NegativeAndPositive() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertEquals(2.471, TableauUtil.average(tab), .001);
    }

    @Test
    public void testAverage_NegativeValue() {
        double[] tab = {-2, -12};
        assertEquals(-7, TableauUtil.average(tab), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopy_IsNull() {
        double[] tab = null;
        TableauUtil.average(tab);
    }

    @Test
    public void testCopy_OneValue() {
        double[] tab = {10};
        double[] expectedTab = TableauUtil.copy(tab);

        assertArrayEquals(expectedTab, tab, .001);
    }

    @Test
    public void testCopy_MultipleValues() {
        double[] tab = {0, -10, 10, 20, 120};
        double[] expectedTab = TableauUtil.copy(tab);

        assertArrayEquals(expectedTab, tab, .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxIndex_IsEmpty() {
        double[] tab = {};
        TableauUtil.maxIndex(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxIndex_IsNull() {
        double[] tab = null;
        TableauUtil.maxIndex(tab);
    }

    @Test
    public void testMaxIndex_OneValue() {
        double[] tab = {10};
        assertEquals(0, TableauUtil.maxIndex(tab));
    }

    @Test
    public void testMaxIndex_NegativeAndPositive() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertEquals(0, TableauUtil.maxIndex(tab));
    }

    @Test
    public void testMaxIndex_NegativeValue() {
        double[] tab = {-2, -12};
        assertEquals(0, TableauUtil.maxIndex(tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSorted_IsEmpty() {
        double[] tab = {};
        TableauUtil.isSorted(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSorted_IsNull() {
        double[] tab = null;
        TableauUtil.isSorted(tab);
    }

    @Test
    public void testIsSorted_OneValue() {
        double[] tab = {10};
        assertTrue(TableauUtil.isSorted(tab));
    }

    @Test
    public void testIsSorted_FailInArray() {
        double[] tab = {-1, 0, 1, 5, 2, 6, 7};
        assertFalse(TableauUtil.isSorted(tab));
    }

    @Test
    public void testIsSorted_FailAtBegin() {
        double[] tab = {5, 4, 2};
        assertFalse(TableauUtil.isSorted(tab));
    }

    @Test
    public void testIsSorted_FailAtEnd() {
        double[] tab = {1, 2, 3, 0};
        assertFalse(TableauUtil.isSorted(tab));
    }

    @Test
    public void testIsSorted_NegativesAndPositivesValuesSorted() {
        double[] tab = {-4, -2, -1, 0, 1, 5, 20};
        assertTrue(TableauUtil.isSorted(tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOf_IsEmpty() {
        double[] tab = {};
        TableauUtil.indexOf(tab, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOf_IsNull() {
        double[] tab = null;
        TableauUtil.indexOf(tab, 1);
    }

    @Test
    public void testIndexOf_OneValue() {
        double[] tab = {10};
        assertEquals(0, TableauUtil.indexOf(tab, 10));
    }

    @Test
    public void testIndexOf_AtBegin() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertEquals(0, TableauUtil.indexOf(tab, 5));
    }

    @Test
    public void testIndexOf_AtEnd() {
        double[] tab = {-2, 4, -12};
        assertEquals(2, TableauUtil.indexOf(tab, -12));
    }

    @Test
    public void testIndexOf_AtCenter() {
        double[] tab = {-2, 4, 10, -12};
        assertEquals(2, TableauUtil.indexOf(tab, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsContent_IsEmpty() {
        String[] tab = {};
        assertFalse(TableauUtil.isContent(tab, ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsContent_IsNull() {
        String[] tab = null;
        assertFalse(TableauUtil.isContent(tab, ""));
    }

    @Test
    public void testIsContent_ContainsOneValue() {
        String[] tab = {"test"};
        assertTrue(TableauUtil.isContent(tab, "test"));
    }

    @Test
    public void testIsContent_ContainsAtBegin() {
        String[] tab = {"mot1", "mot2", "arbre", "mot4"};
        assertTrue(TableauUtil.isContent(tab, "mot1"));
    }

    @Test
    public void testIsContent_ContainsAtEnd() {
        String[] tab = {"mot1", "mot2", "arbre", "mot4"};
        assertTrue(TableauUtil.isContent(tab, "mot4"));
    }

    @Test
    public void testIsContent_ContainsAtCenter() {
        String[] tab = {"mot1", "mot2", "arbre", "mot4"};
        assertTrue(TableauUtil.isContent(tab, "arbre"));
    }

    @Test
    public void testIsContent_NotContains() {
        String[] tab = {"mot1", "mot2", "", "arbre", "mot4"};
        assertFalse(TableauUtil.isContent(tab, "arbremagique"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsContentMargin_IsEmpty() {
        double[] tab = {};
        assertFalse(TableauUtil.isContent(tab, 10, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsContentMargin_IsNull() {
        double[] tab = null;
        assertFalse(TableauUtil.isContent(tab, 10, 0));
    }

    @Test
    public void testIsContentMargin_ContainsOneValueNoMargin() {
        double[] tab = {5};
        assertTrue(TableauUtil.isContent(tab, 5, 0));
    }

    @Test
    public void testIsContentMargin_ContainsOneValueWithMargin() {
        double[] tab = {5};
        assertTrue(TableauUtil.isContent(tab, 3, 2));
    }

    @Test
    public void testIsContentMargin_ContainsAtBegin() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertTrue(TableauUtil.isContent(tab, 2, 3));
    }

    @Test
    public void testIsContentMargin_ContainsAtEnd() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertTrue(TableauUtil.isContent(tab, 4.8, 0));
    }

    @Test
    public void testIsContentMargin_ContainsAtCenter() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertTrue(TableauUtil.isContent(tab, 1, 0));
    }

    @Test
    public void testIsContentMargin_NotContains() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertFalse(TableauUtil.isContent(tab, 4.9, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsDuplicate_IsNull() {
        double[] tab = null;
        TableauUtil.isDuplicate(tab);
    }

    @Test
    public void testIsDuplicate_OneValue() {
        double[] tab = {10};
        assertFalse(TableauUtil.isDuplicate(tab));
    }

    @Test
    public void testIsDuplicate_NotDuplicate() {
        double[] tab = {5, -1, 0, 1, 3.5, 4, 4.8};
        assertFalse(TableauUtil.isDuplicate(tab));
    }

    @Test
    public void testIsDuplicate_DuplicateValue() {
        double[] tab = {4, -2, 0, -12, 4};
        assertTrue(TableauUtil.isDuplicate(tab));
    }

    @Test
    public void testIsDuplicate_MultipleDuplicateValues() {
        double[] tab = {-2, 4, 10, -12, 4, -2};
        assertTrue(TableauUtil.isDuplicate(tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountNegative_IsNull() {
        double[] tab = null;
        TableauUtil.countNegative(tab);
    }

    @Test
    public void testCountNegative_OneValuePositive() {
        double[] tab = {10};
        assertEquals(0, TableauUtil.countNegative(tab));
    }

    @Test
    public void testCountNegative_OneValueNegative() {
        double[] tab = {-10};
        assertEquals(1, TableauUtil.countNegative(tab));
    }

    @Test
    public void testCountNegative_MultipleNegativesValues() {
        double[] tab = {-5, 1, 0, 1, -3.5, 4, -4.8};
        assertEquals(3, TableauUtil.countNegative(tab));
    }

    @Test
    public void testCountNegative_OnlyPositivesValues() {
        double[] tab = {4, 2, 0, 12, 4};
        assertEquals(0, TableauUtil.countNegative(tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapValue_IsNull() {
        double[] tab = null;
        TableauUtil.swapValue(tab, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapValue_IsFirstIndexOutBounds() {
        double[] tab = {1, 2, 3};
        TableauUtil.swapValue(tab, 100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapValue_IsSecondIndexOutBounds() {
        double[] tab = {1, 2, 3};
        TableauUtil.swapValue(tab, 0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapValue_IsNegativeFirstIndex() {
        double[] tab = {1, 2, 3};
        TableauUtil.swapValue(tab, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapValue_IsNegativeSecondIndex() {
        double[] tab = {1, 2, 3};
        TableauUtil.swapValue(tab, 0, -1);
    }

    @Test
    public void testSwapValue_SameIndex() {
        double[] tab = {1, 2, 3, 4};
        TableauUtil.swapValue(tab, 1, 1);
        double[] finalTab = {1, 2, 3, 4};

        assertArrayEquals(finalTab, tab, .001);
    }

    @Test
    public void testSwapValue_DifferentsIndex() {
        double[] tab = {-1, 2, 3, 4};
        TableauUtil.swapValue(tab, 0, 3);
        double[] finalTab = {4, 2, 3, -1};

        assertArrayEquals(finalTab, tab, .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverse_IsNull() {
        double[] tab = null;
        TableauUtil.reverse(tab);
    }

    @Test
    public void testReverse_ImperValues() {
        double[] tab = {-1, 2.5, 3};
        TableauUtil.reverse(tab);
        double[] finalTab = {3, 2.5, -1};

        assertArrayEquals(finalTab, tab, .001);
    }

    @Test
    public void testReverse_PerValues() {
        double[] tab = {-1, 2.5, 3, -20};
        TableauUtil.reverse(tab);
        double[] finalTab = {-20, 3, 2.5, -1};

        assertArrayEquals(finalTab, tab, .001);
    }

    @Test
    public void testReverse_OneValue() {
        double[] tab = {-20.2};
        TableauUtil.reverse(tab);
        double[] finalTab = {-20.2};

        assertArrayEquals(finalTab, tab, .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinIndexes_IsEmpty() {
        double[] tab = {};
        TableauUtil.minIndexes(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinIndexes_IsNull() {
        double[] tab = null;
        TableauUtil.minIndexes(tab);
    }

    @Test
    public void testMinIndexes_OneIndex() {
        double[] tab = {1};
        int[] tabResult = {0};

        assertArrayEquals(tabResult, TableauUtil.minIndexes(tab));
    }

    @Test
    public void testMinIndexes_MultipeIndexMinimal() {
        double[] tab = {1, 10, 1, 20, 1};
        int[] tabResult = {0, 2, 4};

        assertArrayEquals(tabResult, TableauUtil.minIndexes(tab));
    }
}
