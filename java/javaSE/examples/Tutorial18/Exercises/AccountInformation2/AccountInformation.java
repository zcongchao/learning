// Exercise 18.13: AccountInformation.java
// This application displays bank account information.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class AccountInformation extends JFrame
{
   // JLabel and JTextField for first name
   private JLabel firstJLabel;
   private JTextField firstJTextField;

   // JLabel and JTextField for last name
   private JLabel lastJLabel;
   private JTextField lastJTextField;

   // JLabel and JTextField for account number
   private JLabel numberJLabel;
   private JTextField numberJTextField; 

   // JLabel and JTextField for balance
   private JLabel balanceJLabel;
   private JTextField balanceJTextField;

   // JButton to display previous or next record
   private JButton previousJButton;
   private JButton nextJButton;

   // integer for storing the index of the current record
   private int position = 0;

   // Client instance for storing an array of account records
   private Client accountRecords[];
   
   // no-argument constructor
   public AccountInformation()
   {
      createUserInterface();

      // variables hold data to be stored in accountRecords
      String firstName[] = new String[] { "John", "Sarah", "Jack",
         "Adam", "Diane", "David", "Kristin", "Jennifer" };
      String lastName[] = new String[] { "Blue", "White", "Red",
         "Brown", "Yellow", "Black", "Green", "Orange" };
      int accountNumber[] = new int[] { 1234652, 1234666, 1234678,
         1234681, 1234690, 1234770, 1234787, 1234887 }; 
      double balance[] = new double[] { 1000.78, 2056.24, 978.65,
         990.0, 432.75, 780.78, 4590.63, 7910.11 };

      // initialize accountRecords and make it the same
      // length as the variables to be stored in it
      accountRecords = new Client[ firstName.length ];

      // store account information variables in accountRecords
      for ( int i = 0; i < firstName.length; i++)
      {
         accountRecords[ i ] = new Client( firstName[ i ],
            lastName[ i ], accountNumber[ i ], balance[ i ]  );
      }

   } // end constructor
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
            
      // set up firstJLabel
      firstJLabel = new JLabel();
      firstJLabel.setBounds( 16, 16, 100, 24 );
      firstJLabel.setText( "First name:" );
      contentPane.add( firstJLabel );
      
      // set up firstJTextField
      firstJTextField = new JTextField();
      firstJTextField.setBounds( 134, 16, 120, 24 );
      firstJTextField.setEditable( false );
      contentPane.add( firstJTextField );
      
      // set up lastJLabel
      lastJLabel = new JLabel();
      lastJLabel.setBounds( 16, 56, 120, 24 );
      lastJLabel.setText( "Last name:" );
      contentPane.add( lastJLabel );
      
      // set up lastJTextField
      lastJTextField = new JTextField();
      lastJTextField.setBounds( 134, 56, 120, 24 );
      lastJTextField.setEditable( false );
      contentPane.add( lastJTextField );

      // set up numberJLabel
      numberJLabel = new JLabel();
      numberJLabel.setBounds( 16, 96, 120, 24 );
      numberJLabel.setText( "Account number:" );
      contentPane.add( numberJLabel );
      
      // set up numberJTextField
      numberJTextField = new JTextField();
      numberJTextField.setBounds( 134, 96, 120, 24 );
      numberJTextField.setEditable( false );
      contentPane.add( numberJTextField );
      
      // set up balanceJLabel
      balanceJLabel = new JLabel();
      balanceJLabel.setBounds( 16, 136, 100, 24 );
      balanceJLabel.setText( "Balance:" );
      contentPane.add( balanceJLabel );
      
      // set up balanceJTextField
      balanceJTextField = new JTextField();
      balanceJTextField.setBounds( 134, 136, 120, 24 );
      balanceJTextField.setEditable( false );
      contentPane.add( balanceJTextField );
      
      // set up previousJButton
      previousJButton = new JButton();
      previousJButton.setBounds( 16, 190, 90, 24 );
      previousJButton.setText( "Previous" );
      contentPane.add( previousJButton );
      previousJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when previousJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               previousJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
           
      // set up nextJButton
      nextJButton = new JButton();
      nextJButton.setBounds( 164, 190, 90, 24 );
      nextJButton.setText( "Next" );
      contentPane.add( nextJButton );
      nextJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when nextJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nextJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Account Information" ); // set title bar string
      setSize( 280, 255 );               // set window size
      setVisible( true );                // display window
      
   } // end method createUserInterface
   
   // display next account
   private void nextJButtonActionPerformed( ActionEvent event )
   {
      position++;
      
      // prevent position from becoming invalid
      if ( position >= accountRecords.length )
      {
         position = 0;
      }

      displayInformation();
   
   } // end method nextJButtonActionPerformed
   
   // display previous account
   private void previousJButtonActionPerformed( ActionEvent event )
   {
      position--;
      
      // prevent position from becoming invalid
      if ( position < 0 )
      {
         position = accountRecords.length - 1;
      }

      displayInformation();
      
   } // end method previousJButtonActionPerformed
   
   // display correct information in the correct JTextFields
   private void displayInformation()
   {
      DecimalFormat balanceFormat = new DecimalFormat( ".00" );

      firstJTextField.setText( 
         accountRecords[ position ].getFirstName() );
      lastJTextField.setText(
         accountRecords[ position ].getLastName() );
      numberJTextField.setText( String.valueOf( 
         accountRecords[ position ].getAccount() ) );
      balanceJTextField.setText( balanceFormat.format(
         accountRecords[ position ].getBalance() ) );

   } // end method displayInformation
   
   // main method
   public static void main( String[] args )
   {
      AccountInformation application = new AccountInformation();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main
   
} // end class AccountInformation

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