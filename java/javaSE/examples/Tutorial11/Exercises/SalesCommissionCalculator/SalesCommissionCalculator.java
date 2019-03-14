// Exercise 11.11: SalesCommissionCalculator.java
// Calculates a salesperson's commission 
// from the number of units sold.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class SalesCommissionCalculator extends JFrame
{
   // JLabel and JTextField to display number of items sold
   private JLabel itemsSoldJLabel;
   private JTextField itemsSoldJTextField;

   // JButton to initiate calculations 
   private JButton calculateJButton;

   // JLabel and JTextField to display gross sales
   private JLabel salesJLabel;
   private JTextField salesJTextField;

   // JLabel and JTextField to display commission percentage
   private JLabel commissionJLabel;
   private JTextField commissionJTextField;

   // JLabel and JTextField to display total earnings
   private JLabel earningsJLabel;
   private JTextField earningsJTextField;

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

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 170, 45, 90, 25 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when calculateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up salesJLabel
      salesJLabel = new JLabel();
      salesJLabel.setBounds( 20, 95, 80, 20 );
      salesJLabel.setText( "Gross sales:" );
      contentPane.add( salesJLabel );

      // set up salesJTextField
      salesJTextField = new JTextField();
      salesJTextField.setBounds( 170, 95, 90, 20 );
      salesJTextField.setHorizontalAlignment( JTextField.RIGHT );
      salesJTextField.setEditable( false );
      contentPane.add( salesJTextField );
      
      // set up commissionJLabel
      commissionJLabel = new JLabel();
      commissionJLabel.setBounds( 20, 130, 110, 20 );
      commissionJLabel.setText( "Commission (%):" );
      contentPane.add( commissionJLabel );
      
      // set up commissionJTextField
      commissionJTextField = new JTextField();
      commissionJTextField.setBounds( 170, 130, 90, 20 );
      commissionJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      commissionJTextField.setEditable( false );
      contentPane.add( commissionJTextField );
      
      // set up earningsJLabel
      earningsJLabel = new JLabel();
      earningsJLabel.setBounds( 20, 165, 90, 20 );
      earningsJLabel.setText( "Earnings:" );
      contentPane.add( earningsJLabel );

      // set up earningsJTextField
      earningsJTextField = new JTextField();
      earningsJTextField.setBounds( 170, 165, 90, 20 );
      earningsJTextField.setHorizontalAlignment( JTextField.RIGHT );
      earningsJTextField.setEditable( false );
      contentPane.add( earningsJTextField );

      // set properties of application's window
      setTitle( "Sales Commission Calculator" ); // set window title
      setSize( 285, 230 );                       // set window size
      setVisible( true );                        // display window

   } // end method createUserInterface

   // calculate the commission
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // number of items sold
      int items = Integer.parseInt( itemsSoldJTextField.getText() );
      
      final double DOLLARS_PER_UNIT = 100.0;   // cost for each item

      // display results
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

   } // end method calculateJButtonActionPerformed

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
