// Exercise 20.13: MyRectangle.java
// This class defines the MyRectangle object.
import java.awt.*;

public class MyRectangle extends Rectangle
{
   // instance variable to hold fillColor of MyRectangle
   private Color fillColor;
   
   // constructor
   public MyRectangle( int xValue, int yValue, int widthValue, 
      int heightValue, Color colorValue )
   {
      // call constructor of superclass
      super( xValue, yValue, widthValue, heightValue );

      // set fillColor of MyRectangle
      setFillColor( colorValue );

   } // end constructor

   // set fillColor value
   public void setFillColor( Color colorValue )
   {
      fillColor = colorValue;

   } // end method setColor

   // get fillColor value
   public Color getFillColor()
   {
      return fillColor;

   } // end method getColor

   // draw MyRectangle
   public void drawMyRectangle( Graphics g )
   {
      g.setColor( fillColor );
      g.fillRect( x, y, width, height );

   } // end method drawRect

} // end class MyRectangle

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