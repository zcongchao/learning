// Exercise 14.12: QuizAverage.java
// Application enables a user to enter grades and have the average
// calculated.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class QuizAverage extends JFrame
{
   // JLabel and JTextField to display quiz score
   private JLabel quizJLabel;
   private JTextField quizJTextField;

   // JButton to enter quiz score
   private JButton submitJButton;

   // JLabel and JTextField to display number of quizzes taken
   private JLabel numberJLabel;
   private JTextField numberJTextField;

   // JLabel and JTextField to display average of all quiz scores
   private JLabel averageJLabel;
   private JTextField averageJTextField;

   // no-argument constructor
   public QuizAverage()
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
      
      // set up quizJLabel
      quizJLabel = new JLabel();
      quizJLabel.setBounds( 16, 16, 88, 21 );
      quizJLabel.setText( "Quiz score:" );
      contentPane.add( quizJLabel );
      
      // set up quizJTextField
      quizJTextField = new JTextField();
      quizJTextField.setBounds( 122, 16, 40, 24 );
      quizJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( quizJTextField );
      
      // set up submitJButton
      submitJButton = new JButton();
      submitJButton.setBounds( 183, 16, 116, 24 );
      submitJButton.setText( "Submit Score" );
      contentPane.add( submitJButton );
      submitJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when submitJButton is clicked
             public void actionPerformed ( ActionEvent event )
             {
                submitJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set up numberJLabel
      numberJLabel = new JLabel();
      numberJLabel.setBounds( 16, 56, 88, 21 );
      numberJLabel.setText( "Number taken:" );
      contentPane.add( numberJLabel );
      
      // set up numberJTextField
      numberJTextField = new JTextField();
      numberJTextField.setBounds( 122, 56, 40, 24 );
      numberJTextField.setHorizontalAlignment( JTextField.CENTER );
      numberJTextField.setEditable( false );
      contentPane.add( numberJTextField );
      
      // set up averageJLabel
      averageJLabel = new JLabel();
      averageJLabel.setBounds( 175, 56, 56, 21 );
      averageJLabel.setText( "Average:" );
      contentPane.add( averageJLabel );
      
      // set up averageJTextField
      averageJTextField = new JTextField();
      averageJTextField.setBounds( 259, 56, 40, 24 );
      averageJTextField.setHorizontalAlignment( JTextField.CENTER );
      averageJTextField.setEditable( false );
      contentPane.add( averageJTextField );
      
      // set properties of application's window
      setTitle( "Quiz Average" ); // set title bar string
      setSize( 325, 125 );        // set window size
      setVisible( true );         // display window
      
   } // end method createUserInterface
   
   // calculate and display average score
   public void submitJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method submitJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      QuizAverage application = new QuizAverage();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class QuizAverage

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