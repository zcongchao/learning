// Exercise 11.12: IncomeTaxCalculator.java
// Calculates a person's Federal income tax 
// depending that person's salary.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class IncomeTaxCalculator extends JFrame
{
   // JLabel and JTextField for user to input yearly salary
   private JLabel salaryJLabel;
   private JTextField salaryJTextField;

   // JLabel and JTextField to display income tax
   private JLabel incomeTaxJLabel;
   private JTextField incomeTaxJTextField;

   // JButton to initiate tax calculation 
   private JButton calculateJButton;

   // no-argument constructor
   public IncomeTaxCalculator()
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

      // set up salaryJLabel
      salaryJLabel = new JLabel();
      salaryJLabel.setBounds( 20, 20, 100, 20 );
      salaryJLabel.setText( "Yearly Salary:" );
      contentPane.add( salaryJLabel );

      // set up salaryJTextField
      salaryJTextField = new JTextField();
      salaryJTextField.setBounds( 140, 20, 90, 20 );
      salaryJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( salaryJTextField );
      salaryJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when key 
            // pressed in salaryJTextField
            public void keyPressed( KeyEvent event )
            {
               salaryJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up incomeTaxJLabel
      incomeTaxJLabel = new JLabel();
      incomeTaxJLabel.setText( "Income Tax:" );
      incomeTaxJLabel.setBounds( 20, 60, 100, 20 );
      contentPane.add( incomeTaxJLabel );

      // set up incomeTaxJTextField
      incomeTaxJTextField = new JTextField();
      incomeTaxJTextField.setBounds( 140, 60, 90, 20 );
      incomeTaxJTextField.setHorizontalAlignment( JTextField.RIGHT );
      incomeTaxJTextField.setEditable( false );
      contentPane.add( incomeTaxJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 140, 100, 90, 25 );
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

      // set properties of application's window
      setTitle( "Income Tax Calculator" ); // set window title
      setSize( 255, 170 );                 // set window size
      setVisible( true );                  // display window

   } // end method createUserInterface

   // clear incomeTaxJTextField when user types in salaryJTextField
   private void salaryJTextFieldKeyPressed( KeyEvent event )
   {
      incomeTaxJTextField.setText( "" );

   } // end method incomeTaxJTextFieldKeyPressed
   
   // calculate income tax based on user input
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      double taxRate; // stores the tax rate
      int salary = Integer.parseInt( salaryJTextField.getText() );
           
      // display income tax
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

   } // end method calculateJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      IncomeTaxCalculator application = new IncomeTaxCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class IncomeTaxCalculator

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
