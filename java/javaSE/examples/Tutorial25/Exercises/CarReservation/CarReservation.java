// Exercise 25.15: CarReservation.java
// This application allows users to input their names and
// reserve cars on various days.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;

public class CarReservation extends JFrame
{
   // JLabel and JSpinner to display date
   private JLabel selectDateJLabel;
   private JSpinner dateJSpinner;

   // JLabel and JTextField to display name
   private JLabel nameJLabel;
   private JTextField nameJTextField;

   // JButton to reserve car
   private JButton reserveCarJButton;

   // no-argument constructor
   public CarReservation()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      // set up selectDateJLabel
      selectDateJLabel = new JLabel();
      selectDateJLabel.setBounds( 16, 16, 96, 23 );
      selectDateJLabel.setText( "Select the date:" );
      contentPane.add( selectDateJLabel );

      // set up dateJSpinner
      dateJSpinner = new JSpinner( new SpinnerDateModel() );
      dateJSpinner.setBounds( 16, 43, 250, 23 );
      dateJSpinner.setEditor( new JSpinner.DateEditor( 
         dateJSpinner, "MM/dd/yyyy" ) ); 
      contentPane.add( dateJSpinner );
      dateJSpinner.addChangeListener(
      
         new ChangeListener() // anonymous inner class
         {
            // event handler called when dateJSpinner is changed
            public void stateChanged( ChangeEvent event )
            {
               dateJSpinnerChanged( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
            
      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setBounds( 16, 70, 100, 23 );
      nameJLabel.setText( "Name: " );
      contentPane.add( nameJLabel );
            
      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setBounds( 16, 97, 250, 23 );
      contentPane.add( nameJTextField );
      
      // set up reserveCarJButton
      reserveCarJButton = new JButton();
      reserveCarJButton.setBounds( 16, 130, 250, 23 );
      reserveCarJButton.setText( "Reserve Car" );
      contentPane.add( reserveCarJButton );
      reserveCarJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when reserveCarJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               reserveCarJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Car Reservation" ); // set title bar string
      setSize( 287, 190 );           // set window size
      setVisible( true );            // display window

   } // end method createUserInterface
   
   // write reservation to a file
   private void reserveCarJButtonActionPerformed( ActionEvent event )
   {
              
   } // end method reserveCarJButtonActionPerformed

   // enable reserveCarJButton
   private void dateJSpinnerChanged( ChangeEvent event )
   {
      reserveCarJButton.setEnabled( true );
   
   } // end method dateJSpinnerChanged
   
   // main method
   public static void main( String[] args )
   {
      CarReservation application = new CarReservation();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class CarReservation

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