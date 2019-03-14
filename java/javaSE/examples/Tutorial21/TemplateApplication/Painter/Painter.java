// Tutorial 21: Painter.java
// Application enables user to draw on a subclass of JPanel.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Painter extends JFrame
{
   // DrawJPanel for circles drawn by user
   private DrawJPanel myDrawJPanel;

   // no-argument constructor
   public Painter()
   {
      createUserInterface();
   }

   // set up the GUI components
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );
      
      // set up myDrawJPanel
      myDrawJPanel = new DrawJPanel();
      myDrawJPanel.setBounds( 0, 0, 300, 300 );
      contentPane.add( myDrawJPanel );

      // set properties of application's window
      setTitle( "Painter" ); // set title bar text
      setSize( 300, 300 );   // set window size
      setVisible( true );    // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      Painter application = new Painter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Painter

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