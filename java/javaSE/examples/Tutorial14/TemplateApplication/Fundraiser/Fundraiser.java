// Tutorial 14: Fundraiser.java
// Calculates the amount of a donation after expenses and then totals
// repeated donations.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Fundraiser extends JFrame
{
   // JLabel and JTextField to hold donation
   private JLabel donationJLabel;
   private JTextField donationJTextField;

   // JLabel and JTextField to display amount after expenses
   private JLabel afterExpensesJLabel;
   private JTextField afterExpensesJTextField;

   // JLabel and JTextField to display total amount raised
   private JLabel totalRaisedJLabel;
   private JTextField totalRaisedJTextField;

   // JButton to allow user to enter donation
   private JButton donateJButton;
   
   // no-argument constructor
   public Fundraiser() 
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
      
      // set up donationJLabel
      donationJLabel = new JLabel();
      donationJLabel.setBounds( 16, 16, 80, 20 );
      donationJLabel.setText( "Donation:" );
      contentPane.add( donationJLabel );

      // set up donationJTextField
      donationJTextField = new JTextField();
      donationJTextField.setBounds( 122, 16, 120, 21 );
      donationJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( donationJTextField );
      donationJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when donationJTextField is edited
            public void keyPressed( KeyEvent event )
            {
               donationJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
      
      // set up afterExpensesJLabel
      afterExpensesJLabel = new JLabel();
      afterExpensesJLabel.setBounds( 16, 48, 98, 20 );
      afterExpensesJLabel.setText( "After expenses:" );
      contentPane.add( afterExpensesJLabel );

      // set up afterExpensesJTextField
      afterExpensesJTextField = new JTextField();
      afterExpensesJTextField.setBounds( 122, 48, 120, 20 );
      afterExpensesJTextField.setText( "$0.00" );
      afterExpensesJTextField.setEditable( false );
      afterExpensesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( afterExpensesJTextField );
      
      // set up totalRaisedJLabel
      totalRaisedJLabel = new JLabel();
      totalRaisedJLabel.setBounds( 16, 80, 88, 20 );
      totalRaisedJLabel.setText( "Total raised:" );
      contentPane.add( totalRaisedJLabel );

      // set up totalRaisedJTextField
      totalRaisedJTextField = new JTextField();
      totalRaisedJTextField.setBounds( 122, 80, 120, 20 );
      totalRaisedJTextField.setText( "$0.00" );
      totalRaisedJTextField.setEditable( false );
      totalRaisedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( totalRaisedJTextField );
      
      // set up donateJButton
      donateJButton = new JButton();
      donateJButton.setBounds( 63, 112, 122, 24 );
      donateJButton.setText( "Donate" );
      contentPane.add( donateJButton );
      donateJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when donateJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               donateJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Fundraiser" );  // set title bar string
      setSize( 263, 174 );       // set window size
      setVisible( true );        // display window

   } // end method createUserInterface
   
   // returns donation amount after operating expenses
   private double calculateDonation( int donatedAmount )
   {
      final double NET_PERCENTAGE = 0.83;
      
      // calculate amount of donation for charity
      return NET_PERCENTAGE * donatedAmount;

   } // end method calculateDonation
   
   // calculate the donation and fill the JTextFields
   private void donateJButtonActionPerformed( ActionEvent event )
   {
      
   } // end method donateJButtonActionPerformed

   // clear afterExpensesJTextField
   private void donationJTextFieldKeyPressed( KeyEvent event )
   {
      // clear afterExpensesJTextField
      afterExpensesJTextField.setText( "" );

   } // end method donationJTextFieldKeyPressed
   
   // main method
   public static void main( String args[] ) 
   {
      Fundraiser application = new Fundraiser();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Fundraiser

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