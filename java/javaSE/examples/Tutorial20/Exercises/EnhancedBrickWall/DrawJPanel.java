// Exercise 20.12: DrawJPanel.java
// This class defines the DrawJPanel object.
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // ArrayList object to hold MyRectangle objects
   private ArrayList brickArrayList = new ArrayList();
      
   // no-argument constructor
   public DrawJPanel()
   {
      super();

   }  // end contructor

   // add randomNumber brick to ArrayList and draw all bricks
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      // create iterator
      Iterator traverse = brickArrayList.iterator();

      // iterate through ArrayList and draw all MyRectangles
      while ( traverse.hasNext() )
      {
         MyRectangle currentRectangle =
            ( MyRectangle ) traverse.next();

         currentRectangle.drawMyRectangle( g ); // draw brick

      } // end while loop

   } // end method paintComponent

   // create brick wall based on user input
   public void drawBricks()
   {
      // declare a new MyRectangle object
      MyRectangle brick;

      // set the bricks color
      Color myColor = Color.RED;

      // initialize width and height variables
      int width = 45;
      int height = 20;

      // set the y position
      for ( int row = 0; row <= 9; row++ )
      {
         int y = row * 25;

         // set the x position
         for ( int column = 0; column <= 9; column++ )
         {
            int x = column * 50;

            // if row is odd
            if ( row % 2 == 1 )
            {
               // draw the odd rows of bricks
               brick = new MyRectangle( x, y, width, height, 
                  myColor );
               brickArrayList.add( brick );
            }
            else
            {
               // draw the even rows of bricks
               brick = new MyRectangle( x - 25, y, width, 
                  height, myColor );
               brickArrayList.add( brick );
            }
         
         } // end inner for

         // add a small brick to the end of even rows
         if ( row % 2 == 0 )
         {
            brick = new MyRectangle( 9 * 50 - 25, y, 
               width - 25, height, myColor );
            brickArrayList.add( brick );
         }

      } // end outer for

      // repaint JPanel
      repaint();

   } // end method drawBricks

   // clear rectangleArray
   public void clearArray()
   {
      // clear ArrayList
      brickArrayList.clear();

   } // end method clearArray
      
} // end class DrawJPanel

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