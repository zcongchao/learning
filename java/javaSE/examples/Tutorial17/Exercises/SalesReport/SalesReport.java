// Exercise 17.12: SalesReport.java
// This application calculates and displays one week's sales.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;

public class SalesReport extends JFrame 
{
   // JPanel for user inputs
   private JPanel inputItemJPanel;
   
   // JLabel and JTextField for item name
   private JLabel itemJLabel;
   private JTextField itemJTextField;
   
   // JLabel and JTextField for monday
   private JLabel mondayJLabel;
   private JTextField mondayJTextField;

   // JLabel and JTextField for tuesday
   private JLabel tuesdayJLabel;
   private JTextField tuesdayJTextField;

   // JLabel and JTextField for wednesday
   private JLabel wednesdayJLabel;
   private JTextField wednesdayJTextField;

   // JLabel and JTextField for thursday
   private JLabel thursdayJLabel;
   private JTextField thursdayJTextField;

   // JLabel and JTextField for friday
   private JLabel fridayJLabel;
   private JTextField fridayJTextField;

   // JButton to submit gain or loss
   private JButton submitItemJButton;

   // JLabel, JTextArea and JScrollPane to display sales
   private JLabel displayJLabel;
   private JTextArea displayJTextArea;
   private JScrollPane displayJScrollPane;

   // JLabel and JTextField to display sales
   private JLabel salesJLabel;
   private JTextField salesJTextField;
   
   // initialize number of items to zero
   private int itemCount = 0;

   // constants 
   private final int NUMBER_OF_DAYS = 5;
   private final int MAXIMUM_ITEMS = 10;

   // one-dimensional array to store names of items
   private String itemNames[] = new String[ MAXIMUM_ITEMS ];

   // two-dimensional arrays to store items
   private double dailyItems[][] = 
      new double[ MAXIMUM_ITEMS ][ NUMBER_OF_DAYS ];

   // DecimalFormat for two digits of precision
   private DecimalFormat dollars = new DecimalFormat( "$0.00" );

   // no-argument constructor
   public SalesReport()
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

      // set up inputItemJPanel
      inputItemJPanel = new JPanel();
      inputItemJPanel.setBounds( 16, 16, 208, 242 );
      inputItemJPanel.setBorder( new TitledBorder( "Input Item" ) );
      inputItemJPanel.setLayout( null );
      contentPane.add( inputItemJPanel );
      
      // set up itemJLabel
      itemJLabel = new JLabel();
      itemJLabel.setBounds( 12, 32, 90, 23 );
      itemJLabel.setText( "Item:" );
      inputItemJPanel.add( itemJLabel );

      // set up itemJTextField
      itemJTextField = new JTextField();
      itemJTextField.setBounds( 104, 32, 88, 21 );
      itemJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( itemJTextField );
      
      // set up mondayJLabel
      mondayJLabel = new JLabel();
      mondayJLabel.setBounds( 12, 74, 80, 23 );
      mondayJLabel.setText( "Monday:" );
      inputItemJPanel.add( mondayJLabel );

      // set up mondayJTextField
      mondayJTextField = new JTextField();
      mondayJTextField.setBounds( 136, 74, 56, 21 );
      mondayJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( mondayJTextField );

      // set up tuesdayJLabel
      tuesdayJLabel = new JLabel();
      tuesdayJLabel.setBounds( 12, 98, 80, 23 );
      tuesdayJLabel.setText( "Tuesday:" );
      inputItemJPanel.add( tuesdayJLabel );

      // set up tuesdayJTextField
      tuesdayJTextField = new JTextField();
      tuesdayJTextField.setBounds( 136, 98, 56, 21 );
      tuesdayJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( tuesdayJTextField );

      // set up wednesdayJLabel
      wednesdayJLabel = new JLabel();
      wednesdayJLabel.setBounds( 12, 122, 80, 23 );
      wednesdayJLabel.setText( "Wednesday:" );
      inputItemJPanel.add( wednesdayJLabel );

      // set up wednesdayJTextField
      wednesdayJTextField = new JTextField();
      wednesdayJTextField.setBounds( 136, 122, 56, 21 );
      wednesdayJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( wednesdayJTextField );

