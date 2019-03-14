// Exercise 8.12: MortgageCalculator.java
// Calculates mortgage rate based on user inputs
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class MortgageCalculator extends JFrame
{
   // JLabel and JTextField for the mortgage amount
   private JLabel amountJLabel;
   private JTextField amountJTextField;

   // JLabel and JTextField for interest percentage rate
   private JLabel interestJLabel;
   private JTextField interestJTextField;
   
   // JTextArea for displaying results
   private JTextArea outputJTextArea;
   
   // JButton to initiate calculations
   private JButton calculateJButton;
   
   // no-argument constructor
   public MortgageCalculator()
   {
      createUserInterface();
   }
   
   // create and position the GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up amountJLabel
      amountJLabel = new JLabel();
      amountJLabel.setBounds( 16, 16, 104, 26 );
      amountJLabel.setText( "Mortgage amount:" );
      contentPane.add( amountJLabel );
      
      // set up amountJTextField
      amountJTextField = new JTextField();
      amountJTextField.setBounds( 144, 16, 56, 26 );
      amountJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( amountJTextField );
      amountJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler for key pressed in amountJTextField
            public void keyPressed( KeyEvent event )
            {
               amountJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener 
      
      // set up interestJLabel
      interestJLabel = new JLabel( "Annual interest rate:" );
      interestJLabel.setBounds( 16, 56, 115, 26 );
      interestJLabel.setText( "Annual interest rate:" );
      contentPane.add( interestJLabel);
      
      // set up interestJTextField
      interestJTextField = new JTextField();
      interestJTextField.setBounds( 144, 56, 56, 26 );
      interestJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( interestJTextField );
      interestJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // evend handler for key pressed in interestJTextField
            public void interestJTextField( KeyEvent event )
            {
               interestJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener 
            
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 224, 16, 90, 26 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when calculateJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                calculateJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up outputJTextArea
      outputJTextArea = new JTextArea();
      contentPane.add( outputJTextArea );
            
      // set properties of application’s window
      setTitle( "Mortgage Calculator" ); // set title bar text
      setSize( 338, 250 );               // set window's size
      setVisible( true );                // display window
      
   } // end method createUserInterface

   // called when user presses key in amountJTextField
   private void amountJTextFieldKeyPressed( KeyEvent event )
   {
      outputJTextArea.setText( "" );  // clear outputJTextArea
   }
   
   // called when user presses key in interestJTextField
   private void interestJTextFieldKeyPressed( KeyEvent event )
   {
      outputJTextArea.setText( "" );  // clear outputJTextArea
   }
   
   // method called when user clicks calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method calculateJButtonActionPerformed
   
   // calculate monthlyPayment
   private double calculateMonthlyPayment( double monthlyInterest,
      int months, int loanAmount )
   {
      double base = Math.pow( 1 + monthlyInterest, months );
      return loanAmount * monthlyInterest / ( 1 - ( 1 / base ) );
   }

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
