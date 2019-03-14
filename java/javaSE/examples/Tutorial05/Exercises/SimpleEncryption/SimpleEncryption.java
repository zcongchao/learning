// Exercise 5.11 SimpleEncryption.java
// Application that uses a simple formula to encrypt numbers.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleEncryption extends JFrame
{
   // JLabel and JTextField for entering number to encrypt
   private JLabel enterJLabel;
   private JTextField enterJTextField;

   // JLabel and JTextField for displaying encrypted number
   private JLabel encryptedJLabel;
   private JTextField encryptedJTextField;

   // JButton to initiate encryption
   private JButton encryptJButton;

   // no-argument constructor
   public SimpleEncryption()
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
      
      // set up enterJLabel
      enterJLabel = new JLabel();
      enterJLabel.setText( "Enter number to encrypt:" );
      enterJLabel.setBounds( 20, 20, 140, 20 );
      contentPane.add( enterJLabel );
      
      // set up enterJTextField
      enterJTextField = new JTextField();
      enterJTextField.setBounds( 180, 20, 50, 20 );
      contentPane.add( enterJTextField );
      enterJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // called when key pressed in enterJTextField
            public void keyPressed( KeyEvent event )
            {
               enterJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener

      // set up encryptedJLabel
      encryptedJLabel = new JLabel();
      encryptedJLabel.setText( "Encrypted number:" );
      encryptedJLabel.setBounds( 20, 50, 140, 20 );
      contentPane.add( encryptedJLabel );      
      
      // set up encryptedJTextField
      encryptedJTextField = new JTextField();
      encryptedJTextField.setEditable( false );
      encryptedJTextField.setBounds( 180, 50, 50, 20);
      contentPane.add( encryptedJTextField );
      
      // set up encryptJButton
      encryptJButton = new JButton ();
      encryptJButton.setText( "Encrypt" );
      encryptJButton.setBounds( 250, 20, 80, 20 );
      contentPane.add( encryptJButton );      
      encryptJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
            // called when encryptJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               encryptJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
	 
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Simple Encryption" ); // set title bar text
      setSize( 350, 120 );             // set window size
      setVisible( true );              // display window
      
   } // end method createUserInterface
      
   // encrypt number input by user 
   private void encryptJButtonActionPerformed ( ActionEvent event )
   {

   } // end method encryptJButtonActionPerformed
   
   // clear encryptedJTextField because the value is now invalid
   private void enterJTextFieldKeyPressed( KeyEvent event )
   {
      
   } // end method enterJTextFieldKeyPressed

   // main method
   public static void main( String[] args )
   {
      SimpleEncryption application = new SimpleEncryption();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class SimpleEncryption


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
