
public class CookingTime
{
 // integers for storing minutes and seconds
   private int minute;
   private int second;
   
   public CookingTime( int minuteValue, int secondValue )
   {
	   setMinute( minuteValue );
       setSecond( secondValue );
   }
   
   public int getMinute()
   {
	   return minute;
   }
   
   public void setMinute( int value )
   {
	   if ( value >= 0 && value < 60 )
	   {
		   minute = value;
	   }
	   else
	   {
		   minute = 0;
	   }
   }
   
   public int getSecond()
   {
      return second;

   } // end method getSecond

   // set second value
   public void setSecond( int value )
   {
      if ( value >= 0 && value < 60 )
      {
         second = value; // second is valid
      }
      else
      {
         second = 0; // set invalid input to 0
      }

   } // end method setSecond
   
   public boolean isDone()
   {
      return ( minute == 0 && second == 0 );

   } // end method isDone
   
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
         setSecond( 59 );              // set seconds to 59
      }

   } // end method tick     


}
