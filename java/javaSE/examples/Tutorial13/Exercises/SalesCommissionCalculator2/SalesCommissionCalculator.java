// Exercise 13.13: SalesCommissionCalculator.java
// Application calculates a salesperson's commission from the number 
// of units sold.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.*;

public class SalesCommissionCalculator extends JFrame
{
   // JLabel and JTextField for items sold
   private JLabel itemsSoldJLabel;
   private JTextField itemsSoldJTextField;

   // JLabel and JTextField for price of items
   private JLabel priceJLabel;
   private JTextField priceJTextField;

   // JLabel and JTextField for gross sales
   private JLabel grossSalesJLabel;
   private JTextField grossSalesJTextField;

   // JLabel and JSpinner for commission
   private JLabel commissionJLabel;
   private JSpinner commissionJSpinner;

   // JLabel and JTextField for earnings
   private JLabel earningsJLabel;
   private JTextField earningsJTextField;
   
   // JButton to calculate the earnings
   private JButton calculateJButton;

   // no-argument constructor
   public SalesCommissionCalculator()
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

      // set up itemsSoldJLabel
      itemsSoldJLabel = new JLabel();
      itemsSoldJLabel.setBounds( 20, 20, 130, 20 );
      itemsSoldJLabel.setText( "Number of items sold:" );
      contentPane.add( itemsSoldJLabel );

      // set up itemsSoldJTextField
      itemsSoldJTextField = new JTextField();
      itemsSoldJTextField.setBounds( 170, 20, 90, 20 );
      itemsSoldJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( itemsSoldJTextField );

      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 20, 55, 130, 20 );
      priceJLabel.setText( "Price of items:" );
      contentPane.add( priceJLabel );

      // set up priceJTextField
      priceJTextField = new JTextField();
      priceJTextField.setBounds( 170, 55, 90, 20 );
      priceJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( priceJTextField );

      // set up grossSalesJLabel
      grossSalesJLabel = new JLabel();
      grossSalesJLabel.setBounds( 20, 90, 80, 20 );
      grossSalesJLabel.setText( "Gross sales:" );
      contentPane.add( grossSalesJLabel );

      // set up grossSalesJTextField
      grossSalesJTextField = new JTextField();
      grossSalesJTextField.setBounds( 170, 90, 90, 20 );
      grossSalesJTextField.setEditable( false );
      grossSalesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( grossSalesJTextField );

      // set up commissionJLabel
      commissionJLabel = new JLabel();
      commissionJLabel.setBounds( 20, 130, 110, 20 );
      commissionJLabel.setText( "Commission (%):" );
      contentPane.add( commissionJLabel );

      // set up commissionJSpinner
      commissionJSpinner = new JSpinner( 
         new SpinnerNumberModel( 1, 1, 10, 1 ) );
      commissionJSpinner.setBounds( 170, 130, 90, 20 );
      contentPane.add( commissionJSpinner );
      commissionJSpinner.addChangeListener(

         new ChangeListener() // anonymous inner class
         {
            // event handler called when value in 
            // commissionJSpinner changes
            public void stateChanged( ChangeEvent event )
            {
               
            }

         } // end anonymous inner class

      ); // end call to addChangeListener
      
      // set up earningsJLabel
      earningsJLabel = new JLabel();
      earningsJLabel.setBounds( 20, 170, 90, 20 );
      earningsJLabel.setText( "Earnings:" );
      contentPane.add( earningsJLabel );
      
      // set up earningsJTextField
      earningsJTextField = new JTextField();
      earningsJTextField.setBounds( 170, 170, 90, 20 );
      earningsJTextField.setEditable( false );
      earningsJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( earningsJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 170, 205, 90, 25 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when calculateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Sales Commission Calculator" ); // set window title
      setSize( 285, 285 );                       // set window size
      setVisible( true );                        // show window

   } // end method createUserInterface

   // calculate and display sales and earnings
   private void calculateEarnings()
   {
      // get user input
      int items = Integer.parseInt( itemsSoldJTextField.getText() );
      double price = Double.parseDouble( priceJTextField.getText() );
      Integer integerObject = 
         ( Integer ) commissionJSpinner.getValue();
      int commissionRate = integerObject.intValue();
      
      // calculate total sales and earnings
      double sales  = items * price;
      double earnings = ( sales * commissionRate ) / 100;
      
      // display the results
      DecimalFormat dollars = new DecimalFormat( "$0.00" );
      grossSalesJTextField.setText( dollars.format( sales ) );
      earningsJTextField.setText( dollars.format( earnings ) );

   } // end method calculateEarnings

   // main method
   public static void main( String[] args )
   {
      SalesCommissionCalculator application = 
         new SalesCommissionCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class SalesCommissionCalculator

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