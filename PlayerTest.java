import junit.framework.TestCase;

/**
 * @author Namita Singla
 *
 * This class tests the methods of Player.java
 */
public class PlayerTest
    extends TestCase {

  Player p1, p2;

  /**
   * Constructor for PlayerTest.
   *
   * @param arg0
   */
  public PlayerTest(String arg0) {
    super(arg0);
  }

  protected void setUp() throws Exception {
    super.setUp();
    Game game = new Game();
    p1 = new MachinePlayer(1, game);
    p2 = new HumanPlayer(2, game);
    p1.setNext(p2);
    p2.setNext(p1);
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test getId() method of Player class
   */
  public void testGetIdMethod() {
    assertEquals(p1.getId(), 1);
    assertEquals(p2.getId(), 2);
  }

  /**
   * Test getNext() method of Player class
   */
  public void testGetNextMethod() {
    assertEquals(p1.getNext(), p2);
    assertEquals(p2.getNext(), p1);
  }

  /**
   * Test getScore() and setScore(int) methods of Player class
   */
  public void testSetAndGetScoreMethods() {
    p1.setScore(10);
    assertEquals(p1.getScore(), 10);
  }

}
