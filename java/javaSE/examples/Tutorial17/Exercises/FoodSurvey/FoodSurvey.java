// Exercise 17.11: FoodSurvey.java
// This program takes a survey of opinions on various foods.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FoodSurvey extends JFrame 
{
   // JComboBox to give choice of foods
   private JComboBox foodJComboBox;
   
   // JButton to add choice to JTextArea
   private JButton addJButton;

   // ButtonGroup to control like and dislike JRadioButtons
   private ButtonGroup choiceButtonGroup;

   // JRadioButtons to choose like or dislike of food
   private JRadioButton likeJRadioButton;
   private JRadioButton dislikeJRadioButton;

   // JTextArea to display results
   private JTextArea displayJTextArea;
   
   // String array for food choices
   private String foodChoices[] = { "Pizza", "Hot Dog",
      "Fish Sticks", "Mystery Meat" };

   // no-argument constructor
   public FoodSurvey()
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
      
      // set up foodJComboBox
      foodJComboBox = new JComboBox( foodChoices );
      foodJComboBox.setBounds( 16, 16, 110, 23 );
      contentPane.add( foodJComboBox );

      // set up choiceButtonGroup
      choiceButtonGroup = new ButtonGroup();
      
      // set up likeJRadioButton
      likeJRadioButton = new JRadioButton(); 
      likeJRadioButton.setBounds( 135, 16, 60, 23 );
      likeJRadioButton.setText( "Like" );
      likeJRadioButton.setSelected( true );
      choiceButtonGroup.add( likeJRadioButton );
      contentPane.add( likeJRadioButton );
      
      // set up dislikeJRadioButton
      dislikeJRadioButton = new JRadioButton();
      dislikeJRadioButton.setBounds( 195, 16, 70, 23 );
      dislikeJRadioButton.setText( "Dislike" );
      choiceButtonGroup.add( dislikeJRadioButton );
      contentPane.add( dislikeJRadioButton );
      
      // set up addJButton
      addJButton = new JButton();
      addJButton.setBounds( 265, 16, 67, 23 );
      addJButton.setText( "Add" );
      contentPane.add ( addJButton );
      addJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when addJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 16, 55, 315, 93 );
      displayJTextArea.setEditable( false );
      contentPane.add( displayJTextArea );
         
      // set properties of application's window
      setTitle( "Food Survey" ); // set title bar string
      setSize( 355, 190 );       // set window size
      setVisible( true );        // display window

   } // end method createUserInterface

   // calculate and display the student and class average
   private void addJButtonActionPerformed( ActionEvent event )
   {

   } // end method addJButtonActionPerformed
   
   // main method
   public static void main( String[] args ) 
   {
      FoodSurvey application = new FoodSurvey();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main

} // end class FoodSurvey

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