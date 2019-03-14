// Tutorial 6: WageCalculator.java
// This application inputs the hourly wage and number of hours
// worked for an employee, then calculates the employee's gross 
// wages (with overtime for hours worked over 40 hours).
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class WageCalculator extends JFrame 
{
   // JLabel and JTextField for wage per hour
   private JLabel hourlyWageJLabel;
   private JTextField hourlyWageJTextField;

   // JLabel and JTextField for hours worked in a week
   private JLabel hoursWorkedJLabel;
   private JTextField hoursWorkedJTextField;
   
   // JLabel and JTextField for gross wages
   private JLabel grossWagesJLabel;
   private JTextField grossWagesJTextField;
   
   // JButton to initiate wage calculation
   private JButton calculateJButton;
   
   // no-argument constructor
   public WageCalculator()
   {
      createUserInterface();
   }   
   
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null ); 

      // set up hourlyWageJLabel
      hourlyWageJLabel = new JLabel();
      hourlyWageJLabel.setBounds( 16, 16, 90, 21 );
      hourlyWageJLabel.setText( "Hourly wage:" );
      contentPane.add( hourlyWageJLabel );
      
      // set up hourlyWageJTextField
      hourlyWageJTextField = new JTextField();
      hourlyWageJTextField.setBounds( 120, 16, 90, 21 );
      hourlyWageJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( hourlyWageJTextField );
      
      // set up hoursWorkedJLabel
      hoursWorkedJLabel = new JLabel();
      hoursWorkedJLabel.setBounds( 16, 56, 90, 21 );
      hoursWorkedJLabel.setText( "Hours worked:" );
      contentPane.add( hoursWorkedJLabel );
      
      // set up hoursWorkedJTextField
      hoursWorkedJTextField = new JTextField();
      hoursWorkedJTextField.setBounds( 120, 56, 90, 21 );
      hoursWorkedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( hoursWorkedJTextField );
      
      // set up grossWagesJLabel
      grossWagesJLabel = new JLabel();
      grossWagesJLabel.setBounds( 16, 96, 90, 21 );
      grossWagesJLabel.setText( "Gross wages:" );
      contentPane.add( grossWagesJLabel );
      
      // set up grossWagesJTextField
      grossWagesJTextField = new JTextField();
      grossWagesJTextField.setBounds( 120, 96, 90, 21 );
      grossWagesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      grossWagesJTextField.setEditable( false );
      contentPane.add( grossWagesJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 120, 136, 90, 24 );
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
      
      // set properties of application's window
      setTitle( "Wage Calculator" ); // set title bar text
      setSize( 230, 200 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // method called when user presses calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      WageCalculator application = new WageCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class WageCalculator


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
