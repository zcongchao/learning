// Exercise 19.13 ComponentsCollection.java
// This application lists all components used in the application.
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ComponentsCollection extends JFrame
{
   // JLabel and JTextField for reading name from user
   private JLabel nameJLabel;
   private JTextField nameJTextField;

   // JLabel and JComboBox for displaying series name
   private JLabel bookJLabel;
   private JComboBox bookJComboBox;

   // two JLabels for displaying book cover
   private JLabel pictureJLabel;
   private JLabel bookPictureJLabel;

   // JLabel and JList for displaying list of components
   private JLabel listComponentsJLabel;
   private JList listComponentsJList;

   // JButton to allow user interaction
   private JButton submitJButton;

   // instance variables
   private String[] bookList = { "Simply Series",
      "How To Program Series", "Developer Series" };
   private ArrayList componentsArrayList = new ArrayList();
   private Component[] components = new Component[ 9 ];
   private ArrayList outputArrayList = new ArrayList();
   
   // no-argument constructor
   public ComponentsCollection()
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
      
      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setBounds( 16, 15, 48, 21 );
      nameJLabel.setText( "Name:" );
      nameJLabel.setName( "nameJLabel" );
      nameJLabel.setOpaque( true );
      contentPane.add( nameJLabel );

      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setBounds( 64, 16, 172, 20 );
      nameJTextField.setName( "nameJTextField" );
      contentPane.add( nameJTextField );

      // set up bookJLabel
      bookJLabel = new JLabel();
      bookJLabel.setBounds( 16, 48, 48, 21 );
      bookJLabel.setText( "Book:" );
      bookJLabel.setName( "bookJLabel" );
      bookJLabel.setOpaque( true );
      contentPane.add( bookJLabel );

      // set up bookJComboBox
      bookJComboBox = new JComboBox( bookList );
      bookJComboBox.setBounds( 64, 48, 172, 21 );
      bookJComboBox.setName( "bookJComboBox" );
      contentPane.add( bookJComboBox );

      // set up pictureJLabel
      pictureJLabel = new JLabel();
      pictureJLabel.setBounds( 16, 80, 48, 21 );
      pictureJLabel.setText( "Picture:" );
      pictureJLabel.setName( "pictureJLabel" );
      pictureJLabel.setOpaque( true );
      contentPane.add( pictureJLabel );

      // set up bookPictureJLabel
      bookPictureJLabel = new JLabel();
      bookPictureJLabel.setBounds( 64, 80, 91, 119 );
      bookPictureJLabel.setIcon( new ImageIcon(
         "vbnetFEP1_thumb.jpg" ) );
      bookPictureJLabel.setName( "bookPictureJLabel" );
      contentPane.add( bookPictureJLabel );

      // set up listComponentsJLabel
      listComponentsJLabel = new JLabel();
      listComponentsJLabel.setBounds( 252, 16, 112, 21 );
      listComponentsJLabel.setText( "List of components:" );
      listComponentsJLabel.setName( "listComponentsJLabel" );
      listComponentsJLabel.setOpaque( true );
      contentPane.add( listComponentsJLabel );

      // set up listComponentsJList
      listComponentsJList = new JList();
      listComponentsJList.setBounds( 252, 40, 130, 168 );
      listComponentsJList.setName( "listComponentsJList" );
      contentPane.add( listComponentsJList );

      // set up submitJButton
      submitJButton = new JButton();
      submitJButton.setBounds( 296, 224, 76, 23 );
      submitJButton.setText( "Submit" );
      submitJButton.setName( "submitJButton" );
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

      ); // end addActionListener
      
      // put all components in an array
      components = getContentPane().getComponents();

      // add all components to componentsArrayList
      for ( int i = 0; i < 9; i++ )
      {
         componentsArrayList.add( components[ i ] );
      }

      // set properties of application's window
      setTitle( "Components Collection" ); // set title bar string
      setSize( 406, 288 );                 // set window size
      setVisible( true );                  // display window
      
   } // end method createUserInterface
   
   // method to display a list of components
   private void submitJButtonActionPerformed( ActionEvent event )
   {
      
   } // end submitJButtonActionPerformed
   
   // main method
   public static void main( String args[] )
   {
      ComponentsCollection application = new ComponentsCollection();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class ComponentsCollection

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