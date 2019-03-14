// Tutorial 27: MyLine.java
// Class that declares a line object.
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

} // end class MyLine

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