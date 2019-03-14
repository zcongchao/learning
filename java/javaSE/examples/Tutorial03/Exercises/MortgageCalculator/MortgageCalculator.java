// Exercise 3.12: MortgageCalculator.java
// GUI for mortgage calculator application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MortgageCalculator extends JFrame
{
   // JLabel and JTextField for home value
   private JLabel homeValueJLabel;
   private JTextField homeValueJTextField;

   // JLabel and JTextField for loan amount
   private JLabel loanAmountJLabel;
   private JTextField loanAmountJTextField;
   
   // JLabel and JTextField for mortgage term in years
   private JLabel termJLabel;
   private JTextField termJTextField;
   
   // JLabel and JTextField for yearly homeowner's insurance
   private JLabel insuranceJLabel;
   private JTextField insuranceJTextField;
   
   // JLabel and JTextField for yearly property taxes
   private JLabel propertyTaxesJLabel;
   private JTextField propertyTaxesJTextField;
   
   // JLabel and JTextField for interest rate percentage
   private JLabel interestJLabel;
   private JTextField interestJTextField;
   
   // JLabel and JTextField for monthly payment amount
   private JLabel monthlyPaymentJLabel;
   private JTextField monthlyPaymentJTextField;

   // JButtons to calculate monthly payment and clear all JTextFields
   private JButton calculateJButton;
   private JButton clearJButton;

   // no-argument constructor
   public MortgageCalculator()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( null );

      // set up homeValueJLabel
      homeValueJLabel = new JLabel();
      homeValueJLabel.setBounds( 16, 16, 80, 21 );
      homeValueJLabel.setText( "Home value:" );
      container.add( homeValueJLabel );

      // set up homeValueJTextField
      homeValueJTextField = new JTextField();
      homeValueJTextField.setBounds( 212, 16, 100, 21 );
      homeValueJTextField.setText( "125000" );
      homeValueJTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( homeValueJTextField );

      // set up loanAmountJLabel
      loanAmountJLabel = new JLabel();
      loanAmountJLabel.setText( "Loan amount:" );
      container.add( loanAmountJLabel );

      // set up loanAmountJTextField
      loanAmountJTextField = new JTextField();
      loanAmountJTextField.setText( "100000" );
      loanAmountJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      container.add( loanAmountJTextField );

      // set up termJLabel
      termJLabel = new JLabel();
      termJLabel.setBounds( 16, 96, 80, 21 );
      termJLabel.setText( "Term (years):" );
      container.add( termJLabel );

      // set up termJTextField
      termJTextField = new JTextField();
      termJTextField.setBounds( 212, 96, 100, 21 );
      termJTextField.setText( "20" );
      termJTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( termJTextField );

      // set up insuranceJLabel
      insuranceJLabel = new JLabel();
      insuranceJLabel.setBounds( 16, 136, 196, 21 );
      insuranceJLabel.setText( "Homeowner's insurance (yearly):" );
      container.add( insuranceJLabel );

      // set up insuranceJTextField
      insuranceJTextField = new JTextField();
      insuranceJTextField.setBounds( 212, 136, 100, 21 );
      insuranceJTextField.setText( "500" );
      insuranceJTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( insuranceJTextField );

      // set up propertyTaxesJLabel
      propertyTaxesJLabel = new JLabel();
      propertyTaxesJLabel.setBounds( 16, 176, 148, 21 );
      propertyTaxesJLabel.setText( "Property taxes (yearly):" );
      container.add( propertyTaxesJLabel );

      // set up propertyTaxesJTextField
      propertyTaxesJTextField = new JTextField();
      propertyTaxesJTextField.setBounds( 212, 176, 100, 21 );
      propertyTaxesJTextField.setText( "2100" );
      propertyTaxesJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      container.add( propertyTaxesJTextField );

      // set up interestJLabel
      interestJLabel = new JLabel();
      interestJLabel.setBounds( 16, 216, 140, 21 );
      interestJLabel.setText( "Interest rate (percent):" );
      container.add( interestJLabel );

      // set up interestJTextField
      interestJTextField = new JTextField();
      interestJTextField.setBounds( 212, 216, 100, 21 );
      interestJTextField.setText( "5.5" );
      interestJTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( interestJTextField );

      // set up monthlyPaymentJLabel
      monthlyPaymentJLabel = new JLabel();
      monthlyPaymentJLabel.setBounds( 16, 256, 106, 21 );
      monthlyPaymentJLabel.setText( "Monthly payment:" );
      container.add( monthlyPaymentJLabel );

      // set up monthlyPaymentJTextField
      monthlyPaymentJTextField = new JTextField();
      monthlyPaymentJTextField.setBounds( 212, 256, 100, 21 );
      monthlyPaymentJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      monthlyPaymentJTextField.setBorder( new BevelBorder( 1 ) );
      monthlyPaymentJTextField.setEditable( false );
      container.add( monthlyPaymentJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 133, 296, 90, 23 );
      calculateJButton.setText( "Calculate" );
      container.add( calculateJButton );

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 237, 296, 75, 23 );
      clearJButton.setText( "Clear" );
      container.add( clearJButton );

      // set properties of application’s window
      setTitle( "Mortgage Calculator" ); // set title bar text
      setSize( 332, 360 );               // set window size
      setVisible( true );                // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      MortgageCalculator application = new MortgageCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class MortgageCalculator


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
