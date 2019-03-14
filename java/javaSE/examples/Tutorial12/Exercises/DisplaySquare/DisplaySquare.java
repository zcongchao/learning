// Exercise 12.12: DisplaySquare.java
// Displays a square of characters where the size of the square
// and the characters used in the square are specified by the user.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class DisplaySquare extends JFrame
{
   // JLabel and JTextField for size of square sides
   private JLabel squareSizeJLabel;
   private JTextField squareSizeJTextField;

   // JLabel and JTextField for fill character
   private JLabel fillCharacterJLabel;
   private JTextField fillCharacterJTextField;

   // JTextArea and JScrollPane for displaying square
   private JTextArea outputJTextArea;
   private JScrollPane outputJScrollPane;

   // JButton initiates creation and display of square
   private JButton displaySquareJButton;

   // no-argument constructor
   public DisplaySquare()
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

      // set up squareSizeJLabel
      squareSizeJLabel = new JLabel();
      squareSizeJLabel.setBounds( 16, 16, 80, 21 );
      squareSizeJLabel.setText( "Square size:" );
      contentPane.add( squareSizeJLabel );

      // set up squareSizeJTextField
      squareSizeJTextField = new JTextField();
      squareSizeJTextField.setBounds( 104, 16, 24, 21 );
      squareSizeJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( squareSizeJTextField );

      // set up fillCharacterJLabel
      fillCharacterJLabel = new JLabel();
      fillCharacterJLabel.setBounds( 16, 56, 80, 21 );
      fillCharacterJLabel.setText( "Fill character:" );
      contentPane.add( fillCharacterJLabel );

      // set up fillCharacterJTextField
      fillCharacterJTextField = new JTextField();
      fillCharacterJTextField.setBounds( 104, 56, 24, 21 );
      fillCharacterJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( fillCharacterJTextField );

      // set up outputJTextArea
      outputJTextArea = new JTextArea();
      outputJTextArea.setBackground( Color.LIGHT_GRAY );
      outputJTextArea.setEditable( false );
      contentPane.add( outputJTextArea );
      
      // set up outputJScrollPane
      outputJScrollPane = new JScrollPane( outputJTextArea );
      outputJScrollPane.setBounds( 16, 96, 248, 136 );
      contentPane.add( outputJScrollPane );

      // set up displaySquareJButton
      displaySquareJButton = new JButton();
      displaySquareJButton.setBounds( 144, 16, 120, 23 );
      displaySquareJButton.setText( "Display Square" );
      contentPane.add( displaySquareJButton );
      displaySquareJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when 
            // displaySquareJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               displaySquareJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Display Square" ); // set title bar string
      setSize( 288, 276 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface

   // display a square of characters
   private void displaySquareJButtonActionPerformed( 
      ActionEvent event )
   {
      // if valid input is entered
      if ( ( squareSizeJTextField.getText() != "" ) &&
         ( fillCharacterJTextField.getText() != "" ) )
      {
         // retrieve user input
         int squareSize = Integer.parseInt(
            squareSizeJTextField.getText() );
         String fillCharacter = fillCharacterJTextField.getText();

         outputJTextArea.setText( "" ); // clear output

         // loop until row reaches value of first argument (size)
         for ( int row = 1; row <= squareSize; row++ )
         {
            // loop until column reaches value of size
            for ( int column = 1; column <= squareSize; column++ )
            {
               outputJTextArea.append( fillCharacter );
            }

            outputJTextArea.append( "\n" ); // add line to output
         }
      }
      else
      {
         JOptionPane.showMessageDialog( null,
            "Square size and fill character needed",
            "Incorrect Input", JOptionPane.ERROR_MESSAGE );
      }

   } // end method displaySquareJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      DisplaySquare application = new DisplaySquare();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class DisplaySquare

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