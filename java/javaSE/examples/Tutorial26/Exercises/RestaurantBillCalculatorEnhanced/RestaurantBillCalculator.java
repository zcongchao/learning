// Exercise 26.16: RestaurantBillCalculator.java
// Calculates a table's bill.
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class RestaurantBillCalculator extends JFrame
{
   // JLabel for Restaurant
   private JLabel restaurantJLabel;

   // JPanel for Waiter Information
   private JPanel waiterJPanel;

   // JLabel and JComboBox for Table Number
   private JLabel tableNumberJLabel;
   private JComboBox tableNumberJComboBox;

   // JLabel and JTextField for Waiter Name
   private JLabel waiterNameJLabel;
   private JTextField waiterNameJTextField;

   // JPanel for Menu Items
   private JPanel menuItemsJPanel;

   // JLabel and JComboBox for Beverage
   private JLabel beverageJLabel;
   private JComboBox beverageJComboBox; 

   // JLabel and JComboBox for appetizer
   private JLabel appetizerJLabel;
   private JComboBox appetizerJComboBox;

   // JLabel and JComboBox for Main Course
   private JLabel mainCourseJLabel;
   private JComboBox mainCourseJComboBox;

   // JLabel and JComboBox for Dessert
   private JLabel dessertJLabel;
   private JComboBox dessertJComboBox;

   // JLabel and JTextField for Subtotal
   private JLabel subtotalJLabel;
   private JTextField subtotalJTextField; 

   // JLabel and JTextField for Tax
   private JLabel taxJLabel;
   private JTextField taxJTextField;

   // JLabel and JTextField for Total
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // JButton for Save Table
   private JButton saveTableJButton;

   // JButton for Calculate Bill
   private JButton calculateBillJButton; 

   // JButton for Pay Bill
   private JButton payBillJButton;

   // constant for tax rate
   private final static double TAX_RATE = 0.05;

   // declare instance variables for database processing
   private Connection myConnection;
   private Statement myStatement;
   private ResultSet myResultSet;

   // other instance variables
   private ArrayList billItems = new ArrayList();
   private double subtotal;

   // constructor
   public RestaurantBillCalculator(
      String databaseDriver, String databaseURL )
   {
      // make database connection
      try
      {
         // load Cloudscape driver
         Class.forName( databaseDriver );

         // connect to database
         myConnection = DriverManager.getConnection( databaseURL );

         // create statement
         myStatement = myConnection.createStatement();  
      }
      catch ( SQLException exception )
      {
         exception.printStackTrace();
      }
      catch ( ClassNotFoundException exception )
      {
         exception.printStackTrace();
      }

      // set up GUI
      createUserInterface();

   } // end constructor

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );

      // set up restaurantJLabel
      restaurantJLabel = new JLabel();
      restaurantJLabel.setBounds( 80, 8, 128, 24 );
      restaurantJLabel.setText( "Restaurant" );
      restaurantJLabel.setFont( 
         new Font( "SansSerif", Font.BOLD, 16 ) );
      contentPane.add( restaurantJLabel );

      // set up waiterJPanel
      createWaiterJPanel();
      contentPane.add( waiterJPanel );
      
      // set up menuItemsJPanel
      createMenuItemsJPanel();
      contentPane.add( menuItemsJPanel );

      // set up subtotalJLabel
      subtotalJLabel = new JLabel();
      subtotalJLabel.setBounds( 15, 340, 56, 16 );
      subtotalJLabel.setText( "Subtotal:" );
      contentPane.add( subtotalJLabel );

      // set up subtotalJTextField
      subtotalJTextField = new JTextField();
      subtotalJTextField.setBounds( 70, 340, 80, 20 );
      subtotalJTextField.setEditable( false );
      subtotalJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      subtotalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( subtotalJTextField );

      // set up taxJLabel
      taxJLabel = new JLabel();
      taxJLabel.setBounds( 15, 372, 56, 16 );
      taxJLabel.setText( "Tax:" );
      contentPane.add( taxJLabel );

      // set up taxJTextField
      taxJTextField = new JTextField();
      taxJTextField.setBounds( 70, 372, 80, 20 );
      taxJTextField.setEditable( false );
      taxJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      taxJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( taxJTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 15, 404, 56, 16 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 70, 404, 80, 20 );
      totalJTextField.setEditable( false );
      totalJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      totalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( totalJTextField );

      // set up saveTableJButton
      saveTableJButton = new JButton();
      saveTableJButton.setBounds( 167, 328, 90, 24 );
      saveTableJButton.setText( "Save Table" );
      saveTableJButton.setBorder( 
         BorderFactory.createRaisedBevelBorder() );
      saveTableJButton.setEnabled( false );
      contentPane.add( saveTableJButton );
      saveTableJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when saveTableJButton is clicked
            public void actionPerformed( ActionEvent event ) 
            {
               saveTableJButtonActionPerformed( event );
            }

         } // end annoymous inner class

      ); // end addActionListener

      // set up calculateBillJButton
      calculateBillJButton = new JButton();
      calculateBillJButton.setBounds( 167, 360, 90, 24 );
      calculateBillJButton.setText( "Calculate Bill" );
      calculateBillJButton.setBorder( 
         BorderFactory.createRaisedBevelBorder() );
      calculateBillJButton.setEnabled( false );
      contentPane.add( calculateBillJButton );
      calculateBillJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when calculateBillJButton 
            // is clicked
            public void actionPerformed( ActionEvent event ) 
            {
               calculateBillJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end addActionListener

      // set up payBillJButton
      payBillJButton = new JButton();
      payBillJButton.setBounds( 167, 392, 90, 24 );
      payBillJButton.setText( "Pay Bill" );
      payBillJButton.setBorder( 
         BorderFactory.createRaisedBevelBorder() );
      payBillJButton.setEnabled( false );
      contentPane.add( payBillJButton );
      payBillJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when payBillJButton is clicked
            public void actionPerformed( ActionEvent event ) 
            {
               payBillJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end addActionListener

      // set properties of application's window
      setTitle( "Restaurant Bill Calculator" ); // set window title
      setSize( 280, 500 ); // set window size
      setVisible( true );  // display window

      // ensure database connection is closed 
      // when user quits application
      addWindowListener(

         new WindowAdapter()  // anonymous inner class
         {
            // event handler called when close button is clicked
            public void windowClosing( WindowEvent event )
            {
               frameWindowClosing( event );
            }

         } // end anonymous inner class

      ); // end addWindowListener

   } // end method createUserInterface

   // set up waiterJPanel
   private void createWaiterJPanel()
   {
      waiterJPanel = new JPanel();
      waiterJPanel.setBounds( 20, 48, 232, 88 );
      waiterJPanel.setBorder( BorderFactory.createTitledBorder( 
         BorderFactory.createEtchedBorder(), 
         "Waiter Information" ) );
      waiterJPanel.setLayout( null );

      // set up tableNumberJLabel
      tableNumberJLabel = new JLabel();
      tableNumberJLabel.setBounds( 35, 24, 90, 16 );
      tableNumberJLabel.setText( "Table number:" );
      waiterJPanel.add( tableNumberJLabel );

      // set up tableNumberJTextField
      tableNumberJComboBox = new JComboBox();
      tableNumberJComboBox.setBounds( 154, 24, 60, 25 );
      waiterJPanel.add( tableNumberJComboBox );
      tableNumberJComboBox.addItemListener(

         new ItemListener()  // anonymous inner class
         {
            // event handler called when item in tableNumberJComboBox
            // is selected
            public void itemStateChanged( ItemEvent event )
            {
               tableNumberJComboBoxItemStateChanged( event );
            }

         } // end anonymous inner class

      ); // end addItemListener

      // add numbers to tableNumberJComboBox
      tableNumberJComboBox.addItem( "" );
      loadTableNumbers();

      // set up waiterNameJLabel
      waiterNameJLabel = new JLabel();
      waiterNameJLabel.setBounds( 35, 56, 90, 16 );
      waiterNameJLabel.setText( "Waiter name:" );
      waiterJPanel.add( waiterNameJLabel );

      // set up waiterNameJTextField
      waiterNameJTextField = new JTextField();
      waiterNameJTextField.setBounds( 128, 56, 88, 21 );
      waiterNameJTextField.setEditable( false );
      waiterNameJTextField.setBorder(
         BorderFactory.createLoweredBevelBorder() );
      waiterJPanel.add( waiterNameJTextField );

   } // end method createWaiterJPanel

   // set up menuItemsJPanel
   private void createMenuItemsJPanel()
   {
      menuItemsJPanel = new JPanel();
      menuItemsJPanel.setBounds( 20, 152, 232, 152 );
      menuItemsJPanel.setEnabled( false );
      menuItemsJPanel.setBorder( BorderFactory.createTitledBorder( 
         BorderFactory.createEtchedBorder(), "Menu Items" ) );
      menuItemsJPanel.setLayout( null );

      
      // set up beverageJLabel
      beverageJLabel = new JLabel();
      beverageJLabel.setBounds( 8, 24, 80, 24 );
      beverageJLabel.setText( "Beverage:" );
      menuItemsJPanel.add( beverageJLabel );
      
      // set up beverageJComboBox
      beverageJComboBox = new JComboBox();
      beverageJComboBox.setBounds( 88, 24, 128, 25 );
      beverageJComboBox.setEnabled( false );
      menuItemsJPanel.add( beverageJComboBox );
      beverageJComboBox.addItemListener(

         new ItemListener()  // anonymous inner class
         {
            // event handler called when item in beverageJComboBox
            // is selected
            public void itemStateChanged( ItemEvent event )
            {
               beverageJComboBoxItemStateChanged( event );
            }

         } // end anonymous inner class

      ); // end addItemListener

      // add items to beverageJComboBox
      beverageJComboBox.addItem( "" );
      loadCategory( "Beverage", beverageJComboBox );

      // set up appetizerJLabel
      appetizerJLabel = new JLabel();
      appetizerJLabel.setBounds( 8, 56, 80, 24 );
      appetizerJLabel.setText( "Appetizer:" );
      menuItemsJPanel.add( appetizerJLabel );

      // set up appetizerJComboBox
      appetizerJComboBox = new JComboBox();
      appetizerJComboBox.setBounds( 88, 56, 128, 25 );
      appetizerJComboBox.setEnabled( false );
      menuItemsJPanel.add( appetizerJComboBox );
      appetizerJComboBox.addItemListener(

         new ItemListener()  // anonymous inner class
         {
            // event handler called when item in appetizerJComboBox
            // is selected
            public void itemStateChanged( ItemEvent event )
            {
               appetizerJComboBoxItemStateChanged( event );
            }

         } // end anonymous inner class

      ); // end addItemListener

      // add items to appetizerJComboBox
      appetizerJComboBox.addItem( "" );
      loadCategory( "Appetizer", appetizerJComboBox );

      // set up mainCourseJLabel
      mainCourseJLabel = new JLabel();
      mainCourseJLabel.setBounds( 8, 88, 80, 24 );
      mainCourseJLabel.setText( "Main Course:" );
      menuItemsJPanel.add( mainCourseJLabel );

      // set up mainCourseJComboBox
      mainCourseJComboBox = new JComboBox();
      mainCourseJComboBox.setBounds( 88, 88, 128, 25 );
      mainCourseJComboBox.setEnabled( false );
      menuItemsJPanel.add( mainCourseJComboBox );
      mainCourseJComboBox.addItemListener(

         new ItemListener()  // anonymous inner class
         {
            // event handler called when item in mainCourseJComboBox
            // is selected
            public void itemStateChanged( ItemEvent event )
            {
               mainCourseJComboBoxItemStateChanged( event );
            }

         } // end anonymous inner class

      ); // end addItemListener

      // add items to mainCourseJComboBox
      mainCourseJComboBox.addItem( "" );
      loadCategory( "Main Course", mainCourseJComboBox );

      // set up dessertJLabel
      dessertJLabel = new JLabel();
      dessertJLabel.setBounds( 8, 120, 80, 24 );
      dessertJLabel.setText( "Dessert:" );
      menuItemsJPanel.add( dessertJLabel );

      // set up dessertJComboBox
      dessertJComboBox = new JComboBox();
      dessertJComboBox.setBounds( 88, 120, 128, 25 );
      dessertJComboBox.setEnabled( false );
      menuItemsJPanel.add( dessertJComboBox );
      dessertJComboBox.addItemListener(

         new ItemListener()  // anonymous inner class
         {
            // event handler called when item in dessertJComboBox
            // is selected
            public void itemStateChanged( ItemEvent event )
            {
               dessertJComboBoxItemStateChanged( event );
            }

         } // end anonymous inner class

      ); // end addItemListener

      // add items to dessertJComboBox
      dessertJComboBox.addItem( "" );
      loadCategory( "Dessert", dessertJComboBox );

   } // end method createMenuItemsJPanel

   // add numbers to tableNumberJComboBox
   private void loadTableNumbers()
   {

   } // end method loadTableNumbers

   // add items to JComboBox
   private void loadCategory(
      String category, JComboBox categoryJComboBox )
   {
      // read all items from database for specified category
      try
      {
         // obtain all items in specified category
         myResultSet = myStatement.executeQuery( "SELECT name FROM "
            + "Menu WHERE category = '" + category + "'" );

         // add items to JComboBox
         while ( myResultSet.next() == true )
         {
            categoryJComboBox.addItem( 
               myResultSet.getString( "name" ) );
         }

         myResultSet.close(); // close myResultSet

      } // end try

      // catch SQLException
      catch ( SQLException exception )
      {
         exception.printStackTrace();
      }
      
   } // end method loadCategory

   // user select table
   private void tableNumberJComboBoxItemStateChanged( 
      ItemEvent event )
   {

   } // end method tableNumberJComboBoxItemStateChanged

   // user select beverage
   private void beverageJComboBoxItemStateChanged( ItemEvent event )
   {
      // select an item
      if ( event.getStateChange() == ItemEvent.SELECTED )
      {
         billItems.add( 
            ( String ) beverageJComboBox.getSelectedItem() );
      }

   } // end method beverageJComboBoxItemStateChanged

   // user select appetizer
   private void appetizerJComboBoxItemStateChanged( ItemEvent event )
   {
      // select an item
      if ( event.getStateChange() == ItemEvent.SELECTED )
      {
         billItems.add( 
            ( String ) appetizerJComboBox.getSelectedItem() );
      }

   } // end method appetizerJComboBoxItemStateChanged

   // user select main course
   private void mainCourseJComboBoxItemStateChanged( 
      ItemEvent event )
   {
      // select an item
      if ( event.getStateChange() == ItemEvent.SELECTED )
      {
         billItems.add( 
            ( String ) mainCourseJComboBox.getSelectedItem() );
      }

   } // end method mainCourseJComboBoxItemStateChanged

   // user select dessert
   private void dessertJComboBoxItemStateChanged( ItemEvent event )
   {
      // select an item
      if ( event.getStateChange() == ItemEvent.SELECTED )
      {
         billItems.add( 
            ( String ) dessertJComboBox.getSelectedItem() );
      }

   } // end method dessertJComboBoxItemStateChanged

   // user click saveTableJButton
   private void saveTableJButtonActionPerformed( ActionEvent event )
   {

   } // end method saveTableJButtonActionPerformed

   // user click payBillJButton
   private void payBillJButtonActionPerformed( ActionEvent event )
   {

   } // end method payBillJButtonActionPerformed
   
   // reset JFrame
   private void resetJFrame()
   {
      // reset instance variable
      billItems = new ArrayList();

      // reset and disable menuItemsJPanel
      menuItemsJPanel.setEnabled( false );
      beverageJComboBox.setSelectedIndex( 0 );
      appetizerJComboBox.setSelectedIndex( 0 );
      mainCourseJComboBox.setSelectedIndex( 0 );
      dessertJComboBox.setSelectedIndex( 0 );
      beverageJComboBox.setEnabled( false );
      appetizerJComboBox.setEnabled( false );
      mainCourseJComboBox.setEnabled( false );
      dessertJComboBox.setEnabled( false );

      // reset and enable waiterJPanel
      waiterJPanel.setEnabled( true );
      tableNumberJComboBox.setEnabled( true );
      tableNumberJComboBox.setSelectedIndex( 0 );
      waiterNameJTextField.setText( "" );

      // clear JTextFields
      subtotalJTextField.setText( "" );
      taxJTextField.setText( "" );
      totalJTextField.setText( "" );

      // disable JButtons
      saveTableJButton.setEnabled( false );
      calculateBillJButton.setEnabled( false );
      payBillJButton.setEnabled( false );

   } // end method resetJFrame

   // user click Calculate Bill button
   private void calculateBillJButtonActionPerformed( 
      ActionEvent event )
   {
      double total = calculateSubtotal();
  
      // display subtotal, tax and total
      displayTotal( total );

   } // end method calculateBillJButtonActionPerformed

   // display subtotal, tax and total
   private void displayTotal( double total )
   {
      // define display format
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      // display subtotal
      subtotalJTextField.setText( dollars.format( total ) );

      // calculate and display tax
      double tax = total * TAX_RATE;
      taxJTextField.setText( dollars.format( tax ) );

      // display total
      totalJTextField.setText( 
         dollars.format( total + tax ) );
      
   } // end method displayTotal

   // calculate subtotal
   private double calculateSubtotal()
   {
      double total = subtotal;
      Object[] items = billItems.toArray();

      // get data from database
      try
      {
         // get price for each item in items array
         for ( int i = 0; i < items.length; i++ )
         {
            // execute query to get price
            myResultSet = myStatement.executeQuery( "SELECT price " +
               "FROM Menu WHERE name = '" + ( String ) items[ i ] +
               "'" );

            // myResultSet not empty
            if ( myResultSet.next() == true )
            {
               total += myResultSet.getDouble( "price" );
            }

            myResultSet.close(); // close myResultSet

         } // end for

      } // end try

      // catch SQLException
      catch ( SQLException exception )
      {
         exception.printStackTrace();
      }

      return total;

   } // end method calculateSubtotal

   // user close window
   private void frameWindowClosing( WindowEvent event )
   {
      // close myStatement and database connection
      try
      {
         myStatement.close();
         myConnection.close();
      }
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      }
      finally
      {
         System.exit( 0 );
      }

   }  // end method frameWindowClosing

   // main method
   public static void main( String[] args ) 
   {
      // check command-line arguments
      if ( args.length == 2 )
      {
         // get command-line arguments
         String databaseDriver = args[ 0 ];
         String databaseURL = args[ 1 ];

         // create new RestaurantBillCalculator
         RestaurantBillCalculator application = 
            new RestaurantBillCalculator( 
               databaseDriver, databaseURL );
      }
      else
      {
         System.out.println( "Usage: java " + 
            "RestaurantBillCalculator databaseDriver databaseURL" );
      }      

   } // end method main

} // end class RestaurantBillCalculator

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