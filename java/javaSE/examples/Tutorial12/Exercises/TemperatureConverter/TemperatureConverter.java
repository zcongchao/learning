// Exercise 12.11: TemperatureConverter.java
// Converts a degree amount from Celsius to Fahrenheit,
// or from Fahrenheit to Celsius.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class TemperatureConverter extends JFrame
{
   // JLabel and JTextField for degrees value, entered by user
   private JLabel degreesJLabel;
   private JTextField degreesJTextField;

   // JTextField displays degrees converted to Fahrenheit or Celsius
   private JTextField outputJTextField;

   // JButtons initiate conversion to Fahrenheit or Celsius
   private JButton convertFahrenheitJButton;
   private JButton convertCelsiusJButton;

   // no-argument constructor
   public TemperatureConverter()
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

      // set up degreesJLabel
      degreesJLabel = new JLabel();
      degreesJLabel.setBounds( 16, 16, 56, 21 );
      degreesJLabel.setText( "Degrees:" );
      contentPane.add( degreesJLabel );

      // set up degreesJTextField
      degreesJTextField = new JTextField();
      degreesJTextField.setBounds( 76, 16, 64, 21 );
      degreesJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( degreesJTextField );

      // set up outputJTextField
      outputJTextField = new JTextField();
      outputJTextField.setBounds( 16, 56, 354, 21 );
      outputJTextField.setHorizontalAlignment( JTextField.CENTER );
      outputJTextField.setEditable( false );
      contentPane.add( outputJTextField );

      // set up convertFahrenheitJButton
      convertFahrenheitJButton = new JButton();
      convertFahrenheitJButton.setBounds( 16, 104, 162, 40 );
      convertFahrenheitJButton.setText( "Convert To Fahrenheit" );
      contentPane.add( convertFahrenheitJButton );
      convertFahrenheitJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when 
            // convertFahrenheitJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               convertFahrenheitJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up convertCelsiusJButton
      convertCelsiusJButton = new JButton();
      convertCelsiusJButton.setBounds( 208, 104, 162, 40 );
      convertCelsiusJButton.setText( "Convert To Celsius" );
      contentPane.add( convertCelsiusJButton );
      convertCelsiusJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when
            // convertCelsiusJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               convertCelsiusJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Temperature Converter" ); // set title bar string
      setSize( 396, 190 );                 // set window size
      setVisible( true );                  // display window

   } // end method createUserInterface

   // converts degrees to Fahrenheit
   private void convertFahrenheitJButtonActionPerformed( 
      ActionEvent event )
   {
      // format temperature value
      DecimalFormat temperature = new DecimalFormat( "0.00" );

      // retrieve input from user
      double degreeCelsius = Double.parseDouble(
         degreesJTextField.getText() );

      // convert from Celsius to Fahrenheit
      double convertedDegree = 0.00;

      // output converted temperature value
      outputJTextField.setText( degreeCelsius + 
         " degrees Celsius is equal to " +
         temperature.format( convertedDegree ) +
         " degrees Fahrenheit." );

   } // end method convertFahrenheitJButtonActionPerformed

   // converts degrees to Celsius
   private void convertCelsiusJButtonActionPerformed(
      ActionEvent event )
   {
      // format temperature value
      DecimalFormat temperature = new DecimalFormat( "0.00" );

      // retrieve input from user
      double degreeFahrenheit = Double.parseDouble(
         degreesJTextField.getText() );

      // convert from Fahrenheit to Celsius
      double convertedDegree = 0.00;

      // output converted temperature value
      outputJTextField.setText( degreeFahrenheit +
         " degrees Fahrenheit is equal to " +
         temperature.format( convertedDegree ) +
         " degrees Celsius." );

   } // end method convertCelsiusJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      TemperatureConverter application = new TemperatureConverter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class TemperatureConverter

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