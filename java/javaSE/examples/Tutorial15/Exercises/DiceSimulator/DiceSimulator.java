// Exercise 15.12: DiceSimulator.java
// This application rolls dice and counts the frequency of each side.
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DiceSimulator extends JFrame
{
   // JLabel and JTextField to display number of 1s
   private JLabel side1JLabel;
   private JTextField output1JTextField;

   // JLabel and JTextField to display number of 2s
   private JLabel side2JLabel; 
   private JTextField output2JTextField;

   // JLabel and JTextField to display number of 3s
   private JLabel side3JLabel;
   private JTextField output3JTextField;

   // JLabel and JTextField to display number of 4s
   private JLabel side4JLabel;
   private JTextField output4JTextField;

   // JLabel and JTextField to display number of 5s
   private JLabel side5JLabel; 
   private JTextField output5JTextField;

   // JLabel and JTextField to display number of 6s
   private JLabel side6JLabel; 
   private JTextField output6JTextField;

   // JLabel and JTextField to display total rolls
   private JLabel totalJLabel; 
   private JTextField totalJTextField;

   // JLabels to display dice
   private JLabel die1JLabel;
   private JLabel die2JLabel;

   // JButton to roll dice
   private JButton rollJButton;

   // dice face constants
   private final int ONE = 1; 
   private final int TWO = 2;
   private final int THREE = 3;
   private final int FOUR = 4;
   private final int FIVE = 5;
   private final int SIX = 6;
   
   // create a new random object
   private Random generator = new Random();
   
   // no-argument constructor
   public DiceSimulator()
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

      // set up side1JLabel
      side1JLabel = new JLabel();
      side1JLabel.setBounds( 16, 16, 48, 23 );
      side1JLabel.setText( "Side 1:" );
      contentPane.add( side1JLabel );

      // set up output1JTextField
      output1JTextField = new JTextField();
      output1JTextField.setBounds( 72, 16, 56, 23 );
      output1JTextField.setText( "0" );
      output1JTextField.setEditable( false );
      output1JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output1JTextField );

      // set up side2JLabel
      side2JLabel = new JLabel();
      side2JLabel.setBounds( 16, 48, 48, 23 );
      side2JLabel.setText( "Side 2:" );
      contentPane.add( side2JLabel );

      // set up output2JTextField
      output2JTextField = new JTextField();
      output2JTextField.setBounds( 72, 48, 56, 23 );
      output2JTextField.setText( "0" );
      output2JTextField.setEditable( false );
      output2JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output2JTextField );

      // set up side3JLabel
      side3JLabel = new JLabel();
      side3JLabel.setBounds( 16, 80, 48, 23 );
      side3JLabel.setText( "Side 3:" );
      contentPane.add( side3JLabel );

      // set up output3JTextField
      output3JTextField = new JTextField();
      output3JTextField.setBounds( 72, 80, 56, 23 );
      output3JTextField.setText( "0" );
      output3JTextField.setEditable( false );
      output3JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output3JTextField );

      // set up side4JLabel
      side4JLabel = new JLabel();
      side4JLabel.setBounds( 16, 112, 48, 23 );
      side4JLabel.setText( "Side 4:" );
      contentPane.add( side4JLabel );

      // set up output4JTextField
      output4JTextField = new JTextField();
      output4JTextField.setBounds( 72, 111, 56, 23 );
      output4JTextField.setText( "0" );
      output4JTextField.setEditable( false );
      output4JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output4JTextField );

      // set up side5JLabel
      side5JLabel = new JLabel();
      side5JLabel.setBounds( 16, 144, 48, 23 );
      side5JLabel.setText( "Side 5:" );
      contentPane.add( side5JLabel );

      // set up output5JTextField
      output5JTextField = new JTextField();
      output5JTextField.setBounds( 72, 144, 56, 23 );
      output5JTextField.setText( "0" );
      output5JTextField.setEditable( false );
      output5JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output5JTextField );

      // set up side6JLabel
      side6JLabel = new JLabel();
      side6JLabel.setBounds( 16, 176, 48, 23 );
      side6JLabel.setText( "Side 6:" );
      contentPane.add( side6JLabel );

      // set up output6JTextField
      output6JTextField = new JTextField();
      output6JTextField.setBounds( 72, 176, 56, 23 );
      output6JTextField.setText( "0" );
      output6JTextField.setEditable( false );
      output6JTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( output6JTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 16, 208, 48, 23 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 72, 208, 56, 23 );
      totalJTextField.setText( "0" );
      totalJTextField.setEditable( false );
      totalJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( totalJTextField );

      // set up die1JLabel
      die1JLabel = new JLabel();
      die1JLabel.setBounds( 152, 32, 72, 64 );
      contentPane.add( die1JLabel );

      // set up die2JLabel
      die2JLabel = new JLabel();
      die2JLabel.setBounds( 208, 96, 72, 64 );
      contentPane.add( die2JLabel );

      // set up rollJButton
      rollJButton = new JButton();
      rollJButton.setBounds( 144, 208, 136, 24 );
      rollJButton.setText( "Roll" );
      contentPane.add( rollJButton );
      rollJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when rollJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               rollJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Dice Simulator" ); // set title bar string
      setSize( 300, 270 );          // set window size
      setVisible( true );           // display window
      
   } // end method createUserInterface
   
   // roll dice; display frequency of each side
   private void rollJButtonActionPerformed( ActionEvent event )
   {  

   } // end method rollJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      DiceSimulator application = new DiceSimulator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class DiceSimulator

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