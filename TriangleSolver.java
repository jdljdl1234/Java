/*
 * @(#)TriangleSolver.java 1.0
 *
 *
 * Triangle solver class
 * Bob Wilson
 * 01/05/12
 *
 */

 // James Lantos, CS110, Project 1 									

public class TriangleSolver {

  public static String getSolution(int a, int b, int c) {
  
    String result = null;
    double s1, s2, s3; 
    
    // Write your code here to assign the appropriate value to the String result
    // based on the values of the supplied parameters a, b, and c.

    // A. Initial Checks
    //    1. Test for invalid sides (eg, <= 0)
    //    2. Test for one side greater than sum of other two sides
    // B. Where values satisfy pythag thrm, test for 4 cases:
    //    1. All three values same = equalateral
    //    2. Two of three values are same = isosceles
    //    3. Pythagorean theorem (a2+b2=c2) = right triangle
    //    4. None of above = Scalene
    
    // Case A1 
    if  ((a<=0) || (b<=0) || (c<=0)) {
      result = "One side is either less than zero or negative! Not a triangle!";
    } 
    // Case A2
    else {
        if  (a>(b+c) || b>(a+c) || c>(a+b)) {
        result = "One side is greater than the sum of the other two! Not a triangle!";
        }
        else  {
           if ((a==b) && (b==c) && (a==c)) {  // Case B1 
            result = "All sides are equal: equalateral triangle";
           }
           else { 
             if ((a==b) || (b==c) || (a==c)) { // Case B2
             result = "Two sides are equal: isoceles triangle!";
             }
             else {  // Case B3
               s1 = Math.pow(a,2); 
               s2 = Math.pow(b,2);
               s3 = Math.pow(c,2);
               if (((s1+s2)==s3) || ((s1+s3)==s2) || ((s2+s3)==s1)) {
               result = "Pythagorean Right Triangle!";
               }
               else {                // Case B4
                 if  (!(a==b) && !(b==c) && !(a==c)) 
                 result = "No sides are equal: scalene triangle!";
               }
             }
           }
        }
    }
    return result;
}
}
