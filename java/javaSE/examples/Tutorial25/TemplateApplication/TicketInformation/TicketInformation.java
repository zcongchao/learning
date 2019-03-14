// Tutorial 25: TicketInformation.java
// This application reads information about events on different dates
// from a file created by class WriteEvent.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;

public class TicketInformation extends JFrame
{
   // JLabel and JSpinner to display date
   private JLabel dateJLabel;
   private JSpinner dateJSpinner;

   // JLabel and JComboBox to display day's events
   private JLabel eventJLabel;
   private JComboBox eventJComboBox;

   // JLabel and JTextArea to display details of events
   private JLabel descriptionJLabel;
   private JTextArea descriptionJTextArea;

   // File selected by user 
   private File calendarFile;

   // instance variables to store event information and number
   private String[][] daysEvents = new String[ 10 ][ 5 ];
   private int eventNumber;
   
   // no-argument constructor
   public TicketInformation()
   {
      createUserInterface();

      createEventList(); // read file and display events on given day
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up dateJLabel
      dateJLabel = new JLabel();
      dateJLabel.setBounds( 16, 16, 121, 23 );
      dateJLabel.setText( "Select the day (1-31):" );
      contentPane.add( dateJLabel );

      // set up dateJSpinner
      dateJSpinner = new JSpinner( 
         new SpinnerNumberModel( 1, 1, 31, 1 ) );
      dateJSpinner.setBounds( 147, 16, 119, 23 );
      contentPane.add( dateJSpinner );
      dateJSpinner.addChangeListener(
      
         new ChangeListener() // anonymous inner class
         {
            // event handler called when dateJSpinner is changed
            public void stateChanged( ChangeEvent event )
            {
               dateJSpinnerStateChanged( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
            
      // set up eventJLabel
      eventJLabel = new JLabel();
      eventJLabel.setBounds( 16, 67, 100, 23 );
      eventJLabel.setText( "Pick an event: " );
      contentPane.add( eventJLabel );
      
      // set up eventJComboBox
      eventJComboBox = new JComboBox();
      eventJComboBox.setBounds( 16, 94, 250, 23 );
      eventJComboBox.addItem( "- No Events -" );
      contentPane.add( eventJComboBox );
      eventJComboBox.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when eventJComboBox is changed
            public void actionPerformed( ActionEvent event )
            {
               eventJComboBoxActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
            
      // set up descriptionJLabel
      descriptionJLabel = new JLabel();
      descriptionJLabel.setBounds( 16, 141, 100, 23 );
      descriptionJLabel.setText( "Description: " );
      contentPane.add( descriptionJLabel );
      
      // set up descriptionJTextArea
      descriptionJTextArea = new JTextArea();
      descriptionJTextArea.setBounds( 16, 168, 250, 125 );
      descriptionJTextArea.setText( "No events today." );
      descriptionJTextArea.setLineWrap( true );
      descriptionJTextArea.setWrapStyleWord( true );
      descriptionJTextArea.setEditable( false );
      contentPane.add( descriptionJTextArea );         
      
      // set properties of application's window
      setTitle( "Ticket Information" ); // set title bar string
      setSize( 292, 340 );              // set window size
      setVisible( true );               // display window

   } // end method createUserInterface
   
   // read event information from a file for a given date
   private void dateJSpinnerStateChanged( ChangeEvent event )
   {
     
   } // end method dateJSpinnerStateChanged

   // display event information
   private void eventJComboBoxActionPerformed( ActionEvent event )
   {

   } // end method eventJComboBoxActionPerformed

   // read events for current day and display events in application
   private void createEventList()
   {

   } // end method createEventList
   
   // read data from file
   private void extractData()
   {
             
   } // end method extractData
   
   // initialize daysEvents array
   private void initialize()
   {
      // for each of ten possible events per day
      for ( int i = 0; i <= 9; i++ )
      {
         // for each of five fields per event
         for ( int j = 0; j <= 4; j++ )
         {
            daysEvents[ i ][ j ] = "";
         }
      }
       
      daysEvents[ 0 ][ 3 ] = "- No Events -";
      daysEvents[ 0 ][ 4 ] = "No events today.";
   
   } // end method initialize 
   
   // main method
   public static void main( String[] args )
   {
      TicketInformation application = new TicketInformation();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class TicketInformation

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