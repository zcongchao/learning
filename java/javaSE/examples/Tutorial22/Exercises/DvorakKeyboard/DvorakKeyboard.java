// Example 22.16: DvorakKeyboard.java
// Application simulates the letters on a Dvorak Keyboard.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DvorakKeyboard extends JFrame
{
   // JLabels to display instructions
   private JLabel prompt1JLabel;
   private JLabel prompt2JLabel;

   // JTextArea to display output
   private JTextArea displayJTextArea;

   // JButtons to represent first row of keys
   private JButton pJButton, yJButton, fJButton, gJButton, cJButton,
      rJButton, lJButton;

   // JButtons to represent second row of keys
   private JButton aJButton, oJButton, eJButton, uJButton, iJButton,
      dJButton, hJButton, tJButton, nJButton, sJButton;

   // JButtons to represent third row of keys
   private JButton qJButton, jJButton, kJButton, xJButton, bJButton,
      mJButton, wJButton, vJButton, zJButton;

   // JButton to store last key pressed
   private JButton lastJButton;

   // String to hold typed letters
   private String display = "";

   // array of JButtons
   private JButton[] keyJButtons = 
      new JButton[ KeyEvent.KEY_LAST + 1 ];

   // no-argument constructor
   public DvorakKeyboard() 
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up prompt1JLabel
      prompt1JLabel = new JLabel( "Type some text using your " +
         "keyboard. We will display your text and highlight " +
         "keys as" );
      prompt1JLabel.setBounds( 16, 5, 473, 20 );
      contentPane.add( prompt1JLabel );

      // set up prompt2JLabel
      prompt2JLabel = new JLabel( "you go. Note: Clicking the " +
         "JButtons with your mouse will not perform any action."  );
      prompt2JLabel.setBounds( 16, 20, 473, 20 );
      contentPane.add( prompt2JLabel );
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 16, 52, 473, 136 );
      displayJTextArea.setEditable( false );
      displayJTextArea.setLineWrap( true );
      contentPane.add( displayJTextArea );
            
      // set up pJButton
      pJButton = new JButton( "P" );
      pJButton.setBounds( 145, 196, 45, 24 );
      contentPane.add( pJButton );
      keyJButtons[ KeyEvent.VK_R ] = pJButton;
      
      // set up yJButton
      yJButton = new JButton( "Y" );
      yJButton.setBounds( 190, 196, 45, 24 );
      contentPane.add( yJButton );
      keyJButtons[ KeyEvent.VK_T ] = yJButton;
      
      // set up fJButton
      fJButton = new JButton( "F" );
      fJButton.setBounds( 235, 196, 45, 24 );
      contentPane.add( fJButton );
      keyJButtons[ KeyEvent.VK_Y ] = fJButton;
      
      // set up gJButton
      gJButton = new JButton( "G" );
      gJButton.setBounds( 280, 196, 45, 24 );
      contentPane.add( gJButton );
      keyJButtons[ KeyEvent.VK_U ] = gJButton;
      
      // set up cJButton
      cJButton = new JButton( "C" );
      cJButton.setBounds( 325, 196, 45, 24 );
      contentPane.add( cJButton );
      keyJButtons[ KeyEvent.VK_I ] = cJButton;
      
      // set up rJButton
      rJButton = new JButton( "R" );
      rJButton.setBounds( 370, 196, 45, 24 );
      contentPane.add( rJButton );
      keyJButtons[ KeyEvent.VK_O ] = rJButton;
      
      // set up lJButton
      lJButton = new JButton( "L" );
      lJButton.setBounds( 415, 196, 45, 24 );
      contentPane.add( lJButton );
      keyJButtons[ KeyEvent.VK_P ] = lJButton;
      
      // set up aJButton
      aJButton = new JButton( "A" );
      aJButton.setBounds( 16, 220, 45, 24 );
      contentPane.add( aJButton );
      keyJButtons[ KeyEvent.VK_A ] = aJButton;
      
      // set up oJButton
      oJButton = new JButton( "O" );
      oJButton.setBounds( 61, 220, 45, 24 );
      contentPane.add( oJButton );
      keyJButtons[ KeyEvent.VK_S ] = oJButton;
      
      // set up eJButton
      eJButton = new JButton( "E" );
      eJButton.setBounds( 106, 220, 45, 24 );
      contentPane.add( eJButton );
      keyJButtons[ KeyEvent.VK_D ] = eJButton;
      
      // set up uJButton
      uJButton = new JButton( "U" );
      uJButton.setBounds( 151, 220, 45, 24 );
      contentPane.add( uJButton );
      keyJButtons[ KeyEvent.VK_F ] = uJButton;
      
      // set up iJButton
      iJButton = new JButton( "I" );
      iJButton.setBounds( 196, 220, 45, 24 );
      contentPane.add( iJButton );
      keyJButtons[ KeyEvent.VK_G ] = iJButton;
      
      // set up dJButton
      dJButton = new JButton( "D" );
      dJButton.setBounds( 241, 220, 45, 24 );
      contentPane.add( dJButton );
      keyJButtons[ KeyEvent.VK_H ] = dJButton;
      
      // set up hJButton
      hJButton = new JButton( "H" );
      hJButton.setBounds( 286, 220, 45, 24 );
      contentPane.add( hJButton );
      keyJButtons[ KeyEvent.VK_J ] = hJButton;
      
      // set up tJButton
      tJButton = new JButton( "T" );
      tJButton.setBounds( 331, 220, 45, 24 );
      contentPane.add( tJButton );
      keyJButtons[ KeyEvent.VK_K ] = tJButton;
      
      // set up nJButton
      nJButton = new JButton( "N" );
      nJButton.setBounds( 376, 220, 45, 24 );
      contentPane.add( nJButton );
      keyJButtons[ KeyEvent.VK_L ] = nJButton;
      
      // set up sJButton
      sJButton = new JButton( "S" );
      sJButton.setBounds( 421, 220, 45, 24 );
      contentPane.add( sJButton );
      keyJButtons[ KeyEvent.VK_SEMICOLON ] = sJButton;
      
      // set up qJButton
      qJButton = new JButton( "Q" );
      qJButton.setBounds( 100, 244, 45, 24 );
      contentPane.add( qJButton );
      keyJButtons[ KeyEvent.VK_X ] = qJButton;
      
      // set up jJButton
      jJButton = new JButton( "J" );
      jJButton.setBounds( 145, 244, 45, 24 );
      contentPane.add( jJButton );
      keyJButtons[ KeyEvent.VK_C ] = jJButton;
      
      // set up kJButton
      kJButton = new JButton( "K" );
      kJButton.setBounds( 190, 244, 45, 24 );
      contentPane.add( kJButton );
      keyJButtons[ KeyEvent.VK_V ] = kJButton;
      
      // set up xJButton
      xJButton = new JButton( "X" );
      xJButton.setBounds( 235, 244, 45, 24 );
      contentPane.add( xJButton );
      keyJButtons[ KeyEvent.VK_B ] = xJButton;
      
      // set up bJButton
      bJButton = new JButton( "B" );
      bJButton.setBounds( 280, 244, 45, 24 );
      contentPane.add( bJButton );
      keyJButtons[ KeyEvent.VK_N ] = bJButton;
      
      // set up mJButton
      mJButton = new JButton( "M" );
      mJButton.setBounds( 325, 244, 45, 24 );
      contentPane.add( mJButton );
      keyJButtons[ KeyEvent.VK_M ] = mJButton;
      
      // set up wJButton
      wJButton = new JButton( "W" );
      wJButton.setBounds( 370, 244, 50, 24 );
      contentPane.add( wJButton );
      keyJButtons[ KeyEvent.VK_COMMA ] = wJButton;
      
      // set up vJButton
      vJButton = new JButton( "V" );
      vJButton.setBounds( 420, 244, 45, 24 );
      contentPane.add( vJButton );
      keyJButtons[ KeyEvent.VK_PERIOD ] = vJButton;
      
      // set up zJButton
      zJButton = new JButton( "Z" );
      zJButton.setBounds( 465, 244, 45, 24 );
      contentPane.add( zJButton );
      keyJButtons[ KeyEvent.VK_SLASH ] = zJButton;

      // set properties of application's window
      setTitle( "Dvorak Keyboard" ); // set title bar string
      setSize( 528, 305 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // highlight JButton passed as argument
   private void changeColor( JButton highlightJButton )
   {
      resetColor();
      highlightJButton.setBackground( Color.YELLOW );
      lastJButton = highlightJButton;

   } // end method changeColor

   // changes lastJButton's color back to default
   private void resetColor()
   {
      if ( lastJButton != null )
      {
         lastJButton.setBackground( this.getBackground() );
      }

   } // end method resetColor

   // main method
   public static void main( String args[] ) 
   {
      DvorakKeyboard application = new DvorakKeyboard();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class DvorakKeyboard

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