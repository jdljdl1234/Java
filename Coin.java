//********************************************************************
//  Coin.java       Author: Bob Wilson
//
//  Represents one coin with two faces: head and tails
//
//********************************************************************

// James Lantos, CS110, Project 2, March 30, 2013, Coin.java

public class Coin
{
   private boolean faceValue;  // current value showing on the coin

   //-----------------------------------------------------------------
   //  Constructor: Sets the initial face value.
   //-----------------------------------------------------------------
   public Coin()  // constructor
   {
      faceValue = false;  // arbitrarily tails by default
   }

   //-----------------------------------------------------------------
   //  Rolls the die and returns the result.
   //-----------------------------------------------------------------
   public boolean flip()
   {
     faceValue = Math.random() >= 0.5? true : false;
      return faceValue;
   }

   //-----------------------------------------------------------------
   //  Face value mutator.
   //-----------------------------------------------------------------
   public void setFaceValue (boolean value)
   {
      faceValue = value;
   }

   //-----------------------------------------------------------------
   //  Face value accessor.
   //-----------------------------------------------------------------
   public boolean getFaceValue()
   {
      return faceValue;
   }

   //-----------------------------------------------------------------
   //  Returns a string representation of this die.
   //-----------------------------------------------------------------
   public String toString()
   {
     return faceValue? "Heads" : "Tails";
   }
}
