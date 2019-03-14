// Tutorial 19: ShippingHub.java
// This application tracks Parcels that pass through a shipping hub.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ShippingHub extends JFrame
{
   // JLabel and JTextField to display time of arrival
   private JLabel arrivedAtJLabel;
   private JTextField arrivedAtJTextField;

   // JPanel to contain Parcel information
   private JPanel parcelInformationJPanel;

   // JLabel and JTextField to display Parcel identification number
   private JLabel parcelIDJLabel;
   private JTextField parcelIDJTextField;
   
   // JLabel and JTextField for name
   private JLabel nameJLabel;
   private JTextField nameJTextField;
   
   // JLabel and JTextField for address
   private JLabel addressJLabel;
   private JTextField addressJTextField;

   // JLabel and JTextField for city
   private JLabel cityJLabel;
   private JTextField cityJTextField;

   // JLabel and JTextField for state
   private JLabel stateJLabel;
   private JComboBox stateJComboBox;

   // JLabel and JTextField for zip code
   private JLabel zipJLabel;
   private JTextField zipJTextField;

   // JPanel for Parcel number by state
   private JPanel parcelStateJPanel;

   // JComboBox, JList and JScrollPane for Parcel number
   private JComboBox parcelStateJComboBox;

   // JButtons to manipulate Parcels
   private JButton scanNewJButton;
   private JButton addJButton;
   private JButton removeJButton;
   private JButton editJButton;
   private JButton updateJButton;
   private JButton backJButton;
   private JButton nextJButton;

   // array contains options for stateJComboBox
   private String[] states = { "AL", "FL", "GA", "KY", "MS", "NC",
      "SC", "TN", "VA", "WV" };

   // Parcel object contains data for newly entered Parcels
   private Parcel newParcel;

   private int parcelID = 0; // ID for new Parcels

   // position used to track location when the user is
   // browsing through the list of Parcels
   private int position = 0;
   
   // no-argument constructor
   public ShippingHub()
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

      // set up arrivedAtJLabel
      arrivedAtJLabel = new JLabel();
      arrivedAtJLabel.setBounds( 19, 14, 74, 24 );
      arrivedAtJLabel.setText( "Arrived at:" );
      contentPane.add( arrivedAtJLabel );
      
      // set up arrivedAtJTextField
      arrivedAtJTextField = new JTextField();
      arrivedAtJTextField.setBounds( 89, 14, 207, 21 );
      arrivedAtJTextField.setEditable( false );
      contentPane.add( arrivedAtJTextField );
      
      // set up parcelInformationJPanel
      parcelInformationJPanel = new JPanel();
      parcelInformationJPanel.setBounds( 9, 51, 490, 178 );
      parcelInformationJPanel.setBorder(
         new TitledBorder( "Parcel Information" ) );
      parcelInformationJPanel.setLayout( null );
      contentPane.add( parcelInformationJPanel );
      
      // set up parcelIDJLabel
      parcelIDJLabel = new JLabel();
      parcelIDJLabel.setBounds( 15, 27, 84, 24 );
      parcelIDJLabel.setText( "Parcel ID:" );
      parcelInformationJPanel.add( parcelIDJLabel );
      
      // set up parcelIDJTextField
      parcelIDJTextField = new JTextField();
      parcelIDJTextField.setBounds( 80, 27, 386, 21 );
      parcelIDJTextField.setEditable( false );
      parcelInformationJPanel.add( parcelIDJTextField );
      
      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setBounds( 15, 65, 66, 25 );
      nameJLabel.setText( "Name:" );
      parcelInformationJPanel.add( nameJLabel );

      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setBounds( 80, 65, 386, 21 );
      nameJTextField.setEditable( false );
      parcelInformationJPanel.add( nameJTextField );
	  
      // set up addressJLabel
      addressJLabel = new JLabel();
      addressJLabel.setBounds( 15, 103, 66, 25 );
      addressJLabel.setText( "Address:" );
      parcelInformationJPanel.add( addressJLabel );

      // set up addressJTextField
      addressJTextField = new JTextField();
      addressJTextField.setBounds( 80, 103, 386, 21 );
      addressJTextField.setEditable( false );
      parcelInformationJPanel.add( addressJTextField );
      
      // set up cityJLabel
      cityJLabel = new JLabel();
      cityJLabel.setBounds( 15, 141, 37, 24 );
      cityJLabel.setText( "City:" );
      parcelInformationJPanel.add( cityJLabel );
      
      // set up cityJTextField
      cityJTextField = new JTextField();
      cityJTextField.setBounds( 80, 141, 117, 21 );
      cityJTextField.setEditable( false );
      parcelInformationJPanel.add( cityJTextField );
      
      // set up stateJLabel
      stateJLabel = new JLabel();
      stateJLabel.setBounds( 215, 141, 47, 24 );
      stateJLabel.setText( "State:" );
      parcelInformationJPanel.add( stateJLabel );
      
      // set up stateJComboBox
      stateJComboBox = new JComboBox( states );
      stateJComboBox.setBounds( 260, 141, 70, 21 );
      stateJComboBox.setEnabled( false );
      parcelInformationJPanel.add( stateJComboBox );
      
      // set up zipJLabel
      zipJLabel = new JLabel();
      zipJLabel.setBounds( 355, 141, 28, 24 );
      zipJLabel.setText( "Zip:" );
      parcelInformationJPanel.add( zipJLabel );
      
      // set up zipJTextField
      zipJTextField = new JTextField();
      zipJTextField.setBounds( 390, 141, 76, 21 );
      zipJTextField.setEditable( false );
      parcelInformationJPanel.add( zipJTextField );

      // set up parcelStateJPanel
      parcelStateJPanel = new JPanel();
      parcelStateJPanel.setBounds( 508, 51, 136, 178 );
      parcelStateJPanel.setBorder(
         new TitledBorder( "Parcels by State" ) );
      parcelStateJPanel.setLayout( null );
      contentPane.add( parcelStateJPanel );
      
      // set up parcelStateJComboBox
      parcelStateJComboBox = new JComboBox( states );
      parcelStateJComboBox.setBounds( 19, 29, 98, 21 );
      parcelStateJPanel.add( parcelStateJComboBox );
      parcelStateJComboBox.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
            // event handler called when parcelStateJComboBox
            // is selected
            public void actionPerformed( ActionEvent event )
            {
               parcelStateJComboBoxActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up parcelStateJScrollPane
      parcelStateJScrollPane.setBounds( 19, 65, 98, 82 );
      parcelStateJPanel.add( parcelStateJScrollPane );

      // set up scanNewJButton
      scanNewJButton = new JButton();
      scanNewJButton.setBounds( 9, 248, 95, 26 );
      scanNewJButton.setText( "Scan New" );
      contentPane.add( scanNewJButton );
      scanNewJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when scanNewJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               scanNewJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up addJButton
      addJButton = new JButton();
      addJButton.setBounds( 109, 248, 85, 26 );
      addJButton.setText( "Add" );
      addJButton.setEnabled( false );
      contentPane.add( addJButton );
      addJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when addJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               addJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up removeJButton
      removeJButton = new JButton();
      removeJButton.setBounds( 199, 248, 85, 26 );
      removeJButton.setText( "Remove" );
      removeJButton.setEnabled( false );
      contentPane.add( removeJButton );
      removeJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when removeJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               removeJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up editJButton
      editJButton = new JButton();
      editJButton.setBounds( 289, 248, 85, 26 );
      editJButton.setText( "Edit" );
      editJButton.setEnabled( false );
      contentPane.add( editJButton );
      editJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when editJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               editJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up updateJButton
      updateJButton = new JButton();
      updateJButton.setBounds( 379, 248, 85, 26 );
      updateJButton.setText( "Update" );
      updateJButton.setEnabled( false );
      contentPane.add( updateJButton );
      updateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when updateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               updateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up backJButton
      backJButton = new JButton();
      backJButton.setBounds( 469, 248, 85, 26 );
      backJButton.setText( "< Back" );
      backJButton.setEnabled( false );
      contentPane.add( backJButton );
      backJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when backJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               backJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener

      // set up nextJButton
      nextJButton = new JButton();
      nextJButton.setBounds( 559, 248, 85, 26 );
      nextJButton.setText( "Next >" );
      nextJButton.setEnabled( false );
      contentPane.add( nextJButton );
      nextJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when nextJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               nextJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Shipping Hub" ); // set title bar string
      setSize( 663, 313 );        // set window size
      setVisible( true );         // display window
      
   } // end method createUserInterface
   
   // prepare to scan a new parcel
   private void scanNewJButtonActionPerformed( ActionEvent event )
   {
      // clear JTextFields
      clearComponents();

      // disable appropriate components
      setJButtons( false );

      // enable or make editable appropriate components
      addJButton.setEnabled( true );
      parcelInformationJPanelEditable( true );
      
      // grab focus
      nameJTextField.requestFocusInWindow();
      
   } // end method scanNewJButtonActionPerformed
   
   // add a new Parcel
   private void addJButtonActionPerformed( ActionEvent event )
   {
      // set information for new Parcel
      setParcelData();
      
      // disable or make uneditable appropriate components
      addJButton.setEnabled( false );
      parcelInformationJPanelEditable( false );

      // enable appropriate components
      setJButtons( true );
      
   } // end method addJButtonActionPerformed
   
   // remove a Parcel
   private void removeJButtonActionPerformed( ActionEvent event )
   {
      // retrieve the state of the current Parcel
      String stateSelected = newParcel.getState();
      
      // load next Parcel in list if there is one
      if ( parcelsArrayList.size() > 0 )
      {
         if ( position >= parcelsArrayList.size() )
         {
            position = 0; // go to beginning
         }
      }
      else
      {
         // if no other Parcels remain
         clearComponents();
      }

      setJButtons( true ); // enabled appropriate JButtons

      // set focus to scanNewJButton
      scanNewJButton.requestFocusInWindow();
      
   } // end method removeJButtonActionPerformed
   
   // allow user to edit Parcel information
   private void editJButtonActionPerformed( ActionEvent event )
   {
      // disable appropriate components
      setJButtons( false );

	  // make user able to update Parcel information
	  updateJButton.setEnabled( true );
	  parcelInformationJPanelEditable( true );
      
   } // end method editJButtonActionPerformed

   // move to next Parcel
   private void updateJButtonActionPerformed( ActionEvent event )
   {
      // enable or make editable appropriate components
      setJButtons( true );

      // disable or make uneditable appropriate components
      updateJButton.setEnabled( false );
      parcelInformationJPanelEditable( false );
      
   } // end method updateJButtonActionPerformed

   // move to previous Parcel
   private void backJButtonActionPerformed( ActionEvent event )
   {
      if ( position > 0 )
      {
         position--; // move position back by 1
      }
      else // go to last element in list
      {
         position = parcelsArrayList.size() - 1; 
      }

   } // end method backJButtonActionPerformed
   
   // move to next Parcel
   private void nextJButtonActionPerformed( ActionEvent event )
   {
      if ( position < parcelsArrayList.size() - 1 )
      {
         position++; // move position forward by 1
      }
      else
      {
         position = 0; // go to first element in list
      }
      
   } // end method nextJButtonActionPerformed

   // change the list of Parcels in the parcelStateJList
   private void parcelStateJComboBoxActionPerformed(
      ActionEvent event )
   {
      
   } // end method parcelStateJComboBoxActionPerformed
   
   // set all information about the Parcel
   private void setParcelData()
   {
      newParcel.setName( nameJTextField.getText() );
      newParcel.setAddress( addressJTextField.getText() );
      newParcel.setCity( cityJTextField.getText() );
      newParcel.setState( states[
         stateJComboBox.getSelectedIndex() ] );
      newParcel.setZip( Integer.parseInt(
         zipJTextField.getText() ) );

   } // end method setParcelData
   
   // display all information about the Parcel
   private void loadParcel()
   {

   } // end method loadParcel
   
   // clear all information about the Parcel
   private void clearComponents()
   {
      nameJTextField.setText( "" );
      addressJTextField.setText( "" );
      cityJTextField.setText( "" );
      zipJTextField.setText( "" );
      arrivedAtJTextField.setText( "" );
      parcelIDJTextField.setText( "" );

   } // end method clearComponents

   // enabled/disable JButtons
   private void setJButtons( boolean state )
   {
      backJButton.setEnabled( state );
	  scanNewJButton.setEnabled( state );
      removeJButton.setEnabled( state );
      editJButton.setEnabled( state );
      nextJButton.setEnabled( state );

      // disable navigation if not multiple packages
      if ( parcelsArrayList.size() < 2 )
      {
         nextJButton.setEnabled( false );
         backJButton.setEnabled( false );
      }

      // if no items, disable Remove, Edit and Update JButtons
      if ( parcelsArrayList.size() == 0 )
      {
         editJButton.setEnabled( false );
         updateJButton.setEnabled( false );
         removeJButton.setEnabled( false );
      }

   } // end method setJButtons

   // make editable or uneditable components
   // in parcelInformationJPanel
   private void parcelInformationJPanelEditable( boolean editable )
   {
      nameJTextField.setEditable( editable );
      addressJTextField.setEditable( editable );
      cityJTextField.setEditable( editable );
      stateJComboBox.setEnabled( editable );
      zipJTextField.setEditable( editable );

   } // end method parcelInformationJPanelEditable
   
   // main method
   public static void main( String[] args )
   {
      ShippingHub application = new ShippingHub();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class ShippingHub

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