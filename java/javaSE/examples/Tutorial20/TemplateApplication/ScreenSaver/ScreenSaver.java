// Tutorial 20: ScreenSaver.java
// Program simulates screen saver by drawing random shapes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenSaver extends JFrame
{
   // JButton to clear drawingJPanel
   private JButton clearJButton;

   // DrawJPanel for displaying rectangles
   private DrawJPanel drawingJPanel;

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

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 189, 16, 72, 23 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // method called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Screen Saver" ); // set title bar text
      setSize( 500, 500 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // reset drawingJPanel
   private void clearJButtonActionPerformed( ActionEvent event )
   {

   } // end method clearJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      ScreenSaver application = new ScreenSaver();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end main

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