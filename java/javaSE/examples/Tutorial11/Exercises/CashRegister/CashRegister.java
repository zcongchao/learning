// Exercise: 11.16 CashRegister.java
// Application simulates the behavior of a cash register, allowing
// the user to input prices, keep a running subtotal, and
// calculate the sales tax and total.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class CashRegister extends JFrame
{
   double subtotal = 0.0; // stores subtotal of items purchased

   // JLabel and JTextField to enter amount
   private JLabel amountJLabel;
   private JTextField amountJTextField;

   // JButtons to enter numbers in amountJTextField
   private JButton oneJButton;
   private JButton twoJButton;
   private JButton threeJButton;
   private JButton fourJButton;
   private JButton fiveJButton;
   private JButton sixJButton;
   private JButton sevenJButton;
   private JButton eightJButton;
   private JButton nineJButton;
   private JButton zeroJButton;
   private JButton pointJButton;

   // JButton to add value in amountJTextField to subtotal
   private JButton enterJButton;

   // JButton to determine tax and calculate final total
   private JButton totalJButton;

   // JButton to delete value displayed in amountJTextField
   private JButton deleteJButton;

   // JButton to clear results
   private JButton clearJButton;

   // JLabel and JTextField to display subtotal
   private JLabel subtotalJLabel;
   private JTextField subtotalJTextField;

   // JLabel and JTextField to display tax
   private JLabel taxJLabel;
   private JTextField taxJTextField;

   // JLabel and JTextField to display final total
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // DecimalFormat to format dollar amounts
   private DecimalFormat dollars = new DecimalFormat( "$0.00" );

   // no-argument constructor
   public CashRegister()
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

      // set up amountJLabel
      amountJLabel = new JLabel();
      amountJLabel.setBounds( 20, 20, 15, 20 );
      amountJLabel.setText( "$" );
      contentPane.add( amountJLabel );

      // set up amountJTextField
      amountJTextField = new JTextField();
      amountJTextField.setBounds( 40, 20, 260, 20 );
      contentPane.add( amountJTextField );
      
      // set up oneJButton
      oneJButton = new JButton();
      oneJButton.setBounds( 55, 70, 45, 20 );
      oneJButton.setText( "1" );
      contentPane.add( oneJButton );
      oneJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when oneJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               oneJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up twoJButton
      twoJButton = new JButton();
      twoJButton.setBounds( 100, 70, 45, 20 );
      twoJButton.setText( "2" );
      contentPane.add( twoJButton );
      twoJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when twoJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               twoJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up threeJButton
      threeJButton = new JButton();
      threeJButton.setBounds( 145, 70, 45, 20 );
      threeJButton.setText( "3" );
      contentPane.add( threeJButton );
      threeJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when threeJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               threeJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up fourJButton
      fourJButton = new JButton();
      fourJButton.setBounds( 55, 90, 45, 20 );
      fourJButton.setText( "4" );
      contentPane.add( fourJButton );
      fourJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when fourJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fourJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up fiveJButton
      fiveJButton = new JButton();
      fiveJButton.setBounds( 100, 90, 45, 20 );
      fiveJButton.setText( "5" );
      contentPane.add( fiveJButton );
      fiveJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when fiveJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               fiveJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up sixJButton
      sixJButton = new JButton();
      sixJButton.setBounds( 145, 90, 45, 20 );
      sixJButton.setText( "6" );
      contentPane.add( sixJButton );
      sixJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when sixJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sixJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up sevenJButton
      sevenJButton = new JButton();
      sevenJButton.setBounds( 55, 110, 45, 20 );
      sevenJButton.setText( "7" );
      contentPane.add( sevenJButton );
      sevenJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when sevenJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               sevenJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up eightJButton
      eightJButton = new JButton();
      eightJButton.setBounds( 100, 110, 45, 20 );
      eightJButton.setText( "8" );
      contentPane.add( eightJButton );
      eightJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when eightJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               eightJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up nineJButton
      nineJButton = new JButton();
      nineJButton.setBounds( 145, 110, 45, 20 );
      nineJButton.setText( "9" );
      contentPane.add( nineJButton );
      nineJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when nineJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nineJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up zeroJButton
      zeroJButton = new JButton();
      zeroJButton.setBounds( 100, 130, 45, 20 );
      zeroJButton.setText( "0" );
      contentPane.add( zeroJButton );
      zeroJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when zeroJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               zeroJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up pointJButton
      pointJButton = new JButton();
      pointJButton.setBounds( 145, 130, 45, 20 );
      pointJButton.setText( "." );
      contentPane.add( pointJButton );
      pointJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when pointJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               pointJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setBounds( 205, 70, 70, 20 );
      enterJButton.setText( "Enter" );
      contentPane.add( enterJButton );
      enterJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enterJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               enterJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up totalJButton
      totalJButton = new JButton();
      totalJButton.setBounds( 205, 90, 70, 20 );
      totalJButton.setText( "Total" );
      contentPane.add( totalJButton );
      totalJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when totalJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               totalJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up deleteJButton
      deleteJButton = new JButton();
      deleteJButton.setBounds( 205, 110, 70, 20 );
      deleteJButton.setText( "Delete" );
      contentPane.add( deleteJButton );
      deleteJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when deleteJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               deleteJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 205, 130, 70, 20 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when clearJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               clearJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up subtotalJLabel;
      subtotalJLabel = new JLabel();
      subtotalJLabel.setBounds( 20, 180, 90, 20 );
      subtotalJLabel.setText( "Subtotal:" );
      contentPane.add( subtotalJLabel );
      
      // set up subtotalJTextField
      subtotalJTextField = new JTextField();
      subtotalJTextField.setBounds( 160, 180, 140, 20 );
      subtotalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      subtotalJTextField.setEditable( false );
      subtotalJTextField.setText( "$0.00" );
      contentPane.add( subtotalJTextField );
      
      // set up taxJLabel
      taxJLabel = new JLabel();
      taxJLabel.setBounds( 20, 220, 60, 20 );
      taxJLabel.setText( "Tax:" );
      contentPane.add( taxJLabel );
      
      // set up taxJTextField
      taxJTextField = new JTextField();
      taxJTextField.setBounds( 160, 220, 140, 20 );
      taxJTextField.setHorizontalAlignment( JTextField.RIGHT );
      taxJTextField.setEditable( false );
      taxJTextField.setText( "$0.00" );
      contentPane.add( taxJTextField );
      
      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 20, 260, 70, 20 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 160, 260, 140, 20 );
      totalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      totalJTextField.setEditable( false );
      totalJTextField.setText( "$0.00" );
      contentPane.add( totalJTextField );

      // set properties of application's window
      setTitle( "Cash Register" ); // set window title
      setSize( 345, 330 );         // set window size
      setVisible( true );          // display window

   } // end method createUserInterface

   // append "0" to the amount in amountJTextField
   private void zeroJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "0" );

   } // end method zeroJButtonActionPerformed

   // append "1" to the amount in amountJTextField
   private void oneJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "1" );

   } // end method oneJButtonActionPerformed

   // append "2" to the amount in amountJTextField
   private void twoJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "2" );

   } // end method twoJButtonActionPerformed

   // append "3" to the amount in amountJTextField
   private void threeJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "3" );

   } // end method threeJButtonActionPerformed

   // append "4" to the amount in amountJTextField
   private void fourJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "4" );

   } // end method fourJButtonActionPerformed

   // append "5" to the amount in amountJTextField
   private void fiveJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "5" );

   } // end method fiveJButtonActionPerformed

   // append "6" to the amount in amountJTextField
   private void sixJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "6" );

   } // end method sixJButtonActionPerformed

   // append "7" to the amount in amountJTextField
   private void sevenJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "7" );

   } // end method sevenJButtonActionPerformed

   // append "8" to the amount in amountJTextField
   private void eightJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "8" );

   } // end method eightJButtonActionPerformed

   // append "9" to the amount in amountJTextField
   private void nineJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "9" );

   } // end method nineJButtonActionPerformed
   
   // append "." to the amount in amountJTextField
   private void pointJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( amountJTextField.getText() + "." );

   } // end method pointJButtonActionPerformed

   // calculate and display subtotal
   private void enterJButtonActionPerformed( ActionEvent event )
   {

   } // end method enterJButtonActionPerformed
   
   // calculate and display total after taxes
   private void totalJButtonActionPerformed( ActionEvent event )
   {
   
   } // end method totalJButtonActionPerformed
   
   // clear current amount displayed in amountJTextField
   private void deleteJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( "" );

   } // end method deleteJButtonActionPerformed
   
   // clear all results
   private void clearJButtonActionPerformed( ActionEvent event )
   {
      amountJTextField.setText( "" );
      subtotalJTextField.setText( "$0.00" );
      taxJTextField.setText( "$0.00" );
      totalJTextField.setText( "$0.00" );
      subtotal = 0.0; // reset subtotal to 0.0

   } // end method clearJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      CashRegister application = new CashRegister();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class CashRegister

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
