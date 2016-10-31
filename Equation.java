/**
 *  javadoc
 */

import java.lang.Comparable;

public class Equation implements Comparable<Equation>  {
  
  public static final double THRESHHOLD = .001;
  int a, b, c;
  
  /**
   * Description: Initializes the coefficients
   *              a, b, and c, from the supplied parameters.
   * @param a     coefficient of x in the equation
   * @param b     coefficient of y in the equation
   * @param c     value of c in the equation
   */
  
  // constructor
  
  public Equation (int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  
  /**
   * Description: calculates and returns a String representing an equation
   * in ax + by = c format.
   * 
   * @return String returns the formatted equation
   */
  
  // The String returned to represent an equation is a properly sequenced 
  // concatenation of the coefficients, and a couple of string literals
  // Study the tests of the toString method in the JUnit TestCase code to
  // determine the proper concatenation sequence
  
  public String toString() {
    String result = null;
    result = this.a + "x " + ((this.b >=0) ? "+" : "") + this.b + "y = " + this.c;
    return result;
   }
   
  /**
   * Description: Returns the slope of a line.
   * The slope of the line reprsented by the equation is calculated and 
   * returned as the negative of the coefficient a devided by the coefficient b.
   * However, if the coefficient b is equal to zero, the slope is infinite (devide by zero) 
   * and the code throws and ArithmeticException with the text "Infinite slope".
   * 
   * @return double    returns slope
   */
   
   
    public double slope() {
     double slope = 0.0;
    
      if(this.b == 0){
        throw new ArithmeticException("Infinite Slope");
      }
      else 
        slope = (double) -1*this.a/ (double) this.b ;
      return slope;
    }          
    
    /** 
     * Description: Calculates the intercept of the line represented by the equation.
     * @throws throws   an ArithmeticException with the text "No Unique Intercept".
     * @return double   returns the y intercept
     */
    
    // The intercept of the line represented by the equation is the value of y where it 
    // crosses the y axis (x = 0).  It is calculated by dividing the coefficient c by 
    // the coefficient b.  If the coefficient b is equal to zero, there is no unique 
    // value for the intercept (divide by zero) and your code should throw an 
    // ArithmeticException with the text “No Unique Intercept”.  
    
    public double intercept() throws ArithmeticException {
      double intercept = 0.0;
      
      if(this.b == 0){
        throw new ArithmeticException("No Unique Intercept");
      }
      else
        intercept = 1.0*this.c/this.b;
      return intercept;
    }
    
    
    /**
     * Description: Compares the slopes of two linear equations
     * @param that       Equation object to be compared to the Equation objects
     *                   calling the method
     * @return int       Returns zero if the slopes are equal, i.e. the absolute value
     *                   of the difference in slopes is less than THRESHHOLD, minus one if
     *                   the slope of "this" is smaller than slope of "that", and plus
     *                   one if the slope of "this" is larger than the slope of "that".
     */
    
    public int compareTo(Equation that) {
      
      int result;
      
      if ((Math.abs(this.slope()-that.slope()))<THRESHHOLD){
        result = 0;
      }
      else if (this.slope() < that.slope()){
        result = -1;
      }
      else {
        result = 1;
      }
      return result;
    } 
    
      /** 
       * Solves for x with pairs of equations.
       * 
       * @param that     Equation object used in method
       * 
       * @return double  Returns x
       */
      
      
      // Calculate the value of X or Y for a pair of equations, as follows:
      // Calculate the denominator for either expression as:
      
      // double denominator;
      // double numeratorx;
      
      // denominator = (a.this * b.that) - (a.that * b.this);
      
      // Calculate the appropriate numerator to solve for X as:
      
      // numeratorx = (b.that * c.this) - (b.this * c.that);
      
      // Check for the ArithmeticException cases and either throw an exception with the 
      // appropriate text or return the result of the division.
      
      
      public double solveForXWith(Equation that)  {
        //throws ArithmeticException;
        double x=0;
        double denominatorx;
        double numeratorx;
        
        denominatorx = (this.a*that.b) - (that.a*this.b);
        numeratorx = (that.b*this.c) - (this.b*that.c);
        
        if (numeratorx == 0 && denominatorx == 0) {
          throw new ArithmeticException("Parallel Lines");
        }
        else if (denominatorx == 0){
          throw new ArithmeticException("Inconsistent Equations");
        }
        else x = numeratorx/denominatorx;
        return x;
      }
      
      /** 
       * Solves for y with pairs of equations.
       * 
       * @param that     Equation object used in method
       * 
       * @return double  Returns y
       */
      
      
      public double solveForYWith(Equation that) throws ArithmeticException {
        double y = 0.0;
        double denominatorY;
        double numeratorY;
        
        denominatorY = (this.a*that.b) - (that.a*this.b);
        numeratorY = (this.a*that.c) - (that.a*this.c);
        
        if (numeratorY == 0 && denominatorY == 0) {
          throw new ArithmeticException("Parallel Lines");
        }
        else if (denominatorY == 0){
          throw new ArithmeticException("Inconsistent Equations");
        }
        else 
          y = numeratorY/denominatorY;
        return y;
      } //
      
      /**
       * * Description: verifies that the equality in the equation is correct with the provided
       * x and y
       * parameter values
       * @param x              x value of equation to be verified
       * @param y              y value of equation to be verified
       * @return boolean       returns a value of true if the solution is correct and false otherwise
       */
      
      public boolean verifySolution(double x, double y) {
        
        if ((this.a*x + this.b*y) == (this.c))
          return true;
        else
          return false;
        
      } //
      
    } // 