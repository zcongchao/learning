// Exercise 10.13: InterestCalculator.java
// Calculate the total value of an investment.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class InterestCalculator extends JFrame
{
   // JLabel and JTextField for principal invested
   private JLabel principalJLabel;
   private JTextField principalJTextField;

   // JLabel and JTextField for interest rate
   private JLabel interestRateJLabel;
   private JTextField interestRateJTextField;

   // JLabel and JTextField for the number of years
   private JLabel yearsJLabel;
   private JSpinner yearsJSpinner;

   // JLabel and JTextArea display amount on deposit at
   // the end of each year up to number of years entered
   private JLabel yearlyBalanceJLabel;
   private JTextArea yearlyBalanceJTextArea;

   // JScrollPane adds scrollbars to JTextArea for lengthy output
   private JScrollPane yearlyBalanceJScrollPane;

   // JButton calculates amount on deposit at the
   // end of each year up to number of years entered
   private JButton calculateJButton;

   // no-argument constructor
   public InterestCalculator()
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

      // set up principalJLabel
      principalJLabel = new JLabel();
      principalJLabel.setBounds( 16, 16, 56, 24 );
      principalJLabel.setText( "Principal:" );
      contentPane.add( principalJLabel );

      // set up principalJTextField
      principalJTextField = new JTextField();
      principalJTextField.setBounds( 100, 16, 100, 24 );
      principalJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( principalJTextField );
      
      // set up interestRateJLabel
      interestRateJLabel = new JLabel();
      interestRateJLabel.setBounds( 16, 56, 80, 24 );
      interestRateJLabel.setText( "Interest rate:" );
      contentPane.add( interestRateJLabel );

      // set up interestRateJTextField
      interestRateJTextField = new JTextField();
      interestRateJTextField.setBounds( 100, 56, 100, 24 );
      interestRateJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( interestRateJTextField );
      
      // set up yearsJLabel
      yearsJLabel = new JLabel();
      yearsJLabel.setBounds( 16, 96, 48, 24 );
      yearsJLabel.setText( "Years:" );
      contentPane.add( yearsJLabel );

      // set up yearsJSpinner
      yearsJSpinner = new JSpinner( 
         new SpinnerNumberModel( 1, 1, 10, 1 ) );
      yearsJSpinner.setBounds( 100, 96, 100, 24 );
      contentPane.add( yearsJSpinner );
      
      // set up yearlyBalanceJLabel
      yearlyBalanceJLabel = new JLabel();
      yearlyBalanceJLabel.setBounds( 16, 136, 150, 24 );
      yearlyBalanceJLabel.setText( "Yearly account balance:" );
      contentPane.add( yearlyBalanceJLabel );

      // set up yearlyBalanceJTextArea
      yearlyBalanceJTextArea = new JTextArea();
      yearlyBalanceJTextArea.setEditable( false );
      
      // set up yearlyBalanceJScrollPane
      yearlyBalanceJScrollPane = new JScrollPane(
         yearlyBalanceJTextArea );
      yearlyBalanceJScrollPane.setBounds( 16, 160, 300, 92 );
      contentPane.add( yearlyBalanceJScrollPane );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 216, 16, 100, 24 );
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

      
      // set properties of application's window
      setTitle( "Interest Calculator" ); // set title bar text
      setSize( 340, 296 );               // set window size
      setVisible( true );                // display window

   } // end method createUserInterface
   
   // calculate and display amounts
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // declare variables to store user input
      double principal = Double.parseDouble( 
         principalJTextField.getText() );
      double rate = Double.parseDouble( 
         interestRateJTextField.getText() );

      Integer integerObject = ( Integer ) yearsJSpinner.getValue();
      int year = integerObject.intValue();

      // display error message
      if ( true )
      {

      }
      else
      {         
         yearlyBalanceJTextArea.setText( "Year\tAmount on Deposit" );
         DecimalFormat dollars = new DecimalFormat( "$0.00" );
      
         // calculate the total value for each year
         for ( int count = 1; count <= year; count++ )
         {
            double amount = 
               principal * Math.pow( ( 1 + rate / 100 ), count );
            yearlyBalanceJTextArea.append( "\n" + count + "\t" + 
               dollars.format( amount ) );

         } // end for

      } // end else statement
      
   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      InterestCalculator application = new InterestCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class InterestCalculator

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
