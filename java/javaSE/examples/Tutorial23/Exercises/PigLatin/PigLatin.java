// Exercise 23.16: PigLatin.java
// Converts text entered by user into Pig Latin.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class PigLatin extends JFrame
{
   // JLabel and JTextField for input in English
   private JLabel enterSentenceJLabel;
   private JTextField enterSentenceJTextField;

   // JLabel and JTextField for output in Pig Latin
   private JLabel pigLatinJLabel;
   private JTextField pigLatinJTextField;

   // JButton to translate from English to Pig Latin
   private JButton translateJButton;

   // no-argument constructor
   public PigLatin()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up enterSentenceJLabel
      enterSentenceJLabel = new JLabel();
      enterSentenceJLabel.setBounds( 8, 16, 106, 23 );
      enterSentenceJLabel.setText( "Enter a sentence:" );
      contentPane.add( enterSentenceJLabel );
      
      // set up enterSentenceJTextField
      enterSentenceJTextField = new JTextField();
      enterSentenceJTextField.setBounds( 114, 16, 306, 20 );
      contentPane.add( enterSentenceJTextField );
      
      // set up pigLatinJLabel
      pigLatinJLabel = new JLabel();
      pigLatinJLabel.setBounds( 8, 56, 88, 23 );
      pigLatinJLabel.setText( "Pig Latin:" );
      contentPane.add( pigLatinJLabel );
      
      // set up pigLatinJTextField
      pigLatinJTextField = new JTextField();
      pigLatinJTextField.setBounds( 114, 56, 306, 20 );
      pigLatinJTextField.setEditable( false );
      contentPane.add( pigLatinJTextField );
      
      // set up translateJButton
      translateJButton = new JButton();
      translateJButton.setBounds( 325, 96, 95, 23 );
      translateJButton.setText( "Translate" );
      contentPane.add( translateJButton );
      translateJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // method called when translateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               translateJButtonActionPerformed( event );
            }
      
         } // end anonymous inner class
      
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Pig Latin" ); // set title bar string
      setSize( 444, 160 );     // set window size
      setVisible( true );      // display window
   
   } // end method createUserInterface

   // receive sentence from user and send to translateToPigLatin
   private void translateJButtonActionPerformed( ActionEvent event )
   {
      // retrieve English phrase from user
      String phrase = enterSentenceJTextField.getText();

      // display phrase converted to Pig Latin
      pigLatinJTextField.setText( translateToPigLatin( phrase ) );

   } // end method translateJButtonActionPerformed

   // translate String from English to Pig Latin
   private String translateToPigLatin( String englishPhrase )
   {
      String prefix; // stores first letter of each word
      String suffix; // stores a String added to the end of each word

      String translatedText = ""; // stores translated sentence

      // split words into an array
      String words[] = englishPhrase.split( " " );

      return "";

   } // end method translateToPigLatin

   // main method
   public static void main( String[] args )
   {
      PigLatin application = new PigLatin();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class PigLatin

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