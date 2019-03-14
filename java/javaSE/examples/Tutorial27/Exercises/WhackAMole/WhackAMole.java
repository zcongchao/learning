// Exercise 27.13: WhackAMole.java
// This game challenges a player to try to whack the mole.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhackAMole extends JFrame 
{
   // JButton to start a new game
   private JButton newGameJButton;
  
   // JLabel and JTextField for points
   private JLabel pointsJLabel;
   private JTextField pointsJTextField;
   
   // JLabel and JTextField for time remaining
   private JLabel timeJLabel;
   private JTextField timeJTextField;
   
   // counter for moles whacked
   private int points = 0;

   // variable to count down the seconds left
   private int countDown = 30;

   // Timer for the moles
   private Timer moleTimer;

   // Timer for game time
   private Timer gameTimer;

   private Mole gameMole;

   // no-argument constructor
   public WhackAMole()
   {
      gameMole = new Mole(); // declare new Mole object

      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components 
      contentPane.setLayout( null );
      
      // set up newGameJButton
      newGameJButton = new JButton();
      newGameJButton.setBounds( 100, 8, 125, 23 );
      newGameJButton.setText( "New Game" );
      contentPane.add ( newGameJButton );
      newGameJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when newGameJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               newGameJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up pointsJLabel
      pointsJLabel = new JLabel();
      pointsJLabel.setBounds( 16, 315, 50, 23 );
      pointsJLabel.setText( "Points:" );
      contentPane.add( pointsJLabel );
      
      // set up pointsJTextField
      pointsJTextField = new JTextField();
      pointsJTextField.setBounds( 60, 315, 40, 23 );
      pointsJTextField.setText( "0" );
      pointsJTextField.setHorizontalAlignment( JTextField.RIGHT );
      pointsJTextField.setEditable( false );
      contentPane.add( pointsJTextField );

      // set up timeJLabel
      timeJLabel = new JLabel();
      timeJLabel.setBounds( 130, 315, 100, 23 );
      timeJLabel.setText( "Time Remaining:" );
      contentPane.add( timeJLabel );

      // set up timeJTextField
      timeJTextField = new JTextField();
      timeJTextField.setBounds( 243, 315, 40, 23 );
      timeJTextField.setText( "30" );
      timeJTextField.setHorizontalAlignment( JTextField.RIGHT );
      timeJTextField.setEditable( false );
      contentPane.add( timeJTextField );

      // set up moleTimer
      moleTimer = new Timer( 550, 
      
         new ActionListener() // anonymous inner class
         {
            // timer has incremented
            public void actionPerformed( ActionEvent event )
            {
               moleTimerActionPerformed();
            }
         } // end anonymous inner class
      
      ); // end new Timer

      // set up gameTimer
      gameTimer = new Timer( 1000, 
      
         new ActionListener() // anonymous inner class
         {
            // timer has incremented
            public void actionPerformed( ActionEvent event )
            {
               gameTimerActionPerformed();
            }
         } // end anonymous inner class
      
      ); // end new Timer

      addMouseListener( 
         
         new MouseAdapter() // anonymous inner class
         {
            // event handler called when mouse button is pressed
            public void mousePressed( MouseEvent event )
            {
               whackAMoleMousePressed( event );
            }

         } // end anonymous inner class

      ); // end call to addMouseListener

      // set properties of application's window
      setTitle( "Whack A Mole" ); // set title bar string
      setSize( 320, 380 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // paint the chart
   public void paint( Graphics g )
   {
      super.paint( g );

      // draw vertical chart lines
      for ( int i = 0; i <= 250; i += 50 )
      {
         g.drawLine( 35 + i, 68, 35 + i, 318 );
      }

      // draw horizontal chart lines
      for ( int i = 0; i <= 250; i += 50 )
      {
         g.drawLine( 35, 68 + i, 285, 68 + i );
      }

      gameMole.drawMole( g );

   } // end method paint

   // change the position of the mole
   private void moleTimerActionPerformed()
   {
      gameMole.moveMole(); // move the mole to a new hole

      repaint(); // repaint the JFrame

   } // end event handler moleTimerActionPerformed
   
   // ends the Whack A Mole game if time reaches zero
   private void gameTimerActionPerformed()
   {
      countDown--; // decrement counter
      
      // display time remaining
      timeJTextField.setText( String.valueOf( countDown ) );

      // if less than ten seconds are remaining
      if ( countDown < 10 )
      {
         // change the color of the text in timeJTextField to red
         timeJTextField.setForeground( Color.RED );
      }
      
      // when time runs out
      if ( countDown == 0 )
      {
         // stop timers
         gameTimer.stop();
         moleTimer.stop();

         newGameJButton.setEnabled( true ); // enable newGameJButton

         // reset and hide the mole
         gameMole.reset();
         repaint();
         
         // display score in a JOptionPane
         JOptionPane.showMessageDialog( this, "Your score is " +
            points + " points", "Game Over", 
            JOptionPane.INFORMATION_MESSAGE );

      } // end if

   } // end method gameTimerActionPerformed

   // generate a new Whack A Mole game
   private void newGameJButtonActionPerformed( ActionEvent event )
   {
      // reset counters
      points = 0;
      countDown = 30;

      // reset JTextFields
      pointsJTextField.setText( String.valueOf( points ) );
      timeJTextField.setForeground( Color.BLACK );
      timeJTextField.setText( String.valueOf( countDown ) );

      newGameJButton.setEnabled( false ); // disable newGameJButton

      // start the moleTimer and gameTimer
      moleTimer.start();
      gameTimer.start();

      // display first mole
      gameMole.moveMole();
      repaint();

   } // end method newGameJButtonActionPerformed
   
   // user clicked the mouse button
   private void whackAMoleMousePressed( MouseEvent event )
   {
      // if mole is hit
      if ( gameMole.isHit( event.getX(), event.getY() ) )
      {
         points += 50; // add 50 points to the score

         // display new score
         pointsJTextField.setText( String.valueOf( points ) );

         moleTimer.restart(); // restart the moleTimer

         // display next mole
         gameMole.moveMole();
         repaint();

      } // end if

   } // end method whackAMoleMousePressed

   // main method
   public static void main( String[] args ) 
   {
      WhackAMole application = new WhackAMole();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main

} // end class WhackAMole

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