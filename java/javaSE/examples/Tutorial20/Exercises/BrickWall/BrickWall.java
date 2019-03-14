// Exercise 20.11: BrickWall.java
// Program builds a brick wall using rectangles.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickWall extends JFrame
{
   // DrawJPanel for displaying bricks
   private DrawJPanel drawingJPanel;

   // no-argument constructor
   public BrickWall()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );

      // set up drawingJPanel
      drawingJPanel = new DrawJPanel();
      drawingJPanel.setBounds( 0, 0, 450, 250 );
      drawingJPanel.setBackground( Color.WHITE );
      contentPane.add( drawingJPanel );

      // set properties of application's window
      setTitle( "Brick Wall" );   // set title bar text
      setSize( 454, 275 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      BrickWall application = new BrickWall();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class BrickWall

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