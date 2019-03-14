// Exercise 9.16: Factorial.java
// This application accepts an integer and finds its factorial
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Factorial extends JFrame
{
   // JLabel and JTextField for input
   private JLabel enterNumberJLabel;
   private JTextField enterNumberJTextField;

   // JLabel and JTextField for displaying factorial
   private JLabel factorialJLabel;
   private JTextField factorialJTextField;

   // JButton initiates calculation of factorial
   private JButton calculateJButton;
   
   // no-argument constructor
   public Factorial()
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
      
      // set up enterNumberJLabel
      enterNumberJLabel = new JLabel();
      enterNumberJLabel.setBounds( 16, 16, 80, 23 );
      enterNumberJLabel.setText( "Enter number:" );
      contentPane.add( enterNumberJLabel );
      
      // set up factorialJLabel
      factorialJLabel = new JLabel();
      factorialJLabel.setBounds( 16, 56, 72, 23 );
      factorialJLabel.setText( "Factorial:" );
      contentPane.add( factorialJLabel );
      
      // set up factorialJTextField
      factorialJTextField = new JTextField();
      factorialJTextField.setBounds( 112, 56, 104, 23 );
      factorialJTextField.setEditable( false );
      contentPane.add( factorialJTextField );
      
      // set up enterNumberJTextField
      enterNumberJTextField = new JTextField();
      enterNumberJTextField.setBounds( 112, 16, 104, 23 );
      contentPane.add( enterNumberJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 112, 96, 104, 26 );
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
      
      // set properties of applcation's window
      setTitle( "Factorial" ); // set title bar text
      setSize( 240, 160 );     // set window size
      setVisible( true );      // display window
      
   } // end method createUserInterface
      
   // method to calculate factorial based on input
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      int counter = 1;
      int factorial = 1;
      
      // retrieve user input, use as counter
      counter = Integer.parseInt( enterNumberJTextField.getText() );
      
      do // find factorial
      {
         factorial *= counter;
         counter--; // decrease counter by 1 with each iteration
         
      }
      while( counter >= 0 );
      
      // display value in factorialJTextField
      factorialJTextField.setText( String.valueOf( factorial ) );
      
   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      Factorial application = new Factorial();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class Factorial

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
