// Exercise 18.11: TriangleCreator.java
// This application determines types of triangles, based on user
// input.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriangleCreator extends JFrame
{
   // JLabel and JTextArea for side1
   private JLabel side1JLabel; 
   private JTextField side1JTextField;

   // JLabel and JTextArea for side2
   private JLabel side2JLabel;
   private JTextField side2JTextField;

   // JLabel and JTextArea for side3
   private JLabel side3JLabel;
   private JTextField side3JTextField; 

   // JTextField for displaying message
   private JTextField messageJTextField;

   // JButton to create triangle
   private JButton createJButton;
   
   // no-argument constructor
   public TriangleCreator()
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
      
      // set up side1JLabel
      side1JLabel = new JLabel();
      side1JLabel.setBounds( 16, 16, 40, 24 );
      side1JLabel.setText( "Side1:" );
      contentPane.add( side1JLabel );
      
      // set up side1JTextField
      side1JTextField = new JTextField();
      side1JTextField.setBounds( 72, 16, 90, 24 );
      side1JTextField.setHorizontalAlignment( JTextField.RIGHT ); 
      contentPane.add( side1JTextField );
      
      // set up side2JLabel
      side2JLabel = new JLabel();
      side2JLabel.setBounds( 16, 56, 40, 24 );
      side2JLabel.setText( "Side2:" );
      contentPane.add( side2JLabel );
      
      // set up side2JTextField
      side2JTextField = new JTextField();
      side2JTextField.setBounds( 72, 56, 90, 24 );
      side2JTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( side2JTextField );
      
      // set up side3JLabel
      side3JLabel = new JLabel();
      side3JLabel.setBounds( 16, 96, 40, 24 );
      side3JLabel.setText( "Side3:" );
      contentPane.add( side3JLabel );
      
      // set up side3JTextField
      side3JTextField = new JTextField();
      side3JTextField.setBounds( 72, 96, 90, 24 );
      side3JTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( side3JTextField );
      
      // set up messageJTextField
      messageJTextField = new JTextField();
      messageJTextField.setBounds( 16, 140, 252, 24 );
      messageJTextField.setEditable( false );
      contentPane.add( messageJTextField );
      
      // set up createJButton
      createJButton = new JButton();
      createJButton.setBounds( 178, 16, 90, 24 );
      createJButton.setText( "Create" );
      contentPane.add( createJButton );
      createJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when createJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               createJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Triangle Creator" ); // set title bar string
      setSize( 290, 208 );            // set window size
      setVisible( true );             // display window
      
   } // end method createUserInterface
   
   // get user input and display correct text
   private void createJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method createJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      TriangleCreator application = new TriangleCreator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main
   
} // end class TriangleCreator

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