// James Lantos, CS110, Project 2, March 30, 2013, CoinToss.java

/**
 * <p>Title: Histogram</p>
 *
 * <p>Description: Coin Toss with histogram of results</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: UMB</p>
 *
 * @author Bob Wilson
 * @version 1.0 Feb 16, 2007
 */

import java.util.Scanner;

public class CoinToss {
  
  private static final int MIN_HEADS = 0;   // minimum number of heads per set
  
  
  /**
   * main method:
   * ask the user how many sets of coin flips and how many flips per set
   * count occurances of heads in user specified number of sets of coin flips
   * draw a horizontal and vertical histogram of the number of heads
   */
  public static void main(String[] args) {
    
    // set up to get user input
    Scanner scan = new Scanner(System.in);
    
    // ask user for the number of sets of coin flips
    System.out.println("How many sets of coin flips do you want?");
    int nSets = scan.nextInt();
    
    // ask user for the number of coin flips per set 
    System.out.println("How many coin flips per set do you want?");
    int nFlips = scan.nextInt();
    
    // maximum number of heads that can occur is number of flips
    int maxHeads = nFlips;      
    
    // calculate maximum length of histogram bars based on number of flips per set
    // based on finding the number of combinations for half heads / half tails
    //                n!
    // formula is -----------  with r = n/2
    //             r! (n-r)!
    
    int maxLength = factorial (nFlips) / 
      (factorial (nFlips / 2) * factorial (nFlips - nFlips / 2));
    
    // instantiate a coin object named myCoin
    Coin myCoin = new Coin();
    
    // step 1:
    // declare an int array named "counts" to count coin flip occurences
    // make its size one larger than maxHeads
    
    int[] counts = new int[maxHeads + 1];
    
    // step 2:
    // initialize all of the values in the array to 0
    
    counts[0] = MIN_HEADS;
    for(int i=MIN_HEADS; i<=maxHeads; i++)
      counts[i] = 0;
    
    // step 3:
    // flip the coin for nSets with nFlips flips per set
    // count the number of heads in each set (heads = 1, tails = 0)
    
    for (int i=0; i<nSets; i++) {
    int headscnt =0;      
      for (int j=1; j<nFlips; j++)
        headscnt += (myCoin.flip()? 1:0);
      
      counts[headscnt]++;    

    }
    
    
    
    
    
    // step 4:
    // print out the estimated probabilities of all heads and all tails
    
    
    System.out.println("All heads:" + (float) counts[maxHeads] / nSets);
    
    Histogram myHist = new Histogram(counts, MIN_HEADS, maxHeads, maxLength);
    
    myHist.drawHor();
    System.out.println(""); 
    myHist.drawVer();
    
  }
  
  
  // function to calculate factorial of n
  public static int factorial(int n)
  {
    int factorial = 1;
    
    // write the code for a loop to calculate factorial of n here
    
    for (int i=1; i <=n; i++)
      factorial *= i;
    
    return factorial;
  } 
  /*201020*/
}