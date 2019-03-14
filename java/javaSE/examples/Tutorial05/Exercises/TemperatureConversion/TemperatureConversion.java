// Exercise 5.12 TemperatureConversion.java
// Application that converts a Celsius temperature to its equivalent
// Fahrenheit temperature.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConversion extends JFrame
{
   // JLabel and JTextField for Celsius input
   private JLabel celsiusJLabel;
   private JTextField celsiusJTextField;

   // JLabel and JTextField for Fahrenheit output
   private JLabel fahrenheitJLabel;
   private JTextField fahrenheitJTextField;

   // JButton to initiate Celsius to Fahrenheit conversion
   private JButton convertJButton;
   
   // no-argument constructor
   public TemperatureConversion()
   {
      createUserInterface();
   }
   
   // create and position GUI componments; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up celsiusJLabel
      celsiusJLabel = new JLabel();
      celsiusJLabel.setText( "Enter a Celsius temperature:" );
      celsiusJLabel.setBounds( 10, 10, 170, 24 );
      contentPane.add( celsiusJLabel );
      
      // set up celsiusJTextField
      celsiusJTextField = new JTextField();
      celsiusJTextField.setBounds( 180, 10, 100, 24 );
      contentPane.add( celsiusJTextField );
      celsiusJTextField.addKeyListener(
         
         new KeyAdapter() // anonymous inner class
         {
            // called when key pressed in celsiusJTextField
            public void keyPressed( KeyEvent event )
            {
               celsiusJTextFieldKeyPressed( event );
            }
            
         } // end anonymous inner class
      
      ); // end call to addKeyListener
            
      // set up fahrenheitJLabel
      fahrenheitJLabel = new JLabel();
      fahrenheitJLabel.setText( "Fahrenheit equivalent:" );
      fahrenheitJLabel.setBounds( 10, 40, 170, 24 );
      contentPane.add( fahrenheitJLabel );
      
      // set up fahrenheitJTextField
      fahrenheitJTextField = new JTextField();
      fahrenheitJTextField.setEditable( false );
      fahrenheitJTextField.setBounds( 180, 40, 100, 24 );
      contentPane.add( fahrenheitJTextField );
      
      // set up convertJButton
      convertJButton = new JButton ();
      convertJButton.setText( "Convert" );
      convertJButton.setBounds( 290, 10, 80, 24 );
      contentPane.add( convertJButton );
      convertJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // called when convertJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               convertJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
	 
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Temperature Conversion" ); // set title bar text
      setSize( 385, 100 );                  // set window size
      setVisible( true );                   // display window
   
   } // end method createUserInterface
   
   // clear fahrenheitJTextField because the value is now invalid
   private void celsiusJTextFieldKeyPressed( KeyEvent event )
   {
      
   } // end method celsiusJTextFieldKeyTyped
   
   // convert Celsius value to Fahrenheit value
   private void convertJButtonActionPerformed( ActionEvent event )
   {
   
   } // end method convertJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      TemperatureConversion application = 
         new TemperatureConversion();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class TemperatureConversion


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
