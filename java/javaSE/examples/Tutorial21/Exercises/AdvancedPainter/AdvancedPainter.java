// Exercise 21.16: AdvancedPainter.java
// This application allows the user to draw with four different 
// colors and three different sized brushes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AdvancedPainter extends JFrame
{
   // PainterPanel for drawing circles
   private PainterJPanel myPainterJPanel;

   // JPanel and ButtonGroup for color JRadioButtons
   private JPanel colorJPanel;
   private ButtonGroup colorButtonGroup;

   // JRadioButtons for color of circle
   private JRadioButton redJRadioButton;
   private JRadioButton blueJRadioButton;
   private JRadioButton greenJRadioButton;
   private JRadioButton blackJRadioButton;

   // JPanel and ButtonGroup for size JRadioButtons
   private JPanel sizeJPanel;
   private ButtonGroup sizeButtonGroup;

   // JRadioButtons for size of circle
   private JRadioButton smallJRadioButton;
   private JRadioButton mediumJRadioButton;
   private JRadioButton largeJRadioButton;

   // size constants for diameter of circle
   final int SMALL = 4;
   final int MEDIUM = 8;
   final int LARGE = 10;
   
   // no-argument constructor
   public AdvancedPainter()
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

      // set up myPainterJPanel to paint small, black circles
      myPainterJPanel = new PainterJPanel( Color.BLACK, SMALL );
      myPainterJPanel.setBounds( 112, 8, 336, 272 );
      myPainterJPanel.setBackground( Color.WHITE );
      contentPane.add( myPainterJPanel );
      
      // set up colorJPanel
      colorJPanel = new JPanel();
      colorJPanel.setBounds( 8, 8, 96, 152 );
      colorJPanel.setBorder( new TitledBorder( "Color" ) );
      colorJPanel.setOpaque( false );
      colorJPanel.setLayout( null );
      contentPane.add( colorJPanel );
      
      // set up colorButtonGroup
      colorButtonGroup = new ButtonGroup();

      // set up redJRadioButton
      redJRadioButton = new JRadioButton();
      redJRadioButton.setBounds( 16, 16, 56, 24 );
      redJRadioButton.setText( "Red" );
      colorButtonGroup.add( redJRadioButton );
      colorJPanel.add( redJRadioButton );
      redJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when redJRadioButton is selected
            public void actionPerformed( ActionEvent event )
            {
               redJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up blueJRadioButton
      blueJRadioButton = new JRadioButton();
      blueJRadioButton.setBounds( 16, 48, 56, 24 );
      blueJRadioButton.setText( "Blue" );
      colorButtonGroup.add( blueJRadioButton );
      colorJPanel.add( blueJRadioButton );
      blueJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when blueJRadioButton is selected
            public void actionPerformed( ActionEvent event )
            {
               blueJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up greenJRadioButton
      greenJRadioButton = new JRadioButton();
      greenJRadioButton.setBounds( 16, 80, 62, 24 );
      greenJRadioButton.setText( "Green" );
      colorButtonGroup.add( greenJRadioButton );
      colorJPanel.add( greenJRadioButton );
      greenJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when greenJRadioButton is
            // selected
            public void actionPerformed( ActionEvent event )
            {
               greenJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up blackJRadioButton
      blackJRadioButton = new JRadioButton();
      blackJRadioButton.setBounds( 16, 112, 62, 24 );
      blackJRadioButton.setText( "Black" );
      blackJRadioButton.setSelected( true );
      colorButtonGroup.add( blackJRadioButton );
      colorJPanel.add( blackJRadioButton );
      blackJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when blackJRadioButton is
            // selected
            public void actionPerformed( ActionEvent event )
            {
               blackJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up sizeJPanel
      sizeJPanel = new JPanel();
      sizeJPanel.setBounds( 8, 168, 96, 112 );
      sizeJPanel.setBorder( new TitledBorder( "Size" ) );
      sizeJPanel.setOpaque( false );
      sizeJPanel.setLayout( null );
      contentPane.add( sizeJPanel );
           
      // set up sizeButtonGroup
      sizeButtonGroup = new ButtonGroup();

      // set up smallJRadioButton
      smallJRadioButton = new JRadioButton();
      smallJRadioButton.setBounds( 16, 16, 64, 24 );
      smallJRadioButton.setText( "Small" );
      smallJRadioButton.setSelected( true );
      sizeButtonGroup.add( smallJRadioButton );
      sizeJPanel.add( smallJRadioButton );
      smallJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when smallJRadioButton is
            // selected
            public void actionPerformed( ActionEvent event )
            {
               smallJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up mediumJRadioButton
      mediumJRadioButton = new JRadioButton();
      mediumJRadioButton.setBounds( 16, 48, 70, 24 );
      mediumJRadioButton.setText( "Medium" );
      sizeButtonGroup.add( mediumJRadioButton );
      sizeJPanel.add( mediumJRadioButton );
      mediumJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when mediumJRadioButton is
            // selected
            public void actionPerformed( ActionEvent event )
            {
               mediumJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up largeJRadioButton
      largeJRadioButton = new JRadioButton();
      largeJRadioButton.setBounds( 16, 80, 64, 24 );
      largeJRadioButton.setText( "Large" );
      sizeButtonGroup.add( largeJRadioButton );
      sizeJPanel.add( largeJRadioButton );
      largeJRadioButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when largeJRadioButton is
            // selected
            public void actionPerformed( ActionEvent event )
            {
               largeJRadioButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up properties of application's window
      setTitle( "Advanced Painter" ); // set title bar text
      setSize( 462, 312 );            // set window size
      setVisible( true );             // display window
      
   } // end method createUserInterface
   
   // set circle color to red
   private void redJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setColor( Color.RED );
   
   } // end method redJRadioButtonActionPerformed
   
   // set circle color to blue
   private void blueJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setColor( Color.BLUE );
   
   } // end method blueJRadioButtonActionPerformed
   
   // set circle color to green
   private void greenJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setColor( Color.GREEN );
   
   } // end method greenJRadioButtonActionPerformed
   
   // set circle color to black
   private void blackJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setColor( Color.BLACK );
   
   } // end method blackJRadioButtonActionPerformed

   // set circle size to small
   private void smallJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setDiameter( SMALL );
   
   } // end method smallJRadioButtonActionPerformed

   // set circle size to medium
   private void mediumJRadioButtonActionPerformed(
      ActionEvent event )
   {
      myPainterJPanel.setDiameter( MEDIUM );
   
   } // end method mediumJRadioButtonActionPerformed

   // set circle size to large
   private void largeJRadioButtonActionPerformed( ActionEvent event )
   {
      myPainterJPanel.setDiameter( LARGE );
   
   } // end method largeJRadioButtonActionPerformed
   
   // main method   
   public static void main( String [] args )
   {
      AdvancedPainter application = new AdvancedPainter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class AdvancedPainter

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