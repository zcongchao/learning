package carPayment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class CarPayment extends JFrame
{
	//声明变量
	private JLabel priceJLabel;
	
	private JTextField priceJTextField;

   // JLabel and JTextField for down payment
   private JLabel downPaymentJLabel;
   private JTextField downPaymentJTextField;

   // JLabel and JTextField for interest
   private JLabel interestJLabel;
   private JTextField interestJTextField;

   // JButton to initiate calculation
   private JButton calculateJButton;
   
   private JTextArea paymentsJTextArea;
   
   //构造函数
   public CarPayment()
   {
	   createUserInterface();
   }
   
   private void createUserInterface()
   {
	  Container  contentPane = getContentPane();
	  contentPane.setLayout(null);
	  
	  // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 40, 24, 80, 21 );
      priceJLabel.setText( "Price:" );
      contentPane.add( priceJLabel );
      
      // set up priceJTextField
      priceJTextField = new JTextField();
      priceJTextField.setBounds( 184, 24, 56, 21 );
      priceJTextField.setHorizontalAlignment( JTextField.RIGHT ); 
      contentPane.add( priceJTextField );

      // set up downPaymentJLabel
      downPaymentJLabel = new JLabel();
      downPaymentJLabel.setBounds( 40, 56, 96, 21 );
      downPaymentJLabel.setText( "Down payment:" );
      contentPane.add( downPaymentJLabel );
      
      // set up downPaymentJTextField
      downPaymentJTextField = new JTextField();
      downPaymentJTextField.setBounds( 184, 56, 56, 21 );
      downPaymentJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( downPaymentJTextField );
      
      // set up interestJLabel
      interestJLabel = new JLabel();
      interestJLabel.setBounds( 40, 88, 120, 21 );
      interestJLabel.setText( "Annual interest rate:" );
      contentPane.add( interestJLabel );
      
      // set up interestJTextField
      interestJTextField = new JTextField();
      interestJTextField.setBounds( 184, 88, 56, 21 );
      interestJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( interestJTextField );
      
      // set up calculateJButton and register its event handler
      calculateJButton = new JButton();
      calculateJButton.setBounds( 92, 128, 94, 24 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      
      calculateJButton.addActionListener
      (
    		  new ActionListener()
    		  {
    			  public void actionPerformed(ActionEvent event)
    			  {
    				  calculateJButtonActionPerformed( event );
    			  }
    		  }
    		  
       );
      
   // set up paymentsJTextArea
      paymentsJTextArea = new JTextArea();
      paymentsJTextArea.setBounds( 28, 168, 232, 90 );
      paymentsJTextArea.setEditable( false );
      contentPane.add( paymentsJTextArea );
      
   // set properties of application's window
      setTitle( "Car Payment Calculator" ); // set title bar text
      setSize( 288, 302 );                  // set window's size
      setVisible( true );                   // display window
      
      
      
   }
   
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
	   int years = 2;
	   int months;
	   double monthlyPayment;
	   
	   //clear paymentsJTextArea
	   paymentsJTextArea.setText("");
	   
	   paymentsJTextArea.append("Months\tMonthly Payments");
	   
	   int price = Integer.parseInt( priceJTextField.getText() );
	   int downPayment = Integer.parseInt( downPaymentJTextField.getText() );
       double interest = Double.parseDouble( interestJTextField.getText() );
       
       int loanAmount = price - downPayment;
       double monthlyInterest = interest / 1200;
       
       DecimalFormat currency = new DecimalFormat("$0.00");
       
       while (years <= 5)
       {
    	   
    	   months = 12 * years;
    	   
    	// get monthlyPayment         
           monthlyPayment = calculateMonthlyPayment( 
              monthlyInterest, months, loanAmount );

           // insert result into paymentsJTextArea
           paymentsJTextArea.append( "\n" + months + "\t" +
              currency.format( monthlyPayment ) );
           
           years++;  // increment counter

       }
	   
	   
   }
   
   private void clearJTextArea()
   {
      paymentsJTextArea.setText( "" ); // clear JTextArea contents
   }
   
   private double calculateMonthlyPayment(double monthlyInterest, 
		   int months, int loanAmount )
   {
	   double base = Math.pow( 1 + monthlyInterest, months );
	   return loanAmount * monthlyInterest / ( 1 - ( 1 / base ) );
   }

	

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		CarPayment application = new CarPayment();
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
