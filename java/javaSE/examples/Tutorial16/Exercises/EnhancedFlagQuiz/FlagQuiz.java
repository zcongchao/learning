// Exercise 16.11: FlagQuiz.java
// Quiz the user on their knowledge of flags. The user must try to 
// match five flags to their countries.
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FlagQuiz extends JFrame
{
   // array of country names
   private String[] countries = { "Russia", "China", "United States",
      "Italy", "Australia", "South Africa", "Brazil", "Spain" };
      
   // boolean array tracks displayed flags
   private boolean[] flagsUsed = new boolean[ countries.length ];
   
   private int currentIndex; // contains the index of current flag

   // tracks the number of flags that have been displayed
   private int count = 1;

   // JPanel and JLabel for displaying a flag image
   private JPanel flagJPanel;
   private JLabel flagIconJLabel;

   // JLabel and JComboBox for choosing a country
   private JLabel selectCountryJLabel;
   private JComboBox selectCountryJComboBox;

   // JTextField for giving the user feedback
   private JTextField feedbackJTextField;

   // JButton to submit an answer
   private JButton submitJButton;

   // JButton to display the next flag
   private JButton nextFlagJButton;

   // JTextField for final comment
   private JTextField commentJTextField;

   // no-argument constructor
   public FlagQuiz()
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

      // set up flagJPanel
      flagJPanel = new JPanel();
      flagJPanel.setBounds( 16, 8, 100, 90 );
      flagJPanel.setLayout( null );
      flagJPanel.setBorder( new TitledBorder( "Flag" ) );
      contentPane.add( flagJPanel );

      // set up flagIconJLabel
      flagIconJLabel = new JLabel();
      flagIconJLabel.setBounds( 10, 14, 80, 80 );
      flagIconJLabel.setHorizontalAlignment( JLabel.CENTER );
      flagJPanel.add( flagIconJLabel );

      // set up selectCountryJLabel
      selectCountryJLabel = new JLabel();
      selectCountryJLabel.setBounds( 136, 8, 88, 21 );
      selectCountryJLabel.setText( "Select country:" );
      contentPane.add( selectCountryJLabel );

      Arrays.sort( countries ); // sort the array

      // set up selectCountryJComboBox
      selectCountryJComboBox = new JComboBox( countries );
      selectCountryJComboBox.setBounds( 136, 32, 135, 21 );
      selectCountryJComboBox.setMaximumRowCount( 3 );
      contentPane.add( selectCountryJComboBox );

      displayFlag(); // display first flag
      
      // set up feedbackJTextField
      feedbackJTextField = new JTextField();
      feedbackJTextField.setBounds( 136, 64, 135, 32 );
      feedbackJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      feedbackJTextField.setEditable( false );
      contentPane.add( feedbackJTextField );
      
      // set up submitJButton
      submitJButton = new JButton();
      submitJButton.setBounds( 287, 8, 88, 32 );
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
      
      // set up nextFlagJButton
      nextFlagJButton = new JButton();
      nextFlagJButton.setBounds( 287, 48, 88, 32 );
      nextFlagJButton.setText( "Next Flag" );
      nextFlagJButton.setEnabled( false );
      contentPane.add( nextFlagJButton );
      nextFlagJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when nextFlagJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nextFlagJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up commentJTextField
      commentJTextField = new JTextField();
      commentJTextField.setBounds( 287, 88, 88, 24 );
      commentJTextField.setHorizontalAlignment( JLabel.CENTER );
      commentJTextField.setEditable( false );
      contentPane.add( commentJTextField );
      
      // set properties of application's window
      setTitle( "Flag Quiz" ); // set title bar string
      setSize( 390, 145 );     // set window size
      setVisible( true );      // display window
      
   } // end method createUserInterface
   
   // return an unused random number
   private int getUniqueRandomNumber()
   {
      Random generator = new Random();
      int randomNumber;

      // generate random numbers until unused flag is found
      do
      {
         // generate a number between 0-7
         randomNumber = generator.nextInt( 8 );
      }
      while ( flagsUsed[ randomNumber ] == true );
      
      // indicate that flag has been used
      flagsUsed[ randomNumber ] = true;
         
      return randomNumber;
      
   } // end method getUniqueRandomNumber
   
   // choose a flag and display it in the JLabel
   private void displayFlag()
   {
      currentIndex = getUniqueRandomNumber(); // get an unused flag

      // create the path for that flag
      String country =
         ( String ) selectCountryJComboBox.getItemAt( currentIndex );
      String countryPath = "images/" + country + ".png";
      
      // set the flagIconJLabel to display the flag
      flagIconJLabel.setIcon( new ImageIcon( countryPath ) );
      
   } // end method displayFlag
   
   // check the answer and update the quiz
   private void submitJButtonActionPerformed( ActionEvent event )
   {
      // determine whether the answer was correct
      if ( selectCountryJComboBox.getSelectedIndex()
         == currentIndex )
      {
         feedbackJTextField.setText( "Correct!" );
      }
      else // if an incorrect answer is given
      {
         feedbackJTextField.setText( "Sorry, incorrect." );
      }
      
      // inform user if quiz is over
      if ( count == 5 )
      {
         feedbackJTextField.setText( 
            feedbackJTextField.getText() + "   Done!" );

         nextFlagJButton.setEnabled( false );
         submitJButton.setEnabled( false );
         selectCountryJComboBox.setEnabled( false );
      }
      else // if less than 5 flags have been displayed
      {
         submitJButton.setEnabled( false );
         nextFlagJButton.setEnabled( true );
      }
      
   } // end method submitJButtonActionPerformed
   
   // display next flag in the quiz
   private void nextFlagJButtonActionPerformed( ActionEvent event )
   {
      displayFlag(); // display next flag
      count++;
      
      // reset GUI components to initial states
      feedbackJTextField.setText( "" );
      selectCountryJComboBox.setSelectedIndex( 0 );
      submitJButton.setEnabled( true );
      nextFlagJButton.setEnabled( false );
      
   } // end method nextFlagJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      FlagQuiz application = new FlagQuiz();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class FlagQuiz

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