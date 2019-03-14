// Exercise 27.16: PaintJPanel.java
// Creates a component that allows a user to draw shapes.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class PaintJPanel extends JPanel
{
   // Timer for repainting and moving every 30 milliseconds
   private Timer moveTimer;

   // ArrayList for storing all of the shapes
   private ArrayList shapeArrayList = new ArrayList();

   // Color for storing the currently selected color
   private Color currentColor;
   
   // String for storing which shape type is currently being drawn
   private String currentShapeType = "Line";

   // MyMovingShape for storing the shape currently being drawn
   private MyMovingShape currentShape;

   // constructor
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

            // event handler called when mouse button is released
            public void mouseReleased( MouseEvent event )
            {
               paintJPanelMouseReleased( event );
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

      // set timer for moving shapes
      moveTimer = new Timer( 30, 

         new ActionListener() // anonymous inner class
         {
            // event handler called every 30 milliseconds
            public void actionPerformed( ActionEvent event )
            {
               moveTimerActionPerformed( event );
            }
         
         } // end anonymous inner class
      
      ); // end moveTimer declaration

      moveTimer.start(); // start timer

   } // end constructor

   // paint all the shapes
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      MyMovingShape nextShape;
      Iterator shapesIterator = shapeArrayList.iterator();

      // iterate through all of the shapes
      while ( shapesIterator.hasNext() )
      {
         // draw each shape
         nextShape = ( MyMovingShape ) shapesIterator.next();
         nextShape.draw( g );
      }

      // if the user is currently drawing a shape
      if ( currentShape != null )
      {
         // draw the shape currently being drawn by a user
         currentShape.draw( g );
      }

   } // end paintComponent

   // add a shape to the ArrayList
   public void paintJPanelMousePressed( MouseEvent event )
   {
      // store the new shape being drawn to currentShape
      if ( currentShapeType.equals( "Line" ) )
      {
         currentShape = new MyLine( event.getX(), event.getY(), 
            event.getX(), event.getY(), currentColor );
      }
      else if ( currentShapeType.equals( "Rectangle" ) )
      {
         currentShape = new MyRectangle( event.getX(), event.getY(),
            event.getX(), event.getY(), currentColor );
      }
      else if ( currentShapeType.equals( "Oval" ) )
      {
         currentShape = new MyOval( event.getX(), event.getY(), 
            event.getX(), event.getY(), currentColor );
      }

   } // end method paintJPanelMousePressed 

   // resize the shape being drawn
   public void paintJPanelMouseDragged( MouseEvent event )
   {
      // set the location of currentShape to its resized location
      currentShape.setX2( event.getX() );
      currentShape.setY2( event.getY() );

   } // end method paintJPanelMouseDragged

   // finish resizing the shape being drawn and start its movement
   public void paintJPanelMouseReleased( MouseEvent event )
   {
      // set the location of currentShape to its resized location
      currentShape.setX2( event.getX() );
      currentShape.setY2( event.getY() );

      // add completed shape to shapeArray
      shapeArrayList.add( currentShape );

      // the user is no longer drawing so set currentShape to null
      currentShape = null;

   } // end method paintJPanelMouseReleased 

   // move the shapes
   private void moveTimerActionPerformed( ActionEvent event )
   {
      repaint(); // repaint JPanel

   } // end method drawTimerActionPerformed 

   // set currentShapeType value
   public void setCurrentShapeType( String s )
   {
      currentShapeType = s;

   } // end method setCurrentShapeType

   // set CurrentColor value
   public void setCurrentColor( Color c )
   {
      currentColor = c;

   } // end method setCurrentColor

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