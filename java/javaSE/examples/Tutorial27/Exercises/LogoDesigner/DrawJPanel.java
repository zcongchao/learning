// Exercise 27.12: DrawJPanel.java
// Creates a JPanel that allows a user to create shapes on.
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // ArrayList for storing all of the shapes
   private ArrayList shapeArrayList = new ArrayList();

   // paint all the shapes
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      MyShape nextShape;
      Iterator shapesIterator = shapeArrayList.iterator();

      // iterate through all of the shapes
      while ( shapesIterator.hasNext() )
      {
         // draw each shape
         nextShape = ( MyShape ) shapesIterator.next();
         nextShape.draw( g );
      }
   
   } // end method paintComponent

   // clear the ArrayList
   public void clear()
   {
      shapeArrayList.clear();
      repaint();

   } // end method clear

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