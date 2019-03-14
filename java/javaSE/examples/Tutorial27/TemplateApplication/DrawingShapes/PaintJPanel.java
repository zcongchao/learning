// Tutorial 27: PaintJPanel.java
// Panel allows user to create a shape.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PaintJPanel extends JPanel {

   // ArrayList to hold the shapes
   private ArrayList shapesArrayList = new ArrayList();

   // currently selected shape type
   private String currentType = "Line";

   // currently selected color
   private Color currentColor = new Color( 204, 204, 204 );

   // no-argument constructor
   public PaintJPanel()
   {
      addMouseListener( 
         
         new MouseAdapter() // anonymous inner class
         {
            // event handler called when mouse button is pressed
            public void mousePressed( MouseEvent event )
            {
               paintJPanelMousePressed( event );
            }

         } // end anonymous inner class

      ); // end call to addMouseListener

      addMouseMotionListener(
         
         new MouseMotionAdapter() // anonymous inner class
         {
            // event handler called when the mouse is dragged
            public void mouseDragged( MouseEvent event )
            {
               paintJPanelMouseDragged( event );
            }

         } // end anonymous inner class

      ); // end call to addMouseMotionListener

   } // end constructor

   // change the current shape type
   public void setCurrentShapeType( String shape )
   {
      currentType = shape;

   } // end method setCurrentShapeType

   // change the current color
   public void setCurrentColor( Color shapeColor )
   {
      currentColor = shapeColor;

   } // end method setCurrentColor

   // create a new shape
   public void paintJPanelMousePressed( MouseEvent event )
   {

   } // end method paintJPanelMousePressed

   // reset the second point for the shape
   public void paintJPanelMouseDragged( MouseEvent event )
   {

   } // end method paintJPanelMouseDragged

   // paint all the shapes
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
   
   } // end method paintComponent

} // end class PaintJPanel

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