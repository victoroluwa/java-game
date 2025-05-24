import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomStrategyTest {
    @Test
    void testRandomMoveIsValid() {
        RandomStrategy strategy = new RandomStrategy();
        for (int i = 0; i < 100; i++) {
            int move = strategy.NextMove();
            assertTrue(move >= 1 && move <= 2, "Move should be 1 or 2");
        }
    }
}