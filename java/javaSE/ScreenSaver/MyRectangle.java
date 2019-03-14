import java.awt.*;

public class MyRectangle extends Rectangle
{
	private Color fillColor;
	
	public MyRectangle( int xValue, int yValue, int widthValue, 
		      int heightValue, Color colorValue )
	{
		super( xValue, yValue, widthValue, heightValue );
		
		// set fillColor of MyRectangle
	    setFillColor( colorValue );
	}
	
	public void setFillColor( Color colorValue )
	{
		fillColor = colorValue;
	}
	
	// get fillColor value
	   public Color getFillColor()
	   {
	      return fillColor;

	   } // end method getFillColor
	   
	   public void draw( Graphics g )
	   {
	      g.setColor( fillColor );
	      g.fillRect( x, y, width, height );

	   } // end method draw

}
