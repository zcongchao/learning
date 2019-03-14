// Exercise 28.16: CarPayment.java
// Calculate different billing plans for a car loan.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;

public class CarPayment extends JFrame
{
   // JLabel and JTextfield for price
   private JLabel priceJLabel;
   private JTextField priceJTextField;

   // JLabel and JTextfield for down payment
   private JLabel downPaymentJLabel;
   private JTextField downPaymentJTextField;

   // JLabel and JTextfield for interest
   private JLabel interestJLabel;
   private JTextField interestJTextField;

   // JButton for instructions
   private JButton instructionsJButton;

   // JButton to initiate calculation
   private JButton calculateJButton;

   // JTextArea to display results
   private JTextArea paymentsJTextArea;

   // no-argument constructor
   public CarPayment()
   {
      createUserInterface(); // set up GUI
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {   
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );
      
      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 40, 24, 80, 21 );
      priceJLabel.setText( "Price:" );
      contentPane.add( priceJLabel );
      
      // set up priceJTextField
      priceJTextField = new JTextField();
      priceJTextField.setBounds( 184, 24, 56, 21 );
      priceJTextField.setHorizontalAlignment( JTextField.RIGHT ); 
      contentPane.add( priceJTextField );

      // set up downPaymentJLabel
      downPaymentJLabel = new JLabel();
      downPaymentJLabel.setBounds( 40, 56, 96, 21 );
      downPaymentJLabel.setText( "Down payment:" );
      contentPane.add( downPaymentJLabel );
      
      // set up downPaymentJTextField
      downPaymentJTextField = new JTextField();
      downPaymentJTextField.setBounds( 184, 56, 56, 21 );
      downPaymentJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( downPaymentJTextField );
            
      // set up interestJLabel
      interestJLabel = new JLabel();
      interestJLabel.setBounds( 40, 88, 120, 21 );
      interestJLabel.setText( "Annual interest rate:" );
      contentPane.add( interestJLabel );
      
      // set up interestJTextField
      interestJTextField = new JTextField();
      interestJTextField.setBounds( 184, 88, 56, 21 );
      interestJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( interestJTextField );
            
      // set up instructionsJButton and register its event handler
      instructionsJButton = new JButton();
      instructionsJButton.setBounds( 40, 128, 110, 24 );
      instructionsJButton.setText( "Instructions" );
      contentPane.add( instructionsJButton );
      instructionsJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when instructionsJButton
            // is clicked
            public void actionPerformed( ActionEvent event )
            {
               instructionsJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up calculateJButton and register its event handler
      calculateJButton = new JButton();
      calculateJButton.setBounds( 155, 128, 90, 24 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when calculateJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set up paymentsJTextArea
      paymentsJTextArea = new JTextArea();
      paymentsJTextArea.setBounds( 28, 168, 232, 90 );
      paymentsJTextArea.setEditable( false );
      contentPane.add( paymentsJTextArea );
      
      // set properties of application's window
      setTitle( "Car Payment Calculator" ); // set title bar string
      setSize( 288, 302 );                  // set window's size
      setVisible( true );                   // display window

      // ensure synthesizer is cleaned up
      // when user closes application
      addWindowListener(

         new WindowAdapter()  // anonymous inner class
         {
            public void windowClosing( WindowEvent event )
            {
               frameWindowClosing( event );
            }

         } // end anonymous inner class

      ); // end addWindowListener
      
   } // end method createUserInterface
   
   // method called when user clicks instructionsJButton
   private void instructionsJButtonActionPerformed( 
      ActionEvent event )
   {

   } // end method instructionsJButtonActionPerformed

   // method called when user clicks calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {      
      int years = 2;          // repetition counter
      int months;             // payment period
      double monthlyPayment;  // monthly payment
      
      // clear JTextArea
      paymentsJTextArea.setText( "" );

      // add header JTextArea
      paymentsJTextArea.append( "Months\tMonthly Payments" );
   
      // retrieve user input
      int price = Integer.parseInt( priceJTextField.getText() );
      int downPayment = 
         Integer.parseInt( downPaymentJTextField.getText() );
      double interest = 
         Double.parseDouble( interestJTextField.getText() );

      // calculate loan amount and monthly interest
      int loanAmount = price - downPayment;
      double monthlyInterest = interest / 1200;
      
      // format to display monthlyPayment in currency format
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      // while years is less than or equal to five years
      while ( years <= 5 )
      {
         // calculate payment period
         months = 12 * years; 
         
         // get monthlyPayment         
         monthlyPayment = calculateMonthlyPayment( 
            monthlyInterest, months, loanAmount );

         // insert result into JTextArea
         paymentsJTextArea.append( "\n" + months + "\t" +
            dollars.format( monthlyPayment ) );
         
         years++;  // increment counter

      } // end while
      
   } // end method calculateJButtonActionPerformed

   // method to clear JTextArea contents
   private void clearJTextArea()
   {
      paymentsJTextArea.setText( "" ); // clear JTextArea contents

   } // end method clearJTextArea
   
   // calculate monthlyPayment
   private double calculateMonthlyPayment( double monthlyInterest,
      int months, int loanAmount )
   {
      double base = Math.pow( 1 + monthlyInterest, months );
      return loanAmount * monthlyInterest / ( 1 - ( 1 / base ) );

   } // end method calculateMonthlyPayment

   // clean up synthesizer
   private void frameWindowClosing( WindowEvent event )
   {

   }  // end method frameWindowClosing 
   
   // main method
   public static void main( String [] args )
   {
      CarPayment application = new CarPayment();

   } // end method main
   
} // end class CarPayment

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