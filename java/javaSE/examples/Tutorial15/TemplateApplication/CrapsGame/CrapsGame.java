// Tutorial 15: CrapsGame.java
// This application plays a simple craps game.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CrapsGame extends JFrame 
{
   // JPanel and TitledBorder to contain dice
   private JPanel pointDiceJPanel;
   private TitledBorder pointDiceTitledBorder;
   
   // JLabels to display the die images in pointDiceJPanel
   private JLabel pointDie1JLabel;
   private JLabel pointDie2JLabel;

   // JLabels to display the die images from the rolls of the dice
   private JLabel die1JLabel;
   private JLabel die2JLabel;

   // JButtons to allow user to interact with game
   private JButton playJButton;
   private JButton rollJButton;

   // JLabel and JTextField to show results of game
   private JLabel resultJLabel;
   private JTextField resultJTextField;
   
   // no-argument constructor
   public CrapsGame()
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
      
      // set up pointDiceTitledBorder for use with pointDiceJPanel
      pointDiceTitledBorder = new TitledBorder( "Point" );

      // set up pointDiceJPanel
      pointDiceJPanel = new JPanel();
      contentPane.add( pointDiceJPanel );
            
      // set up pointDie1JLabel
      pointDie1JLabel = new JLabel();
      
      // set up pointDie2JLabel
      pointDie2JLabel = new JLabel();
      
      // set up die1JLabel
      die1JLabel = new JLabel();
      die1JLabel.setBounds( 40, 150, 64, 64 );
      contentPane.add( die1JLabel );
      
      // set up die2JLabel
      die2JLabel = new JLabel();
      die2JLabel.setBounds( 136, 150, 64, 56 );
      contentPane.add( die2JLabel );
      
      // set up playJButton
      playJButton = new JButton();
      playJButton.setBounds( 232, 16, 88, 23 );
      playJButton.setText( "Play" );
      contentPane.add( playJButton );
      playJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when playJButton is clicked
             public void actionPerformed ( ActionEvent event )
             {
                playJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up rollJButton
      rollJButton = new JButton();
      rollJButton.setBounds( 232, 56, 88, 23 );
      rollJButton.setText( "Roll" );
      rollJButton.setEnabled( false );
      contentPane.add( rollJButton );
      rollJButton.addActionListener(
            
         new ActionListener() // anonymous inner class
         {
            // event handler called when rollJButton is clicked
            public void actionPerformed ( ActionEvent event )
            {
               rollJButtonActionPerformed( event );
            }
         
         } // end anonymous inner class

      ); // end call to addActionListener

      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 232, 90, 48, 16 );
      resultJLabel.setText( "Result:" );
      contentPane.add( resultJLabel );
      
      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 232, 106, 88, 24 );
      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
      resultJTextField.setEditable( false );
      contentPane.add( resultJTextField );
      
      // set properties of application's window
      setTitle( "Craps Game" ); // set title bar string
      setSize( 350, 250 );      // set window size
      setVisible( true );       // display window
      
   } // end method createUserInterface
   
   // start new game of craps
   private void playJButtonActionPerformed( ActionEvent event )
   {
   
   } // end method playJButtonActionPerformed

   // continue the game
   private void rollJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method rollJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      CrapsGame application = new CrapsGame();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class CrapsGame

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
