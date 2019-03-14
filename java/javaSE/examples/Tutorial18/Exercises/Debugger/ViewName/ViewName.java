// Exercise 18.16: ViewName.java
// User inputs are displayed in a JOptionPane.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewName extends JFrame
{
   // JLabel and JTextField for first name
   private JLabel firstJLabel;
   private JTextField firstJTextField;

   // JLabel and JTextField for last name
   private JLabel lastJLabel;
   private JTextField lastJTextField;

   // JButton to view name
   private JButton viewJButton;
   
   // no-argument constructor
   public ViewName()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handler
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up firstJLabel
      firstJLabel = new JLabel();
      firstJLabel.setBounds( 16, 16, 80, 21 );
      firstJLabel.setText( "First name:" );
      contentPane.add( firstJLabel );
      
      // set up firstJTextField
      firstJTextField = new JTextField();
      firstJTextField.setBounds( 112, 16, 140, 21 );
      firstJTextField.setHorizontalAlignment( JTextField.LEFT );
      contentPane.add( firstJTextField );
      
      // set up lastJLabel
      lastJLabel = new JLabel();
      lastJLabel.setBounds( 16, 56, 80, 21 );
      lastJLabel.setText( "Last name:" );
      contentPane.add( lastJLabel );
      
      // set up lastJTextField
      lastJTextField = new JTextField();
      lastJTextField.setBounds( 112, 56, 140, 21 );
      lastJTextField.setHorizontalAlignment( JTextField.LEFT );
      contentPane.add( lastJTextField );
      
      // set up viewJButton
      viewJButton = new JButton();
      viewJButton.setBounds( 142, 96, 100, 24 );
      viewJButton.setText( "View Name" );
      contentPane.add( viewJButton );
      viewJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when viewJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                viewJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
           
      // set properties of application's window
      setTitle( "View Name" ); // set title bar string
      setSize( 280, 160 );     // set window size
      setVisible( true );      // display window
      
   } // end method createUserInterface
   
   // create new Name object and output to a JOptionPane
   private void viewJButtonActionPerformed( ActionEvent event )
   {
      // create new Name
      Name name = new Name( firstJTextField.getText(), 
         lastJTextField.getText() );

      // assign user's name to output
      String output = ( "Your name is: " + name.getFirst() + " " + 
         name.getLast() );
      
      // display user's name
      JOptionPane.showMessageDialog( this, output, "Name", 
         JOptionPane.INFORMATION_MESSAGE );

   } // end method viewJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      ViewName application = new ViewName();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class ViewName

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