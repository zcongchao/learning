// Exercise 9.13: ArithmeticCalculator.java
// This application accepts two operands and allows
// the user to perform multiplication or addition.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArithmeticCalculator extends JFrame
{
   // JLabel and JTextArea for operands entered by user
   private JLabel operandsJLabel;
   private JTextArea operandsJTextArea;

   // JLabel and JTextField displays result of calculation
   private JLabel resultJLabel;
   private JTextField resultJTextField;

   // JButton initiates asking user for operands
   private JButton enterOperandsJButton;

   // JButtons initiate adding and/or multiplying operands
   private JButton addJButton;
   private JButton multiplyJButton;

   private double value1 = 0; // holds the first value entered
   private double value2 = 0; // holds the second value entered

   // no-argument constructor
   public ArithmeticCalculator()
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

      // set up operandsJLabel
      operandsJLabel = new JLabel();
      operandsJLabel.setBounds( 16, 8, 100, 16 );
      operandsJLabel.setText( "Operands:" );
      contentPane.add( operandsJLabel );

      // set up operandsJTextArea
      operandsJTextArea = new JTextArea();
      operandsJTextArea.setBounds( 16, 27, 104, 32 );
      operandsJTextArea.setEditable( false );
      contentPane.add( operandsJTextArea );

      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 16, 64, 53, 23 );
      resultJLabel.setText( "Result:" );
      contentPane.add( resultJLabel );

      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 16, 91, 104, 26 );
      resultJTextField.setEditable( false );
      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( resultJTextField );
      
      // set up enterOperandsJButton
      enterOperandsJButton = new JButton();
      enterOperandsJButton.setBounds( 140, 27, 125, 26 );
      enterOperandsJButton.setText( "Enter Operands" );
      contentPane.add( enterOperandsJButton );
      enterOperandsJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when enterOperandsJButton pressed
            public void actionPerformed( ActionEvent event )
            {
               enterOperandsJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set up addJButton
      addJButton = new JButton();
      addJButton.setBounds( 140, 59, 125, 26 );
      addJButton.setText( "Add" );
      addJButton.setEnabled( false );
      contentPane.add( addJButton );
      addJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler  called when addJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set up multiplyJButton
      multiplyJButton = new JButton();
      multiplyJButton.setBounds( 140, 91, 125, 26 );
      multiplyJButton.setText( "Multiply" );
      multiplyJButton.setEnabled( false );
      contentPane.add( multiplyJButton );
      multiplyJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when multiplyJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               multiplyJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Arithmetic Calculator" ); // set title bar text
      setSize( 290, 159 );                 // set window size
      setVisible( true );                  // display window
      
   } // end method createUserInterface
   
   // store and display input
   private void enterOperandsJButtonActionPerformed(
      ActionEvent event )
   {
      int counter = 1;
      String input;

      // remove previous data
      operandsJTextArea.setText( "" );
      resultJTextField.setText( "" );

      do // loop twice, once for each operand
      {
         // convert input
         if ( counter == 1 )
         {

         }
         else
         {

         }
      }
      while ( false );

      // display operands
      operandsJTextArea.setText( value1 + "\n" + value2 );

      // allow user to click calculate JButtons
      addJButton.setEnabled( true );
      multiplyJButton.setEnabled( true );
            
   } // end method enterOperandsJButtonActionPerformed
   
   // add and display result
   private void addJButtonActionPerformed( ActionEvent event )
   {
      double result = value1 + value2;
      resultJTextField.setText( String.valueOf( result ) );
   
   } // end method addJButtonActionPerformed
   
   // multiply and display result
   private void multiplyJButtonActionPerformed( ActionEvent event )
   {
      double result = value1 * value2;
      resultJTextField.setText( String.valueOf( result ) );
      
   } // end method multiplyJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      ArithmeticCalculator application = new ArithmeticCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class ArithmeticCalculator

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
