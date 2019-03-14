// Exercise 2.12
// Create GUI for an alarm clock
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AlarmClock extends JFrame
{
   private JButton hourJButton, minuteJButton, secondJButton, 
      onJButton, offJButton, timerJButton;
   private JPanel ampmJPanel;
   private JRadioButton amJRadioButton, pmJRadioButton;
   private JLabel timeJLabel, snoozeJLabel;
   
   // no-argument constructor
   public AlarmClock()
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
      
      // set up hourJButton
      hourJButton = new JButton();
      hourJButton.setText( "HOUR" );
      hourJButton.setBounds( 0, 0, 84, 46 );
      contentPane.add( hourJButton );
            
      // set up minuteJButton
      minuteJButton = new JButton();
      minuteJButton.setBounds( 84, 0, 84, 46 );
      minuteJButton.setText( "MINUTE" );
      contentPane.add( minuteJButton );
            
      // set up secondJButton
      secondJButton = new JButton();
      secondJButton.setBounds( 168, 0, 84, 46 );
      secondJButton.setText( "SECOND" );
      contentPane.add( secondJButton );
      
      //set up onJButton
      onJButton = new JButton();
      onJButton.setBounds( 252, 0, 56, 46 );
      onJButton.setText( "ON" );
      contentPane.add( onJButton );
      
      // set up offJButton
      offJButton = new JButton();
      offJButton.setBounds( 308, 0, 56, 46 );
      offJButton.setText( "OFF" );
      contentPane.add( offJButton );
      
      // set up timeJLabel
      timeJLabel = new JLabel();
      timeJLabel.setOpaque( true );
      timeJLabel.setHorizontalAlignment( JLabel.CENTER );
      contentPane.add( timeJLabel );
      
      // set up the ampm JLabel
      ampmJPanel = new JPanel();
      ampmJPanel.setLayout( null );
      ampmJPanel.setBorder( new TitledBorder( 
         new EtchedBorder( EtchedBorder.LOWERED ), "AM/PM" ) );
      ampmJPanel.setBounds( 132, 56, 90, 80 );
      contentPane.add( ampmJPanel );
            
      // set up amJRadioButton
      amJRadioButton = new JRadioButton();
      ampmJPanel.add( amJRadioButton );

      // set up pmJRadioButton
      pmJRadioButton = new JRadioButton();
      ampmJPanel.add( pmJRadioButton );
      
      // set up timerJButton
      timerJButton = new JButton();
      timerJButton.setBounds( 256, 76, 80, 50 );
      timerJButton.setText( "Timer" );
      contentPane.add( timerJButton );
      
      // set up snoozeJLabel
      snoozeJLabel = new JLabel( "SNOOZE" );
      snoozeJLabel.setBounds( 0, 150, 364, 46 );
      snoozeJLabel.setText( "SNOOZE" );
      snoozeJLabel.setBorder( new LineBorder( Color.BLACK ) );
      snoozeJLabel.setHorizontalAlignment( JLabel.CENTER );
      contentPane.add( snoozeJLabel );
      
      // set properties of application's window
      setTitle( "Alarm Clock" ); // set title bar text
      setSize( 374, 226 );       // set window size
      setVisible( true );        // display window

   } // end method createIserInterface

   // main method
   public static void main( String[] args ) 
   {
      AlarmClock application = new AlarmClock();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class AlarmClock


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
