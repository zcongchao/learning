// Exercise 24.12: PrimeNumbers.java
// Determines all prime numbers within a user-specified range.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class PrimeNumbers extends JFrame
{
   // JLabel and JTextField to enter the lower bound
   private JLabel lowerBoundJLabel;
   private JTextField lowerBoundJTextField;

   // JLabel and JTextField to enter the upper bound
   private JLabel upperBoundJLabel;
   private JTextField upperBoundJTextField;

   // JLabel, JTextField and JScrollPane to display primes
   private JLabel primeNumbersJLabel;
   private JTextArea primeNumbersJTextArea;
   private JScrollPane outputJScrollPane;

   // JButton for determining primes between the bounds
   private JButton calculatePrimesJButton;

   // no-argument constructor
   public PrimeNumbers()
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

      // set up lowerBoundJLabel
      lowerBoundJLabel = new JLabel();
      lowerBoundJLabel.setBounds( 16, 16, 80, 21 );
      lowerBoundJLabel.setText( "Lower bound:" );
      contentPane.add( lowerBoundJLabel );

      // set up lowerBoundJTextField
      lowerBoundJTextField = new JTextField();
      lowerBoundJTextField.setBounds( 104, 16, 56, 21 );
      lowerBoundJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( lowerBoundJTextField );

      // set up upperBoundJLabel
      upperBoundJLabel = new JLabel();
      upperBoundJLabel.setBounds( 16, 56, 80, 21 );
      upperBoundJLabel.setText( "Upper bound:" );
      contentPane.add( upperBoundJLabel );

      // set up upperBoundJTextField
      upperBoundJTextField = new JTextField();
      upperBoundJTextField.setBounds( 104, 56, 56, 21 );
      upperBoundJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( upperBoundJTextField );

      // set up primeNumbersJLabel
      primeNumbersJLabel = new JLabel();
      primeNumbersJLabel.setBounds( 16, 100, 96, 21 );
      primeNumbersJLabel.setText( "Prime numbers:" );
      contentPane.add( primeNumbersJLabel );

      // set up primeNumbersJTextArea
      primeNumbersJTextArea = new JTextArea();
      primeNumbersJTextArea.setEditable( false );
      
      // set up outputJScrollPane
      outputJScrollPane = new JScrollPane( primeNumbersJTextArea );
      outputJScrollPane.setBounds( 16, 120, 144, 96 );
      contentPane.add( outputJScrollPane );

      // set up calculatePrimesJButton
      calculatePrimesJButton = new JButton();
      calculatePrimesJButton.setBounds( 16, 232, 144, 23 );
      calculatePrimesJButton.setText( "Calculate Primes" );
      contentPane.add( calculatePrimesJButton );
      calculatePrimesJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when calculatePrimesJButton 
            // is pressed
            public void actionPerformed( ActionEvent event )
            {
               calculatePrimesJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Prime Numbers" ); // set title bar String
      setSize( 184, 296 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface

   // calculate and display primes using method prime
   private void calculatePrimesJButtonActionPerformed(
      ActionEvent event )
   {
      // clear primeNumbersJTextField
      primeNumbersJTextArea.setText( "" ); 

      // get user input
      int lowerBound = Integer.parseInt(
         lowerBoundJTextField.getText() );
      int upperBound = Integer.parseInt(
         upperBoundJTextField.getText() );
      
      // display prime numbers
      displayPrimes( lowerBound, upperBound );

   } // end method calculatePrimesJButtonActionPerformed

   // display prime numbers within given bounds
   private void displayPrimes( int lowerBound, int upperBound )
   {
      // if bounds are within appropriate range, 
      // display prime numbers
      if ( ( lowerBound <= 0 ) || ( upperBound <= 0 ) )
      {
         JOptionPane.showMessageDialog( this,
            "Bounds must be greater than 0", "Invalid Bounds",
            JOptionPane.ERROR_MESSAGE );
      }
      else if ( upperBound < lowerBound )
      {
         JOptionPane.showMessageDialog( this,
            "Upper bound cannot be less than lower bound",
            "Invalid Bounds", JOptionPane.ERROR_MESSAGE );
      }
      else
      {
         // loop from lower bound to upper bound
         for ( int counter = lowerBound; counter <= upperBound;
            counter++ )
         {
            // if prime number, display in JTextArea
            if ( prime( counter ) )
            {
               primeNumbersJTextArea.append( counter + "\n" );
            }
         
         } // end for loop

      } // end else
      
   } // end method displayPrimes

   // determine if number is prime
   private boolean prime( int number )
   {
      // 1 is not a valid prime number
      if ( number == 1 )
      {
         return false;
      }

      // set square root of number as limit
      double limit = ( double ) Math.sqrt( number );

      // loop until count reaches square root of number
      for ( int count = 2; count <= limit; count++ )
      {
         if ( ( number % count ) == 0 )
         {
            return false; // number is not prime
         }
      
      } // end for loop

      return true; // number is prime

   } // end method prime

   // main method
   public static void main( String[] args )
   {
      PrimeNumbers application = new PrimeNumbers();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class PrimeNumbers

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