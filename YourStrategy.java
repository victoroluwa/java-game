public class YourStrategy implements MoveStrategy {
    @Override
    public int nextMove(int marblesLeft) {
        // Winning strategy for 1-2 Nim:
        // Try to leave opponent with a multiple of 3 marbles
        if (marblesLeft <= 0) return 0;
        
        switch (marblesLeft % 3) {
            case 0: // If multiple of 3, take 1 to force opponent into losing position
                return 1;
            case 1: // If remainder 1, take 1 to leave multiple of 3
                return 1;
            case 2: // If remainder 2, take 2 to leave multiple of 3
                return 2;
            default:
                return 1; // Shouldn't happen, but safe default
        }
    }
}