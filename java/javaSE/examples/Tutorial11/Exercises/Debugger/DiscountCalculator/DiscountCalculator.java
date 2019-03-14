// Exercise 11.15: DiscountCalculator.java
// Calculates a the discount the user will receive
// based on how much the user spends.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiscountCalculator extends JFrame
{
   // JLabel and JTextField allow user to enter amount spent
   private JLabel spentJLabel;
   private JTextField spentJTextField;

   // JButton that initiates discount calculation
   private JButton discountJButton;

   // no-argument constructor
   public DiscountCalculator()
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

      // set up spentJLabel
      spentJLabel = new JLabel();
      spentJLabel.setBounds( 10, 10, 120, 25 );
      spentJLabel.setText( "Enter amount spent:" );
      contentPane.add( spentJLabel );

      // set up spentJTextField
      spentJTextField = new JTextField();
      spentJTextField.setBounds( 140, 10, 90, 25 );
      spentJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( spentJTextField );

      // set up discountJButton
      discountJButton = new JButton();
      discountJButton.setBounds( 140, 45, 90, 25 );
      discountJButton.setText( "Calculate" );
      contentPane.add( discountJButton );
      discountJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when discountJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               discountJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Discount Calculator" ); // set window title
      setSize( 245, 105 );               // set window size
      setVisible( true );                // display window

   } // end method createUserInterface

   // display a message stating the users discount
   private void discountJButtonActionPerformed( ActionEvent event )
   {
      int discountRate; // variable to store discount rate
      int amount = Integer.parseInt( spentJTextField.getText() ); 

      // determine discount percentage
      switch ( amount / 50 )
      {
         case 0: // values in the range $0-49
            discountRate = 0;
            break;

         case 2: // values in the range $100-149
            discountRate = 10;
            break;

         default: // values $150 or greater
            discountRate = 15;

      } // end switch statement
      
      // display discount percentage
      JOptionPane.showMessageDialog( null, 
         "Your Discount is: " + discountRate + " %", 
         "Discount", JOptionPane.INFORMATION_MESSAGE );
   
   } // end method discountJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      DiscountCalculator application = new DiscountCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class DiscountCalculator

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
