// Exercise 18.17: DVDInventory.java
// An application that inventories DVDs.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DVDInventory extends JFrame
{
   // JPanel for containing movie information
   private JPanel informationJPanel;

   // JLabel and JTextField for movie title
   private JLabel movieJLabel;
   private JTextField movieJTextField;

   // JLabel and JTextField for minutes in movie
   private JLabel minutes1JLabel;
   private JTextField minutes1JTextField;

   // JButton to create and display a DVDObject
   private JButton createJButton;
   private JButton informationJButton;

   // JTextField for DVD creation message
   private JTextField bottomJTextField;

   // JPanel for containing bonus material information
   private JPanel bonusJPanel;

   // JLabels and JTextFields for bonus material
   // descriptions and minutes in bonus material 
   private JLabel description1JLabel;
   private JTextField description1JTextField;
   private JLabel minutes2JLabel;
   private JTextField minutes2JTextField;
   private JLabel description2JLabel;
   private JTextField description2JTextField;
   private JLabel minutes3JLabel;
   private JTextField minutes3JTextField;
   private JLabel description3JLabel;
   private JTextField description3JTextField;
   private JLabel minutes4JLabel;
   private JTextField minutes4JTextField;

   // no-argument constructor
   public DVDInventory()
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
      
      // set up informationJPanel
      informationJPanel = new JPanel();
      informationJPanel.setBounds( 8, 8, 240, 112 );
      informationJPanel.setBorder( new TitledBorder( 
         "DVD Information" ) );
      informationJPanel.setLayout( null );
      contentPane.add( informationJPanel );
      
      // set up movieJLabel
      movieJLabel = new JLabel();
      movieJLabel.setBounds( 8, 32, 72, 24 );
      movieJLabel.setText( "Movie title:" );
      informationJPanel.add( movieJLabel );

      // set up movieJTextField
      movieJTextField = new JTextField();
      movieJTextField.setBounds( 80, 32, 140, 24 );
      informationJPanel.add( movieJTextField );
      
      // set up minutes1JLabel
      minutes1JLabel = new JLabel();
      minutes1JLabel.setBounds( 8, 66, 56, 24 );
      minutes1JLabel.setText( "Minutes:" );
      informationJPanel.add( minutes1JLabel );
      
      // set up minutes1JTextField
      minutes1JTextField = new JTextField();
      minutes1JTextField.setBounds( 168, 64, 50, 24 );
      informationJPanel.add( minutes1JTextField );

      // set up createJButton
      createJButton = new JButton();
      createJButton.setBounds( 78, 136, 100, 24 );
      createJButton.setText( "Create" );
      contentPane.add( createJButton );
      createJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when createJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                createJButtonActionPerformed( event );
             }

         } // end anonymous inner class
      
      ); // end call to addActionListener
            
      // set up informationJButton
      informationJButton = new JButton();
      informationJButton.setBounds( 78, 168, 100, 24 );
      informationJButton.setText( "Information" );
      informationJButton.setEnabled( false );
      contentPane.add( informationJButton );
      informationJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
             // event handler called when 
             // informationJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                informationJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up bottomJTextField
      bottomJTextField = new JTextField();
      bottomJTextField.setBounds( 8, 206, 240, 24 );
      bottomJTextField.setHorizontalAlignment( JTextField.CENTER );
      bottomJTextField.setEditable( false );
      contentPane.add( bottomJTextField );
      
      // set up bonusJPanel
      bonusJPanel = new JPanel();
      bonusJPanel.setBounds( 264, 8, 248, 224 );
      bonusJPanel.setBorder( new TitledBorder( "Bonus Materials" ) );
      bonusJPanel.setLayout( null );
      contentPane.add( bonusJPanel );
      
      // set up description1JLabel
      description1JLabel = new JLabel();
      description1JLabel.setBounds( 8, 24, 74, 24 );
      description1JLabel.setText( "Description:" );
      bonusJPanel.add( description1JLabel );
      
      // set up description1JTextField
      description1JTextField = new JTextField();
      description1JTextField.setBounds( 88, 24, 140, 24 );
      bonusJPanel.add( description1JTextField );
      
      // set up minutes2JLabel
      minutes2JLabel = new JLabel();
      minutes2JLabel.setBounds( 8, 56, 56, 24 );
      minutes2JLabel.setText( "Minutes:" );
      bonusJPanel.add( minutes2JLabel );
      
      // set up minutes2JTextField
      minutes2JTextField = new JTextField();
      minutes2JTextField.setBounds( 178, 56, 50, 24 );
      bonusJPanel.add( minutes2JTextField );
      
      // set up description2JLabel
      description2JLabel = new JLabel();
      description2JLabel.setBounds( 8, 88, 74, 24 );
      description2JLabel.setText( "Description:" );
      bonusJPanel.add( description2JLabel );
      
      // set up description2JTextField
      description2JTextField = new JTextField();
      description2JTextField.setBounds( 88, 88, 140, 24 );
      bonusJPanel.add( description2JTextField );
      
      // set up minutes3JLabel
      minutes3JLabel = new JLabel();
      minutes3JLabel.setBounds( 8, 120, 56, 24 );
      minutes3JLabel.setText( "Minutes:" );
      bonusJPanel.add( minutes3JLabel );
      
      // set up minutes3JTextField
      minutes3JTextField = new JTextField();
      minutes3JTextField.setBounds( 178, 120, 50, 24 );
      bonusJPanel.add( minutes3JTextField );
      
      // set up description3JLabel
      description3JLabel = new JLabel();
      description3JLabel.setBounds( 8, 152, 74, 24 );
      description3JLabel.setText( "Description:" );
      bonusJPanel.add( description3JLabel );
      
      // set up description3JTextField
      description3JTextField = new JTextField();
      description3JTextField.setBounds( 88, 152, 140, 24 );
      bonusJPanel.add( description3JTextField );

      // set up minutes4JLabel
      minutes4JLabel = new JLabel();
      minutes4JLabel.setBounds( 8, 184, 56, 24 );
      minutes4JLabel.setText( "Minutes:" );
      bonusJPanel.add( minutes4JLabel );
      
      // set up minutes4JTextField
      minutes4JTextField = new JTextField();
      minutes4JTextField.setBounds( 178, 184, 50, 24 );
      bonusJPanel.add( minutes4JTextField );

      // set properties of application's window
      setTitle( "DVD Inventory" ); // set title bar string
      setSize( 550, 265 );      // set window size
      setVisible( true );       // display window
      
   } // end method createUserInterface

   // get user input and store in a new DVDObject
   private void createJButtonActionPerformed( ActionEvent event )
   {
      // let the user know about the progress
      bottomJTextField.setText( 
         "Your DVD was created successfully!" );
      
      // enable informationJButton
      informationJButton.setEnabled( true );

   } // end method createJButtonActionPerformed
   
   // display last created DVD in a JOptionPane
   private void informationJButtonActionPerformed(
      ActionEvent event )
   {
      // clear successful dvd creation message
      bottomJTextField.setText( "" );
      
      // String for storing movie information to be displayed
      String information = "";
      
      // display output in a JOptionPane
      JOptionPane.showMessageDialog( this, information, 
         "DVD Description", JOptionPane.INFORMATION_MESSAGE );

   } // end method informationJButtonActionPerformed

   // main method
   public static void main( String args[] )
   {
      DVDInventory application = new DVDInventory();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class DVDInventory

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