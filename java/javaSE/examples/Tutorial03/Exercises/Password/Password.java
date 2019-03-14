// Exercise 3.13: Password.java
// GUI for a password-protected message application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Password extends JFrame
{
   // JLabel and JTextField for user name
   private JLabel userNameJLabel;
   private JTextField userNameJTextField;

   // JLabel and JTextField for password
   private JLabel passwordJLabel;
   private JPasswordField passwordJPasswordField;

   // JLabel and JTextField for reentering password
   private JLabel reenterPasswordJLabel;
   private JPasswordField reenterPasswordJPasswordField;

   // JButton for logging in to the Message Application
   private JButton logInJButton;
   
   // JLabel and JTextArea for messages
   private JLabel messageJLabel;
   private JTextArea messageJTextArea;
   
   // JButtons to save a message, log out and clear all input
   private JButton saveJButton;
   private JButton logOutJButton;
   private JButton clearJButton;
   
   // no-argument constructor
   public Password()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( null );

      // set up userNameJLabel
      userNameJLabel = new JLabel();
      userNameJLabel.setBounds( 16, 16, 96, 21 );
      userNameJLabel.setText( "Enter your name:" );
      container.add( userNameJLabel );

      // set up userNameJTextField
      userNameJTextField = new JTextField();
      userNameJTextField.setBounds( 172, 16, 140, 21 );
      userNameJTextField.setText( "Joe Purple" );
      container.add( userNameJTextField );

      // set up passwordJLabel
      passwordJLabel = new JLabel();
      passwordJLabel.setBounds( 16, 48, 122, 21 );
      passwordJLabel.setText( "Enter your password:" );
      container.add( passwordJLabel );

      // set up passwordJPasswordField
      passwordJPasswordField = new JPasswordField();
      passwordJPasswordField.setBounds( 172, 48, 140, 21 );
      passwordJPasswordField.setText( "Hello2world" );
      container.add( passwordJPasswordField );

      // set up reenterPasswordJLabel
      reenterPasswordJLabel = new JLabel();
      reenterPasswordJLabel.setBounds( 16, 80, 148, 21 );
      reenterPasswordJLabel.setText( "Re-enter your password:" );
      container.add( reenterPasswordJLabel );

      // set up reenterPasswordJPasswordField
      reenterPasswordJPasswordField = new JPasswordField();
      reenterPasswordJPasswordField.setBounds( 172, 80, 140, 21 );
      reenterPasswordJPasswordField.setText( "Hello2world" );
      container.add( reenterPasswordJPasswordField );

      // set up logInJButton
      logInJButton = new JButton();
      logInJButton.setBounds( 240, 120, 72, 24 );
      logInJButton.setText( "Log In" );
      container.add( logInJButton );

      // set up messageJLabel
      messageJLabel = new JLabel();
      messageJLabel.setBounds( 16, 136, 164, 21 );
      messageJLabel.setText( "Enter your secret message:" );
      container.add( messageJLabel );

      // set up messageJTextArea
      messageJTextArea = new JTextArea();
      messageJTextArea.setText( 
         "Welcome to Simply Java Programming" );
      container.add( messageJTextArea );
      
      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 58, 248, 72, 24 );
      saveJButton.setText( "Save" );
      container.add( saveJButton );

      // set up logOutJButton
      logOutJButton = new JButton();
      logOutJButton.setBounds( 146, 248, 78, 24 );
      logOutJButton.setText( "Log Out" );
      container.add( logOutJButton );

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 240, 248, 72, 24 );
      clearJButton.setText( "Clear" );
      container.add( clearJButton );

      // set properties of application’s window
      setTitle( "Message Application" ); // set title bar text
      setSize( 336, 312 );               // set window size
      setVisible( true );                // display window
 
   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      Password application = new Password();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Password


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
