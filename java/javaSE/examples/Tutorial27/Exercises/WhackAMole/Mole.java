// Exercise 27.13: Mole.java
// A class that represents the mole in the Whack A Mole application.
import java.awt.*;
import java.util.*;

public class Mole
{
   // int for storing the row in which the mole is in
   private int moleRow = -1;

   // int for storing the column in wich the mole is in
   private int moleColumn = -1;

   // Random object to generate new mole position
   private Random randomGenerator = new Random();

   // draw the mole in a new cell
   public void drawMole( Graphics g )
   {
      // if mole data is not -1
      if ( !( moleRow == -1 || moleColumn == -1 ) )
      {

      } // end if

   } // end method drawMole
   
   // move the mole to a random hole
   public void moveMole()
   {    
      // create random chart location
      moleRow = randomGenerator.nextInt( 5 );
      moleColumn = randomGenerator.nextInt( 5 );

   } // end method move
   
   // clear mole data so that a new game can begin
   public void reset()
   {
      moleRow = -1;
      moleColumn = -1;

   } // end method reset

   // returns whether or not mole is hit by given mouse coordinates
   public boolean isHit( int mouseX, int mouseY )
   {
      // if game has not yet started
      if ( moleRow == -1 )
      {
         return false;
      }

      // calculate cell dimensions
      int x = moleColumn * 50;
      int y = moleRow * 50;

      // if mouse coordinate are inside the mole's current cell
      if ( mouseX > 35 + x && mouseX < 85 + x &&
         mouseY > 68 + y && mouseY < 118 + y )
      {
         return true;
      }
      else // user missed hitting the mole
      {
         return false;
      }
   
   } // end method isHit

} // end class Mole

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