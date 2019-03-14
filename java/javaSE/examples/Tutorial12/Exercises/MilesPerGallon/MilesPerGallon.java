// Exercise 12.13: MilesPerGallon.java
// Calculates miles per gallon based on user input.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class MilesPerGallon extends JFrame
{
   // JLabel and JTextField for amount of miles driven
   private JLabel milesDrivenJLabel;
   private JTextField milesDrivenJTextField;

   // JLabel and JTextField for amount of gallons used
   private JLabel gallonsUsedJLabel;
   private JTextField gallonsUsedJTextField;

   // JLabel and JTextField for amount of miles per gallon
   private JLabel milesPerGallonJLabel;
   private JTextField milesPerGallonJTextField;

   // JButton initiates calculation of miles per gallon
   private JButton calculateMPGJButton;

   // no-argument constructor
   public MilesPerGallon()
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

      // set up milesDrivenJLabel
      milesDrivenJLabel = new JLabel();
      milesDrivenJLabel.setBounds( 16, 16, 81, 21 );
      milesDrivenJLabel.setText( "Miles driven:" );
      contentPane.add( milesDrivenJLabel );

      // set up milesDrivenJTextField
      milesDrivenJTextField = new JTextField();
      milesDrivenJTextField.setBounds( 128, 16, 64, 21 );
      milesDrivenJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( milesDrivenJTextField );

      // set up gallonsUsedJLabel
      gallonsUsedJLabel = new JLabel();
      gallonsUsedJLabel.setBounds( 16, 56, 81, 21 );
      gallonsUsedJLabel.setText( "Gallons used:" );
      contentPane.add( gallonsUsedJLabel );

      // set up gallonsUsedJTextField
      gallonsUsedJTextField = new JTextField();
      gallonsUsedJTextField.setBounds( 128, 56, 64, 21 );
      gallonsUsedJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( gallonsUsedJTextField );

      // set up milesPerGallonJLabel
      milesPerGallonJLabel = new JLabel();
      milesPerGallonJLabel.setBounds( 16, 104, 96, 21 );
      milesPerGallonJLabel.setText( "Miles per gallon:" );
      contentPane.add( milesPerGallonJLabel );

      // set up milesPerGallonJTextField
      milesPerGallonJTextField = new JTextField();
      milesPerGallonJTextField.setBounds( 128, 104, 64, 21 );
      milesPerGallonJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      milesPerGallonJTextField.setEditable( false );
      contentPane.add( milesPerGallonJTextField );

      // set up calculateMPGJButton
      calculateMPGJButton = new JButton();
      calculateMPGJButton.setBounds( 76, 144, 116, 23 );
      calculateMPGJButton.setText( "Calculate MPG" );
      contentPane.add( calculateMPGJButton );
      calculateMPGJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when
            // calculateMPGJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               calculateMPGJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Miles Per Gallon" ); // set title bar string
      setSize( 224, 208 );            // set window size
      setVisible( true );             // display window

   } // end method createUserInterface

   // get user input, call method milesPerGallon and display results
   private void calculateMPGJButtonActionPerformed(
      ActionEvent event )
   {
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );
      
      double miles = Double.parseDouble( 
         milesDrivenJTextField.getText() );
      double gallons = Double.parseDouble( 
         gallonsUsedJTextField.getText() );
      
      // display miles per gallon
      milesPerGallonJTextField.setText( twoDigits.format(
         0.00 ) );

   } // end method calculateMPGJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      MilesPerGallon application = new MilesPerGallon();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class MilesPerGallon

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