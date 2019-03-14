// Tutorial 7: DentalPayment.java
// This application calculates the total cost of the bill for a 
// patient at a dental office.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class DentalPayment extends JFrame
{
   // JLabel that displays header on application window
   private JLabel dentalPaymentFormJLabel;
   
   // JLabel and JTextField for patient name
   private JLabel patientNameJLabel;
   private JTextField patientNameJTextField;
   
   // JCheckBox and JLabel for cleaning
   private JCheckBox cleaningJCheckBox;
   private JLabel cleaningPriceJLabel;
   
   // JCheckBox and JLabel for cavity filling
   private JCheckBox cavityFillingJCheckBox;
   private JLabel cavityFillingPriceJLabel;
   
   // JCheckBox and JLabel for X-Ray
   private JCheckBox xRayJCheckBox;
   private JLabel xRayPriceJLabel;
   
   // JLabel and JTextField for total fee
   private JLabel totalJLabel;
   private JTextField totalJTextField;
   
   // JButton to initiate calculation of fee
   private JButton calculateJButton;
   
   // no-argument constructor
   public DentalPayment()
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

      // set up dentalPaymentFormJLabel
      dentalPaymentFormJLabel = new JLabel();
      dentalPaymentFormJLabel.setBounds( 19, 19, 235, 28 );
      dentalPaymentFormJLabel.setText( "Dental Payment Form" );
      dentalPaymentFormJLabel.setFont(
         new Font( "Default", Font.PLAIN, 22 ) );
      dentalPaymentFormJLabel.setHorizontalAlignment(
         JLabel.CENTER );
      contentPane.add( dentalPaymentFormJLabel );
      
      // set up patientNameJLabel
      patientNameJLabel = new JLabel();
      patientNameJLabel.setBounds( 19, 65, 91, 21 );
      patientNameJLabel.setText( "Patient name:" );
      contentPane.add( patientNameJLabel );
      
      // set up patientNameJTextField
      patientNameJTextField = new JTextField();
      patientNameJTextField.setBounds( 132, 65, 117, 21 );
      contentPane.add( patientNameJTextField );
      
      // set up cleaningJCheckBox
      cleaningJCheckBox = new JCheckBox();
      cleaningJCheckBox.setBounds( 16, 112, 122, 24 );
      cleaningJCheckBox.setText( "Cleaning" );
      contentPane.add( cleaningJCheckBox );
      
      // set up cleaningPriceJLabel
      cleaningPriceJLabel = new JLabel();
      cleaningPriceJLabel.setBounds( 211, 112, 38, 24 );
      cleaningPriceJLabel.setText( "$35" );
      cleaningPriceJLabel.setHorizontalAlignment( JLabel.RIGHT );
      contentPane.add( cleaningPriceJLabel );
      
      // set up cavityFillingJCheckBox
      cavityFillingJCheckBox = new JCheckBox();
      cavityFillingJCheckBox.setBounds( 16, 159, 122, 24 );
      cavityFillingJCheckBox.setText( "Cavity Filling" );
      contentPane.add( cavityFillingJCheckBox );
      
      // set up cavityFillingPriceJLabel
      cavityFillingPriceJLabel = new JLabel();
      cavityFillingPriceJLabel.setBounds( 211, 159, 38, 24 );
      cavityFillingPriceJLabel.setText( "$150" );
      cavityFillingPriceJLabel.setHorizontalAlignment(
         JLabel.RIGHT );
      contentPane.add( cavityFillingPriceJLabel );
      
      // set up xRayJCheckBox
      xRayJCheckBox = new JCheckBox();
      xRayJCheckBox.setBounds( 16, 206, 122, 24 );
      xRayJCheckBox.setText( "X-Ray" );
      contentPane.add( xRayJCheckBox );
      
      // set up xRayPriceJLabel
      xRayPriceJLabel = new JLabel();
      xRayPriceJLabel.setBounds( 211, 206, 38, 24 );
      xRayPriceJLabel.setText( "$85" );
      xRayPriceJLabel.setHorizontalAlignment( JLabel.RIGHT );
      contentPane.add( xRayPriceJLabel );
      
      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 144, 256, 41, 21 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );
      
      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 192, 256, 56, 21 );
      totalJTextField.setEditable( false );
      totalJTextField.setHorizontalAlignment( JTextField.CENTER );
      contentPane.add( totalJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 155, 296, 94, 24 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when user clicks calculateJButton
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Dental Payment" ); // set title bar string
      setSize( 272, 364 );          // set window size
      setVisible( true );           // display window
      
   } // end method createUserInterface
   
   // calculate cost of patient's visit
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // get patient's name
      String patient = patientNameJTextField.getText();
      
      // display error message if no name entered or 
      // no JCheckBox is selected
      if ( ( patient.equals( "" ) ) ||
         ( !cleaningJCheckBox.isSelected() && 
         !cavityFillingJCheckBox.isSelected() &&
         !xRayJCheckBox.isSelected() ) )
      {
         // display error message
         JOptionPane.showMessageDialog( null,
            "Please enter a name and check at least one item.",
            "Missing Information", JOptionPane.ERROR_MESSAGE );
      }
      else // otherwise, do calculations
      {
         double total = 0.0; // sum of all services provided

         // if patient had a cleaning
         if ( cleaningJCheckBox.isSelected() )
         {
            total += 35; // add 35 to total
         }
         
         // if patient had cavity filled
         if ( cavityFillingJCheckBox.isSelected() )
         {
            total += 150; // add 150 to total
         }
         
         // if patient had x-ray taken
         if ( xRayJCheckBox.isSelected() )
         {
            total += 85; // add 85 to total
         }
         
         // specify display format
         DecimalFormat dollars = new DecimalFormat( "$0.00" );

         // display total
         totalJTextField.setText( dollars.format( total ) ); 
         
      } // end else
      
   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      DentalPayment application = new DentalPayment();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   } // end method main
   
} // end class DentalPayment

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
