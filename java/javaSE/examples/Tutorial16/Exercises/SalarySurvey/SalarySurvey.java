// Exercise 16.12: SalarySurvey.java
// Application that takes information about employee salaries and
// uses an array to keep track of the number of employees in each
// salary range.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SalarySurvey extends JFrame
{
   // JLabel and JTextField for entering total sales
   private JLabel enterSalesJLabel;
   private JTextField enterSalesJTextField;

   // JButton to calculate the total salary
   private JButton calculateJButton;

   // JLabel and JTextField for displaying the total salary
   private JLabel salaryJLabel;
   private JTextField salaryJTextField;

   // JButton for displaying the totals
   private JButton totalsJButton;

   // JLabel and JTextArea for displaying the survey results
   private JLabel resultJLabel;
   private JTextArea resultJTextArea;

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
      enterSalesJLabel.setBounds( 20, 20, 80, 20 );
      enterSalesJLabel.setText( "Enter sales:" );
      contentPane.add( enterSalesJLabel );

      // set up salesJTextField
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
      
      // set up salaryJLabel
      salaryJLabel = new JLabel();
      salaryJLabel.setBounds( 20, 100, 80, 20 );
      salaryJLabel.setText( "Total salary:" );
      contentPane.add( salaryJLabel );
      
      // set up salaryJTextField
      salaryJTextField = new JTextField();
      salaryJTextField.setBounds( 120, 100, 70, 20 );
      salaryJTextField.setHorizontalAlignment( JTextField.CENTER );
      salaryJTextField.setEditable( false );
      contentPane.add( salaryJTextField );

      // set up totalsJButton
      totalsJButton = new JButton();
      totalsJButton.setBounds( 55, 140, 110, 20 );
      totalsJButton.setText( "Show Totals" );
      contentPane.add( totalsJButton );
      totalsJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when totalsJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               totalsJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
    
      ); // end call to addActionListener
      
      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 20, 180, 100, 20 );
      resultJLabel.setText( "Survey results:" );
      contentPane.add( resultJLabel );
       
      // set up resultJTextArea
      resultJTextArea = new JTextArea();
      resultJTextArea.setBounds( 20, 210, 170, 180 );
      contentPane.add( resultJTextArea );
      
      // set properties of application's window
      setTitle( "Salary Survey" ); // set title bar string
      setSize( 220, 450 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface
   
   // calculate salary; increment counters
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      int sales = Integer.parseInt( enterSalesJTextField.getText() );
      double salary = 200 + .09 * sales;
      
      salaryJTextField.setText( dollars.format( salary ) );

   } // end method calculateJButtonActionPerformed
   
   // display salary ranges and totals
   private void totalsJButtonActionPerformed( ActionEvent event )
   {
      int lowerBound;
      int upperBound;

	  resultJTextArea.setText( "Salary Range:\tTotal:\n" );

   } // end method totalsJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
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