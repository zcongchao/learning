// Exercise 27.11: ScreenSaver.java
// Application simulates a Screen Saver by drawing random shapes.
import java.awt.*;
import javax.swing.*;

public class ScreenSaver extends JFrame
{
   // DrawJPanel for displaying shapes
   private DrawJPanel shapesDrawJPanel;

   // no-argument constructor
   public ScreenSaver()
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
      
      // set up shapesDrawJPanel
      shapesDrawJPanel = new DrawJPanel();
      shapesDrawJPanel.setBounds( 0, 0, 600, 450 );
      contentPane.add( shapesDrawJPanel );

      // set properties of application's window
      setTitle( "Screen Saver" ); // set title bar string
      setSize( 600, 450 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      ScreenSaver application = new ScreenSaver();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class ScreenSaver

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