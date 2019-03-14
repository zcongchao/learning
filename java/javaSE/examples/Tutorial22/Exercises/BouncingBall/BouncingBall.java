// Exercise 21.12: BouncingBall.java
// Game whose goal is preventing ball from falling off the bottom.
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BouncingBall extends JFrame
{
   // Random object to generate random integers
   private Random randomGenerator = new Random();

   // determine random starting point for the ball
   private int x = 25 + randomGenerator.nextInt( 201 );
   private int y = 25 + randomGenerator.nextInt( 201 );
   
   // position and length of paddle
   private int rectX = 126;
   private int rectWidth = 80;
   
   // distance ball travels each time ball is moved
   private int deltaX = 2 + randomGenerator.nextInt( 6 );
   private int deltaY = 2 + randomGenerator.nextInt( 6 );
   
   // Timer for ball
   private Timer ballTimer;
   
   // no-argument constructor
   public BouncingBall()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // register KeyListener
      addKeyListener(

         new KeyAdapter() // anonymous inner class
         {  
            // event handler called when a key is pressed
            public void keyPressed( KeyEvent event )
            {
               bouncingBallKeyPressed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addKeyListener
      
      // set up ballTimer
      ballTimer = new Timer( 30, 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called every 30 milliseconds
            public void actionPerformed( ActionEvent event )
            {
               ballTimerActionPerformed( event );
            }

         } // end anonymous inner class
      
      ); // end Timer constructor
      
      // set properties of application's window
      setTitle( "Bouncing Ball" ); // set title bar string
      setSize( 415, 430 );         // set window size
      setVisible( true );          // display window
   
   } // end method createUserInterface
   
   // draw the ball and the paddle
   public void paint( Graphics graphics )
   {
      super.paint( graphics );

      // draw the ball
      graphics.setColor( Color.BLUE );
      graphics.fillOval( x, y, 10, 10 );
      
      // draw the paddle
      graphics.setColor( Color.RED );
      graphics.fillRect( rectX, 410, rectWidth, 10 );
      
   } // end method paint
   
   // move the ball; handle bouncing
   private void ballTimerActionPerformed( ActionEvent event )
   {
      // update the position of the ball
      x += deltaX;
      y += deltaY;
      
      if ( y <= 25 )
      {
         // bounce the ball off the ceiling
         deltaY = 2 + randomGenerator.nextInt( 6 );
      }
      else if ( y >= 400 && x >= rectX && x <= 
         ( rectX + rectWidth ) )
      {
         // bounce the ball off the paddle
         deltaY = -2 - randomGenerator.nextInt( 6 );
      }
      else if ( y >= 430 )
      {
         // end the game
         ballTimer.stop();
      }

      if ( x <= 5 )
      {
         // bounce the ball off the left wall
         deltaX = 2 + randomGenerator.nextInt( 6 );
      }
      else if ( x >= 400 )
      {
         // bounce the ball off the right wall
         deltaX = -2 - randomGenerator.nextInt( 6 );
      }
      
      repaint();
    
   } // end method ballTimerActionPerformed
   
   // start the game, move paddle left or right
   private void bouncingBallKeyPressed( KeyEvent event )
   {
      
   } // end method bouncingBallKeyPressed
   
   // main method
   public static void main( String[] args )
   {
      BouncingBall application = new BouncingBall();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class BouncingBall

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