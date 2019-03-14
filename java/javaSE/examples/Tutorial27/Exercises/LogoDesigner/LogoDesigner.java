// Exercise 27.12: LogoDesigner.java
// Application that allows the user to design a logo for a company.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class LogoDesigner extends JFrame
{
   // DrawJPanel for drawing shapes to
   private DrawJPanel drawingJPanel;

   // JPanel for holding JRadioButtons
   private JPanel shapeJPanel;

   // JRadioButtons to choose a shape
   private JRadioButton rectangleJRadioButton;
   private JRadioButton ellipseJRadioButton;
   private JRadioButton lineJRadioButton;
   private JRadioButton filledRectangleJRadioButton;
   private JRadioButton filledEllipseJRadioButton;

   // ButtonGroup for grouping JRadioButtons
   private ButtonGroup shapeButtonGroup;

   // JPanel for holding settings input controls
   private JPanel settingsJPanel;

   // JLabel and JTextField for x or x1
   private JLabel xJLabel;
   private JTextField xJTextField;

   // JLabel and JTextField for y or y1
   private JLabel yJLabel;
   private JTextField yJTextField;

   // JLabel and JTextField for width or x2
   private JLabel widthJLabel;
   private JTextField widthJTextField;

   // JLabel and JTextField for height or y2
   private JLabel heightJLabel;
   private JTextField heightJTextField;

   // JPanel for holding colorJComboBox
   private JPanel colorJPanel;

   // JComboBox to choose the color
   private JComboBox colorJComboBox;

   // JButton to add shape to drawing area
   private JButton addJButton;

   // JButton to clear the drawing area
   private JButton clearJButton;
   
   // String array for storing the Strings in the JComboBox
   private final String[] colorNames = { "Black", "Blue", "Green",
      "Magenta", "Orange", "Red", "Yellow" };
      
   // Color array for storing the Color objects that 
   // correspond to the colorNames array
   private final Color[] colors = { Color.BLACK, Color.BLUE,
      Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED,
      Color.YELLOW };
      
   // no-argument constructor
   public LogoDesigner()
   {
      createUserInterface();
   }

   // set up the GUI components
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );
      
      // set up drawingJPanel
      drawingJPanel = new DrawJPanel();
      drawingJPanel.setBackground( Color.WHITE );
      drawingJPanel.setBounds( 15, 15, 460, 175 );
      drawingJPanel.setOpaque( true );
      contentPane.add( drawingJPanel );
      
      // set up shapeJPanel
      shapeJPanel = new JPanel();
      shapeJPanel.setBounds( 10, 200, 355, 130 );
      shapeJPanel.setBorder( new TitledBorder( "Shape" ) );
      shapeJPanel.setLayout( null );
      contentPane.add( shapeJPanel );
      
      // set up rectangleJRadioButton
      rectangleJRadioButton = new JRadioButton();
      rectangleJRadioButton.setText( "Rectangle" );
      rectangleJRadioButton.setBounds( 20, 25, 90, 20 );
      shapeJPanel.add( rectangleJRadioButton );
      
      // set up ellipseJRadioButton
      ellipseJRadioButton  = new JRadioButton();
      ellipseJRadioButton.setText( "Ellipse" );
      ellipseJRadioButton.setBounds( 20, 60, 100, 20 );
      shapeJPanel.add( ellipseJRadioButton );
      
      // set up lineJRadioButton
      lineJRadioButton = new JRadioButton();
      lineJRadioButton.setText( "Line" );
      lineJRadioButton.setBounds( 20, 95, 70, 20 );
      shapeJPanel.add( lineJRadioButton );
      lineJRadioButton.addChangeListener(
      
         new ChangeListener() // anonymous inner class
         {
            // event handler called when the 
            // state of lineJRadioButton is changed
            public void stateChanged( ChangeEvent event )
            {
               lineJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
  
      // set up filledRectangleJRadioButton
      filledRectangleJRadioButton = new JRadioButton();
      filledRectangleJRadioButton.setText( "Filled Rectangle" );
      filledRectangleJRadioButton.setBounds( 130, 25, 150, 20 );
      shapeJPanel.add( filledRectangleJRadioButton );

      // set up filledEllipseJRadioButton
      filledEllipseJRadioButton = new JRadioButton();
      filledEllipseJRadioButton.setText( "Filled Ellipse" );
      filledEllipseJRadioButton.setBounds( 130, 60, 150, 20 );
      shapeJPanel.add( filledEllipseJRadioButton );
    
      // set up shapeButtonGroup
      shapeButtonGroup = new ButtonGroup();
      shapeButtonGroup.add( rectangleJRadioButton );
      shapeButtonGroup.add( filledRectangleJRadioButton );
      shapeButtonGroup.add( ellipseJRadioButton );
      shapeButtonGroup.add( filledEllipseJRadioButton );
      shapeButtonGroup.add( lineJRadioButton );

      // set up settingsJPanel
      settingsJPanel = new JPanel();
      settingsJPanel.setBounds( 10, 340, 350, 60 );
      settingsJPanel.setBorder( new TitledBorder( "Settings" ) );
      settingsJPanel.setLayout( null );
      contentPane.add( settingsJPanel );
      
      // set up xJLabel
      xJLabel = new JLabel();
      xJLabel.setText( "X:" );
      xJLabel.setBounds( 14, 25, 20, 20 );
      xJLabel.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( xJLabel );
      
      // set up xJTextField
      xJTextField = new JTextField();
      xJTextField.setBounds( 35, 25, 45, 20 );
      xJTextField.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( xJTextField );

      // set up yJLabel
      yJLabel = new JLabel();
      yJLabel.setText( "Y:" );
      yJLabel.setBounds( 84, 25, 20, 20 );
      yJLabel.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( yJLabel );
      
      // set up yJTextField
      yJTextField = new JTextField();
      yJTextField.setBounds( 105, 25, 45, 20 );
      yJTextField.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( yJTextField );

      // set up widthJLabel
      widthJLabel = new JLabel();
      widthJLabel.setText( "Width:" );
      widthJLabel.setBounds( 154, 25, 40, 20 );
      widthJLabel.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( widthJLabel );
      
      // set up widthJTextField
      widthJTextField = new JTextField();
      widthJTextField.setBounds( 195, 25, 45, 20 );
      widthJTextField.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( widthJTextField );

      // set up heightJLabel
      heightJLabel = new JLabel();
      heightJLabel.setText( "Height:" );
      heightJLabel.setBounds( 249, 25, 40, 20 );
      heightJLabel.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( heightJLabel );
           
      // set up heightJTextField
      heightJTextField = new JTextField();
      heightJTextField.setBounds( 290, 25, 45, 20 );
      heightJTextField.setHorizontalAlignment( JTextField.RIGHT );
      settingsJPanel.add( heightJTextField );
      
      // set up colorJPanel
      colorJPanel = new JPanel();
      colorJPanel.setBounds( 370, 200, 110, 70 );
      colorJPanel.setBorder( new TitledBorder( "Color" ) );
      colorJPanel.setLayout( null );
      contentPane.add( colorJPanel );

      // set up colorJComboBox
      colorJComboBox = new JComboBox( colorNames );
      colorJComboBox.setBounds( 10, 25, 90, 25 );
      colorJPanel.add( colorJComboBox );
      
      // set up addJButton
      addJButton = new JButton();
      addJButton.setText( "Add" );
      addJButton.setBounds( 400, 320, 75, 25 );
      contentPane.add( addJButton );
      addJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when addJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setText( "Clear" );
      clearJButton.setBounds( 400, 355, 75, 25 );
      contentPane.add( clearJButton );
      clearJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }
   
         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Logo Designer" ); // set title bar string
      setSize( 500, 435 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface

   // add a new shape to the logo
   public void addJButtonActionPerformed( ActionEvent event )
   {
      Color drawColor = colors[ colorJComboBox.getSelectedIndex() ];
      
      // get information about the shape to be drawn
      int x = Integer.parseInt( xJTextField.getText() );
      int y = Integer.parseInt( yJTextField.getText() );
      int width = Integer.parseInt( widthJTextField.getText() );
      int height = Integer.parseInt( heightJTextField.getText() );
      
      // determine which JRadioButton is selected
      if ( lineJRadioButton.isSelected() )
      {

      }
      else if ( ellipseJRadioButton.isSelected() )
      {

      }
      else if ( filledEllipseJRadioButton.isSelected() )
      {

      }
      else if ( rectangleJRadioButton.isSelected() )
      {

      }
      else if ( filledRectangleJRadioButton.isSelected() )
      {

      }

   } // end method addJButtonActionPerformed
   
   public void clearJButtonActionPerformed( ActionEvent event )
   {
      // clear all JTextFields
      xJTextField.setText( "" );
      yJTextField.setText( "" );
      widthJTextField.setText( "" );
      heightJTextField.setText( "" );
      
      drawingJPanel.clear(); // clear the drawing area
   
   } // end method clearJButtonActionPerformed

   // set JLabel text depending on which JRadioButton is selected
   public void lineJRadioButtonActionPerformed( ChangeEvent event )
   {
      // if the user has selected to draw a line
      if ( lineJRadioButton.isSelected() )
      {
         // change labels to indicate double coordinate input
         xJLabel.setText( "X1:" );
         yJLabel.setText( "Y1:" );
         widthJLabel.setText( "X2:" );
         heightJLabel.setText( "Y2:" );
      }
      else
      {
         // change text to indicate single coordinate with size input
         xJLabel.setText( "X:" );
         yJLabel.setText( "Y:" );
         widthJLabel.setText( "Width:" );
         heightJLabel.setText( "Height:" );
      }

   } // end method lineJRadioButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      LogoDesigner application = new LogoDesigner();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class LogoDesigner

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