// Lab 4, March 21, 2013; CS 110
// James Lantos

import java.util.Scanner;

// CLI: Newton's Method to find roots for an unknown function in class Function

public class Newton
{
  public static void main(String [] args)
  {
    final double THRESHOLD = 0.000001;
    final int MAX_ITERATIONS = 10;
    
    Scanner scan = new Scanner(System.in);
    Function unknown = new Function();
    int i = 0;                   // number of iterations
    
    System.out.println("Enter an initial guess for a root:");
    while (!scan.hasNextDouble())
      scan.next();
    double guess = scan.nextDouble();
    
    while(Math.abs(unknown.f(guess)) > THRESHOLD && (unknown.fprime(guess)) != 0) {
      
      // you need to add your code here
      if (i>=MAX_ITERATIONS) {
        System.out.println("You have reached the maximum iterations! Quitting...");
        break;  
      } // end if
      
      guess = guess - unknown.f(guess)/unknown.fprime(guess);
      i++;
      System.out.println("Root is: " + guess + " after " + i + " iterations.");        
    } // end while
    if (unknown.fprime(guess) == 0) {
      System.out.println("Loop terminated on fprime equals 0! Quitting...");
    } // end if
    } // end main 
} // end public class Newton


