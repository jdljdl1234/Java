/**
 * Superclass for a SimpleNIM game player
 * @author Namita Singla, Robert Cohen
 */
abstract public class Player
    extends Thread {

  private Player next; // the other player
  private Player turn; // go if turn==this
  protected SimpleNIM game;
  private int pickSticks;

  /**
   * Constructor
   * @param game SimpleNIM game
   */
  public Player(SimpleNIM game) {
    this.game = game;
    turn = null;
    next = null;
  }

  /**
   * Sets the opponent
   * @param p the opponent
   */
  public synchronized void setNext(Player p) {
    next = p;
  }

  /**
   * Get the opponent
   * @return The opponent
   */
  public synchronized Player getNext() {
    return next;
  }

  /**
   * Has this player take their turn
   */
  public synchronized void turn() {
    turn = this;
    game.setCurrentPlayer(this);
    notifyAll();
  }

  /**
   * Has the player make a move
   */
  abstract public void makeMove();

  /**
   * Runs the thread for the player
   */
  public synchronized void run() {
    while (!game.gameOver(turn)) {
      while (turn != this) {
        try {
          // wait until it is your turn
          wait();
          // wake up from turn method
        }
        catch (InterruptedException ex) {
          return;
        }
      }
      if (game.gameOver(turn)) {
        break;
      }
      if (turn instanceof HumanPlayer) {
        game.displayMessage(
            "Sticks in the Pile: "
            + game.getSticksLeft()
            + ",    "
            + "Your turn");
      }
      else {
        game.displayMessage(
            "Sticks in the Pile: "
            + game.getSticksLeft()
            + ",    "
            + "My turn");
      }
      while (true) {
        turn.makeMove();
        if (game.validMove(pickSticks)) {
          game.pickSticks(pickSticks, this);
          game.updateSticksLeft(pickSticks);
          break;
        }
        else {
          game.displayMessage("Illegal move!");
        }
      }
      turn = null;
      next.turn();
    }
    if (turn instanceof HumanPlayer) {
      game.displayMessage("You won");
    }
    else {
      game.displayMessage("I won");
    }
  }

  /**
   * Pick up the specified number of sticks
   * @param sticks int
   */
  abstract public void pickSticks(int sticks);

  /**
   * Sets the number of sticks picked
   * @param noOfSticks The number of sticks picked
   */
  public void setPickSticks(int noOfSticks) {
    pickSticks = noOfSticks;
  }
}
