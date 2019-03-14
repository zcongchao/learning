// Exercise 13.11: PresentValue.java
// Application that calculates how much money should be invested in
// order to achieve a certain financial goal.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;

public class PresentValue extends JFrame
{
   // JLabel and JTextField for future value input
   private JLabel futureValueJLabel;
   private JTextField futureValueJTextField;

   // JLabel and JTextField for interest rate input
   private JLabel interestRateJLabel;
   private JTextField interestRateJTextField;

   // JLabel and JSpinner for number of years input
   private JLabel yearsJLabel;
   private JSpinner yearsJSpinner;

   // JLabel and JTextArea for initial amounts 
   // needed to reach future value
   private JLabel amountNeededJLabel;
   private JTextArea amountNeededJTextArea;

   // JButton calculates initial amounts needed
   // to reach future value
   private JButton calculateJButton;

   // JButton to clear values
   private JButton clearJButton;
   
   // no-argument constructor
   public PresentValue()
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
      
      // set up futureJLabel
      futureValueJLabel = new JLabel();
      futureValueJLabel.setBounds( 20, 25, 90, 20 );
      futureValueJLabel.setText( "Future value:" );
      contentPane.add( futureValueJLabel );

      // set up futureValueJTextField
      futureValueJTextField = new JTextField();
      futureValueJTextField.setBounds( 130, 25, 100, 20 );
      futureValueJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( futureValueJTextField );
      futureValueJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when 
            // futureValueJTextField is edited
            public void keyPressed( KeyEvent event )
            {
               futureValueJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up interestRateJLabel
      interestRateJLabel = new JLabel();
      interestRateJLabel.setBounds( 20, 60, 90, 20 );
      interestRateJLabel.setText( "Interest rate:" );
      contentPane.add( interestRateJLabel );
      
      // set up interestRateJTextField
      interestRateJTextField = new JTextField();
      interestRateJTextField.setBounds( 130, 60, 100, 20 );
      interestRateJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( interestRateJTextField );
      interestRateJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when 
            // interestRateJTextField is edited
            public void keyPressed( KeyEvent event )
            {
               interestRateJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener

      // set up yearsJLabel
      yearsJLabel = new JLabel();
      yearsJLabel.setBounds( 20, 95, 80, 20 );
      yearsJLabel.setText( "Years:" );
      contentPane.add( yearsJLabel );

      // set up yearsJSpinner
      yearsJSpinner = new JSpinner( 
         new SpinnerNumberModel( 0, 0, 30, 5 ) );
      yearsJSpinner.setBounds( 130, 95, 100, 20 );
      contentPane.add( yearsJSpinner );
      yearsJSpinner.addChangeListener(

         new ChangeListener() // anonymous inner class
         {
            // event handler called when yearsJSpinner is changed
            public void stateChanged( ChangeEvent event )
            {
               
            }

         } // end anonymous inner class

      ); // end call to addChangeListener

      // set up amountNeededJLabel
      amountNeededJLabel = new JLabel();
      amountNeededJLabel.setBounds( 20, 130, 150, 20 );
      amountNeededJLabel.setText( "Annual amount needed:" );
      contentPane.add( amountNeededJLabel );
      
      // set up amountNeededJTextArea
      amountNeededJTextArea = new JTextArea();
      amountNeededJTextArea.setBounds( 20, 155, 320, 115 );
      amountNeededJTextArea.setEditable( false );
      contentPane.add( amountNeededJTextArea );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 250, 25, 90, 20 );
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

      clearJButton = new JButton();
      clearJButton.setBounds( 250, 60, 90, 20 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Present Value Calculator" ); // set title bar string
      setSize( 370, 320 );                    // set window size
      setVisible( true );                     // show window
      
   } // end method createUserInterface
   
   // calculate and display amounts
   private void calculateJButtonActionPerformed( ActionEvent event )
   {     
      String futureValueText = futureValueJTextField.getText();
      int futureValue = Integer.parseInt( futureValueText );
      String rateText = interestRateJTextField.getText();
      double rate = Double.parseDouble( rateText );

      Integer integerObject = ( Integer ) yearsJSpinner.getValue();
      int years = integerObject.intValue();
      
      amountNeededJTextArea.setText( "Year\tInitial Deposit" );
      DecimalFormat dollars = new DecimalFormat( "$0.00" );
      
      // for loop calculates total amount
      for ( int counter = 5; counter <= years; counter += 5 )  
      {
         double amount = futureValue / Math.pow(
            ( 1 + rate / 100 ), counter );
         amountNeededJTextArea.append( 
            "\n" + counter + "\t" + dollars.format( amount ) );

      } // end for

   } // end method calculateJButtonActionPerformed

   // clear the JTextArea
   private void futureValueJTextFieldKeyPressed( KeyEvent event )
   {
      amountNeededJTextArea.setText( "" );

   } // end method futureValueJTextFieldKeyPressed

   // clear the JTextArea
   private void interestRateJTextFieldKeyPressed( KeyEvent event )
   {
      amountNeededJTextArea.setText( "" );

   } // end method interestRateJTextFieldKeyPressed
   
   // main method
   public static void main( String args[] )
   {
      PresentValue application = new PresentValue();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class PresentValue

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