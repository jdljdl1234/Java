// James Lantos, CS110, Project 2, March 30, 2013, Histogram.java

/**
 * <p>Title: Histogram</p>
 *
 * <p>Description: Histogram Drawing Class</p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: UMB</p>
 *
 * @author Bob Wilson
 * @version 1.0
 */

public class Histogram 
{
  private int [] values;
  private int minIndex;
  private int maxIndex;
  private int maxLength;
  
  
  
  /** constructor for histogram drawing class
    * @param values the array of integer values to draw
    * @param minIndex the lowest index in the array for the range to draw
    * @param maxIndex the highest index in the array for the range to draw
    * @param maxLength the length of line to draw for the largest value
    */
  
  public Histogram(int [] values, int minIndex, int maxIndex, int maxLength) 
  {
    // initialize the values of the instance variables from the constructor parameters
    this.values = new int [maxIndex +1];   // allocate memory for a copy of the values array
    this.minIndex = minIndex;
    this.maxIndex = maxIndex;
    this.maxLength = maxLength;
    
    // step 6: 
    // find largest number in values array for scaling length of bars
    
    int largest=0;
    for (int i=0; i<this.maxIndex; i++) 
      if (values[i] > largest)
      largest = values[i];
    
    
    
    
    // step 7:
    // copy data from values array to this.values array while scaling to maximum length of bars
    
    
    
    
    for (int i=0; i<this.maxIndex; i++)
      this.values[i] = (values[i] * this.maxLength / largest);
    
    
  }  // end constructor
  
  /** draw a horizontal bar graph
    */
  
  public void drawHor()
    
  {
    // step 8:
    // draw horizontal bar graph (one line per roll value)
    
    
    
    for (int a = 0; a<=this.maxIndex; a++) {
      System.out.print("Heads Count " + a + ":" + "\t"); 
      
      for (int b=1; b<=this.values[a]; b++) 
        System.out.print("*");
      
      System.out.println(" " + this.values[a]);
    }
    
  } // end drawHor 
  
  /** draw a vertical bar graph
    */
  
  public void drawVer()
    
    
    // step 9:
    // draw vertical bar graph (one column per roll value)
  {
    
    
    for (int a=this.maxLength; a>0; a--) {
      System.out.printf("Count" + (a<10 ? "   " + a :
                                  (a<100?  "  " + a :
                                  (a<1000?  " " + a : 
                                     a ))) + " \t"); 
                         
                        for (int b=this.minIndex; b<=this.maxIndex; b++) {
                          System.out.print(this.values[b] >= a ? " * " : "   ");  
                        }  
                        System.out.println(""); 
                        }
    System.out.printf("\t");
    for (int c=this.minIndex; c<=this.maxIndex; c++) 
      System.out.print(" " + c + " ");
    
    }
  
  
}/*201020*/
