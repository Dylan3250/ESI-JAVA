package g54027.dev1.td10;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonMathTest {

    @Test
    public void testAbs_PositivesValuesSoSame() {
        assertEquals(6.0, MonMath.abs(6.0), 0.0);
    }

    @Test
    public void testAbs_NegativesValuesSoInversed() {
        assertEquals(4.0, MonMath.abs(-4.0), 0.0);
    }

    @Test
    public void testAbs_ValueIsZero() {
        assertEquals(0.0, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPerimetre_RayonIsNegatif() {
        MonMath.perimetre(-5);
    }
    
    public void testPerimetre_RayonIsZero(){
        assertEquals(0.0, MonMath.perimetre(0.0), 0.01);
    }
    
    public void testPerimetre_RayonIsPositif(){
        assertEquals(25.12, MonMath.perimetre(4.0), 0.01);
    }

}
