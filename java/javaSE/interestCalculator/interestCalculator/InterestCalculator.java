package interestCalculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class InterestCalculator extends JFrame
{
	
	// JLabel and JTextField for principal invested
	   private JLabel principalJLabel;
	   private JTextField principalJTextField;

	   // JLabel and JTextField for interest rate
	   private JLabel interestRateJLabel;
	   private JTextField interestRateJTextField;

	   // JLabel and JTextField for the number of years
	   private JLabel yearsJLabel;
	   private JSpinner yearsJSpinner;

	   // JLabel and JTextArea display amount on deposit at
	   // the end of each year up to number of years entered
	   private JLabel yearlyBalanceJLabel;
	   private JTextArea yearlyBalanceJTextArea;

	   // JScrollPane adds scrollbars to JTextArea for lengthy output
	   private JScrollPane yearlyBalanceJScrollPane;

	   // JButton calculates amount on deposit at the
	   // end of each year up to number of years entered
	   private JButton calculateJButton;

	   // no-argument constructor
	   public InterestCalculator()
	   {
	      createUserInterface();
	   }
	   
	   private void createUserInterface()
	   {
		   // get content pane for attaching GUI components
		      Container contentPane = getContentPane();

		      // enable explicit positioning of GUI components
		      contentPane.setLayout( null );

		      // set up principalJLabel
		      principalJLabel = new JLabel();
		      principalJLabel.setBounds( 16, 16, 56, 24 );
		      principalJLabel.setText( "Principal:" );
		      contentPane.add( principalJLabel );

		      // set up principalJTextField
		      principalJTextField = new JTextField();
		      principalJTextField.setBounds( 100, 16, 100, 24 );
		      principalJTextField.setHorizontalAlignment(
		         JTextField.RIGHT );
		      contentPane.add( principalJTextField );
		      
		      // set up interestRateJLabel
		      interestRateJLabel = new JLabel();
		      interestRateJLabel.setBounds( 16, 56, 80, 24 );
		      interestRateJLabel.setText( "Interest rate:" );
		      contentPane.add( interestRateJLabel );

		      // set up interestRateJTextField
		      interestRateJTextField = new JTextField();
		      interestRateJTextField.setBounds( 100, 56, 100, 24 );
		      interestRateJTextField.setHorizontalAlignment(
		         JTextField.RIGHT );
		      contentPane.add( interestRateJTextField );
		      
		      // set up yearsJLabel
		      yearsJLabel = new JLabel();
		      yearsJLabel.setBounds( 16, 96, 48, 24 );
		      yearsJLabel.setText( "Years:" );
		      contentPane.add( yearsJLabel );
		      
		      yearsJSpinner = new JSpinner( new SpinnerNumberModel( 1, 1, 10, 1 ));
		      yearsJSpinner.setBounds( 100, 96, 100, 24 );
		      contentPane.add( yearsJSpinner );
		      
		   // set up yearlyBalanceJLabel
		      yearlyBalanceJLabel = new JLabel();
		      yearlyBalanceJLabel.setBounds( 16, 136, 150, 24 );
		      yearlyBalanceJLabel.setText( "Yearly account balance:" );
		      contentPane.add( yearlyBalanceJLabel );

		      // set up yearlyBalanceJTextArea
		      yearlyBalanceJTextArea = new JTextArea();
		      yearlyBalanceJTextArea.setEditable( false );
		      
		      // set up yearlyBalanceJScrollPane
		      yearlyBalanceJScrollPane = new JScrollPane(
		         yearlyBalanceJTextArea );
		      yearlyBalanceJScrollPane.setBounds( 16, 160, 300, 92 );
		      contentPane.add( yearlyBalanceJScrollPane );

		      // set up calculateJButton
		      calculateJButton = new JButton();
		      calculateJButton.setBounds( 216, 16, 100, 24 );
		      calculateJButton.setText( "Calculate" );
		      contentPane.add( calculateJButton );
		      calculateJButton.addActionListener(
		      
		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when calculateJButton is clicked
		            public void actionPerformed( ActionEvent event )
		            {
		               calculateJButtonActionPerformed( event );
		            }
		            
		         } // end anonymous inner class
		         
		      ); // end call to addActionListener

		      
		      // set properties of application's window
		      setTitle( "Interest Calculator" ); // set title bar text
		      setSize( 340, 296 );               // set window size
		      setVisible( true );                // display window

	   }
	   
	   // 计算总数
	   private void calculateJButtonActionPerformed ( ActionEvent event )
	   {
		   double principal = Double.parseDouble(principalJTextField.getText());
		   double rate = Double.parseDouble(interestRateJTextField.getText());
		   
		   Integer integerObject = ( Integer ) yearsJSpinner.getValue();
		   int year = integerObject.intValue();
		   
		   yearlyBalanceJTextArea.setText( "Year\tAmount on Deposit" );
		      DecimalFormat dollars = new DecimalFormat( "$0.00" );
		   
		   for ( int count = 1; count <= year; count++ )
		   {
			   double amount = 
			            principal * Math.pow( ( 1 + rate / 100 ), count );
			         yearlyBalanceJTextArea.append( "\n" + count + "\t" + 
			            dollars.format( amount ) );
		   }
		   
		   
	   }

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		InterestCalculator application = new InterestCalculator();
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
