// Exercise 23.12: Encryption.java
// Encrypts data entered by users.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Encryption extends JFrame
{
   // JLabel and JTextField for user input
   private JLabel instructionJLabel;
   private JTextField plainJTextField;

   // ButtonGroup to contain JRadioButtons
   private ButtonGroup radioButtonGroup;

   // JRadioButtons to allow two types of encryption
   private JRadioButton substitutionJRadioButton;
   private JRadioButton transpositionJRadioButton;

   // JLabel and JTextField for output
   private JLabel resultJLabel;
   private JTextField cipherJTextField;

   // JButton to encrypt phrase
   private JButton encryptJButton;

   // no-argument constructor
   public Encryption()
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
      
      // set up instructionJLabel
      instructionJLabel = new JLabel();
      instructionJLabel.setBounds( 16, 16, 126, 21 );
      instructionJLabel.setText( "Enter text to encrypt:" );
      contentPane.add( instructionJLabel );
      
      // set up plainJTextField
      plainJTextField = new JTextField();
      plainJTextField.setBounds( 150, 16, 207, 21 );
      contentPane.add( plainJTextField );
      
      // create logical relationship between JRadioButtons
      radioButtonGroup = new ButtonGroup();
      
      // set up substitutionJRadioButton
      substitutionJRadioButton = new JRadioButton();
      substitutionJRadioButton.setBounds( 24, 56, 140, 24 );
      substitutionJRadioButton.setText( "Substitution Cipher" );
      substitutionJRadioButton.setSelected( true );
      radioButtonGroup.add( substitutionJRadioButton );
      contentPane.add( substitutionJRadioButton );
      
      // set up transpositionJRadioButton
      transpositionJRadioButton = new JRadioButton();
      transpositionJRadioButton.setBounds( 184, 56, 148, 24 );
      transpositionJRadioButton.setText( "Transposition Cipher" );
      radioButtonGroup.add( transpositionJRadioButton );
      contentPane.add( transpositionJRadioButton );
      
      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 16, 96, 100, 21 );
      resultJLabel.setText( "Encrypted text:" );
      contentPane.add( resultJLabel );
      
      // set up cipherJTextField
      cipherJTextField = new JTextField();
      cipherJTextField.setBounds( 150, 96, 207, 21 );
      cipherJTextField.setEditable( false );
      contentPane.add( cipherJTextField );
      
      // set up encryptJButton
      encryptJButton = new JButton();
      encryptJButton.setBounds( 272, 128, 85, 23 );
      encryptJButton.setText( "Encrypt" );
      contentPane.add( encryptJButton );
      encryptJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // method called when encryptJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               encryptJButtonActionPerformed( event );
            }
      
         } // end anonymous inner class
      
      ); // end call to addActionListener
           
      // set properties of application's window
      setTitle( "Encryption" ); // set title bar string
      setSize( 376, 192 );      // set window size
      setVisible( true );       // display window

   } // end method createUserInterface

   // encrypt a String of characters
   private void encryptJButtonActionPerformed( ActionEvent event )
   {
      // determine the selected JRadioButton
      if ( substitutionJRadioButton.isSelected() )
      {
         substitutionCipher(); // call substitutionCipher
      }
      else
      {
         transpositionCipher(); // call transpositionCipher
      }

   } // end method encryptJButtonActionPerformed

   // using the substitution cipher, display encrypted text
   private void substitutionCipher()
   {
      // normal alphabet String
      String normalAlphabet = "abcdefghijklmnopqrstuvwxyz .!?,";

      // substitution alphabet String
      String cipherAlphabet = "cdefg.hijk!lmn opqr?stuv,wxyzab";

      String cipher = ""; // encrypted String

      // get text and change all the characters to lower case
      String plainText = plainJTextField.getText();
      String plain = plainText.toLowerCase();

   } // end method substitutionCipher

   // using the transposition cipher, display encypted text
   private void transpositionCipher()
   {
      String firstWord = ""; // first word
      String lastWord = "";  // second word
      
      // get text from plainJTextField
      String plainText = plainJTextField.getText();

   } // end method transpositionCipher

   // main method
   public static void main( String[] args )
   {
      Encryption application = new Encryption();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Encryption

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