      // set up thursdayJLabel
      thursdayJLabel = new JLabel();
      thursdayJLabel.setBounds( 12, 146, 80, 23 );
      thursdayJLabel.setText( "Thursday:" );
      inputItemJPanel.add( thursdayJLabel );

      // set up thursdayJTextField
      thursdayJTextField = new JTextField();
      thursdayJTextField.setBounds( 136, 146, 56, 21 );
      thursdayJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( thursdayJTextField );

      // set up fridayJLabel
      fridayJLabel = new JLabel();
      fridayJLabel.setBounds( 12, 170, 80, 23 );
      fridayJLabel.setText( "Friday:" );
      inputItemJPanel.add( fridayJLabel );

      // set up fridayJTextField
      fridayJTextField = new JTextField();
      fridayJTextField.setBounds( 136, 170, 56, 21 );
      fridayJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputItemJPanel.add( fridayJTextField );

      // set up submitItemJButton
      submitItemJButton = new JButton();
      submitItemJButton.setBounds( 64, 206, 128, 24 );
      submitItemJButton.setText( "Submit Item" );
      inputItemJPanel.add( submitItemJButton );
      submitItemJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when submitItemJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               submitItemJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up displayJLabel
      displayJLabel = new JLabel();
      displayJLabel.setBounds( 240, 16, 150, 23 );
      displayJLabel.setText( "Itemized sales:" );
      contentPane.add( displayJLabel );
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setEditable( false );

      // set up displayJScrollPane
      displayJScrollPane = new JScrollPane( displayJTextArea );
      displayJScrollPane.setBounds( 240, 48, 402, 208 );
      contentPane.add( displayJScrollPane );
      
      // set up salesJLabel
      salesJLabel = new JLabel();
      salesJLabel.setBounds( 490, 268, 96, 23 );
      salesJLabel.setText( "Gross sales:" );
      contentPane.add( salesJLabel );
      
      // set up salesJTextField
      salesJTextField = new JTextField();
      salesJTextField.setBounds( 576, 268, 66, 23 );
      salesJTextField.setHorizontalAlignment( JTextField.CENTER );
      salesJTextField.setEditable( false );
      contentPane.add( salesJTextField );
      
      // set properties of application's window
      setTitle( "Sales Report" ); // set title bar string
      setSize( 670, 332 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

   // calculate and display the item totals and weekly total
   private void submitItemJButtonActionPerformed( ActionEvent event )
   {
      // get user input
      String nameOfItem = itemJTextField.getText();
      double monday = 
         Double.parseDouble( mondayJTextField.getText() );
      double tuesday = 
         Double.parseDouble( tuesdayJTextField.getText() );
      double wednesday = 
         Double.parseDouble( wednesdayJTextField.getText() );
      double thursday = 
         Double.parseDouble( thursdayJTextField.getText() );
      double friday = 
         Double.parseDouble( fridayJTextField.getText() );

      displaySales(); // display itemized sales
      
      // clear other JTextFields for new data
      itemJTextField.setText( "" );
      mondayJTextField.setText( "" );
      tuesdayJTextField.setText( "" );
      wednesdayJTextField.setText( "" );
      thursdayJTextField.setText( "" );
      fridayJTextField.setText( "" );
 
      // if 10 or more items
      if ( itemCount == MAXIMUM_ITEMS )
      {
         // disable submitItemJButton
         submitItemJButton.setEnabled( false );
      }

   } // end method submitItemJButtonActionPerformed

   // display sales by type and day of week
   private void displaySales()
   {
      // add a header to displayJTextArea
      displayJTextArea.setText( "Name\tMonday\tTuesday\t" +
         "Wednesday\tThursday\tFriday\tTotal\n" );

      double weekTotal = 0;  // initialize weekly total
      double salesTotal = 0; // initialize total sales

      // output the total sales
      salesJTextField.setText( dollars.format( salesTotal ) );

   } // end method displaySales

   // main method
   public static void main( String[] args ) 
   {
      SalesReport application = new SalesReport();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main

} // end class SalesReport

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