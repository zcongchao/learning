// Tutorial 17: StudentGrades.java
// This application computes each student's grade average and
// the class average for ten students.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudentGrades extends JFrame 
{
   // JPanel for user inputs
   private JPanel inputGradeJPanel;
   
   // JLabel and JTextField for student name
   private JLabel studentNameJLabel;
   private JTextField studentNameJTextField;
   
   // JLabel and JTextField for test 1 score
   private JLabel test1JLabel;
   private JTextField test1JTextField;

   // JLabel and JTextField for test 2 score
   private JLabel test2JLabel;
   private JTextField test2JTextField;

   // JLabel and JTextField for test 3 score
   private JLabel test3JLabel;
   private JTextField test3JTextField;

   // JButton to calculate student and class average
   private JButton submitGradesJButton;

   // ButtonGroup to control numeric and letter JRadioButtons
   private ButtonGroup displayButtonGroup;

   // JRadioButtons to choose to display numerically or as letters
   private JRadioButton numericJRadioButton;
   private JRadioButton letterJRadioButton;

   // JLabel and JTextArea to display student averages
   private JLabel displayJLabel;
   private JTextArea displayJTextArea;

   // JLabel and JTextField to display the class average
   private JLabel classAverageJLabel;
   private JTextField classAverageJTextField;
   
   // initialize number of students to zero
   private int studentCount = 0;

   // constants 
   private final int NUMBER_OF_TESTS = 3;
   private final int MAXIMUM_STUDENTS = 10;
   private final int FIRST_TEST = 0;
   private final int SECOND_TEST = 1;
   private final int THIRD_TEST = 2;

   // one-dimensional array to store student names
   private String studentNames[] = new String[ MAXIMUM_STUDENTS ];

   // two-dimensional array to store student grades
   private int studentGrades[][] = 
      new int[ MAXIMUM_STUDENTS ][ NUMBER_OF_TESTS ];

   // DecimalFormat for two digits of precision
   private DecimalFormat twoDigits = new DecimalFormat( "0.00" );

   // no-argument constructor
   public StudentGrades()
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

      // set up inputGradeJPanel
      inputGradeJPanel = new JPanel();
      inputGradeJPanel.setBounds( 16, 16, 208, 218 );
      inputGradeJPanel.setBorder(
         new TitledBorder( "Input Grade" ) );
      inputGradeJPanel.setLayout( null );
      contentPane.add( inputGradeJPanel );
      
      // set up studentNameJLabel
      studentNameJLabel = new JLabel();
      studentNameJLabel.setBounds( 8, 32, 90, 23 );
      studentNameJLabel.setText( "Student Name:" );
      inputGradeJPanel.add( studentNameJLabel );

      // set up studentNameJTextField
      studentNameJTextField = new JTextField();
      studentNameJTextField.setBounds( 104, 32, 88, 21 );
      studentNameJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      inputGradeJPanel.add( studentNameJTextField );
      
      // set up test1JLabel
      test1JLabel = new JLabel();
      test1JLabel.setBounds( 8, 74, 60, 23 );
      test1JLabel.setText( "Test 1:" );
      inputGradeJPanel.add( test1JLabel );

      // set up test1JTextField
      test1JTextField = new JTextField();
      test1JTextField.setBounds( 136, 74, 56, 21 );
      test1JTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputGradeJPanel.add( test1JTextField );

      // set up test2JLabel
      test2JLabel = new JLabel();
      test2JLabel.setBounds( 8, 98, 60, 23 );
      test2JLabel.setText( "Test 2:" );
      inputGradeJPanel.add( test2JLabel );

      // set up test2JTextField
      test2JTextField = new JTextField();
      test2JTextField.setBounds( 136, 98, 56, 21 );
      test2JTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputGradeJPanel.add( test2JTextField );

      // set up test3JLabel
      test3JLabel = new JLabel();
      test3JLabel.setBounds( 8, 122, 60, 23 );
      test3JLabel.setText( "Test 3:" );
      inputGradeJPanel.add( test3JLabel );

      // set up test3JTextField
      test3JTextField = new JTextField();
      test3JTextField.setBounds( 136, 122, 56, 21 );
      test3JTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputGradeJPanel.add( test3JTextField );

      // set up submitGradesJButton
      submitGradesJButton = new JButton();
      submitGradesJButton.setBounds( 72, 182, 120, 24 );
      submitGradesJButton.setText( "Submit Grades" );
      inputGradeJPanel.add( submitGradesJButton );
      submitGradesJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when submitGradesJButton 
            // is clicked
            public void actionPerformed( ActionEvent event )
            {
               submitGradesJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up displayButtonGroup
      displayButtonGroup = new ButtonGroup();
      
      // set up numericJRadioButton
      numericJRadioButton = new JRadioButton(); 
      numericJRadioButton.setBounds( 55, 244, 75, 23 );
      numericJRadioButton.setText( "Numeric" );
      numericJRadioButton.setSelected( true );
      displayButtonGroup.add( numericJRadioButton );
      contentPane.add( numericJRadioButton );
      numericJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when numericJRadioButton 
            // is selected
            public void actionPerformed( ActionEvent event )
            {
               numericJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up letterJRadioButton
      letterJRadioButton = new JRadioButton();
      letterJRadioButton.setBounds( 140, 244, 75, 23 );
      letterJRadioButton.setText( "Letter" );
      displayButtonGroup.add( letterJRadioButton );
      contentPane.add( letterJRadioButton );
      letterJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when letterJRadioButton 
            // is selected
            public void actionPerformed( ActionEvent event )
            {
               letterJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up displayJLabel
      displayJLabel = new JLabel();
      displayJLabel.setBounds( 240, 16, 150, 23 );
      displayJLabel.setText( "Average of each student:" );
      contentPane.add( displayJLabel );
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 240, 48, 402, 184 );
      displayJTextArea.setEditable( false );
      contentPane.add( displayJTextArea );
      
      // set up classAverageJLabel
      classAverageJLabel = new JLabel();
      classAverageJLabel.setBounds( 490, 244, 96, 23 );
      classAverageJLabel.setText( "Class average:" );
      contentPane.add( classAverageJLabel );
      
      // set up classAverageJTextField
      classAverageJTextField = new JTextField();
      classAverageJTextField.setBounds( 586, 244, 56, 23 );
      classAverageJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      classAverageJTextField.setEditable( false );
      contentPane.add( classAverageJTextField );
      
      // set properties of application's window
      setTitle( "Student Grades" ); // set title bar string
      setSize( 670, 308 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface

   // convert a number to a letter grade
   private String convertToLetterGrade( double grade )
   {
      if ( grade >= 90 )
      {
         return "A";
      }
      else if ( grade >= 80 )
      {
         return "B";
      }
      else if ( grade >= 70 )
      {
         return "C";
      }
      else if ( grade >= 60 )
      {
         return "D";
      }
      else
      {
         return "F";
      }
   
   } // end method convertToLetterGrade

   // calculate and display the student and class average
   private void submitGradesJButtonActionPerformed(
      ActionEvent event )
   {
      // get user input
      String nameOfStudent = studentNameJTextField.getText();
      int test1 = Integer.parseInt( test1JTextField.getText() );
      int test2 = Integer.parseInt( test2JTextField.getText() );
      int test3 = Integer.parseInt( test3JTextField.getText() );

      // add user input to arrays
      studentNames[ studentCount ] = nameOfStudent;
      studentGrades[ studentCount ][ FIRST_TEST ] = test1;
      studentGrades[ studentCount ][ SECOND_TEST ] = test2;
      studentGrades[ studentCount ][ THIRD_TEST ] = test3;

      studentCount++; // increment studentCount

      if ( numericJRadioButton.isSelected() )
      {
         displayNumericGrades();
      }
      else
      {
         displayLetterGrades();
      }
      
      // clear other JTextFields for new data
      studentNameJTextField.setText( "" );
      test1JTextField.setText( "" );
      test2JTextField.setText( "" );
      test3JTextField.setText( "" );
 
      // if ten student grades have been entered
      if ( studentCount == MAXIMUM_STUDENTS )
      {
         // disable submitGradesJButton
         submitGradesJButton.setEnabled( false );
      }

   } // end method submitGradesJButtonActionPerformed

   // display student grades and averages as numbers
   private void displayNumericGrades()
   {
      // add a header to displayJTextArea
      displayJTextArea.setText( 
         "Name\tTest 1\tTest 2\tTest 3\tAverage\n" );

      int studentTotal = 0; // store the student's total grades
      int classTotal = 0;   // store the class's total grades

      for ( int student = 0; student < studentCount; student++ )
      {
         // display student names
         displayJTextArea.append( studentNames[ student ] + "\t" );

         studentTotal = 0; // initialize the student's total grades
         
         for ( int test = 0; test < NUMBER_OF_TESTS; test++ )
         {
            // append each test grade to displayJTextArea
            displayJTextArea.append(
               studentGrades[ student ][ test ] + "\t" );

            // add the test grade to the student's total
            studentTotal += studentGrades[ student ][ test ];

         } // end inner for

         // add the student's total grade to the class's total
         classTotal += studentTotal;

         // calculate the student average and display it
         double studentAverage = 
            ( double ) studentTotal / NUMBER_OF_TESTS;
         displayJTextArea.append( 
            twoDigits.format( studentAverage ) + "\n" );

      } // end outer for

      // calculate the class average and display it
      double classAverage = 
         ( double ) classTotal / studentCount / NUMBER_OF_TESTS;
      classAverageJTextField.setText( 
         twoDigits.format( classAverage ) );

   } // end method displayNumericGrades

   // display student grades and averages as letters
   private void displayLetterGrades()
   {
      // add a header to displayJTextArea
      displayJTextArea.setText( 
         "Name\tTest 1\tTest 2\tTest 3\tAverage\n" );

      int studentTotal = 0; // store the student's total grades
      int classTotal = 0;   // store the class's total grades

      for ( int student = 0; student < studentCount; student++ )
      {
         // display student names
         displayJTextArea.append( studentNames[ student ] + "\t" );

         studentTotal = 0; // initialize the student's total grades

         for ( int test = 0; test < NUMBER_OF_TESTS; test++ )
         {
            // append each test grade to displayJTextArea
            displayJTextArea.append( convertToLetterGrade( 
               studentGrades[ student ][ test ] ) + "\t" );

            // add the test grade to the student's total
            studentTotal += studentGrades[ student ][ test ];

         } // end inner for

         // add the student's total grade to the class's total
         classTotal += studentTotal;

         // calculate the student average and display it
         double studentAverage = 
            ( double ) studentTotal / NUMBER_OF_TESTS;
         displayJTextArea.append( 
            convertToLetterGrade( studentAverage ) + "\n" );

      } // end outer for

      // calculate the class average and display it
      double classAverage = 
         ( double ) classTotal / studentCount / NUMBER_OF_TESTS;
      classAverageJTextField.setText( 
         convertToLetterGrade( classAverage ) );

   } // end method displayLetterGrades

   // user selected numeric display
   private void numericJRadioButtonActionPerformed(
      ActionEvent event )
   {
      displayNumericGrades();

   } // end method numericJRadioButtonActionPerformed
   
   // user selected letter display
   private void letterJRadioButtonActionPerformed(
      ActionEvent event )
   {
      displayLetterGrades();
       
   } // end method letterJRadioButtonActionPerformed

   // main method
   public static void main( String[] args ) 
   {
      StudentGrades application = new StudentGrades();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main

} // end class StudentGrades

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