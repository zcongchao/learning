import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;


public class SecurityPanel extends JFrame
{
	// JLabel and JPasswordField for user to input security code
	   private JLabel securityCodeJLabel;
	   private JPasswordField securityCodeJPasswordField;

	   // JButtons to represent security keypad
	   private JButton oneJButton;
	   private JButton twoJButton;
	   private JButton threeJButton;
	   private JButton fourJButton;
	   private JButton fiveJButton;
	   private JButton sixJButton;
	   private JButton sevenJButton;
	   private JButton eightJButton;
	   private JButton nineJButton;
	   private JButton clearJButton;
	   private JButton zeroJButton;
	   private JButton enterJButton;

	   // JLabel, JTextArea and JScrollPane to display access log
	   private JLabel accessLogJLabel;
	   private JTextArea accessLogJTextArea;
	   private JScrollPane accessLogJScrollPane;

	   // no-argument constructor
	   public SecurityPanel()
	   {
	      createUserInterface();
	   }
	   
	   private void createUserInterface()
	   {
		// get content pane for attaching GUI components
		      Container contentPane = getContentPane();
		      
		      // enable explicit positioning of GUI components
		      contentPane.setLayout( null );

		      // set up securityCodeJLabel
		      securityCodeJLabel = new JLabel();
		      securityCodeJLabel.setBounds( 16, 16, 90, 21 );
		      securityCodeJLabel.setText( "Security code:" );
		      contentPane.add( securityCodeJLabel );

		      // set up securityCodeJPasswordField
		      securityCodeJPasswordField = new JPasswordField();
		      securityCodeJPasswordField.setBounds( 114, 16, 172, 26 );
		      securityCodeJPasswordField.setEditable( false );
		      contentPane.add( securityCodeJPasswordField );
		      
		   // set up oneJButton
		      oneJButton = new JButton();
		      oneJButton.setBounds( 80, 64, 50, 50 );
		      oneJButton.setText( "1" );
		      contentPane.add( oneJButton );
		      oneJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when oneJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               oneJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener
		      
		   // set up twoJButton
		      twoJButton = new JButton();
		      twoJButton.setBounds( 130, 64, 50, 50 );
		      twoJButton.setText( "2" );
		      contentPane.add( twoJButton );
		      twoJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when twoJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               twoJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up threeJButton
		      threeJButton = new JButton();
		      threeJButton.setBounds( 180, 64, 50, 50 );
		      threeJButton.setText( "3" );
		      contentPane.add( threeJButton );
		      threeJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when threeJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               threeJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up fourJButton
		      fourJButton = new JButton();
		      fourJButton.setBounds( 80, 114, 50, 50 );
		      fourJButton.setText( "4" );
		      contentPane.add( fourJButton );
		      fourJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when fourJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               fourJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up fiveJButton
		      fiveJButton = new JButton();
		      fiveJButton.setBounds( 130, 114, 50, 50 );
		      fiveJButton.setText( "5" );
		      contentPane.add( fiveJButton );
		      fiveJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when fiveJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               fiveJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up sixJButton
		      sixJButton = new JButton();
		      sixJButton.setBounds( 180, 114, 50, 50 );
		      sixJButton.setText( "6" );
		      contentPane.add( sixJButton );
		      sixJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when sixJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               sixJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up sevenJButton
		      sevenJButton = new JButton();
		      sevenJButton.setBounds( 80, 164, 50, 50 );
		      sevenJButton.setText( "7" );
		      contentPane.add( sevenJButton );
		      sevenJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when sevenJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               sevenJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up eightJButton
		      eightJButton = new JButton();
		      eightJButton.setBounds( 130, 164, 50, 50 );
		      eightJButton.setText( "8" );
		      contentPane.add( eightJButton );
		      eightJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when eightJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               eightJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up nineJButton
		      nineJButton = new JButton();
		      nineJButton.setBounds( 180, 164, 50, 50 );
		      nineJButton.setText( "9" );
		      contentPane.add( nineJButton );
		      nineJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when nineJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               nineJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up clearJButton
		      clearJButton = new JButton();
		      clearJButton.setBounds( 80, 214, 50, 50 );
		      clearJButton.setText( "C" );
		      contentPane.add( clearJButton );
		      clearJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when clearJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               clearJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up zeroJButton
		      zeroJButton = new JButton();
		      zeroJButton.setBounds( 130, 214, 50, 50 );
		      zeroJButton.setText( "0" );
		      contentPane.add( zeroJButton );
		      zeroJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when zeroJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               zeroJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up enterJButton
		      enterJButton = new JButton();
		      enterJButton.setBounds( 180, 214, 50, 50 );
		      enterJButton.setText( "#" );
		      contentPane.add( enterJButton );
		      enterJButton.addActionListener(

		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when enterJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               enterJButtonActionPerformed( event );
		            }

		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up accessLogJLabel
		      accessLogJLabel = new JLabel();
		      accessLogJLabel.setBounds( 16, 285, 100, 16 );
		      accessLogJLabel.setText( "Access log:" );
		      contentPane.add( accessLogJLabel );

		      // set up accessLogJTextArea
		      accessLogJTextArea = new JTextArea();

		      // set up accessLogJScrollPane
		      accessLogJScrollPane = new JScrollPane( accessLogJTextArea );
		      accessLogJScrollPane.setBounds( 16, 309, 270, 95 );
		      contentPane.add( accessLogJScrollPane );

		      // set properties of application's window
		      setTitle( "Security Panel" ); // set title bar string
		      setSize( 310, 450 );          // set window's size
		      setVisible( true );           // display window
		      
	   } 
		      
