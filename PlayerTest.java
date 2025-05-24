import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void testPlayerCreation() {
        Player human = new Player("Human");
        assertEquals("Human", human.getName());
        assertNull(human.getStrategy());

        MoveStrategy strategy = new RandomStrategy();
        Player computer = new Player("Computer", strategy);
        assertEquals("Computer", computer.getName());
        assertNotNull(computer.getStrategy());
    }

    @Test
    void testStrategyChange() {
        Player player = new Player("Test");
        assertNull(player.getStrategy());
        
        MoveStrategy strategy = new RandomStrategy();
        player.setStrategy(strategy);
        assertNotNull(player.getStrategy());
    }
}