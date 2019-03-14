// Exercise 21.12: DrawJPanel.java
// This class defines the DrawJPanel class.
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // Random object to create random numbers
   private Random generator = new Random();

   int x;        // x position of circle
   int y;        // y position of circle
   int diameter; // diameter of circle

   // no-argument constructor
   public DrawJPanel()
   {
      // add MouseListener to DrawJPanel
      addMouseListener(

         new MouseListener() // anonymous inner class
         {
            // event handler called when mouse button is pressed
            public void mousePressed( MouseEvent event )
            {               
               drawJPanelMousePressed( event );
            }

            // event handler must exist to implement interface
            public void mouseReleased( MouseEvent event )
            {
            }

            // event handler must exist to implement interface
            public void mouseClicked( MouseEvent event )
            {
            }

            // event handler must exist to implement interface
            public void mouseEntered( MouseEvent event )
            {
            }

            // event handler must exist to implement interface
            public void mouseExited( MouseEvent event )
            {
            }

         } // end anonymous inner class

      ); // end call to new MouseListener

   } // end constructor

   // set dimensions of circle and call repaint
   private void drawJPanelMousePressed( MouseEvent event )
   {

   } // end method drawJPanelMousePressed

   // draw circle
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

   } // end method paintComponent

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