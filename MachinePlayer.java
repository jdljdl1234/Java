/**
 * Represents a computer Player.
 * @author Namita Singla, Robert Cohen
 */
public class MachinePlayer
    extends Player {

  public MachinePlayer(SimpleNIM game) {
    super(game);
  }

  /**
   * Make a move
   */
  public synchronized void makeMove() {
    try {
      Thread.sleep(1000); // wait a sec so it looks like the comp is thinking
    }
    catch (InterruptedException e) {
    }
    NIMStrategy strategy = new NIMStrategy();
    pickSticks(strategy.bestMove(this, game)); //Make the best move possible
  }

  /**
   * Pick the sticks and notify all
   * @param noOfSticks The number of Sticks
   */
  synchronized public void pickSticks(int noOfSticks) {
    setPickSticks(noOfSticks);
  }
}
