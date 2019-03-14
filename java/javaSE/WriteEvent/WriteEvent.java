import java.awt.*;
import java.awt.event.*;
import java.io.*;
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

   // PrinterWriter to write to files
   private PrintWriter output;
   
   // no-argument constructor
   public WriteEvent()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
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
   }
   
   private void openFileJButtonActionPerformed( ActionEvent event )
   {
	   // display file dialog so user can select file to open
	      JFileChooser fileChooser = new JFileChooser();
	      fileChooser.setDialogTitle( "Open File for Write Event" );
	      int result = fileChooser.showOpenDialog( this );
	      
	      // if user clicked Cancel JButton on dialog, return
	      if ( result == JFileChooser.CANCEL_OPTION )
	      {
	          return; // exit method openFileJButtonActionPerformed
	      }
	      
	   // get selected file
	      File selectedFile = fileChooser.getSelectedFile();

	      // get selected file name
	      String fileName = selectedFile.getName();
	      
	      // display error if file name missing
	      if ( fileName.equals( "" ) )
	      {
	         JOptionPane.showMessageDialog( this, "File name missing.",
	             "File Name Missing", JOptionPane.ERROR_MESSAGE );
	      }
	      else
	      {
	         // open file
	         try
	         {
	            // open file for writing
	            FileWriter outputFile =
	               new FileWriter( selectedFile, true );
	            output = new PrintWriter( outputFile );
	       
	            // change state of JButtons
	            openFileJButton.setEnabled( false );
	            enterJButton.setEnabled( true );
	            closeFileJButton.setEnabled( true );
	         } 
	         catch ( IOException exception )
	         {
	            JOptionPane.showMessageDialog( this, 
	               "Cannot open the file " + fileName + ".", "Error", 
	               JOptionPane.ERROR_MESSAGE );
	         } 
	           
	      } // end else
	   
	      // reset JButtons to initial states
	      resetUserInput();  
	      
   }
   
   private void enterJButtonActionPerformed( ActionEvent event )
   {
	   output.println( dayJSpinner.getValue() ); 
	   
	// retrieve time entered by user
      String time = String.valueOf( timeJSpinner.getValue() );
      time = time.substring( 11, 16 );

      // write time to file followed by a newline character
      output.println( time );
         
      // write price to file followed by a newline character
      output.println( "$" + priceJTextField.getText() );

      // write event name to file followed by a newline character
      output.println( eventJTextField.getText() );

      // write event description to file
      output.println( descriptionJTextArea.getText() );

      // clear JTextFields
      resetUserInput();
   }
   
// file is closed after user is finished with it
   private void closeFileJButtonActionPerformed( ActionEvent event )
   {
      // close file
      output.close();
      
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
   
   

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		WriteEvent application = new WriteEvent();
	    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
