// Exercise 21.11: LineLength.java
// This application allows the user to draw a line and then displays
// the length of the line.
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;

public class LineLength extends JFrame
{
   // JLabel and JTextField for length of line
   private JLabel lengthJLabel;
   private JTextField lengthJTextField;

   // variables to hold coordinates of endpoints
   int point1x;
   int point1y;
   int point2x;
   int point2y;

   DecimalFormat value = new DecimalFormat( "0.00" );
   
   // no-argument constructor
   public LineLength()
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );

      // set up lengthJLabel
      lengthJLabel = new JLabel();
      lengthJLabel.setBounds( 8, 240, 64, 24 );
      lengthJLabel.setText( "Length =" );
      contentPane.add( lengthJLabel );

      // set up lengthJTextField
      lengthJTextField = new JTextField();
      lengthJTextField.setBounds( 72, 240, 48, 24 );
      lengthJTextField.setHorizontalAlignment( JTextField.CENTER );
      lengthJTextField.setEditable( false );
      contentPane.add( lengthJTextField );
      
      // add mouse listener to JFrame
      addMouseListener(   
      
         new MouseListener() // anonymous inner class
         {
            // event handler called when mouse button is pressed
            public void mousePressed( MouseEvent event )
            {
               lineLengthMousePressed( event );
            }
            
            // event handler called when mouse button is released
            public void mouseReleased( MouseEvent event )
            {
               lineLengthMouseReleased( event );
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

      ); // end call to addMouseListener
      
      // set properties of application's window
      setTitle( "Line Length" ); // set title bar text
      setSize( 302, 298 );       // set window size
      setVisible( true );        // display window
      
   } // end method createUserInterface
   
   // mouse is pressed
   public void lineLengthMousePressed( MouseEvent event )
   {

   } // end method lineLengthMousePressed
   
   // mouse is released
   public void lineLengthMouseReleased( MouseEvent event )
   {

   } // end method lineLengthMouseReleased
   
   // find the length of the line
   private double lineLength()
   {      
      return 0.0;

   } // end method lineLength
   
   // paint graphics
   public void paint( Graphics g )
   {
      super.paint( g ); // call superclass's paint method

   } // end method paint
   
   // main method
   public static void main( String [] args )
   {
      LineLength application = new LineLength();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class LineLength

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