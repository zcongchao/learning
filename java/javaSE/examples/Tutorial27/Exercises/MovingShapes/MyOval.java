// Exercise 27.16: MyOval.java
// Class that declares an oval object.
import java.awt.*;

public class MyOval extends MyMovingShape  
{
   // constructor
   public MyOval( int firstX, int firstY, int secondX, int secondY, 
      Color shapeColor )
   {
      super( firstX, firstY, secondX, secondY, shapeColor );

   } // end constructor

   // draw the oval
   public void draw( Graphics g )
   {
      int upperLeftX = Math.min( getX1(), getX2() );
      int upperLeftY = Math.min( getY1(), getY2() );
      int width = Math.abs( getX1() - getX2() );
      int height = Math.abs( getY1() - getY2() );

      g.setColor( getColor() );
      g.fillOval( upperLeftX, upperLeftY, width, height );

   } // end method draw

} // end class MyOval

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