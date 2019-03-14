// Tutorial 12: Maximum.java
// Program finds and displays the greatest value entered by the user.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maximum extends JFrame
{
   // JLabel and JTextField for first value
   private JLabel firstValueJLabel;
   private JTextField firstValueJTextField;

   // JLabel and JTextField for second value
   private JLabel secondValueJLabel;
   private JTextField secondValueJTextField;

   // JLabel and JTextField for third value
   private JLabel thirdValueJLabel;
   private JTextField thirdValueJTextField;

   // JLabel and JTextField for maximum of three values entered
   private JLabel maximumJLabel;
   private JTextField maximumJTextField;

   // JButton initiates finding the maximum value
   private JButton maximumJButton;
   
   // no-argument constructor
   public Maximum()
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
      
      // set up firstValueJLabel
      firstValueJLabel = new JLabel();
      firstValueJLabel.setBounds( 16, 16, 100, 24 );
      firstValueJLabel.setText( "First value:" );
      contentPane.add( firstValueJLabel );
      
      // set up firstValueJTextField
      firstValueJTextField = new JTextField();
      firstValueJTextField.setBounds( 104, 16, 90, 24 );
      firstValueJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( firstValueJTextField );
      
      // lset up secondValueJLabel
      secondValueJLabel = new JLabel(); 
      secondValueJLabel.setBounds( 16, 56, 120, 24 );
      secondValueJLabel.setText( "Second value:" );
      contentPane.add( secondValueJLabel );
      
      // set up secondValueJTextField
      secondValueJTextField = new JTextField();
      secondValueJTextField.setBounds( 104, 56, 90, 24 );
      secondValueJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( secondValueJTextField );
      
      // set up thirdValueJLabel
      thirdValueJLabel = new JLabel();
      thirdValueJLabel.setBounds( 16, 96, 120, 24 );
      thirdValueJLabel.setText( "Third value:" );
      contentPane.add( thirdValueJLabel );
      
      // set up thirdValueJTextField
      thirdValueJTextField = new JTextField();
      thirdValueJTextField.setBounds( 104, 96, 90, 24 );
      thirdValueJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( thirdValueJTextField );
      
      // set up maximumJLabel
      maximumJLabel = new JLabel();
      maximumJLabel.setBounds( 16, 152, 100, 24 );
      maximumJLabel.setText( "Maximum:" );
      contentPane.add( maximumJLabel );
      
      // set up maximumJTextField
      maximumJTextField = new JTextField();
      maximumJTextField.setBounds( 104, 152, 90, 24 );
      maximumJTextField.setHorizontalAlignment( JTextField.CENTER );
      maximumJTextField.setEditable( false );
      contentPane.add( maximumJTextField );
      
      // set up maximumJButton
      maximumJButton = new JButton();
      maximumJButton.setBounds( 104, 192, 90, 24 );
      maximumJButton.setText( "Maximum" );
      contentPane.add( maximumJButton );
      maximumJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when maximumJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               maximumJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Maximum" ); // set title bar string
      setSize( 220, 258 );   // set window size
      setVisible( true );    // display window
      
   } // end method createUserInterface
   
   // get user input, call method maximum, and display the maximum
   private void maximumJButtonActionPerformed( ActionEvent event )
   {
      // convert user input to double
      double first = Double.parseDouble(
         firstValueJTextField.getText() );
      double second = Double.parseDouble(
         secondValueJTextField.getText() );
      double third = Double.parseDouble(
         thirdValueJTextField.getText() );

      // call method to find maximum of three values
      double maximum = determineMaximum( first, second, third );

      maximumJTextField.setText( String.valueOf( maximum ) );
      
   } // end method maximumJButtonActionPerformed
   
   // returns the largest of three values
   private double determineMaximum(
      double one, double two, double three )
   {
      double temporary = Math.max( one, two );
      double maximumValue = Math.max( temporary, three );
      
      return maximumValue;
      
   } // end method determineMaximum
   
   // main method
   public static void main( String[] args )
   {
      Maximum application = new Maximum();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class Maximum

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