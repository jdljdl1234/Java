import java.util.Scanner;

/**
 * <p>Original authors Namita Singla, Robert Cohen</p>
 * <p>Modified by Bob Wilson, 08/19/2005</p>
 *
 * <p>The simple NIM game.<br>
 * There are 21 sticks in the pile. On each move, each user take turns picking
 * up 1, 2, or 3 sticks until there are no more sticks left.
 * The one who picks up the last stick loses.</p>
 */

public class SimpleNIM {
  private int sticksLeft = 21;
  private String player = "B";

  /**
   * Plays the game
   * @param args ignored
   */
  public static void main(String[] args) {

    // we can call a static method before/without instantiating an object
    welcome();

    // instantiate an object named pickUpSticks of class SimpleNIM
    SimpleNIM pickUpSticks = new SimpleNIM();

    // we can only call a non-static method via reference to an object name
    pickUpSticks.start();
  }

  /**
   * Displays the startup information banner.
   */
  private static void welcome() {
    System.out.println("WELCOME TO THE SIMPLE NIM GAME: 21 STICKS IN PILE");
  }

  /**
   * Starts and runs the game
   */
  public void start() {
    Scanner input = new Scanner(System.in);
    do {
      int picksticks = 0;
      boolean goodEntry = false;
      player = otherPlayer(player);
      do {
        System.out.print(
            "Player " + player +
            ": How many sticks do want to pick? (1, 2, or 3) ");
        picksticks = input.nextInt();
        if (validMove(picksticks)) {
          goodEntry = true;
        }
        else {
          System.out.println(
              sticksLeft - picksticks < 0
              ? "You can't pick "
              + picksticks
              + " sticks as only "
              + sticksLeft
              + " sticks left"
              : "That's an illegal move. "
              + "Choose 1, 2, or 3 sticks.");
        }
      }
      while (!goodEntry);

      updateSticksLeft(picksticks);
      System.out.println(
          "Player "
          + player
          + " takes "
          + picksticks
          + ( (picksticks == 1) ? " stick, " : " sticks, ")
          + "leaving "
          + sticksLeft
          + '\n');
    }
    while (gameOver() != true);
    System.out.println("Player " + otherPlayer(player) + " wins the game!");
  }

  /**
   * Update the number of sticks left in pile.
   * @param picksticks No. of sticks picked
   */
  private void updateSticksLeft(int picksticks) {
    sticksLeft = sticksLeft - picksticks;
  }

  /**
   * Game Over?
   * @return true if game is over.
   */
  private boolean gameOver() {
    // YOUR CODE GOES HERE
    
    if (sticksLeft == 0)
      return true;
    else return false;
  }

  /**
   * Returns the other player
   * @param p The current player ("B" or "A")
   * @return The other player ("A" or "B")
   */
  private String otherPlayer(String p) {
    // YOUR CODE GOES HERE

    if (p == "B")
      p = "A"; 
    else p = "B";
    
    return p;

    
  }

  /**
   * Valid move?
   * @param numSticks The number of sticks picked
   * @return true iff there are enough sticks left and numSticks is between 1 and 3
   */

  private boolean validMove(int numSticks) {
    // YOUR CODE GOES HERE
    
    // NOTE: Assumption is that user will not type a non integer or
    //  a very very large integer as I do not know how to test for
    //  these conditions yet.  
    
    if ((numSticks >= 1 && numSticks <= 3) && sticksLeft >= 3)
      return true;
      else return false;
  }
}