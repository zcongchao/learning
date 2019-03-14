// Exercise 8.17: ToDoList.java
// Creates a To-Do List based on user input.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToDoList extends JFrame
{
   // JLabel and JTextField to input a task
   private JLabel taskJLabel;
   private JTextField taskJTextField;

   // JButton to initiate adding a task to the to-do list
   private JButton addJButton;

   // JTextArea to display the to-do list
   private JTextArea outputJTextArea;
   
   // no-argument constructor
   public ToDoList()
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up taskJLabel
      taskJLabel = new JLabel();
      taskJLabel.setBounds( 16, 8, 40, 26 );
      taskJLabel.setText( "Task:" );
      contentPane.add( taskJLabel );
      
      // set up taskJTextField
      taskJTextField = new JTextField();
      taskJTextField.setBounds( 65, 8, 100, 26 );
      taskJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( taskJTextField );
            
      // set up addJButton
      addJButton = new JButton( "Add" );
      addJButton.setBounds( 183, 8, 75, 26 );
      contentPane.add( addJButton );
      addJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when user clicks addJButton 
             public void actionPerformed ( ActionEvent event )
             {
                addJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set up outputJTextArea
      outputJTextArea = new JTextArea();
      outputJTextArea.setEditable( false );

      // set up JScrollPane to allow JTextArea scrolling
      JScrollPane scrollJScrollPane = 
         new JScrollPane( outputJTextArea );
      scrollJScrollPane.setBounds( 16, 48, 242, 95 );
      contentPane.add( scrollJScrollPane );

      // set properties of application’s window
      setTitle( "To Do List" ); // set title bar text
      setSize( 280, 188 );      // set window's size
      setVisible( true );       // display window
      
   } // end method createUserInterface
   
   // called when user clicks addJButton 
   public void addJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method addJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      ToDoList application = new ToDoList();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class ToDoList

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
