import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NimGameTest {
    private NimGame game;
    private Player human;
    private Player computer;
    
    @Before
    public void setUp() {
        human = new Player("Human", new HumanUserStrategy());
        computer = new Player("Computer", new SmartStrategy());
        game = new NimGame(human, computer);
    }
    
    @Test
    public void testGameInitialization() {
        assertEquals(10, game.getMarbleSize());
        assertTrue(game.isHumanTurn());
    }
    
    @Test
    public void testMoveValidation() {
        game.assignMove(1);
        assertEquals(9, game.getMarbleSize());
        game.assignMove(2);
        assertEquals(7, game.getMarbleSize());
    }
    
    @Test
    public void testComputerStrategy() {
        SmartStrategy strategy = new SmartStrategy();
        assertEquals(2, strategy.nextMove(5));
        assertEquals(1, strategy.nextMove(4));
    }
    
    @Test
    public void testGameState() {
        assertTrue(game.isHumanTurn());
        game.assignMove(1);
        assertFalse(game.isHumanTurn());
    }
    
    @Test
    public void testUndoFunctionality() {
        game.assignMove(2);
        game.undoLastMove();
        assertEquals(10, game.getMarbleSize());
        assertTrue(game.isHumanTurn());
    }
    
    @Test
    public void testSaveAndLoad() {
        game.assignMove(2);
        game.saveGame();
        game.assignMove(1);
        game.loadGame();
        assertEquals(8, game.getMarbleSize());
    }
    
    @Test
    public void testWinCondition() {
        while (game.getMarbleSize() > 1) {
            game.assignMove(1);
        }
        game.assignMove(1);
        assertTrue(game.checkWinner());
    }
    
    @Test
    public void testObserverPattern() {
        TestObserver observer = new TestObserver();
        game.addObserver(observer);
        game.assignMove(1);
        assertTrue(observer.wasUpdated());
    }
    
    @Test
    public void testResetGame() {
        game.assignMove(2);
        game.resetGame();
        assertEquals(10, game.getMarbleSize());
    }
    
    @Test
    public void testStrategySwitch() {
        MoveStrategy newStrategy = new RandomStrategy();
        human.setStrategy(newStrategy);
        assertEquals(newStrategy, human.getStrategy());
    }
    
    private class TestObserver implements GameObserver {
        private boolean updated = false;
        
        @Override
        public void update() {
            updated = true;
        }
        
        public boolean wasUpdated() {
            return updated;
        }
    }
}