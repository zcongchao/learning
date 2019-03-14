// Exercise 8.11: TableOfPowers.java
// Displays a table of powers up to a given limit.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TableOfPowers extends JFrame
{
   // JLabel and JTextField for limit of loop counter
   private JLabel limitJLabel;
   private JTextField limitJTextField;

   // JTextArea for displaying results
   private JTextArea outputJTextArea;

   // JButton to initiate calculations
   private JButton calculateJButton;
   
   // no-argument constructor
   public TableOfPowers()
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
      
      // set up limitJLabel
      limitJLabel = new JLabel();
      limitJLabel.setBounds( 16, 16, 64, 26 );
      limitJLabel.setText( "Upper limit:" );
      contentPane.add( limitJLabel );
      
      // set up limitJTextField
      limitJTextField = new JTextField();
      limitJTextField.setBounds( 85, 16, 59, 26 );
      limitJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( limitJTextField );
      limitJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called if key pressed in limitJTextField
            public void keyPressed( KeyEvent event )
            {
               limitJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener 
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 166, 16, 130, 26 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when user clicks calculateJButton
             public void actionPerformed ( ActionEvent event )
             {
                calculateJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener      
      
      // set up outputJTextArea
      outputJTextArea = new JTextArea();
      outputJTextArea.setEditable( false );

      // create JScrollPane that provides scrolling 
      // for outputJTextArea
      JScrollPane scrollJScrollPane = 
         new JScrollPane( outputJTextArea );
      scrollJScrollPane.setBounds( 16, 56, 280, 95 ); 
      contentPane.add( scrollJScrollPane );
      
      // set properties of applicatiojn's window
      setTitle( "Table Of Powers" ); // set title bar text
      setSize( 320, 195 );           // set window's size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // called when user presses key in limitJTextField
   private void limitJTextFieldKeyPressed( KeyEvent event )
   {

   }

   // called when user clicks calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      TableOfPowers application = new TableOfPowers();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class TableOfPowers

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
