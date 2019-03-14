// Exercise 27.16: MyMovingShape.java
// Superclass for all Shape objects.
import java.awt.*;
import java.util.Random;

public abstract class MyMovingShape extends Object 
{
   // ints for storing the location of the shape
   private int x1;
   private int y1;
   private int x2;
   private int y2;

   // Color for storing the color of the shape
   private Color color;

   // Random for generating random ints
   private Random generateRandom = new Random();

   // ints for storing the change in position
   private int dx;
   private int dy;

   // constructor
   public MyMovingShape( int firstX, int firstY, int secondX, 
      int secondY, Color shapeColor )
   {
      setX1( firstX );
      setY1( firstY );
      setX2( secondX );
      setY2( secondY );
      setColor( shapeColor );

      // generate a random velocity for dx and dy from -4 to 4
      setDx( generateRandom.nextInt( 9 ) - 4 );
      setDy( generateRandom.nextInt( 9 ) - 4 );

   } // end constructor

   // set x1 value
   public void setX1( int x )
   { 
      x1 = x;

   } // end method setX1

   // get x1 value
   public int getX1() 
   { 
      return x1;

   } // end method getX1

   // set Y1 value
   public void setY1( int y ) 
   { 
      y1 = y;

   } // end method setY1

   // get Y1 value
   public int getY1() 
   {
      return y1; 

   } // end method getY1

   // set x2 value
   public void setX2( int x ) 
   { 
      x2 = x; 

   } // end method setX2

   // get x2 value
   public int getX2()
   {
      return x2; 

   } // end method getX2

   // set y2 value
   public void setY2( int y )
   { 
      y2 = y; 

   } // end method setY2

   // get y2 value
   public int getY2() 
   { 
      return y2; 

   } // end method getY2

   // set color value
   public void setColor( Color c ) 
   { 
      color = c; 

   } // end method setColor

   // get color value
   public Color getColor()
   { 
      return color;
      
   } // end method getColor

   // set dx value
   public void setDx( int x )
   {
      dx = x;
   
   } // end method setDx
   
   // get dx value
   public int getDx()
   { 
      return dx;
      
   } // end method getDx

   // set dy value
   public void setDy( int y )
   {
      dy = y;

   } // end method setDy

   // get dy value
   public int getDy()
   { 
      return dy;
      
   } // end method getDx

   // abstract draw method
   public abstract void draw( Graphics g );

} // end class MyMovingShape

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