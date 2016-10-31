/** 
 * Application.java
 */

// import java.util.*;
import java.util.Arrays;

public class Application  {
  
  public static void main (String[] args) {
  
    Equation [] equationArray = new Equation [5];

     // 1. Create Equation objects by calling the Equation constructor with three 
    // coefficients as arguments, for example:
    // create an Equation object to represent: 2x + 3y = 6

    equationArray [0] = new Equation(1, 2, 3);
    equationArray [1] = new Equation(-2, 10, 0);
    equationArray [2] = new Equation(1, 5, 2);
    equationArray [3] = new Equation(-4, 1, 7);
    equationArray [4] = new Equation(1, 10, 0);
    
    // 5. Solve a pair of Equations and verify the solution, for example:
    // solve a pair of Equations for X (or Y)
      
     double x = equationArray[0].solveForXWith(equationArray[1]);
     double y = equationArray[0].solveForYWith(equationArray[1]);
     boolean validSolution = equationArray[0].verifySolution(x,y);
     
     System.out.println("x=" + x + ", y=" + y + "Valid Solution: " + validSolution);
     
     System.out.println("Before Sorting:");
     
     for (int i=0; i < equationArray.length; i++) {
       
     System.out.println(equationArray[i].toString() + " : " + equationArray[i].slope());
       
     }
     
     Arrays.sort(equationArray);
     System.out.println();
     System.out.println("After Sorting:");
     
     for (int i=0; i < equationArray.length; i++) {
       
     System.out.println(equationArray[i].toString() + " : " + equationArray[i].slope());
       
     }
     
       
  }
}
 