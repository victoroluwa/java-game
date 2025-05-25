import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Test Player");
        assertEquals("Test Player", player.getName());
    }
    
    @Test
    public void testStrategyAssignment() {
        Player player = new Player("Test Player");
        MoveStrategy strategy = new RandomStrategy();
        player.setStrategy(strategy);
        assertEquals(strategy, player.getStrategy());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMoveWithoutStrategy() {
        Player player = new Player("Test Player");
        player.makeMove(10);
    }
    
    @Test
    public void testMoveWithStrategy() {
        Player player = new Player("Test Player", new RandomStrategy());
        int move = player.makeMove(10);
        assertTrue(move >= 1 && move <= 2);
    }
}