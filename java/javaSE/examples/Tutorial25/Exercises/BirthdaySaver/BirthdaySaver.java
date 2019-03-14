// Exercise 25.11: BirthdaySaver.java
// This application allows the user to store the names and birthdays
// of people in a file.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

public class BirthdaySaver extends JFrame
{
   // JLabel and JTextField for first name
   private JLabel firstNameJLabel;
   private JTextField firstNameJTextField;

   // JLabel and JTextField for last name
   private JLabel lastNameJLabel;
   private JTextField lastNameJTextField;

   // JLabel and JSpinner for birthday display 
   private JLabel birthdayJLabel;
   private JSpinner birthdayJSpinner;

   // JButtons to write to different files
   private JButton openFileJButton;
   private JButton enterJButton;
   private JButton closeFileJButton;

   // PrintWriter for writing data to a file
   private PrintWriter output;
   
   // no-argument constructor
   public BirthdaySaver() 
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

      // set up firstNameJLabel
      firstNameJLabel = new JLabel();
      firstNameJLabel.setBounds( 16, 8, 64, 23 );
      firstNameJLabel.setText( "First Name:" );
      contentPane.add( firstNameJLabel );

      // set up firstNameJTextField
      firstNameJTextField = new JTextField();
      firstNameJTextField.setBounds( 96, 8, 100, 21 );
      contentPane.add( firstNameJTextField );
      
      // set up lastNameJLabel
      lastNameJLabel = new JLabel();
      lastNameJLabel.setBounds( 16, 40, 64, 23 );
      lastNameJLabel.setText( "Last Name:" );
      contentPane.add( lastNameJLabel );

      // set up lastNameJTextField
      lastNameJTextField = new JTextField();
      lastNameJTextField.setBounds( 96, 40, 100, 21 );
      contentPane.add( lastNameJTextField );

      // set up birthdayJLabel
      birthdayJLabel = new JLabel();
      birthdayJLabel.setBounds( 16, 75, 56, 16 );
      birthdayJLabel.setText( "Birthday:" );
      contentPane.add( birthdayJLabel );
      
      // set up birthdayJSpinner
      birthdayJSpinner = 
         new JSpinner( new SpinnerDateModel() );
      birthdayJSpinner.setBounds( 96, 72, 104, 23 );
      birthdayJSpinner.setEditor(  
         new JSpinner.DateEditor( 
            birthdayJSpinner, "MM/dd/yyyy" ) );
      contentPane.add( birthdayJSpinner );
      
      // set up openFileJButton
      openFileJButton = new JButton();
      openFileJButton.setBounds( 237, 8, 95, 24 );
      openFileJButton.setText( "Open File..." );
      contentPane.add( openFileJButton );
      openFileJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when openFileJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               openFileJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setBounds( 237, 40, 95, 24 );
      enterJButton.setText( "Enter" );
      enterJButton.setEnabled( false );
      contentPane.add( enterJButton );
      enterJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enterJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               enterJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up closeFileJButton
      closeFileJButton = new JButton();
      closeFileJButton.setBounds( 237, 72, 95, 24 );
      closeFileJButton.setText( "Close File" );
      closeFileJButton.setEnabled( false );
      contentPane.add( closeFileJButton );
      closeFileJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when closeFileJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               closeFileJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Birthday Saver" ); // set title bar string
      setSize( 350, 131 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface

   // reset input fields
   private void clearUserInput()
   {
      firstNameJTextField.setText( "" );
      lastNameJTextField.setText( "" );
      birthdayJSpinner.setValue( new Date() );

   } // end method clearUserInput

   // enable user to select file to open
   private void openFileJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method openFileJButtonActionPerformed

   // write data to file
   private void enterJButtonActionPerformed( ActionEvent event )
   {
      // write user input to file
      output.println( firstNameJTextField.getText() + " " + 
         lastNameJTextField.getText() );
      String date = String.valueOf( birthdayJSpinner.getValue() );
      output.println( date.substring( 4, 10 ) );

      clearUserInput();

   } // end method enterJButtonActionPerformed

   // close file
   private void closeFileJButtonActionPerformed( ActionEvent event )
   {
      // close PrintWriter
      output.close();
      
      openFileJButton.setEnabled( true );
      enterJButton.setEnabled( false );
      closeFileJButton.setEnabled( false );

   } // end method closeFileJButtonActionPerformed
     
   // main method
   public static void main( String args[] ) 
   {
      BirthdaySaver application = new BirthdaySaver();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class BirthdaySaver

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