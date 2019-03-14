// Exercise 5.17 DigitExtractor.java
// Application that separates a five-digit number into digits.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DigitExtractor extends JFrame
{
   // JLabel and JTextField for user to input number
   private JLabel enterNumberJLabel;
   private JTextField enterNumberJTextField;

   // JLabel and JTextFields for displaying extracted digits
   private JLabel extractedDigitsJLabel;
   private JTextField firstNumberJTextField;
   private JTextField secondNumberJTextField;
   private JTextField thirdNumberJTextField;
   private JTextField fourthNumberJTextField;
   private JTextField fifthNumberJTextField;

   // JButton to initiate extraction of digits
   private JButton enterJButton;
   
   // no-argument constructor
   public DigitExtractor()
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
      enterNumberJLabel.setText( "Enter five-digit number:" );
      enterNumberJLabel.setBounds( 10, 10, 150, 24 );
      contentPane.add( enterNumberJLabel );

      // set up enterNumberJTextField
      enterNumberJTextField = new JTextField();
      enterNumberJTextField.setBounds( 160, 10, 110, 24 );
      contentPane.add( enterNumberJTextField );

      // set up extractedDigitsJLabel
      extractedDigitsJLabel = new JLabel();
      extractedDigitsJLabel.setText( "Extracted digits:" );
      extractedDigitsJLabel.setBounds( 10, 45, 150, 24 );
      contentPane.add( extractedDigitsJLabel );

      // set up firstNumberJTextField
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setEditable( false );
      firstNumberJTextField.setBounds( 160, 45, 15, 24 );
      firstNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( firstNumberJTextField );

      // set up secondNumberJTextField
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setEditable( false );
      secondNumberJTextField.setBounds( 180, 45, 15, 24 );
      secondNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( secondNumberJTextField );

      // set up thirdNumberJTextField
      thirdNumberJTextField = new JTextField();
      thirdNumberJTextField.setEditable( false );
      thirdNumberJTextField.setBounds( 200, 45, 15, 24 );
      thirdNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( thirdNumberJTextField );

      // set up fourthNumberJTextField
      fourthNumberJTextField = new JTextField();
      fourthNumberJTextField.setEditable( false );
      fourthNumberJTextField.setBounds( 220, 45, 15, 24 );
      fourthNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( fourthNumberJTextField );

      // set up fifthNumberJTextField
      fifthNumberJTextField = new JTextField();
      fifthNumberJTextField.setEditable( false );
      fifthNumberJTextField.setBounds( 240, 45, 15, 24 );
      fifthNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( fifthNumberJTextField );

      // set up enterJButton 
      enterJButton = new JButton ();
      enterJButton.setText( "Enter" );
      enterJButton.setBounds( 280, 10, 70, 24 );
      enterJButton.addActionListener( 
         
         new ActionListener() // anonymous inner class
         {
            // called when enterJButton is pressed
            public void actionPerformed( ActionEvent event ) 
            {
               enterJButtonActionPerformed( event );
            }
         
         } // end anonymous inner class
	 
      ); // end call to addActionListener
      
      contentPane.add( enterJButton );
      
      // set properties of application's window
      setTitle( "Digit Extractor" ); // set title bar text
      setSize( 370, 105 );           // set window size
      setVisible( true );            // display window
   
   } // end method createUserInterface
   
   // extract and display individual digits
   private void enterJButtonActionPerformed( ActionEvent event )
   {
   
   } // end method enterJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      DigitExtractor application = new DigitExtractor();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
  
} // end class DigitExtractor


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
