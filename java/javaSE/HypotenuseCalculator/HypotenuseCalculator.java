import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class HypotenuseCalculator extends JFrame
{
	// JLabel and JTextField for length of side A
	   private JLabel lengthSideAJLabel;
	   private JTextField lengthSideAJTextField;

	   // JLabel and JTextField for length of side B
	   private JLabel lengthSideBJLabel;
	   private JTextField lengthSideBJTextField;

	   // JLabel and JTextField for hypotenuse
	   private JLabel lengthHypotenuseJLabel;
	   private JTextField lengthHypotenuseJTextField;

	   // JButton to initiate calculation of hypotenuse
	   private JButton calculateJButton;
	   
	   // no-argument constructor
	   public HypotenuseCalculator()
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
		      
		      // set up lengthSideAJLabel
		      lengthSideAJLabel = new JLabel();
		      lengthSideAJLabel.setBounds( 16, 13, 96, 21 );
		      lengthSideAJLabel.setText( "Length of side A:" );
		      contentPane.add( lengthSideAJLabel );
		      
		      // set up lengthSideAJTextField
		      lengthSideAJTextField = new JTextField();
		      lengthSideAJTextField.setBounds( 150, 13, 90, 21 ); 
		      lengthSideAJTextField.setHorizontalAlignment(
		         JTextField.RIGHT );
		      contentPane.add( lengthSideAJTextField );
		      
		      // set up lengthSideBJLabel
		      lengthSideBJLabel = new JLabel();
		      lengthSideBJLabel.setBounds( 16, 45, 96, 21 );
		      lengthSideBJLabel.setText( "Length of side B:" );
		      contentPane.add( lengthSideBJLabel );
		      
		      // set up lengthSideBJTextField
		      lengthSideBJTextField = new JTextField();
		      lengthSideBJTextField.setBounds( 150, 45, 90, 21 );
		      lengthSideBJTextField.setHorizontalAlignment(
		         JTextField.RIGHT );
		      contentPane.add( lengthSideBJTextField );
		      
		      // set up lengthHypotenuseJLabel
		      lengthHypotenuseJLabel = new JLabel();
		      lengthHypotenuseJLabel.setBounds( 16, 89, 130, 21 );
		      lengthHypotenuseJLabel.setText( "Length of hypotenuse:" );
		      contentPane.add( lengthHypotenuseJLabel );
		      
		      // set up lengthHypotenuseJTextField
		      lengthHypotenuseJTextField = new JTextField();
		      lengthHypotenuseJTextField.setBounds( 150, 89, 90, 21 );
		      lengthHypotenuseJTextField.setHorizontalAlignment(
		         JTextField.CENTER );
		      lengthHypotenuseJTextField.setEditable( false );
		      contentPane.add( lengthHypotenuseJTextField );
		      
		      // set up calculateJButton
		      calculateJButton = new JButton();
		      calculateJButton.setBounds( 150, 121, 90, 23 );
		      calculateJButton.setText( "Calculate" );
		      contentPane.add( calculateJButton );
		      calculateJButton.addActionListener( 
		      
		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when calculateJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               calculateJButtonActionPerformed( event );
		            }
		            
		         } // end anonymous inner class
		         
		      ); // end call to addActionListener
		      
		      // set properties of application's window
		      setTitle( "Hypotenuse Calculator" ); // set title bar string
		      setSize( 262, 182 );                 // set window size
		      setVisible( true );                  // display window
		      
		   } // end method createUserInterface
	   private void calculateJButtonActionPerformed( ActionEvent event )
	   {
	      // get input from JTextFields
		  double sideA = Double.parseDouble(
	         lengthSideAJTextField.getText() );
		  double sideB = Double.parseDouble(
	         lengthSideBJTextField.getText() );

	      // display error message if user enters invalid input
	      if ( sideA <= 0 || sideB <= 0 )
	      {
	         JOptionPane.showMessageDialog( null,
	            "You must enter positive numbers",
	            "Invalid Input Entered", JOptionPane.ERROR_MESSAGE );
	      }
	      else
	      {
	         // calculate the squares of sides A and B
	         double squaredSideA = square( sideA );
	         double squaredSideB = square( sideB );
	         
	         // use the Pythagorean theorem to calculate
	         // square of the hypotenuse
	         double squaredHypotenuse = squaredSideA + squaredSideB;

	         // use built-in method Math.sqrt to calculate the square
	         // root of the hypotenuse squared (this is the hypotenuse)
	         double hypotenuse = Math.sqrt( squaredHypotenuse );
	         
	         DecimalFormat twoDigits = new DecimalFormat( "0.00" );

	         // format hypotenuse value
	         String hypotenuseText = twoDigits.format( hypotenuse );

	         // display hypotenuse in JTextField
	         lengthHypotenuseJTextField.setText( hypotenuseText );

	      } // end else
	      
	   } // end method calculateJButtonActionPerformed
	   
	   private double square(double side)
	   {
		   return side * side;
	   
	   }
	   
	   public static void main(String[] args )
	   {
		   HypotenuseCalculator application = new HypotenuseCalculator();
		   application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   }
	   

}
