// Tutorial 27: MyShape.java
// Superclass for all shape objects.
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

   // set x1 value
   public final void setX1( int x )
   { 
      x1 = x;

   } // end method setX1

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

   // abstract draw method
   public abstract void draw( Graphics g );

} // end class MyShape

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