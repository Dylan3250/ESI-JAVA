package g54027.humbug.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * @authors Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class LevelTest {

    @Test
    public void testLevel_BoundMaxLevelNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Level.getLevel(101);
        });
    }

    @Test
    public void testLevel_BoundMinLevelNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Level.getLevel(0);
        });
    }
}
