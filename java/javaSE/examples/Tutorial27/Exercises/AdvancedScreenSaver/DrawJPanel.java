// Exercise 27.11: DrawJPanel.java
// JPanel that allows shapes to be drawn on.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // Timer to fire when another shape should be drawn
   private Timer drawTimer;

   // Timer to fire when screen should be cleared
   private Timer resetTimer;

   // ArrayList for storing all of the shapes
   private ArrayList shapeArrayList = new ArrayList();

   // Random object for creating shapes
   private Random randomNumber = new Random();

   // set delay for the next shape to be drawn
   private final int SHAPE_DELAY = 20;

   // set delay for the screen to be cleared
   private final int CLEAR_DELAY = 40000;

   // no-argument constructor
   public DrawJPanel()
   {
      setBackground( Color.BLACK ); // set background color

      // set up drawTimer
      drawTimer = new Timer( SHAPE_DELAY,

         new ActionListener() // anonymous inner class
         {
            // event handler called every SHAPE_DELAY
            public void actionPerformed( ActionEvent event )
            {
               drawTimerActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end drawTimer declaration

      drawTimer.start(); // start timer

      // set up resetTimer
      resetTimer = new Timer( CLEAR_DELAY,

         new ActionListener() // anonymous inner class
         {
            // event handler called every CLEAR_DELAY
            public void actionPerformed( ActionEvent event )
            {
               resetTimerActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to new Timer

      resetTimer.start(); // start timer

   } // end constructor

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

   // paint new shape
   private void drawTimerActionPerformed( ActionEvent actionEvent )
   {
      // select a random number for the shape type
      int shapeType = randomNumber.nextInt( 4 );
 
      // randomly generate the x- and y-coordinates
      int x = randomNumber.nextInt( 660 ) - 35 ;
      int y = randomNumber.nextInt( 510 ) - 35 ;
 
      // randomly generate the width and height of the shape
      int width = randomNumber.nextInt( 60 ) + 6 ;
      int height = randomNumber.nextInt( 60 ) + 6;
 
      // randomly generate the color using ints for the red,
      // green, and blue values
      int red = randomNumber.nextInt( 200 );
      int green = randomNumber.nextInt( 200 );
      int blue = randomNumber.nextInt( 200 );
      Color shapeColor = new Color( red, green, blue );
 
      MyShape currentShape; // create new shape

      // if shape is an outlined oval
      if ( shapeType == 0 ) 
      {
         // create an outlined oval
         currentShape = new MyOval( x, y, width + x + 20, height + y, 
            shapeColor );
      }
      else if ( shapeType == 1 ) // else if shape is a filled oval
      {
         // create a filled oval
         currentShape = new MyOval( x, y, width + x + 20, height + y, 
            shapeColor );
      }
      // else if shape is an outlined rectangle
      else if ( shapeType == 2 ) 
      {
         // create an outlined rectangle
         currentShape = new MyRectangle( x, y, width + x,
            height + y + 20, shapeColor );
      }
      else // else if shape is a filled rectangle
      {
         // create a filled rectangle
         currentShape = new MyRectangle( x, y, width + x,
            height + y + 20, shapeColor );
      }    

      // add generated shape to ArrayList
      shapeArrayList.add( currentShape );

      repaint(); 

   } // end method drawTimerActionPerformed

   // clear the ArrayList
   private void resetTimerActionPerformed( ActionEvent actionEvent )
   {
      shapeArrayList.clear();
   }

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