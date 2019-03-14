// Tutorial 13: InterestCalculator.java
// Calculate the total value of an investment.
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class InterestCalculator extends JFrame
{
   // JLabel and JTextField for principal
   private JLabel principalJLabel;
   private JTextField principalJTextField;

   // JLabel and JTextField for interest rate
   private JLabel rateJLabel;
   private JTextField rateJTextField;

   // JLabel and JSpinner for years
   private JLabel yearsJLabel;
   private JSpinner yearsJSpinner;
   
   // JLabel, JTextArea and JScrollPane for yearly balances
   private JLabel accountJLabel;
   private JTextArea accountJTextArea;
   private JScrollPane accountJScrollPane;

   // JButton to calculate the yearly balances
   private JButton calculateJButton;

   // JButton to clear the components
   private JButton clearJButton;

   // no-argument constructor
   public InterestCalculator()
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
            
      // set up principalJLabel
      principalJLabel = new JLabel();
      principalJLabel.setText( "Principal:" );
      principalJLabel.setBounds( 16, 16, 56, 24 );
      contentPane.add( principalJLabel );

      // set up principalJTextField
      principalJTextField = new JTextField();
      principalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      principalJTextField.setBounds( 96, 16, 104, 24 );
      contentPane.add( principalJTextField );
      principalJTextField.addKeyListener( 
      
         new KeyAdapter() // anonymous inner class
         {
            // event handler called when principalJTextField 
            // is edited
            public void keyPressed( KeyEvent event )
            {
               principalJTextFieldKeyPressed( event );
            }
            
         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up rateJLabel
      rateJLabel = new JLabel();
      rateJLabel.setText( "Interest rate:" );
      rateJLabel.setBounds( 16, 56, 80, 24 );
      contentPane.add( rateJLabel );

      // set up rateJTextField
      rateJTextField = new JTextField();
      rateJTextField.setHorizontalAlignment( JTextField.RIGHT );
      rateJTextField.setBounds( 96, 56, 104, 24 );
      contentPane.add( rateJTextField );
      rateJTextField.addKeyListener( 
      
         new KeyAdapter() // anonymous inner class
         {
            // event handler called when rateJTextField is edited
            public void keyPressed( KeyEvent event )
            {
               rateJTextFieldKeyPressed( event );
            }
            
         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up yearsJLabel
      yearsJLabel = new JLabel();
      yearsJLabel.setText( "Years:" );
      yearsJLabel.setBounds( 16, 96, 48, 24 );
      contentPane.add( yearsJLabel );

      // set up yearsJSpinner
      yearsJSpinner = new JSpinner( 
         new SpinnerNumberModel( 1, 1, 10, 1 ) );
      yearsJSpinner.setBounds( 96, 96, 104, 24 );
      contentPane.add( yearsJSpinner );
      yearsJSpinner.addChangeListener( 
      
         new ChangeListener() // anonymous inner class
         {
            // event handler called when value in 
            // yearsJSpinner changes
            public void stateChanged( ChangeEvent event )
            {
               yearsJSpinnerStateChanged( event );
            }
            
         } // end anonymous inner class

      ); // end call to addChangeListener

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setText( "Calculate" );
      calculateJButton.setBounds( 216, 16, 100, 24 );
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

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 216, 56, 100, 24 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when clearJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up accountJLabel
      accountJLabel = new JLabel();
      accountJLabel.setText( "Account balance:" );
      accountJLabel.setBounds( 16, 136, 150, 24 );
      contentPane.add( accountJLabel );
      
      // set up accountJTextArea
      accountJTextArea = new JTextArea();
      accountJTextArea.setEditable( false );
      
      // set up accountJScrollPane
      accountJScrollPane = new JScrollPane( accountJTextArea );
      accountJScrollPane.setBounds( 16, 160, 300, 88 );
      contentPane.add( accountJScrollPane );
      
      // set properties of application's window
      setTitle( "Interest Calculator" ); // set title bar string
      setSize( 340, 300 );               // set window size
      setVisible( true );                // show window

   } // end method createUserInterface

   // clear the accountJTextArea
   private void rateJTextFieldKeyPressed( KeyEvent event )
   {
      accountJTextArea.setText( "" );

   } // end method rateJTextFieldKeyPressed

   // clear the accountJTextArea
   private void principalJTextFieldKeyPressed( KeyEvent event )
   {
      accountJTextArea.setText( "" );

   } // end method principalJTextFieldKeyPressed
   
   // calculate yearly values of investment
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // declare variables to store user input
      double principal = Double.parseDouble( 
         principalJTextField.getText() );
      double rate = Double.parseDouble( rateJTextField.getText() );
      Integer integerObject = ( Integer ) yearsJSpinner.getValue();
      int year = integerObject.intValue();

      accountJTextArea.setText( "Year\tAmount on Deposit" );
      DecimalFormat dollars = new DecimalFormat( "$0.00" );
      
      // calculate the total value for each year
      for ( int count = 1; count <= year; count++ )
      {
         double amount = principal * 
            Math.pow( ( 1 + rate / 100 ), count );
         accountJTextArea.append( "\n" + count + "\t" + 
            dollars.format( amount ) );

      } // end for
      
   } // end method calculateJButtonActionPerformed

   // clear GUI components
   private void clearJButtonActionPerformed( ActionEvent event )
   {
      // clear the JTextFields
      principalJTextField.setText( "" );
      rateJTextField.setText( "" );

      // clear the JTextArea
      accountJTextArea.setText( "" );

      // reset the value of the JSpinner
      yearsJSpinner.setValue( new Integer( 1 ) );
      
   } // end method clearJButtonActionPerformed

   // clear the JTextArea
   private void yearsJSpinnerStateChanged( ChangeEvent event )
   {
      accountJTextArea.setText( "" );

   } // end method yearJSpinnerStateChanged
   
   // main method
   public static void main( String args[] )
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