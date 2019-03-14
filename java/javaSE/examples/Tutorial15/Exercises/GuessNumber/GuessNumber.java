// Exercise 15.11: GuessNumber.java
// This game asks the user to guess a number from 1 to 100.
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GuessNumber extends JFrame
{
   // JLabels to display question
   private JLabel question1JLabel;
   private JLabel question2JLabel;

   // JLabel and JTextField to get user guess
   private JLabel guessJLabel;
   private JTextField guessJTextField;

   // JButton to enter guess
   private JButton enterJButton;

   // JLabel and JTextField to display if user is correct
   private JLabel resultJLabel;
   private JTextField resultJTextField;

   // JButton to start a new game
   private JButton newGameJButton;

   // no-argument constructor
   public GuessNumber()
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
      
      // set up question1JLabel
      question1JLabel = new JLabel();
      question1JLabel.setText(
         "I have a number between 1 and 100." );
      question1JLabel.setBounds( 40, 10, 216, 34 );
      contentPane.add( question1JLabel );

      // set up question2JLabel
      question2JLabel = new JLabel();
      question2JLabel.setText( "Can you guess my number?" );
      question2JLabel.setBounds( 40, 24, 216, 34 );
      contentPane.add( question2JLabel );

      // set up guessJLabel
      guessJLabel = new JLabel();
      guessJLabel.setText( "Guess:" );
      guessJLabel.setBounds( 16, 74, 40, 20 );
      contentPane.add( guessJLabel );

      // set up guessJTextField
      guessJTextField = new JTextField();
      guessJTextField.setBounds( 64, 74, 128, 20 );
      contentPane.add( guessJTextField );

      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setText( "Enter" );
      enterJButton.setBounds( 208, 74, 96, 21 );
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

      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setText( "Result:" );
      resultJLabel.setBounds( 16, 106, 40, 23 );
      contentPane.add( resultJLabel );

      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 64, 104, 128, 23 );
      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
      resultJTextField.setEditable( false );
      contentPane.add( resultJTextField );

      // set up newGameJButton
      newGameJButton = new JButton();
      newGameJButton.setText( "New Game" );
      newGameJButton.setBounds( 208, 106, 96, 21 );
      newGameJButton.setEnabled( false );
      contentPane.add( newGameJButton );
      newGameJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when newGameJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               newGameJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Guess the Number" ); // set title bar string
      setSize( 321, 167 );            // set window size
      setVisible( true );             // display window
      
   } // end method createUserInterface
   
   // compare guess to answer
   private void enterJButtonActionPerformed( ActionEvent event )
   {

   } // end method enterJButtonActionPerformed
   
   // reset resultJTextField; generate new question
   private void newGameJButtonActionPerformed( ActionEvent event )
   {

   } // end method newGameJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      GuessNumber application = new GuessNumber();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class GuessNumber

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