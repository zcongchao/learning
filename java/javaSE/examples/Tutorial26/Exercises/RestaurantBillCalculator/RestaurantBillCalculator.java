// Exercise 26.12: RestaurantBillCalculator.java
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

   // JPanel to display waiter information
   private JPanel waiterJPanel;

   // JLabel and JTextField for table number
   private JLabel tableNumberJLabel;
   private JTextField tableNumberJTextField;

   // JLabel and JTextField for waiter name
   private JLabel waiterNameJLabel;
   private JTextField waiterNameJTextField;

   // JPanel to display menu items
   private JPanel menuItemsJPanel;

   // JLabel and JComboBox for beverage
   private JLabel beverageJLabel;
   private JComboBox beverageJComboBox;

   // JLabel and JComboBox for appetizer
   private JLabel appetizerJLabel;
   private JComboBox appetizerJComboBox;

   // JLabel and JComboBox for main course
   private JLabel mainCourseJLabel;
   private JComboBox mainCourseJComboBox;

   // JLabel and JComboBox for dessert
   private JLabel dessertJLabel;
   private JComboBox dessertJComboBox;

   // JButton for calculate bill
   private JButton calculateBillJButton;

   // JLabel and JTextField for subtotal
   private JLabel subtotalJLabel;
   private JTextField subtotalJTextField;

   // JLabel and JTextField for tax
   private JLabel taxJLabel;
   private JTextField taxJTextField;

   // JLabel and JTextField for total
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // constant for tax rate
   private final static double TAX_RATE = 0.05;

   // declare instance variables for database processing
   private Connection myConnection;
   private Statement myStatement;
   private ResultSet myResultSet;

   // declare instance variable ArrayList to hold bill items
   private ArrayList billItems = new ArrayList();

   // constructor
   public RestaurantBillCalculator( 
      String databaseDriver, String databaseURL )
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

      // set up restaurantJLabel
      restaurantJLabel = new JLabel();
      restaurantJLabel.setBounds( 80, 8, 128, 24 );
      restaurantJLabel.setText( "Restaurant" );
      restaurantJLabel.setFont( 
         new Font( "SansSerif", Font.BOLD , 16 ) );
      contentPane.add( restaurantJLabel );

      // set up waiterJPanel
      createWaiterJPanel(); 
      contentPane.add( waiterJPanel );

      // set up menuItemsJPanel
      createMenuItemsJPanel();
      contentPane.add( menuItemsJPanel );

      // set up calculateBillJButton
      calculateBillJButton = new JButton();
      calculateBillJButton.setBounds( 92, 320, 90, 24 );
      calculateBillJButton.setText( "Calculate Bill" );
      calculateBillJButton.setBorder( 
         BorderFactory.createRaisedBevelBorder() );
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
      
      // set up subtotalJLabel
      subtotalJLabel = new JLabel();
      subtotalJLabel.setBounds( 28, 360, 56, 16 );
      subtotalJLabel.setText( "Subtotal:" );
      contentPane.add( subtotalJLabel );

      // set up subtotalJTextField
      subtotalJTextField = new JTextField();
      subtotalJTextField.setBounds( 92, 360, 90, 20 );
      subtotalJTextField.setEditable( false );
      subtotalJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      subtotalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( subtotalJTextField );

      // set up taxJLabel
      taxJLabel = new JLabel();
      taxJLabel.setBounds( 28, 392, 56, 16 );
      taxJLabel.setText( "Tax:" );
      contentPane.add( taxJLabel );

      // set up taxJTextField
      taxJTextField = new JTextField();
      taxJTextField.setBounds( 92, 392, 90, 20 );
      taxJTextField.setEditable( false );
      taxJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      taxJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( taxJTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 28, 424, 56, 16 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 92, 424, 90, 20 );
      totalJTextField.setEditable( false );
      totalJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      totalJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( totalJTextField );

      // set properties of application's window
      setTitle( "Restaurant Bill Calculator" ); // set window title
      setSize( 280, 500 ); // set window size
      setVisible( true );  // display window

      // ensure database connection is closed 
      // when user quits application
      addWindowListener(

         new WindowAdapter() // anonymous inner class
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
      // set up waiterJPanel
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
      tableNumberJTextField = new JTextField();
      tableNumberJTextField.setBounds( 128, 24, 88, 21 );
      waiterJPanel.add( tableNumberJTextField );

      // set up waiterNameJLabel
      waiterNameJLabel = new JLabel();
      waiterNameJLabel.setBounds( 35, 56, 90, 16 );
      waiterNameJLabel.setText( "Waiter name:" );
      waiterJPanel.add( waiterNameJLabel );

      // set up waiterNameJTextField
      waiterNameJTextField = new JTextField();
      waiterNameJTextField.setBounds( 128, 56, 88, 21 );
      waiterJPanel.add( waiterNameJTextField );

   } // end method createWaiterJPanel

   // create menuItemsJPanel
   private void createMenuItemsJPanel()
   {
      // set up menuItemsJPanel
      menuItemsJPanel = new JPanel();
      menuItemsJPanel.setBounds( 20, 152, 232, 152 );
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
      mainCourseJLabel.setText( "Main Course:" );
      mainCourseJLabel.setBounds( 8, 88, 80, 24 );
      menuItemsJPanel.add( mainCourseJLabel );

      // set up mainCourseJComboBox
      mainCourseJComboBox = new JComboBox();
      mainCourseJComboBox.setBounds( 88, 88, 128, 25 );
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

      menuItemsJPanel.add( mainCourseJComboBox );

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

   // add items to JComboBox
   private void loadCategory(
      String category, JComboBox categoryJComboBox )
   {
            
   } // end method loadCategory

   // user select beverage
   private void beverageJComboBoxItemStateChanged( ItemEvent event )
   {
      
   } // end method beverageJComboBoxItemStateChanged

   // user select appetizer
   private void appetizerJComboBoxItemStateChanged( ItemEvent event )
   {
      
   } // end method appetizerJComboBoxItemStateChanged

   // user select main course
   private void mainCourseJComboBoxItemStateChanged( 
      ItemEvent event )
   {
      
   } // end method mainCourseJComboBoxItemStateChanged

   // user select dessert
   private void dessertJComboBoxItemStateChanged( ItemEvent event )
   {
      
   } // end method dessertJComboBoxItemStateChanged

   // user click Calculate Bill JButton
   private void calculateBillJButtonActionPerformed( 
      ActionEvent event )
   {
      
   } // end method calculateBillJButtonActionPerformed

   // calculate subtotal
   private double calculateSubtotal()
   {
      return 0;

   } // end method calculateSubtotal

   // user close window
   private void frameWindowClosing( WindowEvent event )
   {
      
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

         // create new RestaurantBillCalculator
         RestaurantBillCalculator application = 
            new RestaurantBillCalculator ( 
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