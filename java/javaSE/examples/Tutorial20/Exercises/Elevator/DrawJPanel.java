// Exercise 20.13: DrawJPanel.java
// This class defines the DrawJPanel object.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // integer to store the current floor
   private int currentFloor = 1;

   // integer to store the previous floor
   private int lastFloor = 1;

   // integer to store the current position of the elevator
   private int currentPosition = 400;

   // integer to store the position to me moved to
   private int moveToPosition = 400;

   // MyRectangle object to represent the elevator
   private MyRectangle buildingElevator;

   // Timer for displaying elevator movement
   private Timer delayTimer;
      
   // no-argument constructor
   public DrawJPanel()
   {
      super();

      // Timer object to move the elevator
      delayTimer = new Timer( 10, 
      
         new ActionListener() // anonymous inner class
         {
            // timer has incremented
            public void actionPerformed( ActionEvent event )
            {
               delayTimerActionPerformed( event );
            }
         
         } // end anonymous inner class
      
      ); // end call to ActionListener

   }  // end contructor

   // draw all elevator rectangles
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      // draw elevator
      buildingElevator.drawMyRectangle( g );

   } // end method paintComponent

   // move elevator to the new floor
   public void moveElevatorToFloor( int floor )
   {
      // set the current position to the correct y-coordinate
      currentPosition = ( 9 - currentFloor ) * 50;
      lastFloor = currentFloor;

      // set the new position to the correct y-coordinate
      moveToPosition = ( 9 - floor ) * 50;
      currentFloor = floor;

      // if elevator needs to be moved
      if ( currentPosition != moveToPosition )
      {
         delayTimer.start(); // start the timer
      }

   } // end method moveElevatorToFloor

   // move the elevator
   public void moveElevator()
   {

   } // end method drawElevator

   // call method moveElevator when the delayTimer increments
   private void delayTimerActionPerformed( ActionEvent event )
   {
      moveElevator();

      // stop timer when elevator reaches correct floor
      if ( currentPosition == moveToPosition )
      {
         delayTimer.stop();
      }
   
   } // end method delayTimerActionPerformed
      
} // end class drawJPanel

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