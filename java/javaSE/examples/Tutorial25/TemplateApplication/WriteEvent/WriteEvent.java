// Tutorial 25: WriteEvent.java
// This application writes information about an event on a given 
// date to a file.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;

public class WriteEvent extends JFrame
{
   // JLabel and JSpinner to display day of month
   private JLabel dayJLabel;
   private JSpinner dayJSpinner;

   // JLabel and JSpinner to display time
   private JLabel timeJLabel;
   private JSpinner timeJSpinner;

   // JLabel and JTextField to display price
   private JLabel priceJLabel;
   private JTextField priceJTextField;

   // JLabel and JTextField to display event name
   private JLabel eventJLabel;
   private JTextField eventJTextField;

   // JLabel and JTextArea to display event description
   private JLabel descriptionJLabel;
   private JTextArea descriptionJTextArea;

   // JButtons to allow user to write to files
   private JButton openFileJButton;
   private JButton enterJButton;
   private JButton closeFileJButton;
   
   // no-argument constructor
   public WriteEvent()
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
      
      // set up dayJLabel
      dayJLabel = new JLabel();
      dayJLabel.setBounds( 20, 16, 75, 23 );
      dayJLabel.setText( "Day:" );
      contentPane.add( dayJLabel );
      
      // set up dayJSpinner
      dayJSpinner = new JSpinner(
         new SpinnerNumberModel( 1, 1, 31, 1 ) );
      dayJSpinner.setBounds( 108, 16, 150, 23 );
      contentPane.add( dayJSpinner );
      
      // set up timeJLabel
      timeJLabel = new JLabel();
      timeJLabel.setBounds( 20, 46, 75, 23 );
      timeJLabel.setText( "Time:" );
      contentPane.add( timeJLabel );
      
      // set up timeJSpinner
      timeJSpinner = new JSpinner( new SpinnerDateModel() );
      timeJSpinner.setBounds( 108, 46, 150, 23 );
      timeJSpinner.setEditor( 
         new JSpinner.DateEditor( timeJSpinner, "HH:mm" ) );
      contentPane.add( timeJSpinner );
      
      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 20, 76, 75, 23 );
      priceJLabel.setText( "Price:" );
      contentPane.add( priceJLabel );
      
      // set up priceJTextField
      priceJTextField = new JTextField();
      priceJTextField.setBounds( 108, 76, 150, 23 );
      contentPane.add( priceJTextField );
      
      // set up eventJLabel
      eventJLabel = new JLabel();
      eventJLabel.setBounds( 20, 106, 75, 23 );
      eventJLabel.setText( "Event:" );
      contentPane.add( eventJLabel );
      
      // set up eventJTextField
      eventJTextField = new JTextField();
      eventJTextField.setBounds( 108, 106, 150, 23 );
      contentPane.add( eventJTextField );
      
      // set up descriptionJLabel
      descriptionJLabel = new JLabel();
      descriptionJLabel.setBounds( 20, 136, 75, 23 );
      descriptionJLabel.setText( "Description:" );
      contentPane.add( descriptionJLabel );
   
      // set up descriptionJTextArea
      descriptionJTextArea = new JTextArea();
      descriptionJTextArea.setBounds( 108, 136, 150, 125 );
      descriptionJTextArea.setLineWrap( true );
      descriptionJTextArea.setWrapStyleWord( true );
      contentPane.add( descriptionJTextArea );
      
      // set up openFileJButton
      openFileJButton = new JButton();
      openFileJButton.setBounds( 5, 275, 100, 40 );
      openFileJButton.setText( "Open File..." );
      contentPane.add( openFileJButton );
      openFileJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when openFileJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               openFileJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
      
      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setBounds( 106, 275, 80, 40 );
      enterJButton.setText( "Enter" );
      enterJButton.setEnabled( false );
      contentPane.add( enterJButton );
      enterJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when enterJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               enterJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
      
      // set up closeFileJButton
      closeFileJButton = new JButton();
      closeFileJButton.setBounds( 186, 275, 95, 40 );
      closeFileJButton.setText( "Close File" );
      closeFileJButton.setEnabled( false );
      contentPane.add( closeFileJButton );
      closeFileJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when closeFileJButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               closeFileJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener            
      
      // set properties of application's window
      setTitle( "WriteEvent" ); // set title bar string
      setSize( 290, 345 );      // set window size
      setVisible( true );       // display window

   } // end method createUserInterface

   // open a file for writing
   private void openFileJButtonActionPerformed( ActionEvent event )
   {
       
   } // end method openFileJButtonActionPerformed
   
   // save data entered to specified file
   private void enterJButtonActionPerformed( ActionEvent event )
   {
   
   } // end method enterJButtonActionPerformed
   
   // file is closed after user is finished with it
   private void closeFileJButtonActionPerformed( ActionEvent event )
   {      
      // reset state of JButtons
      enterJButton.setEnabled( false );
      openFileJButton.setEnabled( true );
      closeFileJButton.setEnabled( false );
   
      // clear JTextFields
      resetUserInput();
   
   } // end method closeFileJButtonActionPerformed

   // clear JTextFields
   private void resetUserInput()
   {
      priceJTextField.setText( "" );
      eventJTextField.setText( "" );
      descriptionJTextArea.setText( "" );
   
   } // end method resetUserInput
   
   // main method
   public static void main( String[] args )
   {
      WriteEvent application = new WriteEvent();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class WriteEvent

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