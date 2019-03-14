// Exercise 10.12: ComparingRates.java
// Application that calculates the amount of money the user will have
// after one year of saving $100 a month, plus an initial deposit.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class ComparingRates extends JFrame
{
   // JLabel and JTextField for principal amount
   private JLabel principalJLabel;
   private JTextField principalJTextField;

   // JLabel and JTextArea for resulting amounts
   private JLabel resultJLabel;
   private JTextArea resultJTextArea;

   // JButton calculates resulting amounts for various interest rates
   private JButton calculateJButton;
   
   // no-argument constructor
   public ComparingRates()
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
      principalJLabel.setBounds( 20, 20, 80, 20 );
      principalJLabel.setText( "Principal:" );
      contentPane.add( principalJLabel );

      // set up principalJTextField
      principalJTextField = new JTextField();
      principalJTextField.setBounds( 80, 20, 90, 20 );
      principalJTextField.setText( "0" );
      principalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( principalJTextField );
      
      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 20, 60, 100, 20 );
      resultJLabel.setText( "Result:" );
      contentPane.add( resultJLabel );
      
      // set up resultJTextArea
      resultJTextArea = new JTextArea();
      contentPane.add( resultJTextArea );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 190, 20, 90, 20 );
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
      setTitle( "Comparing Rates" ); // set title bar text
      setSize( 310, 255 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // calculate and display amounts
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      resultJTextArea.setText( "Rate (%)\tAmount after 10 years" );
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      int principal = Integer.parseInt( 
         principalJTextField.getText() );
      
      // for loop to calculate interest
      for ( ;; )  
      {

      } // end for

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      ComparingRates application = new ComparingRates();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class ComparingRates

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
