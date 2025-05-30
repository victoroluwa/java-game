public class Player {
    private String name;
    private MoveStrategy strategy;

    public Player(String name) {
        this.name = name;
        this.strategy = null;
    }

    public Player(String name, MoveStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public int makeMove(int marblesLeft) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy set for player");
        }
        return strategy.nextMove(marblesLeft);
    }

    public String getName() {
        return name;
    }

    public MoveStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
}