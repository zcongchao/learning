package classAverage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassAverage extends JFrame
{
	private JLabel gradeListJLabel;
	private JTextArea gradeListJTextArea;

   // JButton initiates retrieving grades
   private JButton getGradesJButton;

   // JButton initiates calculating average
   private JButton averageJButton;

   // JLabel and JTextField used to display average
   private JLabel classAverageJLabel;
   private JTextField classAverageJTextField;
   
   private int total = 0;
   
   public ClassAverage()
   {
	   createUserInterface();
   }
   
   private void createUserInterface()
   {
	   Container contentPane = getContentPane();
	   
	   contentPane.setLayout(null);
	   
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
	     			   
      }
   private void getGradesJButtonActionPerformed(ActionEvent event)
   {
	   total = 0;
	   int counter = 1;
	   String input;
	   int grade;
	   
	   gradeListJTextArea.setText( "" );
       classAverageJTextField.setText( "" );
       
       do
       {
    	   input = JOptionPane.showInputDialog(null, "Enter Grade");
    	   grade = Integer.parseInt( input );
    	   
    	   gradeListJTextArea.append(grade + "\n");
    	   total += grade;
    	   counter++;
    	   	   
       }
       while (counter <= 10);
       
       averageJButton.setEnabled( true );     // enable averageJButton
       averageJButton.requestFocusInWindow();
	   
	   
   }
   
   private void averageJButtonActionPerformed(ActionEvent event)
   {
	   double average = ( double ) total / 10;
	   classAverageJTextField.setText(String.valueOf( average));
   }
   
   


	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		ClassAverage application = new ClassAverage();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
