// Tutorial 16: SumArray.java
// Sum the values in an array and display it.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SumArray extends JFrame
{
   // JLabel and JTextField for number of array elements
   private JLabel totalJLabel;
   private JTextField totalJTextField;
   
   // JButton to sum the array
   private JButton sumArrayJButton;

   // no-argument constructor
   public SumArray()
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

	  // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 10, 16, 135, 23 );
      totalJLabel.setText( "Total of array elements:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 152, 16, 24, 23 );
      totalJTextField.setEditable( false );
      totalJTextField.setHorizontalAlignment( JLabel.RIGHT );
      contentPane.add( totalJTextField );
      
      // set up sumArrayJButton
      sumArrayJButton = new JButton();
      sumArrayJButton.setBounds( 50, 56, 100, 23 );
      sumArrayJButton.setText( "Sum Array" );
      contentPane.add( sumArrayJButton );
      sumArrayJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when sumArrayJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sumArrayJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Sum Array" ); // set title bar string
      setSize( 200, 120 );     // set window size
      setVisible( true );      // display window

   } // end method createUserInterface

   // method called to determine sum of array
   private void sumArrayJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method sumArrayJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      SumArray application = new SumArray();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class SumArray

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