// Tutorial 9: ClassAverage.java
// Application enables user to have the average of grades calculated.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassAverage extends JFrame
{
   // JLabel and JTextArea for list of grades
   private JLabel gradeListJLabel;
   private JTextArea gradeListJTextArea;

   // JButton initiates retrieving grades
   private JButton getGradesJButton;

   // JButton initiates calculating average
   private JButton averageJButton;

   // JLabel and JTextField used to display average
   private JLabel classAverageJLabel;
   private JTextField classAverageJTextField;
   
   private int total = 0; // holds value of the grade total

   // no-argument constructor
   public ClassAverage()
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

      // set up gradeListJLabel
      gradeListJLabel = new JLabel();
      gradeListJLabel.setBounds( 16, 8, 70, 23 );
      gradeListJLabel.setText( "Grade list:" );
      contentPane.add( gradeListJLabel );

      // set up gradeListJTextArea
      gradeListJTextArea = new JTextArea();
      gradeListJTextArea.setBounds( 16, 32, 88, 180 );
      contentPane.add( gradeListJTextArea );

      // set up getGradesJButton
      getGradesJButton = new JButton();
      getGradesJButton.setBounds( 128, 50, 100, 26 );
      getGradesJButton.setText( "Get Grades" );
      contentPane.add( getGradesJButton );
      getGradesJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when getGradesJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               getGradesJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up averageJButton
      averageJButton = new JButton();
      averageJButton.setBounds( 128, 90, 100, 26 );
      averageJButton.setText( "Average" );
      averageJButton.setEnabled( false );
      contentPane.add( averageJButton );
      averageJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when averageJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               averageJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up classAverageJLabel
      classAverageJLabel = new JLabel();
      classAverageJLabel.setBounds( 128, 132, 90, 23 );
      classAverageJLabel.setText( "Class average:" );
      contentPane.add( classAverageJLabel );

      // set up classAverageJTextField
      classAverageJTextField = new JTextField();
      classAverageJTextField.setBounds( 128, 156, 100, 21 );
      classAverageJTextField.setEditable( false );
      classAverageJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( classAverageJTextField );

      // set properties of application's window
      setTitle( "Class Average" ); // set title bar text
      setSize( 250, 250 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface

   // method retrieves, totals, and displays grades from user
   private void getGradesJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method getGradesJButtonActionPerformed
   
   // method calculates average of grades entered
   private void averageJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method averageJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      ClassAverage application = new ClassAverage();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class ClassAverage

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
