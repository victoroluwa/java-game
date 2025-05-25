import java.util.Random;

public class RandomStrategy implements MoveStrategy {
    private Random random = new Random();

    @Override
    public int nextMove(int marblesLeft) {
        // Ensure not to remove more than available
        return marblesLeft == 1 ? 1 : random.nextInt(2) + 1;
    }
   
}
