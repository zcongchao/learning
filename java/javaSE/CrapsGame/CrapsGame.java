import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.*;

public class CrapsGame extends JFrame
{
	// JPanel and TitledBorder to contain dice
	   private JPanel pointDiceJPanel;
	   private TitledBorder pointDiceTitledBorder;
	   
	   // JLabels to display the die images in pointDiceJPanel
	   private JLabel pointDie1JLabel;
	   private JLabel pointDie2JLabel;

	   // JLabels to display the die images from the rolls of the dice
	   private JLabel die1JLabel;
	   private JLabel die2JLabel;

	   // JButtons to allow user to interact with game
	   private JButton playJButton;
	   private JButton rollJButton;

	   // JLabel and JTextField to show results of game
	   private JLabel resultJLabel;
	   private JTextField resultJTextField;
	   
	   private final int LUCKY_SEVEN = 7;
	   private final int YO_LEVEN = 11;

	   // constants representing losing dice rolls
	   private final int SNAKE_EYES = 2;
	   private final int TREY = 3;
	   private final int BOX_CARS = 12;
	   private final int CRAPS = 7;

	   // file name and directory constants
	   private final String FILE_PREFIX = "Images/die";
	   private final String FILE_SUFFIX = ".png";

	   // instance variables
	   private int myPoint = 0;
	   private Random randomObject = new Random();
	   
	   // no-argument constructor
	   public CrapsGame()
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

		      // set up pointDiceTitledBorder for use with pointDiceJPanel
		      pointDiceTitledBorder = new TitledBorder( "Point" );
		      
		      pointDiceJPanel = new JPanel();
		      pointDiceJPanel.setBounds( 16, 16, 200, 116 );
		      pointDiceJPanel.setLayout( null );
		      pointDiceJPanel.setBorder( pointDiceTitledBorder );
		      contentPane.add( pointDiceJPanel );
		      
		   // set up pointDie1JLabel
		      pointDie1JLabel = new JLabel();
		      pointDie1JLabel.setBounds( 24, 34, 64, 56 );
		      pointDiceJPanel.add( pointDie1JLabel );
		      
		      // set up pointDie2JLabel
		      pointDie2JLabel = new JLabel();
		      pointDie2JLabel.setBounds( 120, 34, 64, 56 );
		      pointDiceJPanel.add( pointDie2JLabel );
		      
		      // set up die1JLabel
		      die1JLabel = new JLabel();
		      die1JLabel.setBounds( 40, 150, 64, 64 );
		      contentPane.add( die1JLabel );
		      
		      // set up die2JLabel
		      die2JLabel = new JLabel();
		      die2JLabel.setBounds( 136, 150, 64, 56 );
		      contentPane.add( die2JLabel );
		      
		      // set up playJButton
		      playJButton = new JButton();
		      playJButton.setBounds( 232, 16, 88, 23 );
		      playJButton.setText( "Play" );
		      contentPane.add( playJButton );
		      playJButton.addActionListener(
		         
		         new ActionListener() // anonymous inner class
		         {
		             // event handler called when playJButton is clicked
		             public void actionPerformed ( ActionEvent event )
		             {
		                playJButtonActionPerformed( event );
		             }

		         } // end anonymous inner class

		      ); // end call to addActionListener      
		      
		      // set up rollJButton
		      rollJButton = new JButton();
		      rollJButton.setBounds( 232, 56, 88, 23 );
		      rollJButton.setText( "Roll" );
		      rollJButton.setEnabled( false );
		      contentPane.add( rollJButton );
		      rollJButton.addActionListener(
		            
		         new ActionListener() // anonymous inner class
		         {
		            // event handler called when rollJButton is clicked
		            public void actionPerformed ( ActionEvent event )
		            {
		               rollJButtonActionPerformed( event );
		            }
		         
		         } // end anonymous inner class

		      ); // end call to addActionListener

		      // set up resultJLabel
		      resultJLabel = new JLabel();
		      resultJLabel.setBounds( 232, 90, 48, 16 );
		      resultJLabel.setText( "Result:" );
		      contentPane.add( resultJLabel );
		      
		      // set up resultJTextField
		      resultJTextField = new JTextField();
		      resultJTextField.setBounds( 232, 106, 88, 24 );
		      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
		      resultJTextField.setEditable( false );
		      contentPane.add( resultJTextField );
		      
		      // set properties of application's window
		      setTitle( "Craps Game" ); // set title bar string
		      setSize( 350, 250 );      // set window size
		      setVisible( true );       // display window
		   
	   }
	   
	   private void playJButtonActionPerformed( ActionEvent event )
	   {
		// clear point icons
		      pointDie1JLabel.setIcon( null );
		      pointDie2JLabel.setIcon( null );
		      
		      // reset title of border
		      pointDiceTitledBorder.setTitle( "Point" );
		      //刷新图片
		      pointDiceJPanel.repaint();
		      
		      int sumOfDice = rollDice();
		      
		      switch ( sumOfDice )
		      {
		      case LUCKY_SEVEN:
		      case YO_LEVEN:
		    	  resultJTextField.setText( "You win!!!" );
		    	  break;
		    	  
		      case SNAKE_EYES:
		      case TREY:
         	  case BOX_CARS:
         		 resultJTextField.setText( "Sorry, you lose." );
         		 break;
         		 
     		 default:
     			 
     			myPoint = sumOfDice;
     			resultJTextField.setText( "Roll again!" );
     			pointDie1JLabel.setIcon( die1JLabel.getIcon() );
                pointDie2JLabel.setIcon( die2JLabel.getIcon() );

                // update the border title
                pointDiceTitledBorder.setTitle(
                   "Point is " + sumOfDice );
                pointDiceJPanel.repaint();

                // change the state of the JButtons
                playJButton.setEnabled( false );
                rollJButton.setEnabled( true );
     			
     		
		      }
		           
	   }
	   
	   private void rollJButtonActionPerformed( ActionEvent event )
	   {
		   int sumOfDice = rollDice();
		   
		   if ( sumOfDice == myPoint)
		   {
			   resultJTextField.setText( "You win!!!" );
		         rollJButton.setEnabled( false );
		         playJButton.setEnabled( true );
		   }
		   
		   else if ( sumOfDice == CRAPS )
		   {
			   resultJTextField.setText( "Sorry, you lose." );
		         rollJButton.setEnabled( false );
		         playJButton.setEnabled( true );
		   }
	   }
	   
	   private int rollDice()
	   {
		   //随机生成1-6
		   int die1 = 1 + randomObject.nextInt( 6 );
		   int die2 = 1 + randomObject.nextInt( 6 );
		   
		   //
		   displayDie( die1JLabel, die1);
		   displayDie( die2JLabel, die2);
		   
		   return die1 + die2;
		 	   
	   }
	   
	   private void displayDie( JLabel picDieJLabel, int face)
	   {
		  ImageIcon image = new ImageIcon( FILE_PREFIX + face + FILE_SUFFIX);
		  
		  picDieJLabel.setIcon( image );
	   }
	   
	   
	   

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		CrapsGame application = new CrapsGame();
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		

	}

}
