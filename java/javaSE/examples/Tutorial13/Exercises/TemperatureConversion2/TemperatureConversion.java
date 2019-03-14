// Exercise 13.12: TemperatureConversion.java
// Converts a degree amount from Celsius to Fahrenheit,
// or from Fahrenheit to Celsius.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class TemperatureConversion extends JFrame
{
   // JLabel and JTextField for Fahrenheit
   private JLabel fahrenheitJLabel;
   private JTextField fahrenheitJTextField;
   
   // JLabel and JTextField for Celsius
   private JLabel celsiusJLabel;
   private JTextField celsiusJTextField;

   // DecimalFormat for temperatures
   DecimalFormat temperature = new DecimalFormat( "0.0" );

   // no-argument constructor
   public TemperatureConversion()
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

      // set up fahrenheitJLabel
      fahrenheitJLabel = new JLabel();
      fahrenheitJLabel.setBounds( 12, 24, 72, 21 );
      fahrenheitJLabel.setText( "Fahrenheit:" );
      contentPane.add( fahrenheitJLabel );

      // set up fahrenheitJTextField
      fahrenheitJTextField = new JTextField();
      fahrenheitJTextField.setBounds( 78, 24, 64, 21 );
      fahrenheitJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( fahrenheitJTextField );
      fahrenheitJTextField.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enter is pressed in 
            // fahrenheitJTextField
            public void actionPerformed( ActionEvent event )
            {
               
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up celsiusJLabel
      celsiusJLabel = new JLabel();
      celsiusJLabel.setBounds( 162, 24, 56, 21 );
      celsiusJLabel.setText( "Celsius:" );
      contentPane.add( celsiusJLabel );

      // set up celsiusJTextField
      celsiusJTextField = new JTextField();
      celsiusJTextField.setBounds( 212, 24, 64, 21 );
      celsiusJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( celsiusJTextField );
      celsiusJTextField.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enter is pressed in 
            // celsiusJTextField
            public void actionPerformed( ActionEvent event )
            {
               
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Temperature Converter" ); // set title-bar string
      setSize( 306, 100 );                 // set window size
      setVisible( true );                  // show window

   } // end method createUserInterface

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