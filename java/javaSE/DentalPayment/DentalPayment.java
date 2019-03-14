//Tutorial 7: DentalPayment.java
// This application calculates the total cost of the bill for a 
// patient at a dental office.

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;



public class DentalPayment  extends JFrame
{
	//JLabel that displays header on application window
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
	   
   public DentalPayment(){
	   
	   createUserInterface();
   }
   
   private void createUserInterface()
   {
	   Container contentPane = getContentPane();
	   contentPane.setLayout( null );
	   
	   // set up dentalPaymentFormJLabel
	   dentalPaymentFormJLabel = new JLabel();
	   dentalPaymentFormJLabel.setBounds( 19, 19, 235, 28 );
	   dentalPaymentFormJLabel.setText( "Dental Payment Form" );
	   dentalPaymentFormJLabel.setFont(
		         new Font( "Default", Font.PLAIN, 22 ) );
	   dentalPaymentFormJLabel.setHorizontalAlignment(
		         JLabel.CENTER );
	   contentPane.add(dentalPaymentFormJLabel);
	   
	   //set up patientNameJLabel
	   patientNameJLabel = new JLabel();
       patientNameJLabel.setBounds( 19, 65, 91, 21 );
	   patientNameJLabel.setText( "Patient name:" );
	   contentPane.add( patientNameJLabel );
	   
	   //文本框
	   patientNameJTextField = new JTextField();
	   patientNameJTextField.setBounds( 132, 65, 117, 21 );
	   contentPane.add( patientNameJTextField );
	   
	   //set up cleaningJCheckBox
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
	   //set up cavityFillingPriceJLabel
	   cavityFillingPriceJLabel = new JLabel();
	   cavityFillingPriceJLabel.setBounds( 211, 159, 38, 24 );
	   cavityFillingPriceJLabel.setText( "$150" );
	   cavityFillingPriceJLabel.setHorizontalAlignment(
		         JLabel.RIGHT );
	   contentPane.add(cavityFillingPriceJLabel);
	   
	   //set up xRayJCheckBox
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
      
      //set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds(155, 296, 94, 24 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
    		  
		 new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 calculateJButtonActionPerformed( event);
			 }
		 }
    		  
	  );
      
      //set properties of application's window
      setTitle( "Dental Payment" ); // set title bar string
      setSize( 272, 364 );          // set window size
      setVisible( true );           // display window
     	   
   }
   
   //计算模块
   private void calculateJButtonActionPerformed( ActionEvent event)
   {
	  //获取客户姓名
	   String patient = patientNameJTextField.getText();
	   
	   //display error message if no name entered or 
	// no JCheckBox is selected
	   if ( (patient.equals("") ) || ( !cleaningJCheckBox.isSelected() && !!cavityFillingJCheckBox.isSelected() &&
		         !xRayJCheckBox.isSelected() ) )
	   {
		   JOptionPane.showMessageDialog(null, 
				   "Please enter a name and check at least one item.",
		            "Missing Information", JOptionPane.ERROR_MESSAGE );
	   }
	   else
	   {
		  double total = 0.0;
		  
		  // if patient had a cleaning
		  if ( cleaningJCheckBox.isSelected() )
		  {
			  total += 35;
		  }
		  
		  if (cavityFillingJCheckBox.isSelected())
		  {
			  total += 150;
		  }
		  
		  if ( xRayJCheckBox.isSelected() )
		  {
			  total += 85;
		  }
		  
		  DecimalFormat dollars = new DecimalFormat( "$0.00" );
		  
		  totalJTextField.setText(dollars.format( total ));
	   }
		      
   }
	
	

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		DentalPayment application = new DentalPayment();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
