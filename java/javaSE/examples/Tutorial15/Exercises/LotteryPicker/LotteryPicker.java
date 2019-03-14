// Exercise 15.13: LotteryPicker.java
// This application picks randomly generated numbers for a lottery.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;

public class LotteryPicker extends JFrame
{
   // JLabel and JTextField to display three number lottery
   private JLabel threeJLabel;
   private JTextField output3JTextField;

   // JLabel and JTextField to display four number lottery
   private JLabel fourJLabel;
   private JTextField output4JTextField;

   // JLabel and JTextField to display five number lottery
   private JLabel fiveJLabel;
   private JTextField output5JTextField;

   // JLabel and JTextField to display five number + one lottery
   private JLabel fivePlus1JLabel;
   private JTextField output5Plus1JTextField;
   private JTextField outputExtra1JTextField; 

   // JButton to generate new lottery numbers
   private JButton generateJButton;

   // create a new Random object
   private Random generator = new Random();
   
   // no-argument constructor
   public LotteryPicker()
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

      // set up threeJLabel
      threeJLabel = new JLabel();
      threeJLabel.setText( "Three number lottery:" );
      threeJLabel.setBounds( 16, 18, 132, 16 );
      contentPane.add( threeJLabel );

      // set up output3JTextField
      output3JTextField = new JTextField();
      output3JTextField.setBounds( 152, 16, 124, 23 );
      output3JTextField.setHorizontalAlignment( JTextField.CENTER );
      output3JTextField.setEditable( false );
      contentPane.add( output3JTextField );

      // set up fourJLabel
      fourJLabel = new JLabel();
      fourJLabel.setText( "Four number lottery:" );
      fourJLabel.setBounds( 16, 50, 132, 16 );
      contentPane.add( fourJLabel );

      // set up output4JTextField
      output4JTextField = new JTextField();
      output4JTextField.setBounds( 152, 48, 124, 23 );
      output4JTextField.setHorizontalAlignment( JTextField.CENTER );
      output4JTextField.setEditable( false );
      contentPane.add( output4JTextField );

      // set up fiveJLabel
      fiveJLabel = new JLabel();
      fiveJLabel.setText( "Five number lottery:" );
      fiveJLabel.setBounds( 16, 82, 132, 16 );
      contentPane.add( fiveJLabel );

      // set up output5JTextField
      output5JTextField = new JTextField();
      output5JTextField.setBounds( 152, 80, 124, 23 );
      output5JTextField.setHorizontalAlignment( JTextField.CENTER );
      output5JTextField.setEditable( false );
      contentPane.add( output5JTextField );

      // set up fivePlus1JLabel
      fivePlus1JLabel = new JLabel();
      fivePlus1JLabel.setText( "Five number + 1 lottery:" );
      fivePlus1JLabel.setBounds( 16, 114, 132, 16 );
      contentPane.add( fivePlus1JLabel );

      // set up output5Plus1JTextField
      output5Plus1JTextField = new JTextField();
      output5Plus1JTextField.setBounds( 152, 112, 92, 23 );
      output5Plus1JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      output5Plus1JTextField.setEditable( false );
      contentPane.add( output5Plus1JTextField );

      // set up outputExtra1JTextField
      outputExtra1JTextField = new JTextField();
      outputExtra1JTextField.setBounds( 252, 112, 24, 23 );
      outputExtra1JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      outputExtra1JTextField.setEditable( false );
      contentPane.add( outputExtra1JTextField );

      // set up generateJButton
      generateJButton = new JButton();
      generateJButton.setText( "Generate" );
      generateJButton.setBounds( 180, 152, 96, 24 );
      contentPane.add( generateJButton );
      generateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when generateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               generateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Lottery Picker" ); // set title bar string
      setSize( 300, 216 );          // set window size
      setVisible( true );           // display window
      
   } // end method createUserInterface
   
   // generate random lottery numbers
   private void generateJButtonActionPerformed( ActionEvent event )
   {

   } // end method generateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      LotteryPicker application = new LotteryPicker();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class LotteryPicker

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