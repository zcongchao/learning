// Tutorial 20: BrickWall.java
// Application builds a brick wall using rectangles.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickWall extends JFrame
{
   // JButton to draw the brick wall
   private JButton drawJButton;

   // JButton to clear the JPanel
   private JButton clearJButton;

   // DrawJPanel for displaying bricks
   private DrawJPanel drawingJPanel;

   // JLabel and JTextField for inputing rows
   private JLabel rowsJLabel;
   private JTextField rowsJTextField;

   // JLabel and JTextField for inputing columns
   private JLabel columnsJLabel; 
   public JTextField columnsJTextField;

   // no-argument constructor
   public BrickWall()
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

      // set up drawJButton
      drawJButton = new JButton();
      drawJButton.setBounds( 100, 8, 100, 23 );
      drawJButton.setText( "Draw Wall" );
      contentPane.add( drawJButton );
      drawJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // method called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               drawJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 250, 8, 100, 23 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // method called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up drawingJPanel
      drawingJPanel = new DrawJPanel();
      drawingJPanel.setBounds( 0, 40, 450, 250 );
      drawingJPanel.setBackground( Color.WHITE );
      contentPane.add( drawingJPanel );

      // set up rowsJLabel
      rowsJLabel = new JLabel();
      rowsJLabel.setBounds( 50, 325, 50, 25 );
      rowsJLabel.setText( "Rows:" );
      contentPane.add( rowsJLabel );

      // set up rowsJTextField
      rowsJTextField = new JTextField();
      rowsJTextField.setBounds( 100, 325, 50, 25 );
      rowsJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( rowsJTextField );

      // set up columnsJLabel
      columnsJLabel = new JLabel();
      columnsJLabel.setBounds( 225, 325, 75, 25 );
      columnsJLabel.setText( "Columns:" );
      contentPane.add( columnsJLabel );

      // set up columnsJTextField
      columnsJTextField = new JTextField();
      columnsJTextField.setBounds( 290, 325, 50, 25 );
      columnsJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( columnsJTextField );

      // set properties of application's window
      setTitle( "Brick Wall" );   // set title bar text
      setSize( 459, 400 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // reset drawingJPanel
   private void clearJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.clearArray();
      drawingJPanel.repaint();

   } // end method drawJButtonActionPerformed

   // draw the brick wall
   private void drawJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method drawJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      BrickWall application = new BrickWall();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class BrickWall

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