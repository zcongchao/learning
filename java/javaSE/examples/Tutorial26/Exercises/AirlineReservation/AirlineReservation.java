// Exercise 26.13: AirlineReservation.java
// Displays flight information.
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AirlineReservation extends JFrame 
{
   // JLabel and JComboBox for Choose a Flight
   private JLabel chooseFlightJLabel;
   private JComboBox chooseFlightJComboBox;

   // JButton for View Flight Information
   private JButton flightInfoJButton;

   // JPanel for displaying flight information
   private JPanel flightInfoJPanel;

   // JLabel and JTextField for Date
   private JLabel dateJLabel;
   private JTextField dateJTextField;

   // JLabel and JTextField for Departure City
   private JLabel departureCityJLabel;
   private JTextField departureCityJTextField;

   // JLabel and JTextField for Arrival City
   private JLabel arrivalCityJLabel;
   private JTextField arrivalCityJTextField;

   // JPanel and JTextArea for displaying passenger list
   private JPanel passengerListJPanel;
   private JTextArea displayJTextArea;

   // declare instance variables for database processing
   private Connection myConnection;
   private Statement myStatement;
   private ResultSet myResultSet;
   
   // constructor
   public AirlineReservation(
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

      // set up chooseFlightJLabel
      chooseFlightJLabel = new JLabel();
      chooseFlightJLabel.setBounds( 24, 16, 100, 16 );
      chooseFlightJLabel.setText( "Choose a Flight:" );
      contentPane.add( chooseFlightJLabel );

      // set up chooseFlightJComboBox
      chooseFlightJComboBox = new JComboBox();
      chooseFlightJComboBox.setBounds( 130, 16, 72, 25 );
      chooseFlightJComboBox.addItem( "" );
      contentPane.add( chooseFlightJComboBox );

      // load flight numbers into chooseFlightJComboBox
      loadFlightNumbers();

      // set up flightInfoJButton
      flightInfoJButton = new JButton();
      flightInfoJButton.setBounds( 230, 16, 150, 30 );
      flightInfoJButton.setText( "View Flight Information" );
      flightInfoJButton.setBorder( 
         BorderFactory.createRaisedBevelBorder() );
      contentPane.add( flightInfoJButton );
      flightInfoJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when flightInfoJButton is clicked
            public void actionPerformed( ActionEvent event ) 
            {
               flightInfoJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end addActionListener

      // set up flightInformationJPanel
      createFlightInfoJPanel();
      contentPane.add( flightInfoJPanel );
      
      // set properties of application's window
      setTitle( "Airline Reservation" ); // set title bar string
      setSize( 410, 250 );               // set window size
      setVisible( true );                // display window

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

   // set up flightInformationJPanel
   private void createFlightInfoJPanel()
   {
      // set up flightInfoJPanel
      flightInfoJPanel = new JPanel();
      flightInfoJPanel.setBounds( 15, 56, 370, 152 );
      flightInfoJPanel.setBorder( BorderFactory.createTitledBorder( 
         BorderFactory.createEtchedBorder(),
         "Flight Information" ) );
      flightInfoJPanel.setLayout( null );

      // set up dateJLabel
      dateJLabel = new JLabel();
      dateJLabel.setBounds( 16, 32, 100, 16 );
      dateJLabel.setText( "Date:" );
      flightInfoJPanel.add( dateJLabel );

      // set up dateJTextField
      dateJTextField = new JTextField();
      dateJTextField.setBounds( 116, 32, 88, 20 );
      dateJTextField.setEditable( false );
      dateJTextField.setBorder( 
         BorderFactory.createLoweredBevelBorder() );
      flightInfoJPanel.add( dateJTextField );

      // set up depatureCityJLabel
      departureCityJLabel = new JLabel();
      departureCityJLabel.setBounds( 16, 64, 100, 16 );
      departureCityJLabel.setText( "Departure City:" );
      flightInfoJPanel.add( departureCityJLabel );

      // set up departureCityJTextField
      departureCityJTextField = new JTextField();
      departureCityJTextField.setBounds( 116, 64, 88, 20 );
      departureCityJTextField.setEditable( false );
      departureCityJTextField.setBorder(
         BorderFactory.createLoweredBevelBorder() );
      flightInfoJPanel.add( departureCityJTextField );

      // set up arrivalCityJLabel
      arrivalCityJLabel = new JLabel();
      arrivalCityJLabel.setBounds( 16, 96, 100, 16 );
      arrivalCityJLabel.setText( "Arrival City:" );
      flightInfoJPanel.add( arrivalCityJLabel );
  
      // set up arrivalCityJTextField
      arrivalCityJTextField = new JTextField();
      arrivalCityJTextField.setBounds( 116, 96, 88, 20 );
      arrivalCityJTextField.setEditable( false );
      arrivalCityJTextField.setBorder(
         BorderFactory.createLoweredBevelBorder() );
      flightInfoJPanel.add( arrivalCityJTextField );

      // set up passengerListJPanel
      createPassengerListJPanel();
      flightInfoJPanel.add( passengerListJPanel );

   } // end method createFlightInfoJPanel

   // set up passengerListJPanel
   private void createPassengerListJPanel()
   {
      // set up passengerListJPanel
      passengerListJPanel = new JPanel();
      passengerListJPanel.setBounds( 220, 16, 128, 120 );
      passengerListJPanel.setBorder( 
         BorderFactory.createTitledBorder( 
         BorderFactory.createEtchedBorder(), 
         "Passenger List" ) );
      passengerListJPanel.setLayout( null );

      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 16, 24, 96, 82 );
      displayJTextArea.setEditable( false );
      displayJTextArea.setBorder(
         BorderFactory.createLoweredBevelBorder() );  
      passengerListJPanel.add( displayJTextArea );   

   } // end method createPassengerListJPanel

   // load flight numbers into chooseFlightJComboBox
   private void loadFlightNumbers()
   {
      
   } // end method loadFlightNumbers

   // user click View Flight Information JButton
   private void flightInfoJButtonActionPerformed( ActionEvent event )
   {
      
   } // end flightInfoJButtonActionPerformed

   // display flight information
   private void displayFlightInformation( String flightNumber )
   {

   } // end method displayFlightInformation

   // user close window
   private void frameWindowClosing( WindowEvent event )
   {

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

         // create new AirlineReservation
         AirlineReservation application = new AirlineReservation(
            databaseDriver, databaseURL );
      }
      else
      {
         System.out.println( "Usage: java AirlineReservation " + 
            "databaseDriver databaseURL" );
      }      

   } // end method main

} // end class AirlineReservation

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