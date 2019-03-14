// Exercise 6.11: CurrencyConverter.java
// Converts dollar amounts into other currency.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame
{
   // JLabel and JTextField to input dollar amount
   private JLabel dollarJLabel;
   private JTextField dollarJTextField;
   
   // JLabel and JTextField to input currency type to convert to
   private JLabel typeJLabel;
   private JTextField typeJTextField;
   
   // JLabel and JTextField to display converted value
   private JLabel convertedJLabel;
   private JTextField convertedJTextField;
   
   // JButton to initiate conversion
   private JButton convertJButton;
   
   // no-argument constructor
   public CurrencyConverter()
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
      
      // set up dollarJLabel
      dollarJLabel = new JLabel();
      dollarJLabel.setBounds( 16, 16, 128, 21 );
      dollarJLabel.setText( "Dollars to convert:" );
      contentPane.add( dollarJLabel );
            
      // set up dollarJTextField
      dollarJTextField = new JTextField();
      dollarJTextField.setBounds( 175, 16, 96, 21 );
      dollarJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( dollarJTextField );
      
      // set up typeJLabel
      typeJLabel = new JLabel();
      typeJLabel.setBounds( 16, 56, 150, 21 );
      typeJLabel.setText( "Convert from dollars to:" );
      contentPane.add( typeJLabel );
      
      // set up typeJTextField
      typeJTextField = new JTextField();
      typeJTextField.setBounds( 175, 56, 96, 21 );
      typeJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( typeJTextField );
      
      // set up convertedJLabel
      convertedJLabel = new JLabel();
      convertedJLabel.setBounds( 16, 96, 112, 24 );
      convertedJLabel.setText( "Converted amount:" );
      contentPane.add( convertedJLabel );

      // set up convertedJTextField
      convertedJTextField = new JTextField();
      convertedJTextField.setBounds( 175, 96, 96, 21 );
      convertedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      convertedJTextField.setEditable( false );
      contentPane.add( convertedJTextField );
      
      // set up convertJButton and register its event handler
      convertJButton = new JButton();
      convertJButton.setText( "Convert" );
      convertJButton.setBounds( 175, 136, 96, 24 );
      contentPane.add( convertJButton );
      convertJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when convertJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                convertJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Currency Converter" ); // set title bar text
      setSize( 300, 200 );              // set window size
      setVisible( true );               // display window
      
   } // end method createUserInterface
   
   // this method is called when the user clicks convertJButton
   private void convertJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method convertJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      CurrencyConverter application = new CurrencyConverter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class CurrencyConverter


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
