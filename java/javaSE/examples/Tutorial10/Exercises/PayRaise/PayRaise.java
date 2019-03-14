// Exercise 10.17: PayRaise.java
// Application that calculates how much money should be invested in
// order to achieve a certain financial goal.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class PayRaise extends JFrame
{
   // JLabel and JSpinner for yearly raise
   private JLabel raiseJLabel;
   private JSpinner raiseJSpinner;

   // JLabel and JSpinner for number of years
   private JLabel yearsJLabel;
   private JSpinner yearsJSpinner;

   // JLabel and JTextArea for amount earned
   // after a certain number of years
   private JLabel amountEarnedJLabel;
   private JTextArea amountEarnedJTextArea;

   // JScrollPane adds scrollbars to amountEarnedJTextArea
   private JScrollPane amountEarnedJScrollPane;

   // JButton calculates amount earned
   private JButton calculateJButton;
   
   // no-argument constructor
   public PayRaise()
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
      
      // set up raiseJLabel
      raiseJLabel = new JLabel();
      raiseJLabel.setBounds( 20, 25, 150, 20 );
      raiseJLabel.setText( "Amount of raise (in %):" );
      contentPane.add( raiseJLabel );

      // set up raiseJSpinner
      raiseJSpinner = new JSpinner( 
         new SpinnerNumberModel() );
      contentPane.add( raiseJSpinner );
      
      // set up yearsJLabel
      yearsJLabel = new JLabel();
      yearsJLabel.setBounds( 20, 60, 80, 20 );
      yearsJLabel.setText( "Years:" );
      contentPane.add( yearsJLabel );

      // set up yearsJSpinner
      yearsJSpinner = new JSpinner(
         new SpinnerNumberModel() );
      contentPane.add( yearsJSpinner );
      
      // set up amountEarnedJLabel
      amountEarnedJLabel = new JLabel();
      amountEarnedJLabel.setBounds( 20, 95, 150, 20 );
      amountEarnedJLabel.setText( "Yearly amount earned:" );
      contentPane.add( amountEarnedJLabel );

      // set up amountEarnedJTextArea
      amountEarnedJTextArea = new JTextArea();

      // set up amountEarnedJScrollPane
      amountEarnedJScrollPane = new JScrollPane();
      contentPane.add( amountEarnedJScrollPane );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 260, 25, 90, 20 );
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
      setTitle( "Pay Raise Calculator" ); // set title bar text
      setSize( 380, 280 );                // set window size
      setVisible( true );                 // display window
      
   } // end method createUserInterface
   
   // calculate and display amounts
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // store weekly starting wage
      double wage = 500; 

      amountEarnedJTextArea.setText( "Year\tAmount" );
      DecimalFormat dollars = new DecimalFormat( "$0.00" );
      
      // for loop calculates total
      for ( ;; )  
      {

      } // end for

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      PayRaise application = new PayRaise();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class PayRaise

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
