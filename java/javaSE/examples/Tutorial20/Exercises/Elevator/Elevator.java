// Exercise 20.13: Elevator.java
// Application simulates an elevator.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Elevator extends JFrame
{
   // JLabel for elevator JButtons
   private JLabel selectFloorJLabel;
   
   // JButtons to select the floor
   private JButton oneJButton;
   private JButton twoJButton;
   private JButton threeJButton;
   private JButton fourJButton;
   private JButton fiveJButton;
   private JButton sixJButton;
   private JButton sevenJButton;
   private JButton eightJButton;
   private JButton nineJButton;

   // JTextArea for displaying elevator location
   public JTextArea displayJTextArea;

   // DrawJPanel for displaying rectangles
   private DrawJPanel drawingJPanel;

   // JLabel for displaying floor sign
   private JLabel floorJLabel;

   // JLabels for displaying the floor
   private JLabel oneJLabel;
   private JLabel twoJLabel;
   private JLabel threeJLabel;
   private JLabel fourJLabel;
   private JLabel fiveJLabel;
   private JLabel sixJLabel;
   private JLabel sevenJLabel;
   private JLabel eightJLabel;
   private JLabel nineJLabel;

   // no-argument constructor
   public Elevator()
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

      // set up selectFloorJLabel
      selectFloorJLabel = new JLabel();
      selectFloorJLabel.setBounds( 15, 65, 100, 25 );
      selectFloorJLabel.setText( "Select Floor:" );
      contentPane.add( selectFloorJLabel );

      // set up oneJButton
      oneJButton = new JButton();
      oneJButton.setBounds( 15, 100, 41, 41 );
      oneJButton.setText( "1" );
      contentPane.add( oneJButton );
      oneJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when oneJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               oneJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up twoJButton
      twoJButton = new JButton();
      twoJButton.setBounds( 75, 100, 41, 41 );
      twoJButton.setText( "2" );
      contentPane.add( twoJButton );
      twoJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when twoJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               twoJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up threeJButton
      threeJButton = new JButton();
      threeJButton.setBounds( 135, 100, 41, 41 );
      threeJButton.setText( "3" );
      contentPane.add( threeJButton );
      threeJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when threeJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               threeJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up fourJButton
      fourJButton = new JButton();
      fourJButton.setBounds( 15, 160, 41, 41 );
      fourJButton.setText( "4" );
      contentPane.add( fourJButton );
      fourJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when fourJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fourJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up fiveJButton
      fiveJButton = new JButton();
      fiveJButton.setBounds( 75, 160, 41, 41 );
      fiveJButton.setText( "5" );
      contentPane.add( fiveJButton );
      fiveJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when fiveJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fiveJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up sixJButton
      sixJButton = new JButton();
      sixJButton.setBounds( 135, 160, 41, 41 );
      sixJButton.setText( "6" );
      contentPane.add( sixJButton );
      sixJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when sixJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sixJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up sevenJButton
      sevenJButton = new JButton();
      sevenJButton.setBounds( 15, 220, 41, 41 );
      sevenJButton.setText( "7" );
      contentPane.add( sevenJButton );
      sevenJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when sevenJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sevenJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up eightJButton
      eightJButton = new JButton();
      eightJButton.setBounds( 75, 220, 41, 41 );
      eightJButton.setText( "8" );
      contentPane.add( eightJButton );
      eightJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when eightJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               eightJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up nineJButton
      nineJButton = new JButton();
      nineJButton.setBounds( 135, 220, 41, 41 );
      nineJButton.setText( "9" );
      contentPane.add( nineJButton );
      nineJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when nineJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nineJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 16, 290, 170, 20 );
      displayJTextArea.setEditable( false );
      displayJTextArea.setForeground( Color.RED );
      contentPane.add( displayJTextArea );

      // set up drawingJPanel
      drawingJPanel = new DrawJPanel();
      drawingJPanel.setBounds( 215, 50, 150, 450 );
      drawingJPanel.setBackground( Color.WHITE );
      contentPane.add( drawingJPanel );

      // set up floorJLabel
      floorJLabel = new JLabel();
      floorJLabel.setBounds( 375, 16, 50, 25 );
      floorJLabel.setText( "Floor:" );
      contentPane.add( floorJLabel );

      // set up oneJLabel
      oneJLabel = new JLabel();
      oneJLabel.setBounds( 385, 460, 25, 25 );
      oneJLabel.setText( "1" );
      contentPane.add( oneJLabel );

      // set up twoJLabel
      twoJLabel = new JLabel();
      twoJLabel.setBounds( 385, 410, 25, 25 );
      twoJLabel.setText( "2" );
      contentPane.add( twoJLabel );

      // set up threeJLabel
      threeJLabel = new JLabel();
      threeJLabel.setBounds( 385, 360, 25, 25 );
      threeJLabel.setText( "3" );
      contentPane.add( threeJLabel );

      // set up fourJLabel
      fourJLabel = new JLabel();
      fourJLabel.setBounds( 385, 310, 25, 25 );
      fourJLabel.setText( "4" );
      contentPane.add( fourJLabel );

      // set up fiveJLabel
      fiveJLabel = new JLabel();
      fiveJLabel.setBounds( 385, 260, 25, 25 );
      fiveJLabel.setText( "5" );
      contentPane.add( fiveJLabel );

      // set up sixJLabel
      sixJLabel = new JLabel();
      sixJLabel.setBounds( 385, 210, 25, 25 );
      sixJLabel.setText( "6" );
      contentPane.add( sixJLabel );

      // set up sevenJLabel
      sevenJLabel = new JLabel();
      sevenJLabel.setBounds( 385, 160, 25, 25 );
      sevenJLabel.setText( "7" );
      contentPane.add( sevenJLabel );

      // set up eightJLabel
      eightJLabel = new JLabel();
      eightJLabel.setBounds( 385, 110, 25, 25 );
      eightJLabel.setText( "8" );
      contentPane.add( eightJLabel );

      // set up nineJLabel
      nineJLabel = new JLabel();
      nineJLabel.setBounds( 385, 60, 25, 25 );
      nineJLabel.setText( "9" );
      contentPane.add( nineJLabel );

      // set properties of application's window
      setTitle( "Elevator" ); // set title bar text
      setSize( 430, 540 );    // set window size
      setVisible( true );     // display window

   } // end method createUserInterface

   // move the elevator to the first floor
   private void oneJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 1 ); // move the elevator
      
      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the FIRST floor" );

   } // end method oneJButtonActionPerformed

   // move the elevator to the second floor
   private void twoJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 2 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the SECOND floor" );

   } // end method twoJButtonActionPerformed

   // move the elevator to the third floor
   private void threeJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 3 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the THIRD floor" );

   } // end method threeJButtonActionPerformed

      // move the elevator to the fourth floor
   private void fourJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 4 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the FOURTH floor" );

   } // end method fourJButtonActionPerformed

      // move the elevator to the fifth floor
   private void fiveJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 5 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the FIFTH floor" );

   } // end method fiveJButtonActionPerformed

      // move the elevator to the sixth floor
   private void sixJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 6 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the SIXTH floor" );

   } // end method sixJButtonActionPerformed

      // move the elevator to the seventh floor
   private void sevenJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 7 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the SEVENTH floor" );

   } // end method sevenJButtonActionPerformed

      // move the elevator to the eighth floor
   private void eightJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 8 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the EIGHTH floor" );

   } // end method eightJButtonActionPerformed

      // move the elevator to the ninth floor
   private void nineJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.moveElevatorToFloor( 9 ); // move the elevator

      // display a message in the displayJTextArea
      displayJTextArea.setText( "You are on the NINTH floor" );

   } // end method nineJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      Elevator application = new Elevator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Elevator

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