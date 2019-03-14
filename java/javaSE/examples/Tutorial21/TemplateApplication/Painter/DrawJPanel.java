// Tutorial 21: DrawJPanel.java
// This class allows the user to draw and erase on the application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawJPanel extends JPanel
{
   // Point to hold the mouse cursor's location
   private Point currentPoint;

   // constants for the drawn circle
   private final Color DRAW_COLOR = Color.BLUE;
   private final int DRAW_DIAMETER = 8;

   // instance variables for the circle
   private Color drawColor;
   private int drawDiameter;
   
   // constructor
   public DrawJPanel()
   {

   }  // end constructor

} // end class DrawJPanel

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