// Exercise 14.16: Decryption.java
// This application decrypts encrypted data one character at a time.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Decryption extends JFrame
{
   // JLabel and JTextField for encrypted letter
   private JLabel encryptedLetterJLabel;
   private JTextField encryptedLetterJTextField;

   // JButton to decrypt letter
   private JButton decryptJButton;

   // JLabel and JTextField for message
   private JLabel messageJLabel;
   private JTextField messageJTextField;

   // no-argument constructor
   public Decryption()
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
      
      // set up encryptedLetterJLabel
      encryptedLetterJLabel = new JLabel();
      encryptedLetterJLabel.setBounds( 16, 16, 150, 21 );
      encryptedLetterJLabel.setText( "Encrypted letter:" );
      contentPane.add( encryptedLetterJLabel );
      
      // set up encryptedLetterJTextField
      encryptedLetterJTextField = new JTextField();
      encryptedLetterJTextField.setBounds( 142, 16, 43, 24 );
      encryptedLetterJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( encryptedLetterJTextField );
      
      // set up decryptJButton
      decryptJButton = new JButton();
      decryptJButton.setBounds( 229, 16, 86, 24 );
      decryptJButton.setText( "Decrypt" );
      contentPane.add( decryptJButton );
      decryptJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when decryptJButton is clicked
            public void actionPerformed ( ActionEvent event )
            {
               decryptJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set up messageJLabel
      messageJLabel = new JLabel();
      messageJLabel.setBounds( 16, 56, 150, 21 );
      messageJLabel.setText( "Decrypted message:" );
      contentPane.add( messageJLabel );
      
      // set up messageJTextField
      messageJTextField = new JTextField();
      messageJTextField.setBounds( 142, 56, 173, 24 );
      messageJTextField.setHorizontalAlignment( JTextField.CENTER );
      messageJTextField.setEditable( false );
      contentPane.add( messageJTextField );

      // set properties of applications' window
      setTitle( "Decryption" ); // set title bar string
      setSize( 335, 125 );      // set window size
      setVisible( true );       // display window
      
   } // end method createUserInterface
   
   // decrypt letter and append to output
   public void decryptJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method decryptJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      Decryption application = new Decryption();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Decryption

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