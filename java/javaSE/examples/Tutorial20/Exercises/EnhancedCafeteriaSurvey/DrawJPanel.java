// Exercise 20.13: DrawJPanel.java
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
   private ArrayList barArray = new ArrayList();

   // no-argument constructor
   public DrawJPanel()
   {
      super();
      
   }  // end contructor

   // draw all bar rectangles
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      // create iterator
      Iterator traverse = barArray.iterator();

      // iterate through ArrayList and draw all MyRectangles
      while ( traverse.hasNext() )
      {
         MyRectangle barRectangle =
            ( MyRectangle ) traverse.next();

         barRectangle.drawMyRectangle( g ); // draw bar

      } // end while loop

   } // end method paintComponent

   // draw the bar graph
   public void drawGraph( int[] answers )
   {
      repaint(); // repaint JPanel

   } // end method drawGraph
      
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