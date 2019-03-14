// Exercise 24.13 SimpleCalculator.java
// Application that takes two numbers and performs arithmetic 
// operations with the input values.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame
{
   // JLabel and JTextField for user to input first number
   private JLabel firstNumberJLabel;
   private JTextField firstNumberJTextField;
   
   // JLabel and JTextField for user to input second number
   private JLabel secondNumberJLabel;
   private JTextField secondNumberJTextField;
   
   // JLabel and JTextField to display result
   private JLabel resultJLabel;
   private JTextField resultJTextField;

   // JButtons to initiate calculations
   private JButton addJButton;
   private JButton subtractJButton;
   private JButton multiplyJButton;
   private JButton divideJButton;
   
   // no-argument constructor
   public SimpleCalculator()
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
      
      // set up firstNumberLabel
      firstNumberJLabel = new JLabel();
      firstNumberJLabel.setBounds( 20, 20, 130, 25 );
      firstNumberJLabel.setText( "Enter first number:" );
      contentPane.add( firstNumberJLabel );
      
      // set up firstNumberJTextField
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setBounds( 170, 20, 60, 25 );
      firstNumberJTextField.setText( "0" );
      firstNumberJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( firstNumberJTextField );
      firstNumberJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when key pressed 
            // in firstNumberJTextField
            public void keyPressed( KeyEvent event )
            {
               firstNumberJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up secondNumberJLabel
      secondNumberJLabel = new JLabel();
      secondNumberJLabel.setBounds( 20, 55, 130, 25 );
      secondNumberJLabel.setText( "Enter second number:" );
      contentPane.add( secondNumberJLabel );
      
      // set up secondNumberJTextField
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setBounds( 170, 55, 60, 25 );
      secondNumberJTextField.setText( "0" );
      secondNumberJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( secondNumberJTextField );
      secondNumberJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when key pressed 
            // in secondNumberJTextField
            public void keyPressed( KeyEvent event )
            {
               secondNumberJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 20, 90, 130, 25 );
      resultJLabel.setText( "Result:" );
      contentPane.add( resultJLabel );
                  
      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 170, 90, 60, 25 );
      resultJTextField.setText( "" );
      resultJTextField.setHorizontalAlignment( JTextField.RIGHT );
      resultJTextField.setEditable( false );
      contentPane.add( resultJTextField );
      
      // set up addJButton
      addJButton = new JButton ();
      addJButton.setBounds( 250, 20, 41, 25 );
      addJButton.setText( "+" );
      addJButton.setFont( new Font( "Monospaced", Font.PLAIN, 12 ) );
      contentPane.add( addJButton );
      addJButton.addActionListener( 
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when addJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }
         
         } // end anonymous inner class
	 
      ); // end call to addActionListener
            
      // set up subtractJButton
      subtractJButton = new JButton ();
      subtractJButton.setBounds( 301, 20, 41, 25 );
      subtractJButton.setText( "-" );
      subtractJButton.setFont( 
         new Font( "Monospaced", Font.PLAIN, 12 ) );
      contentPane.add( subtractJButton );
      subtractJButton.addActionListener( 
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when subtractJButton is pressed
            public void actionPerformed( ActionEvent event )
      	   {
               subtractJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
	 
      ); // end call to addActionListener
            
      // set up multiplyJButton
      multiplyJButton = new JButton ();
      multiplyJButton.setBounds( 250, 55, 41, 25 );
      multiplyJButton.setText( "*" );
      multiplyJButton.setFont( 
         new Font( "Monospaced", Font.PLAIN, 12 ) );
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

      // set up divideJButton
      divideJButton = new JButton ();
      divideJButton.setBounds( 301, 55, 41, 25 );
      divideJButton.setText( "/" );
      divideJButton.setFont( 
         new Font( "Monospaced", Font.PLAIN, 12 ) );
      contentPane.add( divideJButton );
      divideJButton.addActionListener( 
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when divideJButton is pressed
            public void actionPerformed( ActionEvent event )
       	   {
               divideJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
	 
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Calculator" ); // set title bar String
      setSize( 370, 160 );      // set window size
      setVisible( true );       // display window
   
   } // end method createUserInterface
   
   // clear resultJTextField because the value is now invalid
   private void firstNumberJTextFieldKeyPressed( KeyEvent event )
   {
      resultJTextField.setText( "" ); // clear resultJTextField
      
   } // end method firstNumberKeyPressed
   
   // clear resultJTextField because the value is now invalid
   private void secondNumberJTextFieldKeyPressed( KeyEvent event )
   {
      resultJTextField.setText( "" ); // clear resultJTextField
      
   } // end method secondNumberJTextFieldKeyPressed
   
   // add the two numbers
   private void addJButtonActionPerformed( ActionEvent event )
   {
      int number1 = 
         Integer.parseInt( firstNumberJTextField.getText() );
      int number2 = 
         Integer.parseInt( secondNumberJTextField.getText() );

      // add the two values and store in result
      int result = number1 + number2;
      
      // display the result
      resultJTextField.setText( String.valueOf( result ) );
         
   } // end method addJButtonActionPerformed
   
   // subtract the two numbers
   private void subtractJButtonActionPerformed( ActionEvent event )
   {
      int number1 = 
         Integer.parseInt( firstNumberJTextField.getText() );
      int number2 = 
         Integer.parseInt( secondNumberJTextField.getText() );

      // subtract the two values and store in result
      int result = number1 - number2;
      
      // display the result
      resultJTextField.setText( String.valueOf( result ) );

   } // end method subtractJButtonActionPerformed
   
   // multiply the two numbers
   private void multiplyJButtonActionPerformed( ActionEvent event )
   {
      int number1 = 
         Integer.parseInt( firstNumberJTextField.getText() );
      int number2 = 
         Integer.parseInt( secondNumberJTextField.getText() );

      // multiply the two values and store in result
      int result = number1 * number2;
     
      // display the result
      resultJTextField.setText( String.valueOf( result ) );
   
   } // end method multiplyJButtonActionPerformed
   
   // divide the two numbers
   private void divideJButtonActionPerformed( ActionEvent event )
   {
      int number1 = 
         Integer.parseInt( firstNumberJTextField.getText() );
      int number2 = 
         Integer.parseInt( secondNumberJTextField.getText() );

      // divide the two values and store in result
      int result = number1 / number2;
      
      // display the result
      resultJTextField.setText( String.valueOf( result ) );

   } // end method divideJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      SimpleCalculator application = new SimpleCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class SimpleCalculator

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