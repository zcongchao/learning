// Exercise 23.13: Anagram.java
// Application provides an anagram game to users.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
import javax.swing.*;

public class Anagram extends JFrame
{
   // JTextField for scrambled word
   private JTextField anagramJTextField;

   // JLabel and JTextField for guess from user
   private JLabel guessJLabel;
   private JTextField guessJTextField;

   // JButton to allow user to submit guess
   private JButton submitJButton;

   // JTextField for correct or incorrect message
   private JTextField resultJTextField;

   // array of words to be scrambled
   private String anagramList[] = { "components", "events",
      "properties", "visual", "program", "application", "basic",
      "debugger", "database", "files", "inheritance", "assembly",
      "multimedia", "procedures", "functions", "arrays", "strings",
      "collections", "integration", "structures" };

   private int randomNumber;              // random index variable
   Random randomGenerator = new Random(); // instance of class Random

   // no-argument constructor
   public Anagram()
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
      
      // set up anagramJTextField
      anagramJTextField = new JTextField();
      anagramJTextField.setBounds( 16, 16, 148, 21 );
      anagramJTextField.setEditable( false );
      anagramJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( anagramJTextField );
      
      // set up guessJLabel
      guessJLabel = new JLabel();
      guessJLabel.setBounds( 16, 72, 72, 21 );
      guessJLabel.setText( "Your guess:" );
      contentPane.add( guessJLabel );
      
      // set up guessJTextField
      guessJTextField = new JTextField();
      guessJTextField.setBounds( 16, 96, 148, 21 );
      contentPane.add( guessJTextField );
      
      // set up submitJButton
      submitJButton = new JButton();
      submitJButton.setBounds( 48, 136, 74, 23 );
      submitJButton.setText( "Submit" );
      contentPane.add( submitJButton );
      submitJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when submitJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               submitJButtonActionPerformed( event );
            }
      
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 16, 176, 148, 21 );
      resultJTextField.setEditable( false );
      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( resultJTextField );
      
      // set properties of application's window
      setTitle( "Anagram Game" ); // set title bar string
      setSize( 188, 240 );        // set window size
      setVisible( true );         // display window

      generateAnagram(); // generate new word

   } // end method createUserInterface

   // check if guess is correct
   private void submitJButtonActionPerformed( ActionEvent event )
   {
      // get text from guessJTextField
      String text = guessJTextField.getText();
      
      // if answer is correct
      if ( text.equals( anagramList[ randomNumber ] ) )
      {
         resultJTextField.setText( "You are Correct!" );

         guessJTextField.setText( "" ); // clear the JTextField

         // place focus on guessJTextField
         guessJTextField.requestFocusInWindow(); 

         generateAnagram(); // generate first word
      }
      else // answer is incorrect
      {
         resultJTextField.setText( "Wrong answer. Try again!" );

         guessJTextField.setText( "" ); // clear the JTextField

         // place focus on guessJTextField
         guessJTextField.requestFocusInWindow();
      }

   } // end method submitJButtonActionPerformed

   // scramble random word and display it in anagramJTextField
   private void generateAnagram()
   {
      // generate new random number
      randomNumber = randomGenerator.nextInt( 20 );

      // select new word from array with random index
      String scrambled = anagramList[ randomNumber ];

      // generate new random index
      int randomIndex = 
         randomGenerator.nextInt( scrambled.length() );
   
   } // end method generateAnagram
   
   // main method
   public static void main( String[] args )
   {
      Anagram application = new Anagram();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Anagram

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