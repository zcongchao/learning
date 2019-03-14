// Exercise 14.11: TaskList.java
// Creates a task list based on user input.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TaskList extends JFrame
{
   // JLabel and JTextField to display task
   private JLabel taskJLabel;
   private JTextField taskJTextField;

   // JButton to enter task
   private JButton addTaskJButton;

   // JLabel and JTextArea to display entered tasks
   private JLabel taskListJLabel;
   private JTextArea taskListJTextArea;

   // JLabel and JTextField to display number of entered tasks
   private JLabel numberJLabel;
   private JTextField numberJTextField;

   // no-argument constructor
   public TaskList()
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

      // set up taskJLabel
      taskJLabel = new JLabel();
      taskJLabel.setBounds( 16, 16, 32, 24 );
      taskJLabel.setText( "Task:" );
      contentPane.add( taskJLabel );
      
      // set up taskJTextField
      taskJTextField = new JTextField();
      taskJTextField.setBounds( 56, 16, 128, 24 );
      taskJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( taskJTextField );
      
      // set up addTaskJButton
      addTaskJButton = new JButton();
      addTaskJButton.setBounds( 200, 16, 148, 24 );
      addTaskJButton.setText( "Add Task" );
      contentPane.add( addTaskJButton );
      addTaskJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when addTaskJButton is clicked
            public void actionPerformed ( ActionEvent event )
            {
               addTaskJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up taskListJLabel
      taskListJLabel = new JLabel();
      taskListJLabel.setBounds( 16, 64, 100, 24 );
      taskListJLabel.setText( "Task list:" );
      contentPane.add( taskListJLabel );
      
      // set up taskListJTextArea
      taskListJTextArea = new JTextArea();
      taskListJTextArea.setBounds( 16, 90, 168, 108 );
      taskListJTextArea.setEditable( false );
      contentPane.add( taskListJTextArea );
      
      // set up numberJLabel
      numberJLabel = new JLabel();
      numberJLabel.setBounds( 200, 104, 116, 24 );
      numberJLabel.setText( "Number of Tasks:" );
      contentPane.add( numberJLabel );
      
      // set up numberJTextField
      numberJTextField = new JTextField();
      numberJTextField.setBounds( 316, 104, 32, 24 );
      numberJTextField.setEditable ( false );
      numberJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( numberJTextField );
      
      // set properties of application's window
      setTitle( "Task List" ); // set title bar string
      setSize( 375, 240 );     // set window size
      setVisible( true );      // display window
      
   } // end method createUserInterface
   
   // display task list and task number
   public void addTaskJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method addJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      TaskList application = new TaskList();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class TaskList

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