// Exercise 17.16: LotteryPicker.java
// This application picks randomly generated numbers for a lottery.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;

public class LotteryPicker extends JFrame
{
   // JLabel and JTextField for first lottery
   private JLabel oneJLabel;
   private JTextField oneJTextField;

   // JLabel and JTextField for second lottery
   private JLabel twoJLabel;
   private JTextField twoJTextField;

   // JLabel and JTextField for third lottery
   private JLabel threeJLabel;
   private JTextField threeJTextField;

   // JLabel and JTextField for fourth lottery
   private JLabel fourJLabel;
   private JTextField fourJTextField;

   // JButton to generate lottery numbers
   private JButton generateJButton;

   // Random object to create random integers
   private Random generator = new Random();

   // two-dimensional array to maintain unique random numbers
   private boolean[][] uniqueNumber = new boolean[ 4 ][ 40 ];

   // one-dimensional array to store strings for output
   private String[] output = new String[ 4 ];

   // instance variable to hold the selected lottery number
   private int selection;
   
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

      // set up oneJLabel
      oneJLabel = new JLabel();
      oneJLabel.setBounds( 16, 18, 100, 16 );
      oneJLabel.setText( "First lottery:" );
      contentPane.add( oneJLabel );

      // set up oneJTextField
      oneJTextField = new JTextField();
      oneJTextField.setBounds( 120, 16, 124, 23 );
      oneJTextField.setHorizontalAlignment( JTextField.CENTER );
      oneJTextField.setEditable( false );
      contentPane.add( oneJTextField );

      // set up twoJLabel
      twoJLabel = new JLabel();
      twoJLabel.setBounds( 16, 50, 100, 16 );
      twoJLabel.setText( "Second lottery:" );
      contentPane.add( twoJLabel );

      // set up twoJTextField
      twoJTextField = new JTextField();
      twoJTextField.setBounds( 120, 48, 124, 23 );
      twoJTextField.setHorizontalAlignment( JTextField.CENTER );
      twoJTextField.setEditable( false );
      contentPane.add( twoJTextField );

      // set up threeJLabel
      threeJLabel = new JLabel();
      threeJLabel.setBounds( 16, 82, 100, 16 );
      threeJLabel.setText( "Third lottery:" );
      contentPane.add( threeJLabel );

      // set up threeJTextField
      threeJTextField = new JTextField();
      threeJTextField.setBounds( 120, 80, 124, 23 );
      threeJTextField.setHorizontalAlignment( JTextField.CENTER );
      threeJTextField.setEditable( false );
      contentPane.add( threeJTextField );

      // set up fourJLabel
      fourJLabel = new JLabel();
      fourJLabel.setBounds( 16, 114, 100, 16 );
      fourJLabel.setText( "Fourth lottery:" );
      contentPane.add( fourJLabel );

      // set up fourJTextField
      fourJTextField = new JTextField();
      fourJTextField.setBounds( 120, 112, 124, 23 );
      fourJTextField.setHorizontalAlignment( JTextField.CENTER );
      fourJTextField.setEditable( false );
      contentPane.add( fourJTextField );

      // set up generateJButton
      generateJButton = new JButton();
      generateJButton.setBounds( 148, 150, 96, 24 );
      generateJButton.setText( "Generate" );
      contentPane.add( generateJButton );
      generateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when generateJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               generateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Lottery Picker" ); // set title bar string
      setSize( 264, 212 );          // set window size
      setVisible( true );           // display window
      
   } // end method createUserInterface

   // generate four random five-number lottery combinations
   private void generateJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method generateJButtonActionPerformed
   
   // generate random number in a given range
   private int generate( int low, int high )
   {
      // generate random number in range from low to high
      return low + generator.nextInt( high - low + 1 );

   } // end method generate
   
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