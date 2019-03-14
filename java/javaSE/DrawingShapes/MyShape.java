import java.awt.*;

public abstract class MyShape extends Object
{
	private int x1;
   private int y1;
   private int x2;
   private int y2;
   private Color color;

   // constructor
   public MyShape( int firstX, int firstY, int secondX, int secondY, 
      Color shapeColor )
   {
      setX1( firstX );
      setY1( firstY );
      setX2( secondX );
      setY2( secondY );
      setColor( shapeColor );

   } // end constructor
   
   
   
   public final void setX1( int x )
   {
	   x1 = x;
   }
   
   // get x1 value
   public final int getX1() 
   { 
      return x1;

   } // end method getX1

   // set Y1 value
   public final void setY1( int y ) 
   { 
      y1 = y;

   } // end method setY1

   // get Y1 value
   public final int getY1() 
   {
      return y1; 

   } // end method getY1

   // set x2 value
   public final void setX2( int x ) 
   { 
      x2 = x; 

   } // end method setX2

   // get x2 value
   public final int getX2()
   {
      return x2; 

   } // end method getX2

   // set y2 value
   public final void setY2( int y )
   { 
      y2 = y; 

   } // end method setY2

   // get y2 value
   public final int getY2() 
   { 
      return y2; 

   } // end method getY2

   // set color value
   public final void setColor( Color c ) 
   { 
      color = c; 

   } // end method setColor

   // get color value
   public final Color getColor()
   { 
      return color;
      
   } // end method getColor

   public abstract void draw( Graphics g );

}
