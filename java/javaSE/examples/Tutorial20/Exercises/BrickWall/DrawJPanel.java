// Exercise 20.11: DrawJPanel.java
// This class defines the DrawJPanel object.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // ArrayList object to hold MyRectangle objects
   private ArrayList brickArrayList = new ArrayList();
      
   // no-argument constructor
   public DrawJPanel()
   {
      super();

      drawBricks();

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

   // draw 10 rows and 9 columns of bricks
   public void drawBricks()
   {
      // declare a new MyRectangle object
      MyRectangle brick;

      // set the bricks color
      Color myColor = Color.RED;

      // initialize width and height variables
      int width = 45;
      int height = 20;
      
      // repaint JPanel
      repaint();

   } // end method drawBricks

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