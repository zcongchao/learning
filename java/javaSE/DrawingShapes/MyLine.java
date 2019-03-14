import java.awt.*;

public class MyLine extends MyShape 
{
	// constructor
	   public MyLine( int firstX, int firstY, int secondX, int secondY, 
	      Color shapeColor )
	   {
	      super( firstX, firstY, secondX, secondY, shapeColor );

	   } // end constructor

	   // draw a line
	   public void draw( Graphics g )
	   {
	      g.setColor( getColor() );
	      g.drawLine( getX1(), getY1(), getX2(), getY2() );

	   } // end method draw
}
