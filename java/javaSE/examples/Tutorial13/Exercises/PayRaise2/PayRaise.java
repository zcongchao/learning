// Exercise 13.16: PayRaise.java
// Application that calculates yearly salaries given an annual 
// raise percentage and number of years.
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
   
   // no-argument constructor
   public PayRaise()
   {
      createUserInterface();

      // display initial yearly wage in JTextArea
      calculateWages();
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
      contentPane.add( raiseJLabel);

      // set up raiseJSpinner
      raiseJSpinner = new JSpinner( 
         new SpinnerNumberModel( 3, 3, 8, 1 ) );
      raiseJSpinner.setBounds( 170, 25, 70, 22 );
      contentPane.add( raiseJSpinner );
      raiseJSpinner.addChangeListener(

         new ChangeListener() // anonymous inner class
         {
            // event handler called when raiseJSpinner is changed
            public void stateChanged( ChangeEvent event )
            {

            }

         } // end anonymous inner class

      ); // end call to addChangeListener
      
      // set up yearsJLabel
      yearsJLabel = new JLabel();
      yearsJLabel.setBounds( 20, 60, 80, 20 );
      yearsJLabel.setText( "Years:" );
      contentPane.add( yearsJLabel );

      // set up yearsJSpinner
      yearsJSpinner = new JSpinner(
         new SpinnerNumberModel( 1, 1, 50, 1 ) );
      yearsJSpinner.setBounds( 170, 60, 70, 22 );
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
      
      // set up amountEarnedJLabel
      amountEarnedJLabel = new JLabel();
      amountEarnedJLabel.setBounds( 20, 95, 150, 20 );
      amountEarnedJLabel.setText( "Yearly amount earned:" );
      contentPane.add( amountEarnedJLabel );

      // set up amountEarnedJTextArea
      amountEarnedJTextArea = new JTextArea();
      amountEarnedJTextArea.setEditable( false );

      // set up amountEarnedJScrollPane
      amountEarnedJScrollPane = new JScrollPane(
         amountEarnedJTextArea );
      amountEarnedJScrollPane.setBounds( 20, 120, 330, 115 );
      contentPane.add( amountEarnedJScrollPane );
      
      // set properties of application's window
      setTitle( "Pay Raise Calculator" ); // set title-bar string
      setSize( 380, 280 );                // set window size
      setVisible( true );                 // show window
      
   } // end method createUserInterface
   
   // calculate and display yearly wages
   private void calculateWages()
   {
      // store weekly starting wage
      double wage = 500;

      Integer integerRaiseObject = 
         ( Integer ) raiseJSpinner.getValue();
      int rate = integerRaiseObject.intValue();

      Integer integerYearsObject = 
         ( Integer ) yearsJSpinner.getValue();
      int years = integerYearsObject.intValue();

      amountEarnedJTextArea.setText( "Year\tAmount" );
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      // for loop calculates total
      for ( int counter = 1; counter <= years; counter++ )  
      {
         double amount = wage * 52;
         amountEarnedJTextArea.append( 
		    "\n" + counter + "\t" + dollars.format( amount ) );
         
         wage *= ( 1 + ( ( double ) rate / 100 ) );

      } // end for

   } // end method calculateWages
   
   // main method
   public static void main( String args[] )
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