// Exercise 3.11: AddressBook.java
// GUI that enables users to input address information.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddressBook extends JFrame
{
   // JLabel and JTextField for first name
   private JLabel firstNameJLabel;
   private JTextField firstNameJTextField;

   // JLabel and JTextField for last name
   private JLabel lastNameJLabel;
   private JTextField lastNameJTextField;

   // JLabel and JTextField for address
   private JLabel addressJLabel;
   private JTextField addressJTextField;

   // JLabel and JTextField for city
   private JLabel cityJLabel;
   private JTextField cityJTextField;
   
   // JLabel and JTextField for state
   private JLabel stateJLabel;
   private JTextField stateJTextField;
   
   // JLabel and JTextField for zip code
   private JLabel zipJLabel;
   private JTextField zipJTextField;
   
   // JLabel and JTextField for email address
   private JLabel emailJLabel;
   private JTextField emailJTextField;
   
   // JLabel and JTextField for phone number
   private JLabel phoneJLabel;
   private JTextField phoneJTextField;
   
   // JLabel and JTextField for mobile-phone number
   private JLabel mobileJLabel;
   private JTextField mobileJTextField;
   
   // JLabel and JTextField for beeper number
   private JLabel beeperJLabel;
   private JTextField beeperJTextField;
   
   // JButtons to save user input and clear all JTextFields
   private JButton saveJButton;
   private JButton clearJButton;
   
   // no-argument constructor
   public AddressBook()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( null );

      // set up firstNameJLabel
      firstNameJLabel = new JLabel();
      firstNameJLabel.setBounds( 16, 16, 64, 21 );
      firstNameJLabel.setText( "First name:" );
      container.add( firstNameJLabel );

      // set up firstNameJTextField
      firstNameJTextField = new JTextField();
      firstNameJTextField.setBounds( 88, 16, 134, 21 );
      firstNameJTextField.setText( "John" );
      container.add( firstNameJTextField );

      // set up lastNameJLabel
      lastNameJLabel = new JLabel();
      lastNameJLabel.setBounds( 242, 16, 64, 21 );
      lastNameJLabel.setText( "Last name:" );
      container.add( lastNameJLabel );

      // set up lastNameJTextField
      lastNameJTextField = new JTextField();
      lastNameJTextField.setBounds( 314, 16, 134, 21 );
      lastNameJTextField.setText( "Doe" );
      container.add( lastNameJTextField );

      // set up addressJLabel
      addressJLabel = new JLabel();
      addressJLabel.setText( "Address:" );
      container.add( addressJLabel );

      // set up addressJTextField
      addressJTextField = new JTextField();
      addressJTextField.setText( "123 Main Street" );
      container.add( addressJTextField );

      // set up cityJLabel
      cityJLabel = new JLabel();
      cityJLabel.setBounds( 16, 96, 32, 21 );
      cityJLabel.setText( "City:" );
      container.add( cityJLabel );

      // set up cityJTextField
      cityJTextField = new JTextField();
      cityJTextField.setBounds( 88, 96, 112, 21 );
      cityJTextField.setText( "Some Town" );
      container.add( cityJTextField );

      // set up stateJLabel
      stateJLabel = new JLabel();
      stateJLabel.setBounds( 222, 96, 40, 21 );
      stateJLabel.setText( "State:" );
      container.add( stateJLabel );

      // set up stateJTextField
      stateJTextField = new JTextField();
      stateJTextField.setBounds( 270, 96, 32, 21 );
      stateJTextField.setText( "MA" );
      container.add( stateJTextField );

      // set up zipJLabel
      zipJLabel = new JLabel();
      zipJLabel.setBounds( 320, 96, 32, 21 );
      zipJLabel.setText( "Zip:" );
      container.add( zipJLabel );

      // set up zipJTextField
      zipJTextField = new JTextField();
      zipJTextField.setBounds( 360, 96, 88, 21 );
      zipJTextField.setText( "00000" );
      container.add( zipJTextField );

      // set up emailJLabel
      emailJLabel = new JLabel();
      emailJLabel.setBounds( 16, 136, 40, 21 );
      emailJLabel.setText( "E-mail:" );
      container.add( emailJLabel );

      // set up emailJTextField
      emailJTextField = new JTextField();
      emailJTextField.setBounds( 88, 136, 176, 21 );
      emailJTextField.setText( "John.Doe@not-a-domain.com" );
      container.add( emailJTextField );

      // set up phoneJLabel
      phoneJLabel = new JLabel();
      phoneJLabel.setBounds( 280, 136, 40, 21 );
      phoneJLabel.setText( "Phone:" );
      container.add( phoneJLabel );

      // set up phoneJTextField
      phoneJTextField = new JTextField();
      phoneJTextField.setBounds( 336, 136, 112, 21 );
      phoneJTextField.setText( "781-555-4567" );
      container.add( phoneJTextField );

      // set up mobileJLabel
      mobileJLabel = new JLabel();
      mobileJLabel.setBounds( 16, 176, 50, 21 );
      mobileJLabel.setText( "Mobile: " );
      container.add( mobileJLabel );

      // set up mobileJTextField
      mobileJTextField = new JTextField();
      mobileJTextField.setBounds( 88, 176, 176, 21 );
      mobileJTextField.setText( "978-555-6541" );
      container.add( mobileJTextField );

      // set up beeperJLabel
      beeperJLabel = new JLabel();
      beeperJLabel.setBounds( 280, 176, 48, 21 );
      beeperJLabel.setText( "Beeper:" );
      container.add( beeperJLabel );

      // set up beeperJTextField
      beeperJTextField = new JTextField();
      beeperJTextField.setBounds( 336, 176, 112, 21 );
      beeperJTextField.setText( "508-555-7896" );
      container.add( beeperJTextField );

      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 284, 216, 75, 23 );
      saveJButton.setText( "Save" );
      container.add( saveJButton );

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 373, 216, 75, 23 );
      clearJButton.setText( "Clear" );
      container.add( clearJButton );

      // set properties of application’s window
      setTitle( "Address Book" ); // set title bar text
      setSize( 472, 280 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      AddressBook application = new AddressBook();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class AddressBook


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
