import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NimGameTest {
    private NimGame game;
    private Player humanPlayer;
    private Player computerPlayer;

    @BeforeEach
    void setUp() {
        humanPlayer = new Player("Human", new HumanUserStrategy());
        computerPlayer = new Player("Computer", new RandomStrategy());
        game = new NimGame(humanPlayer, computerPlayer);
    }

    @Test
    void testInitialGameState() {
        assertEquals(10, game.getMarbleSize());
        assertTrue(game.isHumanTurn());
        assertEquals("Human", game.getHumanPlayer().getName());
        assertEquals("Computer", game.getComputerPlayer().getName());
    }

    @Test
    void testAssignMove() {
        game.assignMove(2);
        assertEquals(8, game.getMarbleSize());
        assertFalse(game.isHumanTurn());
    }

    @Test
    void testCheckWinner() {
        assertFalse(game.checkWinner());
        game.assignMove(8);
        game.assignMove(2);
        assertTrue(game.checkWinner());
    }
}