// Tutorial 28: PhoneBook.java
// An application announces phone number with FreeTTS.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.speech.*;
import javax.speech.synthesis.*;

public class PhoneBook extends JFrame 
{
   // JLabels to display instructions
   private JLabel instruction1JLabel;
   private JLabel instruction2JLabel;

   // JComboBox for names
   private JComboBox nameJComboBox;

   // JButton to get phone number
   private JButton getPhoneNumberJButton;

   // Synthesizer to speak phone number
   private Synthesizer speechSynthesizer;

   // fill array with people's names
   private String[] namesArray = { "John", "Jennifer", "Howard" };

   // fill array with people's phone numbers
   private String[] numbersArray = 
      { "(555) 555-9876", "(555) 555-1234", "(555) 555-4567" };

   // no-argument constructor
   public PhoneBook()
   {
      // initialize Synthesizer 
      try
      {
         // create SynthesizerModeDesc for FreeTTS synthesizer.
         SynthesizerModeDesc descriptor = new SynthesizerModeDesc(
            "Unlimited domain FreeTTS Speech Synthesizer " + 
            "from Sun Labs", null, Locale.US, Boolean.FALSE, null ); 

         // create a Synthesizer 
         speechSynthesizer = Central.createSynthesizer( descriptor );
 
         // Synthesizer created successfully
         if ( speechSynthesizer != null )
         {
            // prepare synthesizer to speak
            speechSynthesizer.allocate();
            speechSynthesizer.resume();
	    
            // get synthesizer properties
            SynthesizerProperties properties =
               speechSynthesizer.getSynthesizerProperties();

            // set up speaking rate
            properties.setSpeakingRate( 100.0f );
	    
         } // end if
	 
         else
         {
            System.err.println( "Synthesizer creation failed." );
	        System.exit( 1 );
         }

      } // end try

      catch ( Exception myException ) 
      {
         myException.printStackTrace();
      }

      createUserInterface(); // set up GUI

   } // end constructor

   // create and position GUI components; register event handler
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );

      // set up instruction1JLabel
      instruction1JLabel = new JLabel();
      instruction1JLabel.setBounds( 16, 8, 264, 23 );
      instruction1JLabel.setText(
         "Select a name from the combo box." );
      contentPane.add( instruction1JLabel );

      // set up instruction2JLabel
      instruction2JLabel = new JLabel();
      instruction2JLabel.setBounds( 16, 35, 264, 23 );
      instruction2JLabel.setText(
         "Click the button to listen to the phone number." );
      contentPane.add( instruction2JLabel );

      // set up nameJComboBox
      nameJComboBox = new JComboBox( namesArray );
      nameJComboBox.setBounds( 50, 65, 150, 23 );
      contentPane.add( nameJComboBox );

      // set up getPhoneNumberJButton
      getPhoneNumberJButton = new JButton();
      getPhoneNumberJButton.setBounds( 50, 100, 150, 23 );
      getPhoneNumberJButton.setText( "Get Phone Number" );
      contentPane.add( getPhoneNumberJButton );
      getPhoneNumberJButton.addActionListener(

         new ActionListener()  // anonymous inner class
         {
            // event handler called when getPhoneNumberJButton
            // is clicked 
            public void actionPerformed( ActionEvent event )
            {
               getPhoneNumberJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener

      // set properties of application's window
      setTitle( "Phone Book" );  // set title bar string
      setSize( 300, 160 );       // set window size
      setVisible( true );        // display window

      // ensure synthesizer is cleaned up
      // when user closes application
      addWindowListener(

         new WindowAdapter()  // anonymous inner class
         {
            public void windowClosing( WindowEvent event )
            {
               frameWindowClosing( event );
            }

         } // end anonymous inner class

      ); // end addWindowListener

   } // end method createUserInterface

   // speak a person's phone number
   private void getPhoneNumberJButtonActionPerformed( 
      ActionEvent event )
   {
      // get index of the selected person
      int selectedName = nameJComboBox.getSelectedIndex();

      // declare text to speak
      String textToSpeak = namesArray[ selectedName ] +
         "'s phone number is " + numbersArray[ selectedName ];

      // speak the person's name and phone number
      speechSynthesizer.speakPlainText( textToSpeak, null );

   } // end method getPhoneNumberJButtonActionPerformed

   // clean up synthesizer
   private void frameWindowClosing( WindowEvent event )
   {
      // deallocate synthesizer
      try 
      {
         speechSynthesizer.deallocate();
      }
      catch ( Exception myException )
      {
         myException.printStackTrace();
      }
      finally
      {
         System.exit( 0 );
      }

   }  // end method frameWindowClosing 

   // main method
   public static void main( String[] args ) 
   {
      PhoneBook application = new PhoneBook();

   } // end method main

} // end class PhoneBook

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
