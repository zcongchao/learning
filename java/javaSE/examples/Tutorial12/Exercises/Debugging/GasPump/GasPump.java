// Exercise 12.16: GasPump.java
// Calculates gas prices based on the number of gallons and grade.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class GasPump extends JFrame
{
   // JLabel and JTextField for number of gallons
   private JLabel numberGallonsJLabel;
   private JTextField numberGallonsJTextField;

   // JLabel and JTextField for total price
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // JLabel and JButton for regular grade gas
   private JLabel regularJLabel;
   private JButton regularJButton;

   // JLabel and JButton for special grade gas
   private JLabel specialJLabel;
   private JButton specialJButton;

   // JLabel and JButton for super+ grade gas
   private JLabel superJLabel;
   private JButton superJButton;

   private double gallons = 0.0; // number of gallons

   // no-argument constructor
   public GasPump()
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

      // set up numberGallonsJLabel
      numberGallonsJLabel = new JLabel();
      numberGallonsJLabel.setBounds( 16, 16, 114, 21 );
      numberGallonsJLabel.setText( "Number of gallons:" );
      contentPane.add( numberGallonsJLabel );

      // set up numberGallonsJTextField
      numberGallonsJTextField = new JTextField();
      numberGallonsJTextField.setBounds( 138, 16, 86, 21 );
      numberGallonsJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( numberGallonsJTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 240, 16, 40, 21 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 291, 16, 61, 21 );
      totalJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      totalJTextField.setEditable( false );
      contentPane.add( totalJTextField );

      // set up regularJLabel
      regularJLabel = new JLabel();
      regularJLabel.setBounds( 16, 56, 85, 21 );
      regularJLabel.setText( "Regular: $1.61" );
      contentPane.add( regularJLabel );

      // set up regularJButton
      regularJButton = new JButton();
      regularJButton.setBounds( 16, 77, 85, 85 );
      regularJButton.setText( "Regular" );
      contentPane.add( regularJButton );
      regularJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when regularJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               regularJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up specialJLabel
      specialJLabel = new JLabel();
      specialJLabel.setBounds( 144, 56, 85, 21 );
      specialJLabel.setText( "Special: $1.67" );
      contentPane.add( specialJLabel );

      // set up specialJButton
      specialJButton = new JButton();
      specialJButton.setBounds( 144, 77, 85, 85 );
      specialJButton.setText( "Special" );
      contentPane.add( specialJButton );
      specialJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when specialJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               specialJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up superJLabel
      superJLabel = new JLabel();
      superJLabel.setBounds( 272, 56, 85, 21 );
      superJLabel.setText( "Super+: $1.77" );
      contentPane.add( superJLabel );

      // set up superJButton
      superJButton = new JButton();
      superJButton.setBounds( 272, 77, 85, 85 );
      superJButton.setText( "Super+" );
      contentPane.add( superJButton );
      superJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when superJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               superJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Gas Pump" ); // set title bar string
      setSize( 380, 202 );    // set window size
      setVisible( true );     // display window

   } // end method createUserInterface

   // calculate total for regular gas grade
   private void regularJButtonActionPerformed( ActionEvent event )
   {
      gallons = Double.parseDouble(
         numberGallonsJTextField.getText() );

      // call method to determine total
      total( 1, gallons );

   } // end method regularJButtonActionPerformed

   // calculates total for special gas grade
   private void specialJButtonActionPerformed( ActionEvent event )
   {
      gallons = Double.parseDouble(
         numberGallonsJTextField.getText() );

      // call method to determine total
      total( 2, gallons );

   } // end method specialJButtonActionPerformed

   // calculates total for super gas grade
   private void superJButtonActionPerformed( ActionEvent event )
   {
      gallons = Double.parseDouble(
         numberGallonsJTextField.getText() );

      // call method to determine total
      total( 3, gallons );

   } // end method superJButtonActionPerformed
   
   // calculate and display total price based on gas grade 
   private void total( int grade, double gallons )
   {
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      // determine grade selected and output total
      switch ( grade )
      {
         case 1:
            totalJTextField.setText(
               dollars.format( 1.61 * gallons ) );
            break;
         case 2:
            totalJTextField.setText(
               dollars.format( 1.57 * gallons ) );
            break;
         case 3:
            totalJTextField.setText(
               dollars.format( 1.77 * gallons ) );
            break;

      } // end switch

   } // end method total

   // main method
   public static void main( String[] args )
   {
      GasPump application = new GasPump();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class GasPump

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