// Exercise 18.12: CookingTime.java
// Represents time data and contains get and set methods.

public class CookingTime
{
   // integers for storing minutes and seconds
   private int minute;
   private int second;
   
   // CookingTime constructor, minute and second supplied
   public CookingTime( int minuteValue, int secondValue )
   {
      setMinute( minuteValue );
      setSecond( secondValue );
      
   } // end constructor
   
   // return minute value
   public int getMinute()
   {
      return minute;

   } // end method getMinute
   
   // set minute value
   public void setMinute( int value )
   {
      if ( value >= 0 && value < 60 )
      {
         minute = value;
      }
      else // set invalid input to 0
      {
         minute = 0; 
      }

   } // end method setMinute
   
   // return second value
   public int getSecond()
   {
      return second;

   } // end method getSecond

   // set second value
   public void setSecond( int value )
   {
      if ( value >= 0 && value < 60 )
      {
         second = value;
      }
      else // set invalid input to 0
      {
         second = 0; 
      }

   } // end method setSecond

   // return whether or not the time has reached zero
   public boolean isDone()
   {
      return ( minute == 0 && second == 0 );

   } // end method isDone

   // decrement the time by one second
   public void tick()
   {
      // handle case when seconds need to be decremented
      if ( getSecond() > 0 )
      {
         setSecond( getSecond() - 1 ); // subtract one second
      }
      // handle case when minutes must be decremented
      else if ( getMinute() > 0 )
      { 
         setMinute( getMinute() - 1 ); // subtract one minute
         setSecond( 59 );              // reset seconds to new minute
      }

   } // end method tick

} // end class CookingTime

/**************************************************************************
 * (C) Copyright 1992-2004 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/