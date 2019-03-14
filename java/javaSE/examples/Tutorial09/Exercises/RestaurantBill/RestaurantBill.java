// Exercise 9.17: RestaurantBill.java
// This application calculates a restaurant bill.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class RestaurantBill extends JFrame
{
   // JLabel and JTextArea for quantity of lunch items
   private JLabel quantityJLabel;
   private JTextArea quantityJTextArea;

   // JLabel and JTextArea for name of lunch items
   private JLabel itemJLabel;
   private JTextArea itemJTextArea;

   // JLabel and JTextArea for price of lunch items
   private JLabel priceJLabel;
   private JTextArea priceJTextArea;

   // JButton initiates calculation of bill
   private JButton addItemsJButton;

   // JLabel and JTextField displays total cost
   private JLabel totalCostJLabel;
   private JTextField totalCostJTextField;
   
   // no-argument constructor
   public RestaurantBill()
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

      // set up quantityJLabel
      quantityJLabel = new JLabel();
      quantityJLabel.setBounds( 16, 8, 56, 23 );
      quantityJLabel.setText( "Quantity:" );
      contentPane.add( quantityJLabel );

      // set up quantityJTextArea
      quantityJTextArea = new JTextArea();
      quantityJTextArea.setBounds( 16, 32, 72, 55 );
      contentPane.add( quantityJTextArea );

      // set up itemJLabel
      itemJLabel = new JLabel();
      itemJLabel.setBounds( 104, 8, 64, 23 );
      itemJLabel.setText( "Item:" );
      contentPane.add( itemJLabel );

      // set up itemJTextArea
      itemJTextArea = new JTextArea();
      itemJTextArea.setBounds( 104, 32, 104, 55 );
      contentPane.add( itemJTextArea );

      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 224, 8, 56, 23 );
      priceJLabel.setText( "Price:" );
      contentPane.add( priceJLabel );
      
      // set up priceJTextArea
      priceJTextArea = new JTextArea();
      priceJTextArea.setBounds( 224, 32, 96, 55 );
      contentPane.add( priceJTextArea );
      
      // set up addItemsJButton
      addItemsJButton = new JButton();
      addItemsJButton.setBounds( 16, 105, 96, 23 );
      addItemsJButton.setText( "Add Items" );
      contentPane.add( addItemsJButton );
      addItemsJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when addItemsJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               addItemsJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up totalCostJLabel
      totalCostJLabel = new JLabel();
      totalCostJLabel.setBounds( 144, 105, 64, 23 );
      totalCostJLabel.setText( "Total Cost:" );
      contentPane.add( totalCostJLabel );
      
      // set up totalCostJTextField
      totalCostJTextField = new JTextField();
      totalCostJTextField.setBounds( 224, 105, 96, 23 );
      totalCostJTextField.setEditable( false );
      totalCostJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( totalCostJTextField );
      
      // set properties of application's window
      setTitle( "Restaurant Bill" ); // set title bar text
      setSize( 345, 169 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // method to retrieve input from users and calculate total
   private void addItemsJButtonActionPerformed( ActionEvent event )
   {
      // clear previous grades and calculation result
      totalCostJTextField.setText( "" );
      quantityJTextArea.setText( "" );
      itemJTextArea.setText( "" );
      priceJTextArea.setText( "" );

      int counter = 1;
      double total = 0;
      DecimalFormat dollars = new DecimalFormat( "$0.00" );
      
      // display price with monetary format
      totalCostJTextField.setText( dollars.format( total ) );

   } // end method addItemsJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      RestaurantBill application = new RestaurantBill();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class RestaurantBill

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
