// Tutorial 2: Welcome.java
// This application welcomes the user to Java programming.
import java.awt.*;
import javax.swing.*;

public class Welcome extends JFrame
{
   private JLabel textJLabel;    // JLabel that displays text
   private JLabel pictureJLabel; // JLabel that displays an image

   // no-argument constructor
   public Welcome()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setBackground( Color.YELLOW );
      contentPane.setLayout( null );
      
      // set up textJLabel
      textJLabel = new JLabel();
      textJLabel.setText( "Welcome to Java Programming!" );
      textJLabel.setLocation( 35, 0 );
      textJLabel.setSize( 550, 88 );
      textJLabel.setFont( new Font( "SansSerif", Font.PLAIN, 36 ) );
      textJLabel.setHorizontalAlignment( JLabel.CENTER );
      contentPane.add( textJLabel );
      
      // set up pictureJLabel
      pictureJLabel = new JLabel();
      pictureJLabel.setIcon( new ImageIcon( "bug.png" ) );
      pictureJLabel.setBounds( 54, 120, 500, 250 );
      pictureJLabel.setHorizontalAlignment( JLabel.CENTER );
      contentPane.add( pictureJLabel );

      // set properties of application's window
      setTitle( "Welcome" ); // set JFrame's title bar string
      setSize( 608, 413 );   // set width and height of JFrame
      setVisible( true );    // display JFrame on screen

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      Welcome application = new Welcome();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Welcome


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
