import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;


public class DrawJPanel extends JPanel
{
	private Random randomNumber = new Random();
	
// Timer object to generate events
   private Timer drawTimer;

   // ArrayList object to hold MyRectangle objects
   private ArrayList rectangleArrayList = new ArrayList();
   
   private Color[] colors = { Color.BLUE, Color.ORANGE, Color.PINK,
		      Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK,
		      Color.WHITE, Color.RED, Color.GREEN };
   
   public DrawJPanel()
   {
	   super();
	   
	   drawTimer = new Timer( 250, 
			   
			   new ActionListener()
			   {
		   			public void actionPerformed( ActionEvent event )
		   			{
		   				drawTimerActionPerformed();
		   			}
			   }
	   );
	   
	   drawTimer.start();
   }
   
   private void drawTimerActionPerformed()
   {
	// get random dimensions and a random color
      int x = randomNumber.nextInt( 380 );
      int y = randomNumber.nextInt( 380 );
      int width = randomNumber.nextInt( 150 );
      int height = randomNumber.nextInt( 150 );
      int color = randomNumber.nextInt( 10 );
      
   // create MyRectangle object and add it to rectangleArrayList
      MyRectangle rectangle = new MyRectangle( x, y, width, height,
         colors[ color ] );
      rectangleArrayList.add( rectangle );

      repaint();
   }
   
   public void paintComponent( Graphics g )
   {
	   super.paintComponent( g );
	   
	   Iterator rectangleIterator = rectangleArrayList.iterator();
	   
	   MyRectangle currentRectangle;
	   
	   while ( rectangleIterator.hasNext() )
	   {
		   currentRectangle = ( MyRectangle ) rectangleIterator.next();
		   currentRectangle.draw( g );
	   }
	   
   }
   
   public void clear()
   {
	   rectangleArrayList.clear(); // clear ArrayList

	    repaint();
   }
}
