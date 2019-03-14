// Exercise 10.16: SavingsCalculator.java
// Application that calculates the amount of money the user will have
// after one year of saving $100 a month, plus an initial deposit.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SavingsCalculator extends JFrame
{
   // JLabel and JTextField for starting amount
   private JLabel startingJLabel;
   private JTextField startingJTextField;

   // JLabel and JTextField for amount after one year
   private JLabel yearJLabel;
   private JTextField yearJTextField;

   // JButton calculates amounts after one, two and three years
   private JButton calculateJButton;
   
   // no-argument constructor
   public SavingsCalculator()
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
      
      // set up startingJLabel
      startingJLabel = new JLabel();
      startingJLabel.setBounds( 15, 15, 120, 20 );
      startingJLabel.setText( "Starting amount:" );
      contentPane.add( startingJLabel );

      // set up startingJTextField
      startingJTextField = new JTextField();
      startingJTextField.setBounds( 155, 15, 90, 20 );
      startingJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( startingJTextField );
      
      // set up yearJLabel
      yearJLabel = new JLabel();
      yearJLabel.setBounds( 15, 50, 160, 20 );
      yearJLabel.setText( "Amount after one year:" );
      contentPane.add( yearJLabel );

      // set up yearJTextField
      yearJTextField = new JTextField();
      yearJTextField.setBounds( 155, 50, 90, 20 );
      yearJTextField.setText( "0" );
      yearJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( yearJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 155, 85, 90, 20 );
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
      setTitle( "Savings Calculator" ); // set title bar text
      setSize( 270, 150 );              // set window size
      setVisible( true );               // display window

   } // end method createUserInterface
   
   // calculate and display amount
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      int deposit = Integer.parseInt( startingJTextField.getText() );
      
      // for loop increments deposit
      for ( int counter = 1; counter < 12; counter++ )
      {
          deposit += 100;
      }
      
      // display deposit in yearJTextField
      yearJTextField.setText( String.valueOf( deposit ) );
      
   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      SavingsCalculator application = new SavingsCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
}  // end class SavingsCalculator

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
