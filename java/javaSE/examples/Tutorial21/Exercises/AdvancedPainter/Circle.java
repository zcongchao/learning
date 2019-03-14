// Exercise 21.16: Circle.java
// This class represents a circle.
import java.awt.*;

public class Circle
{
   // instance variables
   private int diameter;
   private Point location;
   private Color drawnColor;

   // constructor with size, corner and shade supplied
   public Circle( int size, Point corner, Color shade )
   {
      setDiameter( size );
      setLocation( corner );
      setDrawnColor( shade );

   } // end constructor

   // get the diameter of the circle
   public int getDiameter()
   {
      return diameter;

   } // end method getDiameter

   // set the diameter of the circle
   public void setDiameter( int size )
   {
      if ( size >= 0 )
      {
         diameter = size;
      }
      else
      {
         diameter = 0;
      }

   } // end method setDiameter

   // get the location of the upper-left corner of the circle
   public Point getLocation()
   {
      return location;

   } // end method getLocation

   // set the location of the upper-left corner of the circle
   public void setLocation( Point corner )
   {
      location = corner;

   } // end method setLocation

   // get the color of the circle
   public Color getDrawnColor()
   {
      return drawnColor;

   } // end method getDrawnColor

   // set the color of the circle
   public void setDrawnColor( Color shade )
   {
      drawnColor = shade;

   } // end method setDrawnColor

   // draw the circle
   public void draw( Graphics g )
   {

   } // end method draw

} // end class Circle

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