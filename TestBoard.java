import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TestBoard extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testinRange() {
    
    Board range = new Board(5,5);
    
       
 //   boolean result = true;
 //   boolean actualrxc = range.inRange(4,4);
    assertTrue(range.inRange(4,4));
    
 
  }
  
}
