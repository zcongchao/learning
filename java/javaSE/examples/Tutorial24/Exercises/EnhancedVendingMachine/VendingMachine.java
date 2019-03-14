// Exercise 24.16: VendingMachine.java
// Creates vending machine using an array of food and beverages.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VendingMachine extends JFrame
{
   // JPanel to hold all pictures
   private JPanel windowJPanel;
   
   // JLabels for first snack shown
   private JLabel zeroJLabel;
   private JLabel zeroIconJLabel;

   // JLabels for second snack shown
   private JLabel oneJLabel;
   private JLabel oneIconJLabel;

   // JLabels for third snack shown
   private JLabel twoJLabel;
   private JLabel twoIconJLabel;

   // JLabels for fourth snack shown
   private JLabel threeJLabel;
   private JLabel threeIconJLabel; 

   // JLabels for fifth snack shown
   private JLabel fourJLabel;
   private JLabel fourIconJLabel;

   // JLabels for sixth snack shown
   private JLabel fiveJLabel;
   private JLabel fiveIconJLabel;

   // JLabels for seventh snack shown
   private JLabel sixJLabel;
   private JLabel sixIconJLabel;

   // JLabels for eigth snack shown
   private JLabel sevenJLabel;
   private JLabel sevenIconJLabel;
   
   // JTextField for displaying selection number
   private JTextField displayJTextField;

   // JLabel and JTextField for user input
   private JLabel inputJLabel;
   private JTextField inputJTextField;

   // JButton to dispense user's snack
   private JButton dispenseJButton;

   // String array to hold snacks
   String snacks[] = new String[] { "Chocolate Chip Cookie", 
      "Bubble Gum", "Plain Pretzel", "Soda", "Salted Pretzel", 
      "Oatmeal Cookie", "Diet Soda", "Sugar-free Gum" };

   // no-argument constructor
   public VendingMachine()
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
      
      // set up windowJPanel
      windowJPanel = new JPanel();
      windowJPanel.setBounds( 10, 10, 260, 170 );
      windowJPanel.setBorder( new LineBorder( Color.BLACK ) );
      windowJPanel.setLayout( null );
      contentPane.add( windowJPanel );
      
      // set up zeroIconJLabel
      zeroIconJLabel = new JLabel();
      zeroIconJLabel.setIcon( new ImageIcon( "images/cookie.png" ) );
      zeroIconJLabel.setBounds( 10, 10, 50, 50 );
      windowJPanel.add( zeroIconJLabel );

      // set up zeroJLabel
      zeroJLabel = new JLabel();
      zeroJLabel.setText( "0" );
      zeroJLabel.setBounds( 10, 60, 50, 20 );
      zeroJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( zeroJLabel );

      // set up oneIconJLabel
      oneIconJLabel = new JLabel();
      oneIconJLabel.setIcon( new ImageIcon( "images/gum.png" ) );
      oneIconJLabel.setBounds( 70, 10, 50, 50 );
      windowJPanel.add( oneIconJLabel );
      
      // set up oneJLabel
      oneJLabel = new JLabel();
      oneJLabel.setText( "1" );
      oneJLabel.setBounds( 70, 60, 50, 20 );
      oneJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( oneJLabel );
      
      // set up twoIconJLabel
      twoIconJLabel = new JLabel();
      twoIconJLabel.setIcon( new ImageIcon( "images/pretzel.png" ) );
      twoIconJLabel.setBounds( 130, 10, 50, 50 );
      windowJPanel.add( twoIconJLabel );
      
      // set up twoJLabel
      twoJLabel = new JLabel();
      twoJLabel.setText( "2" );
      twoJLabel.setBounds( 130, 60, 50, 20 );
      twoJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( twoJLabel );
      
      // set up threeIconJLabel
      threeIconJLabel = new JLabel();
      threeIconJLabel.setIcon( new ImageIcon( 
         "images/soda.png" ) );
      threeIconJLabel.setBounds( 190, 10, 50, 50 );
      windowJPanel.add( threeIconJLabel );
            
      // set up threeJLabel
      threeJLabel = new JLabel();
      threeJLabel.setText( "3" );
      threeJLabel.setBounds( 190, 60, 50, 20 );
      threeJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( threeJLabel );
      
      // set up fourIconJLabel
      fourIconJLabel = new JLabel();
      fourIconJLabel.setIcon( new ImageIcon( 
         "images/pretzel.png" ) );
      fourIconJLabel.setBounds( 10, 90, 50, 50 );
      windowJPanel.add( fourIconJLabel );
      
      // set up fourJLabel
      fourJLabel = new JLabel();
      fourJLabel.setText( "4" );
      fourJLabel.setBounds( 10, 140, 50, 20 );
      fourJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( fourJLabel );
      
      // set up fiveIconJLabel
      fiveIconJLabel = new JLabel();
      fiveIconJLabel.setIcon( new ImageIcon( "images/cookie.png" ) );
      fiveIconJLabel.setBounds( 70, 90, 50, 50 );
      windowJPanel.add( fiveIconJLabel );
      
      // set up fiveJLabel
      fiveJLabel = new JLabel();
      fiveJLabel.setText( "5" );
      fiveJLabel.setBounds( 70, 140, 50, 20 );
      fiveJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( fiveJLabel );
      
      // set up sixIconJLabel
      sixIconJLabel = new JLabel();
      sixIconJLabel.setIcon( new ImageIcon( "images/soda.png" ) );
      sixIconJLabel.setBounds( 130, 90, 50, 50 );
      windowJPanel.add( sixIconJLabel );
      
      // set up sixJLabel
      sixJLabel = new JLabel();
      sixJLabel.setText( "6" );
      sixJLabel.setBounds( 130, 140, 50, 20 );
      sixJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( sixJLabel );

      // set up sevenIconJLabel
      sevenIconJLabel = new JLabel();
      sevenIconJLabel.setIcon( new ImageIcon( "images/gum.png" ) );
      sevenIconJLabel.setBounds( 190, 90, 50, 50 );
      windowJPanel.add( sevenIconJLabel );
      
      // set up sevenJLabel
      sevenJLabel = new JLabel();
      sevenJLabel.setText( "7" );
      sevenJLabel.setBounds( 190, 140, 50, 20 );
      sevenJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( sevenJLabel );

      // set up dispenseJButton
      dispenseJButton = new JButton();
      dispenseJButton.setBounds( 280, 80, 135, 30 );
      dispenseJButton.setText( "Dispense Snack" );
      contentPane.add( dispenseJButton );
      dispenseJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when dispenseJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               dispenseJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up inputJLabel
      inputJLabel = new JLabel();
      inputJLabel.setBounds( 280, 10, 135, 20 );
      inputJLabel.setText( "Please make selection:" );
      contentPane.add( inputJLabel );
      
      // set up inputJTextField
      inputJTextField = new JTextField();
      inputJTextField.setBounds( 280, 35, 135, 25 );
      inputJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( inputJTextField );

      // set up displayJTextField
      displayJTextField = new JTextField();
      displayJTextField.setBounds( 10, 190, 260, 50 );
      displayJTextField.setEditable( false );
      displayJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( displayJTextField );

      // set properties of application's window
      setTitle( "Vending Machine" ); // set title bar String
      setSize( 440, 280 );           // set window size
      setVisible( true );            // display window

   } // end method createUserInterface

   // get user selection and dispense proper snack
   private void dispenseJButtonActionPerformed( ActionEvent event )
   {
      int selection = Integer.parseInt( 
         inputJTextField.getText() );

      displayJTextField.setText( snacks[ selection ] + 
         " has been dispensed" );

   } // end method dispenseJButtonActionPerformed

   // main method
   public static void main( String args[] ) 
   {
      VendingMachine application = new VendingMachine();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class VendingMachine

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