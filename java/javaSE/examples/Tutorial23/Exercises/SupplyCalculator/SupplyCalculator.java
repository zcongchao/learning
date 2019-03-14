// Exercise 23.11: SupplyCalculator.java
// Enables users to select from a list of supplies
// and determine the price of the selected supplies.
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class SupplyCalculator extends JFrame
{
   // JLabel, JList and JScrollPane for displaying items in stock
   private JLabel stockListJLabel;
   private JList stockJList;
   private JScrollPane stockJScrollPane;

   // JButtons to add and remove items from the user item list
   private JButton addJButton;
   private JButton removeJButton;

   // JButton to calculate total amount user is spending
   private JButton calculateJButton;

   // JLabel, JList and JScrollPane for displaying user item list
   private JLabel itemsJLabel;
   private JList itemsJList;
   private JScrollPane itemsJScrollPane;

   // JLabel and JTextField for displaying total cost
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // ArrayList for storing items user has selected
   private ArrayList userArrayList = new ArrayList();

   // String for storing items in stock
   private String stockItems[] = { "Staples - $2.10", 
      "Stapler - $5.99", "Folder - $3.65", "Notebook - $4.99", 
      "Pencil - $1.29", "Eraser - $1.49", "Pen - $1.89", 
      "Post-it - $0.99", "Marker - $1.99", "MousePad - $2.49" };
      
   // no-argument constructor
   public SupplyCalculator()
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
      
      // set up stockListJLabel
      stockListJLabel = new JLabel();
      stockListJLabel.setBounds( 16, 16, 100, 21 );
      stockListJLabel.setText( "Items in Stock:" );
      contentPane.add( stockListJLabel );
      
      // set up stockJList and stockJScrollPane
      stockJList = new JList( stockItems );
      stockJScrollPane = new JScrollPane( stockJList );
      stockJScrollPane.setBounds( 16, 40, 112, 134 );
      contentPane.add( stockJScrollPane );
      
      // set up addJButton
      addJButton = new JButton();
      addJButton.setBounds( 144, 56, 104, 23 );
      addJButton.setText( "Add >>" );
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
      removeJButton.setBounds( 144, 96, 104, 23 );
      removeJButton.setText( "<< Remove" );
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
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 144, 144, 104, 23 );
      calculateJButton.setText( "Calculate" );
      calculateJButton.setEnabled( false );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when calculateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }
          
         } // end anonymous inner class
      
      ); // end call to addActionListener
     
      // set up itemsJLabel
      itemsJLabel = new JLabel();
      itemsJLabel.setBounds( 262, 16, 110, 21 );
      itemsJLabel.setText( "Items in Your List:" );
      contentPane.add( itemsJLabel );
      
      // set up itemsJList and itemsJScrollPane
      itemsJList = new JList();
      itemsJScrollPane = new JScrollPane( itemsJList );
      itemsJScrollPane.setBounds( 262, 40, 112, 134 );
      contentPane.add( itemsJScrollPane );
      
      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 214, 184, 40, 23 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );
      
      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 262, 184, 112, 23 );
      totalJTextField.setHorizontalAlignment( JTextField.CENTER );
      totalJTextField.setEditable( false );
      contentPane.add( totalJTextField );
      
      // set properties of application's window
      setTitle( "Supply Cost Calculator" ); // set title bar string
      setSize( 398, 248 );                  // set window size
      setVisible( true );                   // display window
      
   } // end method createUserInterface
   
   // add shopping item to itemsJList
   private void addJButtonActionPerformed( ActionEvent event )
   {
      // Object array to hold user selection
      Object selectedValue[] = stockJList.getSelectedValues();

      // if there is at least one item selected
      if ( selectedValue.length != 0 )
      {
         for ( int counter = 0; counter < selectedValue.length;
               counter++ )
         {
            // add item to userArrayList
            userArrayList.add(
               ( String ) ( selectedValue[ counter ] ) );
         }

         // add item to itemsJList
         itemsJList.setListData( userArrayList.toArray() );

         // enable Calculate and Remove JButtons
         removeJButton.setEnabled( true );
         calculateJButton.setEnabled( true );
         
         totalJTextField.setText( "" ); // clear totalJTextField
      }
      else
      {
         // display message if there is no item selected
         JOptionPane.showMessageDialog( this,
            "Please select item to add", "Cannot Add",
            JOptionPane.ERROR_MESSAGE );
      }

      // clear selected index
      stockJList.clearSelection();

   } // end method addJButtonActionPerformed

   // remove shopping item from itemsJList
   private void removeJButtonActionPerformed( ActionEvent event )
   {
      // int array to hold user selection
      int[] selectedValue = itemsJList.getSelectedIndices();

      // if there is at least one item selected
      if ( selectedValue.length != 0 )
      {
         for ( int counter = 0; counter < selectedValue.length;
               counter++ )
         {
            // remove item at the selected index
            // subtract counter, to reset index based on
            // removals from previous iterations of the for loop
            userArrayList.remove(
               selectedValue[ counter ] - counter );
         }

         // reset data based on changes to ArrayList
         itemsJList.setListData( userArrayList.toArray() );
      }
      else
      {
         // display message if there is no item selected
         JOptionPane.showMessageDialog( this,
            "Please select item to remove", "Cannot Remove",
            JOptionPane.ERROR_MESSAGE );
      }

      // if there are no items remaining
      if ( userArrayList.size() < 1 )
      {
         // disable the Remove and Calculate JButtons
         removeJButton.setEnabled( false );
         calculateJButton.setEnabled( false );
      }

      totalJTextField.setText( "" ); // clear totalJTextField

   } // end method removeJButtonActionPerformed

   // calculate total price
   private void calculateJButtonActionPerformed( ActionEvent event )
   {

   } // end method calculateJButtonActionPerformed

   // main method
   public static void main( String[] args )
   {
      SupplyCalculator application = new SupplyCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class SupplyCalculator

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