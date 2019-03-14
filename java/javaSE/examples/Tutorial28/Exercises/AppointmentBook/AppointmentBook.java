// Exercise 28.11: AppointmentBook.java
// An application that announces the date and time of appointments
// with FreeTTS.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AppointmentBook extends JFrame
{
   // JLabel and JTextField for the name of the person that the
   // appointment will be with
   private JLabel appointmentWithJLabel;
   private JTextField appointmentWithJTextField;
   
   // JLabel, JSpinner, and DateEditor for the date of the
   // appointment
   private JLabel appointmentDateJLabel;
   private JSpinner appointmentDateJSpinner;
   private JSpinner.DateEditor dateFormat;
   
   // JLabel and JTextField for the time of the appointment
   private JLabel appointmentTimeJLabel;
   private JTextField appointmentTimeJTextField;

   // JButton to add an appointment
   private JButton addJButton;

   // JButton to get appointment
   private JButton getAppointmentJButton;

   // arrays to store the month
   private final String[] threeLettersMonths = { 
      "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", 
      "Sep", "Oct", "Nov", "Dec" };
   private final String[] months = { "January", "February", "March",
      "April", "May", "June", "July", "August", "September", 
      "October", "November", "December" };

   // arrays to store the dates
   private final String[] threeLettersDays = 
      { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
   private final String[] days = { "Sunday", "Monday", "Tuesday",
      "Wednesday", "Thursday", "Friday", "Saturday" };

   // no-argument constructor
   public AppointmentBook()
   {
      createUserInterface(); // set up GUI

   } // end constructor

   // create and position GUI components; register event handler
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );

      // set up appointmentWithJLabel
      appointmentWithJLabel = new JLabel();
      appointmentWithJLabel.setBounds( 16, 16, 106, 23 );
      appointmentWithJLabel.setText( "Appointment With:" );
      contentPane.add( appointmentWithJLabel );

      // set up appointmentWithJTextField
      appointmentWithJTextField = new JTextField();
      appointmentWithJTextField.setBounds( 128, 16, 136, 21 );
      appointmentWithJTextField.setText( "" );
      contentPane.add( appointmentWithJTextField );

      // set up appointmentDateJLabel
      appointmentDateJLabel = new JLabel();
      appointmentDateJLabel.setBounds( 16, 48, 106, 23 );
      appointmentDateJLabel.setText( "Appointment Date:" );
      contentPane.add( appointmentDateJLabel );
      
      // set up appointmentDateJSpinner
      SpinnerModel model = new SpinnerDateModel();
      appointmentDateJSpinner = new JSpinner ( model );
      dateFormat = new JSpinner.DateEditor( appointmentDateJSpinner,
         "MM/dd/yyyy" );
      appointmentDateJSpinner.setEditor( dateFormat );
      appointmentDateJSpinner.setBounds( 128, 48, 136, 21 );
      contentPane.add( appointmentDateJSpinner );

      // set up appointmentTimeJLabel
      appointmentTimeJLabel = new JLabel();
      appointmentTimeJLabel.setBounds( 16, 80, 106, 23 );
      appointmentTimeJLabel.setText( "Appointment Time:" );
      contentPane.add( appointmentTimeJLabel );
      
      // set up appointmentTimeJTextField
      appointmentTimeJTextField = new JTextField();
      appointmentTimeJTextField.setBounds( 128, 80, 136, 21 );
      appointmentTimeJTextField.setText( "" );
      contentPane.add( appointmentTimeJTextField );

      // set up addJButton
      addJButton = new JButton();
      addJButton.setBounds( 20, 112, 75, 23 );
      addJButton.setText( "Add" );
      contentPane.add( addJButton );
      addJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when addJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set up getAppointmentJButton
      getAppointmentJButton = new JButton();
      getAppointmentJButton.setBounds( 100, 112, 150, 23 );
      getAppointmentJButton.setText( "Get Appointment" );
      contentPane.add( getAppointmentJButton );
      getAppointmentJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when getAppointmentJButton
            // is clicked
            public void actionPerformed( ActionEvent event )
            {
               getAppointmentJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of the application's window
      setTitle( "Appointment Book" ); // set title bar string
      setSize( 280, 176 );            // set window size
      setVisible( true );             // display window

      // ensure synthesizer is cleaned up
      // when user closes application
      addWindowListener(

         new WindowAdapter()  // anonymous inner class
         {
            public void windowClosing( WindowEvent event )
            {
               frameWindowClosing( event );
            }

         } // end anonymous inner class

      ); // end addWindowListener

   } // end method createUserInterface

   // add an appointment
   private void addJButtonActionPerformed( ActionEvent event )
   {

   } // end method addJButtonActionPerformed

   // speak an appointment
   private void getAppointmentJButtonActionPerformed( 
      ActionEvent event )
   {

   } // end method getAppointmentActionPerformed

   // parse date returned by JPinner
   private String parseDate( String dateToParse )
   {
      // get day 
      String day = parseDay( dateToParse.substring( 0, 3 ) );

      // get month
      String month = parseMonth( dateToParse.substring( 4, 7 ) );

      return day + " " + month + " " + 
         dateToParse.substring( 8, 10) + " " +
         dateToParse.substring( 24, 28 );

   } // end method parseDate

   // parse day 
   private String parseDay( String dayToParse )
   {
      // get day
      for ( int i = 0; i < threeLettersDays.length; i ++ )
      {
         // find a match
         if ( dayToParse.equals( threeLettersDays[ i ] ) )
         {
            return days[ i ];  // return the day
         }
      }

      return "";

   } // end method parseDay

   // parse month
   private String parseMonth( String monthToParse )
   {
      // get month
      for ( int i = 0; i < threeLettersMonths.length; i ++ )
      {
         // find a match
         if ( monthToParse.equals( threeLettersMonths[ i ] ) )
         {
            return months[ i ];  // return the day
         }
      }

      return "";

   } // end method parseMonth

   // clean up synthesizer
   private void frameWindowClosing( WindowEvent event )
   {

   }  // end method frameWindowClosing

   // main method
   public static void main( String[] args ) 
   {
      AppointmentBook application = new AppointmentBook();

   } // end method main

} // end class AppointmentBook

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
