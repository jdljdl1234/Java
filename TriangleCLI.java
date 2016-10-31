/*
 * @(#)TriangleCLI.java 1.0
 *
 *
 * Command Line Interface for triangle solver
 * Bob Wilson
 * 01/05/12
 *
 */

import java.util.Scanner;

public class TriangleCLI {
  public static void main(String[] arg) {
    // sides of the triangle
    int a = 0;           
    int b = 0;
    int c = 0;

    // instantiate our scan object of Scanner class
    Scanner scan = new Scanner(System.in);

    // get the coefficients and solve for the roots of a quadratic equation
    System.out.println(
        "Enter three sides for triangle to be solved");

    do {
    System.out.println("Enter side a:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the first side as an integer
    a = scan.nextInt();

    System.out.println("Enter side b:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the second side as an integer
    b = scan.nextInt();

    System.out.println("Enter side c:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the third side as an integer
    c = scan.nextInt();

    // use the solver to print the triangle and its solution
    // System.out.println(TriangleSolver.getEquation(a, b, c));
    System.out.println(TriangleSolver.getSolution(a, b, c));
    
    // ask the user about solving another equation
    System.out.println("Do you want to solve another triangle (y or n)?:");
    }
    while(scan.next().equals("y"));
  }
}
