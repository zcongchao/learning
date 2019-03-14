// Exercise 3.14: MonitorInvoice.java
// GUI for invoice application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MonitorInvoice extends JFrame
{
   // JLabel that displays title in window
   private JLabel titleJLabel;

   // JLabel and JTextField for invoice number
   private JLabel invoiceNumberJLabel;
   private JTextField invoiceNumberJTextField;
   
   // JLabel and JTextField for invoice date
   private JLabel invoiceDateJLabel;
   private JTextField invoiceDateJTextField;
   
   // JLabel and JTextField for company name
   private JLabel companyNameJLabel;
   private JTextField companyNameJTextField;
   
   // JLabel and JTextField for street address
   private JLabel addressJLabel;
   private JTextField addressJTextField;
   
   // JLabel and JTextField for city, state and zip code
   private JLabel cityStateZipJLabel;
   private JTextField cityStateZipJTextField;
   
   // JLabels for column heads
   private JLabel sizeJLabel;
   private JLabel quantityJLabel;
   private JLabel priceJLabel;
   private JLabel totalsJLabel;

   // JLabel and JTextFields for 15" monitors
   private JLabel fifteenJLabel;   
   private JTextField quantity15JTextField;
   private JTextField price15JTextField;
   private JTextField totals15JTextField;
   
   // JLabel and JTextFields for 17" monitors
   private JLabel seventeenJLabel;
   private JTextField quantity17JTextField;
   private JTextField price17JTextField;
   private JTextField totals17JTextField;

   // JLabel and JTextFields for 19" monitors
   private JLabel nineteenJLabel;
   private JTextField quantity19JTextField;
   private JTextField price19JTextField;
   private JTextField totals19JTextField;

   // JLabel and JTextField subtotal
   private JLabel subtotalJLabel;
   private JTextField subtotalJTextField;
   
   // JLabel and JTextField for taxes
   private JLabel taxJLabel;
   private JTextField taxJTextField;
   
   // JLabel and JTextField for total
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // JButtons to save, calculate results and clear JTextFields
   private JButton saveJButton;
   private JButton calculateJButton;
   private JButton clearJButton;

   // no-argument constructor
   public MonitorInvoice()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( null );

      // set up titleJLabel
      titleJLabel = new JLabel();
      titleJLabel.setBounds( 0, 16, 378, 32 );
      titleJLabel.setText( "Monitor Invoice" );
      titleJLabel.setHorizontalAlignment( JLabel.CENTER );
      titleJLabel.setFont( new Font(
         titleJLabel.getFont().getName(),
         titleJLabel.getFont().getStyle(), 20 ) );
      container.add( titleJLabel );

      // set up invoiceNumberJLabel
      invoiceNumberJLabel = new JLabel();
      invoiceNumberJLabel.setBounds( 16, 64, 92, 21 );
      invoiceNumberJLabel.setText( "Invoice number:" );
      container.add( invoiceNumberJLabel );

      // set up invoiceDateJLabel
      invoiceDateJLabel = new JLabel();
      invoiceDateJLabel.setBounds( 176, 64, 72, 21 );
      invoiceDateJLabel.setText( "Invoice date:" );
      container.add( invoiceDateJLabel );

      // set up companyNameJLabel
      companyNameJLabel = new JLabel();
      companyNameJLabel.setBounds( 16, 104, 92, 21 );
      companyNameJLabel.setText( "Company name:" );
      container.add( companyNameJLabel );

      // set up addressJLabel
      addressJLabel = new JLabel();
      addressJLabel.setBounds( 16, 144, 92, 21 );
      addressJLabel.setText( "Address (line 1):" );
      container.add( addressJLabel );

      // set up cityStateZipJLabel
      cityStateZipJLabel = new JLabel();
      cityStateZipJLabel.setBounds( 16, 184, 92, 21 );
      cityStateZipJLabel.setText( "Address (line 2):" );
      container.add( cityStateZipJLabel );

      // set up sizeJLabel
      sizeJLabel = new JLabel();
      sizeJLabel.setBounds( 20, 224, 80, 21 );
      sizeJLabel.setText( "Monitor size:" );
      sizeJLabel.setHorizontalAlignment( JLabel.RIGHT );
      container.add( sizeJLabel );

      // set up quantityJLabel
      quantityJLabel = new JLabel();
      quantityJLabel.setBounds( 112, 224, 56, 21 );
      quantityJLabel.setText( "Quantity:" );
      container.add( quantityJLabel );

      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 192, 224, 42, 21 );
      priceJLabel.setText( "Price:" );
      container.add( priceJLabel );

      // set up totalsJLabel
      totalsJLabel = new JLabel();
      totalsJLabel.setBounds( 288, 224, 40, 21 );
      totalsJLabel.setText( "Totals:" );
      container.add( totalsJLabel );

      // set up fifteenJLabel
      fifteenJLabel = new JLabel();
      fifteenJLabel.setBounds( 20, 248, 80, 21 );
      fifteenJLabel.setText( "15\":" );
      fifteenJLabel.setHorizontalAlignment( JLabel.RIGHT );
      container.add( fifteenJLabel );

      // set up seventeenJLabel
      seventeenJLabel = new JLabel();
      seventeenJLabel.setBounds( 20, 280, 80, 21 );
      seventeenJLabel.setText( "17\":" );
      seventeenJLabel.setHorizontalAlignment( JLabel.RIGHT );
      container.add( seventeenJLabel );

      // set up nineteenJLabel
      nineteenJLabel = new JLabel();
      nineteenJLabel.setBounds( 20, 312, 80, 21 );
      nineteenJLabel.setText( "19\":" );
      nineteenJLabel.setHorizontalAlignment( JLabel.RIGHT );
      container.add( nineteenJLabel );

      // set up subtotalJLabel
      subtotalJLabel = new JLabel();
      subtotalJLabel.setBounds( 224, 344, 56, 21 );
      subtotalJLabel.setText( "Subtotal:" );
      container.add( subtotalJLabel );

      // set up taxJLabel
      taxJLabel = new JLabel();
      taxJLabel.setBounds( 224, 376, 32, 21 );
      taxJLabel.setText( "Tax:" );
      container.add( taxJLabel );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 224, 408, 40, 21 );
      totalJLabel.setText( "Total:" );
      container.add( totalJLabel );

      // set up invoiceNumberJTextField
      invoiceNumberJTextField = new JTextField();
      invoiceNumberJTextField.setBounds( 122, 64, 38, 21 );
      invoiceNumberJTextField.setText( "128" );
      container.add( invoiceNumberJTextField );

      // set up invoiceDateJTextField
      invoiceDateJTextField = new JTextField();
      invoiceDateJTextField.setBounds( 256, 64, 104, 21 );
      invoiceDateJTextField.setText( "04/01/2003" );
      container.add( invoiceDateJTextField );

      // set up companyNameJTextField
      companyNameJTextField = new JTextField();
      companyNameJTextField.setBounds( 122, 104, 238, 21 );
      companyNameJTextField.setText( "Deitel & Associates" );
      container.add( companyNameJTextField );

      // set up addressJTextField
      addressJTextField = new JTextField();
      addressJTextField.setBounds( 122, 144, 238, 21 );
      addressJTextField.setText( "100 Main Street" );
      container.add( addressJTextField );

      // set up cityStateZipJTextField
      cityStateZipJTextField = new JTextField();
      cityStateZipJTextField.setBounds( 122, 184, 238, 21 );
      cityStateZipJTextField.setText( "Some Town, MA 00000" );
      container.add( cityStateZipJTextField );

      // set up quantity15JTextField
      quantity15JTextField = new JTextField();
      quantity15JTextField.setText( "10" );
      quantity15JTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      container.add( quantity15JTextField );

      // set up quantity17JTextField
      quantity17JTextField = new JTextField();
      quantity17JTextField.setText( "0" );
      quantity17JTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      container.add( quantity17JTextField );

      // set up quantity19JTextField
      quantity19JTextField = new JTextField();
      quantity19JTextField.setText( "0" );
      quantity19JTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      container.add( quantity19JTextField );

      // set up price15JTextField
      price15JTextField = new JTextField();
      price15JTextField.setText( "150" );
      price15JTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( price15JTextField );

      // set up price17JTextField
      price17JTextField = new JTextField();
      price17JTextField.setText( "0" );
      price17JTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( price17JTextField );

      // set up price19JTextField
      price19JTextField = new JTextField();
      price19JTextField.setText( "0" );
      price19JTextField.setHorizontalAlignment( JTextField.RIGHT );
      container.add( price19JTextField );

      // set up totals15JTextField
      totals15JTextField = new JTextField();
      totals15JTextField.setHorizontalAlignment( JTextField.RIGHT );
      totals15JTextField.setEditable( false );
      totals15JTextField.setBorder( new BevelBorder( 1 ) );
      container.add( totals15JTextField );

      // set up totals17JTextField
      totals17JTextField = new JTextField();
      totals17JTextField.setHorizontalAlignment( JTextField.RIGHT );
      totals17JTextField.setEditable( false );
      totals17JTextField.setBorder( new BevelBorder( 1 ) );
      container.add( totals17JTextField );

      // set up totals19JTextField
      totals19JTextField = new JTextField();
      totals19JTextField.setHorizontalAlignment( JTextField.RIGHT );
      totals19JTextField.setEditable( false );
      totals19JTextField.setBorder( new BevelBorder( 1 ) );
      container.add( totals19JTextField );

      // set up subtotalJTextField
      subtotalJTextField = new JTextField();
      subtotalJTextField.setBounds( 288, 344, 72, 21 );
      subtotalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      subtotalJTextField.setEditable( false );
      subtotalJTextField.setBorder( new BevelBorder( 1 ) );
      container.add( subtotalJTextField );

      // set up taxJTextField
      taxJTextField = new JTextField();
      taxJTextField.setBounds( 288, 376, 72, 21 );
      taxJTextField.setHorizontalAlignment( JTextField.RIGHT );
      taxJTextField.setEditable( false );
      taxJTextField.setBorder( new BevelBorder( 1 ) );
      container.add( taxJTextField );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 288, 408, 72, 21 );
      totalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      totalJTextField.setEditable( false );
      totalJTextField.setBorder( new BevelBorder( 1 ) );
      container.add( totalJTextField );
      
      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 102, 442, 72, 23 );
      saveJButton.setText( "Save" );
      container.add( saveJButton );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 187, 442, 88, 23 );
      calculateJButton.setText( "Calculate" );
      container.add( calculateJButton );

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 288, 442, 72, 23 );
      clearJButton.setText( "Clear" );
      container.add( clearJButton );

      // set properties of application’s window
      setTitle( "Monitor Invoice" ); // set title bar text
      setSize( 384, 504 );           // set window size
      setVisible( true );            // display window
   
   } // end method createUserInterface
   
   // main method
   public static void main( String[] args )
   {
      MonitorInvoice application = new MonitorInvoice();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class MonitorInvoice


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
