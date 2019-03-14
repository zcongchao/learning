// Exercise 14.13: VendingMachine.java
// Creates vending machine that will display price of entered item.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VendingMachine extends JFrame
{
   // JPanel to hold all pictures
   private JPanel windowJPanel;
   
   // JLabels for first snack shown
   private JLabel oneJLabel;
   private JLabel oneIconJLabel;

   // JLabels for second snack shown
   private JLabel twoJLabel;
   private JLabel twoIconJLabel;

   // JLabels for third snack shown
   private JLabel threeJLabel;
   private JLabel threeIconJLabel;

   // JLabels for fourth snack shown
   private JLabel fourJLabel;
   private JLabel fourIconJLabel; 

   // JLabels for fifth snack shown
   private JLabel fiveJLabel;
   private JLabel fiveIconJLabel;

   // JLabels for sixth snack shown
   private JLabel sixJLabel;
   private JLabel sixIconJLabel;

   // JLabels for seventh snack shown
   private JLabel sevenJLabel;
   private JLabel sevenIconJLabel;

   // JLabels for eighth snack shown
   private JLabel eightJLabel;
   private JLabel eightIconJLabel;
   
   // JTextField for displaying snack price
   private JTextField displayJTextField;

   // JLabel and JTextField for user input
   private JLabel inputJLabel;
   private JTextField inputJTextField;

   // JButton to enter user input
   private JButton enterJButton;

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
      
      // set up oneIconJLabel
      oneIconJLabel = new JLabel();
      oneIconJLabel.setBounds( 10, 10, 50, 50 );
      oneIconJLabel.setIcon( new ImageIcon( "images/cookie.png" ) );
      windowJPanel.add( oneIconJLabel );

      // set up oneJLabel
      oneJLabel = new JLabel();
      oneJLabel.setBounds( 10, 60, 50, 20 );
      oneJLabel.setText( "1" );
      oneJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( oneJLabel );

      // set up twoIconJLabel
      twoIconJLabel = new JLabel();
      twoIconJLabel.setBounds( 70, 10, 50, 50 );
      twoIconJLabel.setIcon( new ImageIcon( "images/gum.png" ) );
      windowJPanel.add( twoIconJLabel );
      
      // set up twoJLabel
      twoJLabel = new JLabel();
      twoJLabel.setBounds( 70, 60, 50, 20 );
      twoJLabel.setText( "2" );
      twoJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( twoJLabel );
      
      // set up threeIconJLabel
      threeIconJLabel = new JLabel();
      threeIconJLabel.setBounds( 130, 10, 50, 50 );
      threeIconJLabel.setIcon( new ImageIcon( 
         "images/pretzel.png" ) );
      windowJPanel.add( threeIconJLabel );
      
      // set up threeJLabel
      threeJLabel = new JLabel();
      threeJLabel.setBounds( 130, 60, 50, 20 );
      threeJLabel.setText( "3" );
      threeJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( threeJLabel );
      
      // set up fourIconJLabel
      fourIconJLabel = new JLabel();
      fourIconJLabel.setBounds( 190, 10, 50, 50 );
      fourIconJLabel.setIcon( new ImageIcon( "images/soda.png" ) );
      windowJPanel.add( fourIconJLabel );
            
      // set up fourJLabel
      fourJLabel = new JLabel();
      fourJLabel.setBounds( 190, 60, 50, 20 );
      fourJLabel.setText( "4" );
      fourJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( fourJLabel );
      
      // set up fiveIconJLabel
      fiveIconJLabel = new JLabel();
      fiveIconJLabel.setBounds( 10, 90, 50, 50 );
      fiveIconJLabel.setIcon( new ImageIcon( 
         "images/pretzel.png" ) );
      windowJPanel.add( fiveIconJLabel );
      
      // set up fiveJLabel
      fiveJLabel = new JLabel();
      fiveJLabel.setBounds( 10, 140, 50, 20 );
      fiveJLabel.setText( "5" );
      fiveJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( fiveJLabel );
      
      // set up sixIconJLabel
      sixIconJLabel = new JLabel();
      sixIconJLabel.setBounds( 70, 90, 50, 50 );
      sixIconJLabel.setIcon( new ImageIcon( "images/cookie.png" ) );
      windowJPanel.add( sixIconJLabel );
      
      // set up sixJLabel
      sixJLabel = new JLabel();
      sixJLabel.setBounds( 70, 140, 50, 20 );
      sixJLabel.setText( "6" );
      sixJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( sixJLabel );
      
      // set up sevenIconJLabel
      sevenIconJLabel = new JLabel();
      sevenIconJLabel.setBounds( 130, 90, 50, 50 );
      sevenIconJLabel.setIcon( new ImageIcon( "images/soda.png" ) );
      windowJPanel.add( sevenIconJLabel );
      
      // set up sevenJLabel
      sevenJLabel = new JLabel();
      sevenJLabel.setBounds( 130, 140, 50, 20 );
      sevenJLabel.setText( "7" );
      sevenJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( sevenJLabel );

      // set up eightIconJLabel
      eightIconJLabel = new JLabel();
      eightIconJLabel.setBounds( 190, 90, 50, 50 );
      eightIconJLabel.setIcon( new ImageIcon( "images/gum.png" ) );
      windowJPanel.add( eightIconJLabel );
      
      // set up eightJLabel
      eightJLabel = new JLabel();
      eightJLabel.setBounds( 190, 140, 50, 20 );
      eightJLabel.setText( "8" );
      eightJLabel.setHorizontalAlignment( JLabel.CENTER );
      windowJPanel.add( eightJLabel );

      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setBounds( 280, 80, 135, 30 );
      enterJButton.setText( "Enter" );
      contentPane.add( enterJButton );
      enterJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enterJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               enterJButtonActionPerformed( event );
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
      setTitle( "Vending Machine" ); // set title bar string
      setSize( 432, 275 );           // set window size
      setVisible( true );            // display window

   } // end method createUserInterface

   // get user input and display price of specified snack
   private void enterJButtonActionPerformed( ActionEvent event )
   {

   } // end method enterJButtonActionPerformed

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