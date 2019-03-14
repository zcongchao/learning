// Exercise 16.16: RoadSignTest.java
// Tests the user on their knowledge of road signs. The user must 
// try to match five signs to their meanings.
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RoadSignTest extends JFrame
{
   // JPanel and JLabel for displaying a sign image
   private JPanel signIconJPanel;
   private JLabel signIconJLabel;

   // JLabel and JComboBox for choosing a sign
   private JLabel chooseJLabel;
   private JComboBox signJComboBox;

   // JTextField for providing feedback to the user
   private JTextField feedbackJTextField;

   // JButton to submit the users answer and display the result
   private JButton submitJButton;

   // JButton to display the next sign image
   private JButton nextSignJButton;

   private int currentIndex; // integer holds the current array index
   private int count = 1; // integer counts number of signs displayed
      
   // no-argument constructor
   public RoadSignTest()
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
      
      // set up signIconJPanel
      signIconJPanel = new JPanel();
      signIconJPanel.setBounds( 16, 8, 100, 94 );
      signIconJPanel.setBorder( new TitledBorder( "Sign" ) );
      contentPane.add( signIconJPanel );

      // set up signIconJLabel
      signIconJLabel = new JLabel();
      signIconJLabel.setHorizontalAlignment( JLabel.CENTER );
      signIconJPanel.add( signIconJLabel );
      
      // set up chooseJLabel
      chooseJLabel = new JLabel();
      chooseJLabel.setBounds( 136, 8, 88, 21 );
      chooseJLabel.setText( "Select sign:" );
      contentPane.add( chooseJLabel );

      // set up signJComboBox
      signJComboBox = new JComboBox();
      signJComboBox.setBounds( 136, 32, 144, 21 );
      contentPane.add( signJComboBox );

      displaySign(); // display the first sign

      // set up feedbackJTextField
      feedbackJTextField = new JTextField();
      feedbackJTextField.setBounds( 136, 64, 144, 36 );
      feedbackJTextField.setHorizontalAlignment( JTextField.CENTER );
      feedbackJTextField.setEditable( false );
      contentPane.add( feedbackJTextField );
      
      // set up submitJButton
      submitJButton = new JButton();
      submitJButton.setBounds( 296, 8, 88, 32 );
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
      
      // set up nextSignJButton
      nextSignJButton = new JButton();
      nextSignJButton.setBounds( 296, 48, 88, 32 );
      nextSignJButton.setText( "Next Sign" );
      nextSignJButton.setEnabled( false );
      contentPane.add( nextSignJButton );
      nextSignJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when nextSignJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nextSignJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener  
      
      // set properties of application's window
      setTitle( "Road Sign Test" ); // set title bar string
      setSize( 400, 140 );          // set window size
      setVisible( true );           // display window
   
   } // end method createUserInterface
   
   // return an unused random number
   private int getUniqueRandomNumber()
   {
      Random generator = new Random();
      int randomNumber = 0;
      
      return randomNumber;
      
   } // end method getUniqueRandomNumber
   
   // choose a sign and display it in the JLabel
   private void displaySign()
   {
      currentIndex = getUniqueRandomNumber(); // get an unused sign
      
      // create the path for that sign
      String signPath = "images/sign" + currentIndex + ".png";
      
      // set the label to display the sign
      signIconJLabel.setIcon( new ImageIcon( signPath ) );
   
   } // end method displaySign
   
   // check the answer and update the quiz
   private void submitJButtonActionPerformed( ActionEvent event )
   {
      // determine whether the answer was correct
      if ( signJComboBox.getSelectedIndex() == currentIndex )
      {
         feedbackJTextField.setText( "Correct!" );
      }
      else
      {
         feedbackJTextField.setText( "Sorry, incorrect." );
      }
      
      // inform the user if the quiz is over
      if ( count == 5 )
      {
         nextSignJButton.setEnabled( false );
         submitJButton.setEnabled( false );
         signJComboBox.setEnabled( false );
      }
      else
      {
         submitJButton.setEnabled( false );
         nextSignJButton.setEnabled( true );
      }

   } // end method submitJButtonActionPerformed
   
   // display next sign in the quiz
   private void nextSignJButtonActionPerformed( ActionEvent event )
   {
      displaySign(); // display the next sign
      count++; // increment the counter
      
      // reset the GUI components to the initial states
      feedbackJTextField.setText( "" );
      signJComboBox.setSelectedIndex( 0 );
      submitJButton.setEnabled( true );
      nextSignJButton.setEnabled( false );
      
   } // end method nextSignJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      RoadSignTest application = new RoadSignTest();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main
   
} // end class RoadSignTest

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