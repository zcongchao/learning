// Exercise 27.16: MovingShapes.java
// Application allows user to create shapes that move around screen.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingShapes extends JFrame 
{
   // JComboBox to choose a drawing shape
   private JComboBox shapeJComboBox;

   // JButton to select a new color
   private JButton colorJButton;

   // PaintJPanel for drawing shapes
   private PaintJPanel painterPaintJPanel;

   // String array for storing the choices in shapeJComboBox
   private String[] shapeTypes = { "Line", "Rectangle", "Oval" };

   // no-argument constructor
   public MovingShapes()
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

      // set up controlsJPanel
      JPanel controlsJPanel = new JPanel();
      controlsJPanel.setBounds( 0, 0, 400, 40 );
      controlsJPanel.setLayout( null );
      contentPane.add( controlsJPanel );
      
      // set up painterPaintJPanel
      painterPaintJPanel = new PaintJPanel();
      painterPaintJPanel.setBounds( 0, 40, 400, 340 );
      painterPaintJPanel.setBackground( Color.WHITE );
      contentPane.add( painterPaintJPanel );

      // set up shapeJComboBox
      shapeJComboBox = new JComboBox( shapeTypes );
      shapeJComboBox.setBounds( 100, 2, 90, 24 );
      controlsJPanel.add( shapeJComboBox );
      shapeJComboBox.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when shapeJComboBox is selected
            public void actionPerformed( ActionEvent event )
            {
               shapeJComboBoxActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up colorJButton
      colorJButton = new JButton();
      colorJButton.setText( "Color" );
      colorJButton.setBounds( 210, 2, 80, 24 );
      controlsJPanel.add( colorJButton );
      colorJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when colorJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               colorJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Moving Shapes" ); // set title bar string
      setSize( 408, 407 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface

   // select a new color for the shape
   private void colorJButtonActionPerformed( ActionEvent event )
   {
      Color selection = JColorChooser.showDialog( null, 
         "Select a Color", Color.BLACK );
      colorJButton.setBackground( selection );
      painterPaintJPanel.setCurrentColor( selection );

   } // end method colorJButtonActionPerformed

   // set the selected shape in the painting panel
   private void shapeJComboBoxActionPerformed( ActionEvent e ) 
   {
      painterPaintJPanel.setCurrentShapeType( 
         shapeJComboBox.getSelectedItem().toString() );

   } // end method shapeJComboBoxActionPerformed

   // main method
   public static void main( String args[] )
   {
      MovingShapes application = new MovingShapes();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class MovingShapes

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