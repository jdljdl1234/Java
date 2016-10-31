/**
 * Represents a human Player.
 * @author Namita Singla, Robert Cohen
 */
public class HumanPlayer
    extends Player {

  /**
   * Constructor
   * @param game The game the player is playing
   */
  public HumanPlayer(SimpleNIM game) {
    super(game);
  }

  /**
   * Make a move
   */
  synchronized public void makeMove() {
    // Simply wait for the human player to choose a move
    try {
      wait();
    }
    catch (InterruptedException e) {
    }
  }

  /**
   * Pick a specified number of sticks
   * @param noOfSticks The number of Sticks
   */
  synchronized public void pickSticks(int noOfSticks) {
    setPickSticks(noOfSticks);
    notifyAll();
  }

}
