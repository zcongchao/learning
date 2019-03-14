// Tutorial 20: DrawJPanel.java
// This class draws a random rectangle every .25 seconds.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // Random object to create random numbers
   private Random randomNumber = new Random();

   // Timer object to generate events
   private Timer drawTimer;

   // ArrayList object to hold MyRectangle objects
   private ArrayList rectangleArrayList = new ArrayList();

   // array of possible MyRectangle colors
   private Color[] colors = { Color.BLUE, Color.ORANGE, Color.PINK,
      Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK,
      Color.WHITE, Color.RED, Color.GREEN };
      
   // no-argument constructor
   public DrawJPanel()
   {
      super();

      drawTimer = new Timer( 250, 

         new ActionListener() // anonymous inner class
         {
            // event handler called every 250 microseconds
            public void actionPerformed( ActionEvent event ) 
            {
               drawTimerActionPerformed();   
            }
            
         } // end anonymous inner class
         
      ); // end call to new Timer

      drawTimer.start(); // start timer

   }  // end contructor
         
   // create new MyRectangle object and add it to rectangleArrayList
   private void drawTimerActionPerformed()
   {
      // get random dimensions and a random color
      int x = randomNumber.nextInt( 380 );
      int y = randomNumber.nextInt( 380 );
      int width = randomNumber.nextInt( 150 );
      int height = randomNumber.nextInt( 150 );
      int color = randomNumber.nextInt( 10 );

      // create MyRectangle object and add it to rectangleArrayList
      MyRectangle rectangle = new MyRectangle( x, y, width, height,
         colors[ color ] );
      rectangleArrayList.add( rectangle );

      repaint();

   } // end method drawTimerActionPerformed

   // draw all rectangles
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      // create iterator
      Iterator rectangleIterator = rectangleArrayList.iterator();

      MyRectangle currentRectangle; // create MyRectangle

      // iterate through ArrayList and draw all MyRectangles
      while ( rectangleIterator.hasNext() )
      {
         currentRectangle = 
            ( MyRectangle ) rectangleIterator.next();

         currentRectangle.draw( g ); // draw rectangle
      } 

   } // end method paintComponent

   // clear rectangleArray
   public void clear()
   {
      rectangleArrayList.clear(); // clear ArrayList

      repaint(); // repaint JPanel

   } // end method clear
      
} // end class DrawJPanel

/*
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