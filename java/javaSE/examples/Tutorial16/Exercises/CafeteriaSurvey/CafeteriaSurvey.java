// Exercise 16.13: CafeteriaSurvey.java
// Application that asks 20 users to enter a rating of the quality of
// food in the student cafeteria and displays a histogram of the
// data. User can add ratings between the values of 1 and 10, with
// 1 being "awful" and 10 being "excellent."
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CafeteriaSurvey extends JFrame
{
   // JLabel and JComboBox for choosing a rating
   private JLabel ratingJLabel;
   private JComboBox ratingJComboBox;

   // JButton to submit a rating
   private JButton submitRatingJButton;

   // JLabel and JTextArea for displaying all ratings
   private JLabel resultJLabel;
   private JTextArea resultJTextArea;

   private int responseCounter = 0; // tracks number of responses
   
   // no-argument constructor
   public CafeteriaSurvey()
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
      
      // set up ratingJLabel
      ratingJLabel = new JLabel();
      ratingJLabel.setBounds( 20, 20, 140, 20 );
      ratingJLabel.setText( "Rate cafeteria food:" );
      contentPane.add( ratingJLabel );

      // set up ratingJComboBox
      ratingJComboBox = new JComboBox();
      ratingJComboBox.setBounds( 180, 20, 80, 20 );
      contentPane.add( ratingJComboBox );
      
      // set up submitJButton
      submitRatingJButton = new JButton();
      submitRatingJButton.setBounds( 80, 55, 130, 20 );
      submitRatingJButton.setText( "Submit Rating" );
      contentPane.add( submitRatingJButton );
      submitRatingJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when
            // submitRatingJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               submitRatingJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
    
      ); // end call to addActionListener
      
      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 20, 100, 100, 20 );
      resultJLabel.setText( "Survey results:" );
      contentPane.add( resultJLabel );
      
      // set up resultJTextArea
      resultJTextArea = new JTextArea();
      resultJTextArea.setBounds( 20, 130, 240, 190 );
      resultJTextArea.setEditable( false );
      contentPane.add( resultJTextArea );
      
      // set properties of application's window
      setTitle( "Cafeteria Survey" ); // set title bar string
      setSize( 290, 370 );            // set window size
      setVisible( true );             // display window

   } // end method createUserInterface
   
   // submit response and display results
   private void submitRatingJButtonActionPerformed( 
      ActionEvent event )
   {
      responseCounter++;
      int input = ratingJComboBox.getSelectedIndex() + 1;
      
      // if 20 ratings have been entered, display histogram
      if ( responseCounter == 20 )
      {
         resultJTextArea.setText( "Rating\tFrequency:\n" );

         for ( int i = 1; i <= 10; i++ )
         {
            resultJTextArea.append( i + "\t" );

            resultJTextArea.append( "\n" );

         } // end outer for loop
    
      submitRatingJButton.setEnabled( false );

      } // end if statement

   } // end submitJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      CafeteriaSurvey application = new CafeteriaSurvey();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class CafeteriaSurvey

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