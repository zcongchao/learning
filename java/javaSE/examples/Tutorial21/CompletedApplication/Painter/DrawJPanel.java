// Tutorial 21: DrawJPanel.java
// This class allows the user to draw and erase on the application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // Point to hold the mouse cursor's location
   private Point currentPoint;

   // constants for the drawn circle
   private final Color DRAW_COLOR = Color.BLUE;
   private final int DRAW_DIAMETER = 8;

   // constants for the erase circle
   private final Color ERASE_COLOR = getBackground();
   private final int ERASE_DIAMETER = 8;

   // instance variables for the circle
   private Color drawColor;
   private int drawDiameter;
   
   // constructor
   public DrawJPanel()
   {
      addMouseListener(

         new MouseListener() // anonymous inner class
         {
            // event handler called when a mouse button is clicked
            public void mouseClicked( MouseEvent event )
            {
            }

            // event handler called when mouse enters this DrawJPanel
            public void mouseEntered( MouseEvent event )
            {
            }

            // event handler called when mouse exits this DrawJPanel
            public void mouseExited( MouseEvent event )
            {
            }

            // event handler called when a mouse button is pressed
            public void mousePressed( MouseEvent event )
            {
               drawJPanelMousePressed( event );
            }

            // event handler called when a mouse button is released
            public void mouseReleased( MouseEvent event )
            {
            }

         } // end anonymous inner class

      ); // end call to addMouseListener

      addMouseMotionListener(

         new MouseMotionListener() // anonymous inner class
         {
            // event handler called when the mouse is dragged
            public void mouseDragged( MouseEvent event )
            {
               drawJPanelMouseDragged( event );
            }

            // event handler called when the mouse is moved
            public void mouseMoved( MouseEvent event )
            {
            }

         } // end anonymous inner class

      ); // end call to addMouseMotionListener

   }  // end constructor

   // draw a circle on this DrawJPanel
   private void drawJPanelMousePressed( MouseEvent event )
   {
      // store the location of the mouse
      currentPoint = event.getPoint();

      if ( event.isMetaDown() ) // right mouse button is pressed
      {
         drawColor = ERASE_COLOR;
         drawDiameter = ERASE_DIAMETER;
      }
      else // left mouse button is pressed
      {
         drawColor = DRAW_COLOR;
         drawDiameter = DRAW_DIAMETER;
      }

      repaint(); // repaint this DrawJPanel

   } // end method drawJPanelMousePressed

   // draw a small circle at the mouse's location
   public void paintComponent( Graphics g )
   {
      g.setColor( drawColor ); // set the color

      if ( currentPoint != null )
      {
         // draw a filled circle at the mouse's location
         g.fillOval( currentPoint.x, currentPoint.y, 
            drawDiameter, drawDiameter );
      }

   } // end method paintComponent

   // draw a circle on this DrawJPanel
   private void drawJPanelMouseDragged( MouseEvent event )
   {
      // store the location of the mouse
      currentPoint = event.getPoint();

      repaint(); // repaint this DrawJPanel

   } // end method drawJPanelMouseDragged

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