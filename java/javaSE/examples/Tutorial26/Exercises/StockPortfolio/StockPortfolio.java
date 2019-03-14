// Exercise 26.11: StockPortfolio.java
// Displays a client's stock portfolio.
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;

public class StockPortfolio extends JFrame
{
   // JLabels for prompt
   private JLabel prompt1JLabel;
   private JLabel prompt2JLabel; 

   // JComboBox for stock names
   private JComboBox stockNamesJComboBox;

   // JButton for stock information
   private JButton stockInfoJButton;

   // JPanel for displaying stock information
   private JPanel stockInfoJPanel;

   // JLabel and JTextField for stock name
   private JLabel stockNameJLabel; 
   private JTextField stockNameJTextField;

   // JLabel and JTextField for stock symbol
   private JLabel stockSymbolJLabel;
   private JTextField stockSymbolJTextField;

   // JLabel and JTextField for number of shares
   private JLabel sharesJLabel; 
   private JTextField sharesJTextField;

   // JLabel and JTextField for price of shares
   private JLabel priceJLabel;
   private JTextField priceJTextField;

   // JLabel and JTextField for total value
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // instance variables for database processing

   // constructor
   public StockPortfolio( String databaseDriver, String databaseURL )
   {
      createUserInterface(); // set up GUI

   } // end constructor

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );

      // set up prompt1JLlabel
      prompt1JLabel = new JLabel();
      prompt1JLabel.setBounds( 8, 16, 350, 16 );
      prompt1JLabel.setText( "Select the name of " +
         "the stock for which you want " );
      contentPane.add( prompt1JLabel );

      // set up prompt2JLabel
      prompt2JLabel = new JLabel();
      prompt2JLabel.setBounds( 8, 32, 350, 16 );
      prompt2JLabel.setText( "information, and then " +
         "press the Stock Information button." );
      contentPane.add( prompt2JLabel );
      
      // set up stockNamesJComboBox 
      stockNamesJComboBox = new JComboBox();
      stockNamesJComboBox.setBounds( 76, 65, 200, 26 );
      stockNamesJComboBox.addItem( "" );
      contentPane.add( stockNamesJComboBox );
      
      // load stock names into stockNamesJComboBox
      loadStockNames();

      // set up stockInfoJButton
      stockInfoJButton = new JButton();
      stockInfoJButton.setBounds( 100, 100, 150, 23 );
      stockInfoJButton.setText( "Stock Information" );
      contentPane.add( stockInfoJButton );
      stockInfoJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when stockInfoJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               stockInfoJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end addActionLstener

      // set up stockInfoJPanel
      stockInfoJPanel = new JPanel();
      stockInfoJPanel.setBounds( 18, 145, 300, 192 );
      stockInfoJPanel.setLayout( null );
      stockInfoJPanel.setBorder( BorderFactory.createTitledBorder( 
         BorderFactory.createEtchedBorder(), "Stock Info" ) );
      contentPane.add( stockInfoJPanel );

      // set up stockNameJLabel
      stockNameJLabel = new JLabel();
      stockNameJLabel.setBounds( 8, 24, 150, 23 );
      stockNameJLabel.setText( "Stock name:" );
      stockInfoJPanel.add( stockNameJLabel );

      // set up stockNameJTextField
      stockNameJTextField = new JTextField();
      stockNameJTextField.setBounds( 158, 24, 125, 24 );
      stockNameJTextField.setEditable( false );
      stockNameJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      stockNameJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      stockInfoJPanel.add( stockNameJTextField );

      // set up stockSymbolJLabel
      stockSymbolJLabel = new JLabel();
      stockSymbolJLabel.setBounds( 8, 56, 150, 23 );
      stockSymbolJLabel.setText( "Stock symbol:" );
      stockInfoJPanel.add( stockSymbolJLabel );

      // set up stockSymbolJTextField
      stockSymbolJTextField = new JTextField();
      stockSymbolJTextField.setBounds( 158, 56, 125, 24 );
      stockSymbolJTextField.setEditable( false );
      stockSymbolJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      stockSymbolJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      stockInfoJPanel.add( stockSymbolJTextField );

      // set up sharesJLabel
      sharesJLabel = new JLabel();
      sharesJLabel.setBounds( 8, 88, 150, 23 );
      sharesJLabel.setText( "Number of shares:" );
      stockInfoJPanel.add( sharesJLabel );

      // set up sharesJTextField
      sharesJTextField = new JTextField();
      sharesJTextField.setBounds( 158, 88, 125, 24 );
      sharesJTextField.setEditable( false );
      sharesJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      sharesJTextField.setHorizontalAlignment( JTextField.CENTER );
      stockInfoJPanel.add( sharesJTextField );

      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 8, 120, 150, 23 );
      priceJLabel.setText( "Price per share:" );
      stockInfoJPanel.add( priceJLabel );

      // set up priceJTextField
      priceJTextField = new JTextField();
      priceJTextField.setBounds( 158, 120, 125, 24 );
      priceJTextField.setEditable( false );
      priceJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      priceJTextField.setHorizontalAlignment( JTextField.CENTER );
      stockInfoJPanel.add( priceJTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 8, 152, 150, 23 );
      totalJLabel.setText( "Total value:" );
      stockInfoJPanel.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 158, 152, 125, 24 );
      totalJTextField.setEditable( false );
      totalJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      totalJTextField.setHorizontalAlignment( JTextField.CENTER );
      stockInfoJPanel.add( totalJTextField );

      // ensure database connection is closed 
      // when user quits application
      addWindowListener(

         new WindowAdapter()  // anonymous inner class
         {
            public void windowClosing( WindowEvent event )
            {
               frameWindowClosing( event );
            }

         } // end anonymous inner class

      ); // end addWindowListener

      // set properties of application's window
      setTitle( "Stock Portfolio" ); // set title bar string
      setSize( 350, 380 );           // set window size
      setVisible( true );            // display window

   } // end method createUserInterface

   // load stock names into stockNamesJComboBox
   private void loadStockNames()
   {
      // add stock names in database to stockNamesJComboBox

   } // end method loadStockNames

   // user clicked stockInfoJButton
   private void stockInfoJButtonActionPerformed( ActionEvent event )
   {

   } // end method stockInfoJButtonActionPerformed

   // user close window
   private void frameWindowClosing( WindowEvent event )
   {
      // close myStatement and database connection
      
   }  // end method frameWindowClosing
	
   // method main
   public static void main( String[] args )
   {
      // check command-line arguments
      if ( args.length == 2 )
      {
         // get command-line arguments
         String databaseDriver = args[ 0 ];
         String databaseURL = args[ 1 ];

         // create new StockPortfolio
         StockPortfolio application = 
            new StockPortfolio( databaseDriver, databaseURL );
      }
      else
      {
         System.out.println( "Usage: java StockPortfolio " + 
            "databaseDriver databaseURL" );
      }

   } // end method main

} // end class StockPortfolio

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