      private void oneJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "1" );
      }
   // append 2 to the security code
      private void twoJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "2" );

      } // end method twoJButtonActionPerformed

      // append 3 to the security code
      private void threeJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "3" );

      } // end method threeJButtonActionPerformed

      // append 4 to the security code
      private void fourJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "4" );

      } // end method fourJButtonActionPerformed

      // append 5 to the security code
      private void fiveJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "5" );

      } // end method fiveJButtonActionPerformed

      // append 6 to the security code
      private void sixJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "6" );

      } // end method sixJButtonActionPerformed

      // append 7 to the security code
      private void sevenJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "7" );

      } // end method sevenJButtonActionPerformed

      // append 8 to the security code
      private void eightJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "8" );

      } // end method eightJButtonActionPerformed

      // append 9 to the security code
      private void nineJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "9" );

      } // end method nineJButtonActionPerformed
      
      // append 0 to the security code
      private void zeroJButtonActionPerformed( ActionEvent event )
      {
         securityCodeJPasswordField.setText( String.valueOf( 
            securityCodeJPasswordField.getPassword() ) + "0" );

      } // end method zeroJButtonActionPerformed

      // clears the securityCodeJPasswordField
      private void clearJButtonActionPerformed( ActionEvent event )
      {
        securityCodeJPasswordField.setText( "" );

      } // end method clearJButtonActionPerformed
      
      private void enterJButtonActionPerformed( ActionEvent event )
      {
    	  String message;
    	  
    	  int accessCode = Integer.parseInt(String.valueOf(
    			  securityCodeJPasswordField.getPassword()));
    	  securityCodeJPasswordField.setText( "" );
    	  
    	  switch ( accessCode )
    	  {
    	    
    	  case 7:
    	  case 8:
    	  case 9:
    		  message = "Restricted Access";
    		  break;
    		  
    	  case 1645:
    		  message = "Technician";
    		  break;
    		  
    	  case 8345:
    		  message = "Custodian";
    		  break;
    		  
    	  case 9998:
          case 1006:
          case 1007:
          case 1008:
             message = "Scientist";
             break; // done processing case
             
         default:
        	 message = "Access Denied";
    		  
    		  
    		  
    	  }
    	  
    	  DateFormat formatter = DateFormat.getTimeInstance();
    	  accessLogJTextArea.append(formatter.format(new Date() ) +
    			  "   " + message + "\n");
    	  
      }

      
		      
 

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		SecurityPanel application = new SecurityPanel();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        

	}

}
