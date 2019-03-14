import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class ScreenScraping extends JFrame
{
	// JLabel and JComboBox for item names
   private JLabel itemJLabel;
   private JComboBox itemJComboBox;

   // JLabel and JTextField for conversion rate
   private JLabel rateJLabel;
   private JTextField rateJTextField;

   // JLabel and JTextField for item price
   private JLabel priceJLabel;
   private JTextField priceJTextField;

   // JButton to search HTML code for item price
   private JButton searchJButton;

   // JLabel and JTextArea for HTML code
   private JLabel sourceJLabel;
   private JTextArea sourceJTextArea;

   // items that can be found in HTML code
   private String[] items = { "Antique Rocking Chair",
      "Silver Teapot", "Gold Pocket Watch" };
   
   // small piece of HTML code containing items and prices
   private String htmlText = "<HTML><BODY><TABLE>"
      + "<TR><TD>Antique Rocking Chair</TD>"
      + "<TD>&euro;82.67</TD></TR>"
      + "<TR><TD>Silver Teapot</TD>"
      + "<TD>&euro;64.55</TD></TR>"
      + "<TR><TD>Gold Pocket Watch</TD>"
      + "<TD>&euro;128.83</TD></TR>"
      + "</TABLE></BODY></HTML>";
      
   // no-argument constructor
   public ScreenScraping()
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

	      // set up itemJLabel
	      itemJLabel = new JLabel();
	      itemJLabel.setBounds( 8, 16, 40, 21 );
	      itemJLabel.setText( "Item:" );
	      contentPane.add( itemJLabel );
	      
	      // set up itemJComboBox
	      itemJComboBox = new JComboBox( items );
	      itemJComboBox.setBounds( 56, 16, 184, 21 );
	      contentPane.add( itemJComboBox );

	      // set up rateJLabel
	      rateJLabel = new JLabel();
	      rateJLabel.setBounds( 8, 48, 40, 21 );
	      rateJLabel.setText( "Rate:" );
	      contentPane.add( rateJLabel );

	      // set up rateJTextField
	      rateJTextField = new JTextField();
	      rateJTextField.setBounds( 56, 48, 184, 21 );
	      rateJTextField.setHorizontalAlignment( JTextField.RIGHT );
	      contentPane.add( rateJTextField );

	      // set up priceJLabel
	      priceJLabel = new JLabel();
	      priceJLabel.setBounds( 8, 80, 40, 21 );
	      priceJLabel.setText( "Price:" );
	      contentPane.add( priceJLabel );
	      
	      // set up priceJTextField
	      priceJTextField = new JTextField();
	      priceJTextField.setBounds( 56, 80, 96, 21 );
	      priceJTextField.setHorizontalAlignment( JTextField.CENTER );
	      priceJTextField.setEditable( false );
	      contentPane.add( priceJTextField );

	      // set up searchJButton
	      searchJButton = new JButton();
	      searchJButton.setBounds( 160, 80, 80, 23 );
	      searchJButton.setText( "Search" );
	      contentPane.add( searchJButton );
	      searchJButton.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when searchJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	               searchJButtonActionPerformed( event );
	            }

	         } // end anonymous inner class

	      ); // end call to addActionListener

	      // set up sourceJLabel
	      sourceJLabel = new JLabel();
	      sourceJLabel.setBounds( 8, 112, 48, 16 );
	      sourceJLabel.setText( "Source:" );
	      contentPane.add( sourceJLabel );

	      // set up sourceJTextArea
	      sourceJTextArea = new JTextArea();
	      sourceJTextArea.setBounds( 8, 136, 232, 105 );
	      sourceJTextArea.setText( htmlText );
	      sourceJTextArea.setLineWrap( true );
	      contentPane.add( sourceJTextArea );
	         
	      // set properties of application's window
	      setTitle( "Screen Scraping" ); // set title bar string
	      setSize( 259, 278 );           // set window size
	      setVisible( true );            // display window
	      
	   } // end method createUserInterface 
   private void searchJButtonActionPerformed( ActionEvent event )
   {
	   String rate = rateJTextField.getText();
	   
	   if ( rate.equals( "" ) )
	      {
	         JOptionPane.showMessageDialog( null, 
	            "Please enter conversion rate first.",
	            "Missing Rate", JOptionPane.WARNING_MESSAGE );
	         
	         return; // exit method
	      }
	   
	   String selectedItem = 
		         ( String ) itemJComboBox.getSelectedItem();
	   
	   int itemLocation = htmlText.indexOf( selectedItem );
	   int priceBegin = htmlText.indexOf( "&euro;", itemLocation );
	   int priceEnd = htmlText.indexOf( "</TD>", priceBegin );
	   
	   String priceText = htmlText.substring(priceBegin + 6, priceEnd );
	   double price = Double.parseDouble( priceText );

	      // convert price from euros to dollars
	      double conversionRate = Double.parseDouble(
	         rateJTextField.getText() );
	      price *= conversionRate;
	      
	      // display price of item in priceJTextField
	      DecimalFormat dollars = new DecimalFormat( "$0.00" );
	      priceJTextField.setText( dollars.format( price ) );
   }

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		ScreenScraping application = new ScreenScraping();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
