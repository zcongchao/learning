// Tutorial 20: DrawJPanel.java
// This class draws a random rectangle every .25 seconds.
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;

public class DrawJPanel
{
   // no-argument constructor
   public DrawJPanel()
   {
      drawTimer = new Timer( 250, 

         new ActionListener() // anonymous inner class
         {
            // event handler called every 250 microseconds
            public void actionPerformed( ActionEvent event ) 
            {
               drawTimerActionPerformed();
            }
            
         } // end anonymous inner class
         
      ); // end call to new Timer

   }  // end contructor

} // end class drawJPanel

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