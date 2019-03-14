// Exercise 19.11: SalarySurvey.java
// Application that takes information about employee salaries and
// uses an array to keep track of the number of employees in each
// salary range.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;

public class SalarySurvey extends JFrame
{
   // JLabel and JTextField for sales input
   private JLabel enterSalesJLabel;
   private JTextField enterSalesJTextField;

   // JButton to initiate calculation of salary
   private JButton calculateJButton;

   // JLabel and JTextField for salary output
   private JLabel totalSalaryJLabel;
   private JTextField totalSalaryJTextField;

   // JButton to display salaries and totals
   private JButton showTotalsJButton;

   // JLabel and JTextArea for salaries and totals
   private JLabel surveyResultsJLabel;
   private JTextArea surveyResultsJTextArea;

   // String[] and two ArrayLists to hold salaries
   private String[] salaryRangesArray = { "$200-$299",
      "$300-$399", "$400-$499", "$500-$599",
      "$600-$699", "$700-$799", "$800-$899",
      "$900-$999", "$1000 +" };
   private ArrayList rangesArrayList = new ArrayList();

   // int array to hold totals
   int[] resultArray = new int[ 11 ];

   // DecimalFormat to format output
   DecimalFormat dollars = new DecimalFormat( "$0.00" );
   
   // no-argument constructor
   public SalarySurvey()
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

      // set up enterSalesJLabel
      enterSalesJLabel = new JLabel();
      enterSalesJLabel.setBounds( 20, 20, 80, 20);
      enterSalesJLabel.setText( "Enter sales:" );
      contentPane.add( enterSalesJLabel );
      
      // set up enterSalesJTextField
      enterSalesJTextField = new JTextField();
      enterSalesJTextField.setBounds( 120, 20, 70, 20 );
      enterSalesJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( enterSalesJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 55, 60, 110, 20 );
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

      // set up totalSalaryJLabel
      totalSalaryJLabel = new JLabel();
      totalSalaryJLabel.setBounds( 20, 100, 80, 20 );
      totalSalaryJLabel.setText( "Total salary:" );
      contentPane.add( totalSalaryJLabel );
      
      // set up totalSalaryJTextField
      totalSalaryJTextField = new JTextField();
      totalSalaryJTextField.setBounds( 120, 100, 70, 20 );
      totalSalaryJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      totalSalaryJTextField.setEditable( false );
      contentPane.add( totalSalaryJTextField );
      
      // set up showTotalsJButton
      showTotalsJButton = new JButton();
      showTotalsJButton.setBounds( 55, 140, 110, 20 );
      showTotalsJButton.setText( "Show Totals" );
      contentPane.add( showTotalsJButton );
      showTotalsJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when showTotalsJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               showTotalsJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set up surveyResultsJLabel
      surveyResultsJLabel = new JLabel();
      surveyResultsJLabel.setBounds( 20, 180, 100, 20 );
      surveyResultsJLabel.setText( "Survey results:" );
      contentPane.add( surveyResultsJLabel );

      // set up surveyResultsJTextArea
      surveyResultsJTextArea = new JTextArea();
      surveyResultsJTextArea.setBounds( 20, 210, 170, 180 );
      contentPane.add( surveyResultsJTextArea );

      // add all salary ranges to rangesArrayList
      for ( int counter = 0; counter < 9; counter++ )
      {
         rangesArrayList.add( salaryRangesArray[ counter ] );
      }
      
      // set properties of application's window
      setTitle( "Salary Survey" ); // set title bar string
      setSize( 220, 450 );         // set window size
      setVisible( true );          // display window
      
   } // end method createUserInterface
   
   // calculate the total salary based on user input
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // get user input and calculate salary
      int sales = Integer.parseInt( enterSalesJTextField.getText() );
      double salary = 200 + .09 * sales;
      int index = ( int ) salary / 100;

      // increment salary counters
      if ( index >= 10 )
      {
         // increment counters
         resultArray[ 10 ]++;
      }
      else
      {
         // increment counter
         resultArray[ index ]++;
      }

      // display salary
      totalSalaryJTextField.setText( dollars.format( salary ) );
      
   } // end calculateJButtonActionPerformed
   
   // display range of salaries
   private void showTotalsJButtonActionPerformed(
      ActionEvent event )
   {
      
   } // end showTotalsJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      SalarySurvey application = new SalarySurvey();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class SalarySurvey

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