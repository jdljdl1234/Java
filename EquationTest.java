/** EquationTest.java JUnit TestCase for Equation Class
 * @author Bob Wilson
 * @version 01/28/2011
 *
 * <p>CS110 Project 3 test cases</p>
 */

import junit.framework.TestCase;

public class EquationTest extends TestCase
{
  // test cases for a single equation object
  
  public void testSingleEquation()
  {
    Equation uut = new Equation( 1, 1, 1);
    assertEquals(-1.0, uut.slope(), Equation.THRESHHOLD);
    assertEquals( 1.0, uut.intercept(), Equation.THRESHHOLD);
    assertEquals("1x +1y = 1", uut.toString());
    
    uut = new Equation( 1, -1, 4);
    assertEquals( 1.0, uut.slope(), Equation.THRESHHOLD);
    assertEquals(-4.0, uut.intercept(), Equation.THRESHHOLD);
    assertEquals("1x -1y = 4", uut.toString());
    
    uut = new Equation(-1, 2, -1);
    assertEquals( 0.5, uut.slope(), Equation.THRESHHOLD);
    assertEquals(-0.5, uut.intercept(), Equation.THRESHHOLD);
    assertEquals("-1x +2y = -1", uut.toString());
    
    try {
      uut = new Equation(1, 0, 1);
      assertEquals(0.0, uut.slope(), Equation.THRESHHOLD);  // exception should occur
      assertTrue(false);           // should not execute this
    }
    catch (ArithmeticException e) {
      // exception is expected
      assertTrue(e.toString().contains("Infinite Slope"));
    }
    
    try {
      uut = new Equation(1, 0, 1);
      assertEquals(0.0, uut.intercept(), Equation.THRESHHOLD);  // exception should occur
      assertTrue(false);           // should not execute this
    }
    catch (ArithmeticException e) {
      // exception is expected
      assertTrue(e.toString().contains("No Unique Intercept"));
    }
  }
  
  // test cases for solving pairs of equations for x and y
  
  public void testSolvingPairs()
  {
    try {
      Equation uut1 = new Equation(1,  1, 4);
      Equation uut2 = new Equation(1, -1, 2);
      assertEquals(3.0, uut1.solveForXWith(uut2), Equation.THRESHHOLD);
      assertEquals(1.0, uut1.solveForYWith(uut2), Equation.THRESHHOLD);
      assertEquals(3.0, uut2.solveForXWith(uut1), Equation.THRESHHOLD);
      assertEquals(1.0, uut2.solveForYWith(uut1), Equation.THRESHHOLD);
      assertTrue(uut1.verifySolution(3.0, 1.0));
      assertTrue(uut2.verifySolution(3.0, 1.0));
    }
    catch (ArithmeticException e) {
      // no exception expected
      assertTrue(false);           // should not execute this
    }
    
    try {
      Equation uut1 = new Equation(1, 1, 1);
      Equation uut2 = new Equation(2, 2, 2);
      assertEquals(0.0, uut1.solveForXWith(uut2), Equation.THRESHHOLD);
      assertTrue(false);           // should not execute this
    }
    catch (ArithmeticException e) {
      // exception is expected
      assertTrue(e.toString().contains("Parallel Lines"));
    }
    
    try {
      Equation uut1 = new Equation(1, 1, 1);
      Equation uut2 = new Equation(1, 1, 3);
      assertEquals(0.0, uut1.solveForYWith(uut2), Equation.THRESHHOLD);
      assertTrue(false);           // should not execute this
    }
    catch (ArithmeticException e) {
      // exception is expected
      assertTrue(e.toString().contains("Inconsistent Equations"));
    }
  }
  
  // test cases for implementing interface Comparable
  
  public void testComparability()
  {
    Comparable<Equation> uut1 = new Equation(1, 1, 1);
    Equation uut2 = new Equation(-1, 1, 1);
    assertEquals(-1, uut1.compareTo(uut2));
    assertEquals( 0, uut2.compareTo(uut2));
    assertEquals(+1, uut2.compareTo( (Equation) uut1));  // cast uut1 back to what it was born as
  }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             