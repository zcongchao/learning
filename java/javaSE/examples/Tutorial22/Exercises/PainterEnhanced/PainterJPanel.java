// Exercise 21.16 PainterJPanel.java
// A customized JPanel class for AdvancedPainter.java.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PainterJPanel extends JPanel
{
   private int circleDiameter; // diameter of circle
   private Color circleColor;  // color of circle

   private Circle newCircle; // Circle to add to the ArrayList

   // ArrayList to hold drawn circles
   private ArrayList circleArrayList = new ArrayList();
   
   // constructor
   public PainterJPanel( Color colorValue, int diameter )
   {
      circleColor = colorValue;
      circleDiameter = diameter;
      
      // set up mouse motion listener
      addMouseMotionListener(
      
         new MouseMotionListener() // anonymous inner class
         {
            // event handler called when mouse is dragged
            public void mouseDragged( MouseEvent event )
            {
               painterJPanelMouseDragged( event );
            }

            // event handler must exist to implement interface
            public void mouseMoved( MouseEvent event )
            {
            }
            
         } // end anonymous inner class
         
      ); // end call to addMouseMotionListener
      
   } // end constructor
   
   // sets the circleColor
   public void setColor( Color choice )
   {
      circleColor = choice;

   } // end method setColor

   // gets the circleColor
   public Color getColor()
   {
      return circleColor;

   } // end method getColor
   
   // sets the circleDiameter
   public void setDiameter( int diameter )
   {
      circleDiameter = diameter;

   } // end method setDiameter
   
   // paint a circle on this PainterJPanel
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      Iterator circleIterator = circleArrayList.iterator();
      Circle drawCircle;

      // iterate through the ArrayList
      while( circleIterator.hasNext() )
      {
         drawCircle = ( Circle )circleIterator.next();
         drawCircle.draw( g ); // draw each circle
      }

   } // end method paintComponent

   // create a circle and add it to the ArrayList
   private void painterJPanelMouseDragged( MouseEvent event )
   {
      if ( event.isMetaDown() )
      {
         // erase circle if right mouse button is pressed
         newCircle = new Circle( circleDiameter, event.getPoint(),
            this.getBackground() );
      }
      else
      {
         // draw circle if left mouse button is pressed
         newCircle = new Circle( circleDiameter, event.getPoint(),
            circleColor );
      }

      circleArrayList.add( newCircle );

      repaint(); // repaint this PainterJPanel

   } // end method painterJPanelMouseDragged
   
} // end class PainterJPanel

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