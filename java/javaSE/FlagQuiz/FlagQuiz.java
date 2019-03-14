import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;


public class FlagQuiz extends JFrame
{
	// array of country names
	   private String[] countries = { "Russia", "China", "United States",
	      "Italy", "Australia", "South Africa", "Brazil", "Spain" };
	      
	   // boolean array tracks displayed flags
	   private boolean[]  flagsUsed = new boolean[ countries.length ];
	   
	   private int currentIndex; // contains the index of current flag

	   // tracks the number of flags that have been displayed
	   private int count = 1;

	   // JPanel and JLabel for displaying a flag image
	   private JPanel flagJPanel;
	   private JLabel flagIconJLabel;

	   // JLabel and JComboBox for choosing a country
	   private JLabel selectCountryJLabel;
	   private JComboBox selectCountryJComboBox;

	   // JTextField for giving the user feedback
	   private JTextField feedbackJTextField;

	   // JButton to submit an answer
	   private JButton submitJButton;

	   // JButton to display the next flag
	   private JButton nextFlagJButton;
	      
	   // no-argument constructor
	   public FlagQuiz()
	   {      
	      createUserInterface();      
	   }
	   
	   private void createUserInterface()
	   {
		// get content pane for attaching GUI components
		      Container contentPane = getContentPane();
		      
		      // enable explicit positioning of GUI components
		      contentPane.setLayout( null );

		      // set up flagJPanel
		      flagJPanel = new JPanel();
		      flagJPanel.setBounds( 16, 8, 100, 90 );
		      flagJPanel.setLayout( null );
		      flagJPanel.setBorder( new TitledBorder( "Flag" ) );
		      contentPane.add( flagJPanel );

		      // set up flagIconJLabel
		      flagIconJLabel = new JLabel();
		      flagIconJLabel.setBounds( 10, 14, 80, 80 );
		      flagIconJLabel.setHorizontalAlignment( JLabel.CENTER );
		      flagJPanel.add( flagIconJLabel );

		      // set up selectCountryJLabel
		      selectCountryJLabel = new JLabel();
		      selectCountryJLabel.setBounds( 136, 8, 88, 21 );
		      selectCountryJLabel.setText( "Select country:" );
		      contentPane.add( selectCountryJLabel );
		      
		      Arrays.sort( countries);
		      
		   // set up selectCountryJComboBox
		      selectCountryJComboBox = new JComboBox( countries );
		      selectCountryJComboBox.setBounds( 136, 32, 135, 21 );
		      selectCountryJComboBox.setMaximumRowCount( 3 );
		      contentPane.add( selectCountryJComboBox );
		      
		      displayFlag(); // display first flag
		      
		      // set up feedbackJTextField
		      feedbackJTextField = new JTextField();
		      feedbackJTextField.setBounds( 136, 64, 135, 32 );
		      feedbackJTextField.setHorizontalAlignment(
		         JTextField.CENTER );
		      feedbackJTextField.setEditable( false );
		      contentPane.add( feedbackJTextField );
		      
		      // set up submitJButton
		      submitJButton = new JButton();
		      submitJButton.setBounds( 287, 8, 88, 32 );
		      submitJButton.setText( "Submit" );
		      contentPane.add( submitJButton );
		      submitJButton.addActionListener(
		      
		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when submitJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               submitJButtonActionPerformed( event );
		            }
		            
		         } // end anonymous inner class
		         
		      ); // end call to addActionListener            
		      
		      // set up nextFlagJButton
		      nextFlagJButton = new JButton();
		      nextFlagJButton.setBounds( 287, 48, 88, 32 );
		      nextFlagJButton.setText( "Next Flag" );
		      nextFlagJButton.setEnabled( false );
		      contentPane.add( nextFlagJButton );
		      nextFlagJButton.addActionListener(
		      
		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when nextFlagJButton is pressed
		            public void actionPerformed( ActionEvent event )
		            {
		               nextFlagJButtonActionPerformed( event );
		            }
		            
		         } // end anonymous inner class
		         
		      ); // end call to addActionListener
		      
		      // set properties of application's window
		      setTitle( "Flag Quiz" ); // set title bar string
		      setSize( 390, 135 );     // set window size
		      setVisible( true );      // display window
		      
	   }
	   
	   private int getUniqueRandomNumber()
	   {
		   Random generator = new Random();
		   int randomNumber;
		   
		   do
		   {
			   randomNumber = generator.nextInt( 8 );
		   }
		   while ( flagsUsed[ randomNumber ] == true );
		   
		   flagsUsed[ randomNumber ] = true;
		   
		   return randomNumber;
	   }
	   
	   private void displayFlag()
	   {
		   currentIndex = getUniqueRandomNumber();
		   String country =
			         ( String ) selectCountryJComboBox.getItemAt( currentIndex );
		   String countryPath = "images/" + country + ".png";
		   
		   flagIconJLabel.setIcon( new ImageIcon( countryPath ) );
	   }
	   
	   private void submitJButtonActionPerformed( ActionEvent event )
	   {
		   if ( selectCountryJComboBox.getSelectedIndex() == currentIndex )
		   {
			   feedbackJTextField.setText( "Correct!" );
		   }
		   else
		   {
			   feedbackJTextField.setText( "Sorry, incorrect." );
		   }
		   
		// inform user if quiz is over
		      if ( count == 5 )
		      {
		         feedbackJTextField.setText( 
		            feedbackJTextField.getText() + "   Done!" );
		         nextFlagJButton.setEnabled( false );
		         submitJButton.setEnabled( false );
		         selectCountryJComboBox.setEnabled( false );
		      }
		      else // if less than 5 flags have been displayed
		      {
		         submitJButton.setEnabled( false );
		         nextFlagJButton.setEnabled( true );
		      }
	   }
	   
	   private void nextFlagJButtonActionPerformed( ActionEvent event )
	   {
		   displayFlag(); // display next flag
	       count++;
	       
	    // reset GUI components to initial states
	       feedbackJTextField.setText( "" );
	       selectCountryJComboBox.setSelectedIndex( 0 );
	       submitJButton.setEnabled( true );
	       nextFlagJButton.setEnabled( false );
	   }
	   
	   public static void main( String[] args)
	   {
		   FlagQuiz application = new FlagQuiz();
		      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   }
}
