// Exercise 8.13: OfficeSupplies.java
// Creates a list of office supplies to buy.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OfficeSupplies extends JFrame
{
   // JLabel and JTextField for inputting items
   private JLabel itemJLabel;
   private JTextField itemJTextField;

   // JTextArea and JScrollPane for displaying items to purchase
   private JTextArea outputJTextArea;
   private JScrollPane outputJScrollPane;

   // JButton to add item to list of items being purchased
   private JButton buyJButton;

   // JButton to clear list of items being purchased
   private JButton clearJButton;

   // no-argument constructor
   public OfficeSupplies()
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
      itemJLabel.setBounds( 16, 24, 35, 21 );
      itemJLabel.setText( "Item:" );
      contentPane.add( itemJLabel );
      
      // set up itemJTextField
      itemJTextField = new JTextField();
      itemJTextField.setBounds( 55, 24, 137, 21 );
      itemJTextField.setHorizontalAlignment( JTextField.LEFT );
      contentPane.add( itemJTextField );
      
      // set up outputJTextArea
      outputJTextArea = new JTextArea();
      outputJTextArea.setEditable( false );

      // set up outputJScrollPane
      outputJScrollPane = new JScrollPane( outputJTextArea );
      outputJScrollPane.setBounds( 16, 64, 176, 95 );
      contentPane.add( outputJScrollPane );
      
      // set up buyJButton
      buyJButton = new JButton();
      buyJButton.setBounds( 16, 176, 80, 24 );
      buyJButton.setText( "Buy" );
      contentPane.add( buyJButton );
      buyJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when buyJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                buyJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 112, 176, 80, 24 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when clearJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                clearJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set properties of application’s window
      setTitle( "Office Supplies" ); // set title bar text
      setSize( 218, 245 );           // set window's size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // called when user clicks buyJButton
   public void buyJButtonActionPerformed( ActionEvent event )
   {

   } // end method buyJButtonActionPerformed
   
   // called when user clicks clearJButton
   public void clearJButtonActionPerformed( ActionEvent event )
   {

   } // end method clearJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      OfficeSupplies application = new OfficeSupplies();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class OfficeSupplies

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
