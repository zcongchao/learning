// Fig. 22.13 Painter.java
// Application enables user to paint objects and name them.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Painter extends JFrame
{
   // JMenuBar to hold paint and text options
   private JMenuBar painterJMenuBar;
   
   // JMenu to holds paint and text options
   private JMenu paintJMenu;
   private JMenu textJMenu;

   // JMenuItems and JMenu allow user to change application colors
   private JMenuItem paintColorJMenuItem;
   private JMenu paintSizeJMenu;
   
   // array of JRadioButtonMenuItems and ButtonGroup for different
   // paint size options
   private JRadioButtonMenuItem paintSizeItems[];
   private ButtonGroup paintSizeButtonGroup;
   
   // JMenuItems and JMenu allow user to change text properties
   private JMenuItem textColorJMenuItem;
   private JMenu formatJMenu;

   // JMenus allow user to format text
   private JMenu styleJMenu;
   private JMenu sizeJMenu;
   
   // JRadioButtonMenuItems, ButtonGroup and JCheckBoxMenuItems
   // display style and size options
   private JCheckBoxMenuItem styleItems[];
   private JRadioButtonMenuItem sizeItems[];
   private ButtonGroup sizeButtonGroup;

   // JTextArea for user to type in and Font of the JTextArea
   private JTextArea displayJTextArea;
   private Font displayFont;

   // PainterJPanel to allow user to paint with mouse
   private PainterJPanel myPainterJPanel;
   
   // String array to hold paint size options
   private final String paintSizes[] = { "4", "6", "8", "10" };

   // String array to hold font style options
   private final String styles[] = { "Bold", "Italic" }; 

   // String array to hold font size options
   private final String fontSizes[] = { "12", "16", "20" };

   // no-argument constructor
   public Painter()
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
      
      // set up painterJMenuBar
      painterJMenuBar = new JMenuBar();
      setJMenuBar( painterJMenuBar );      
      
      // set up paintColorJMenuItem
      paintColorJMenuItem = new JMenuItem();          
      paintColorJMenuItem.setText( "Paint Color..." );
      paintColorJMenuItem.setMnemonic( KeyEvent.VK_C );
      paintJMenu.add( paintColorJMenuItem );
      paintColorJMenuItem.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when paintColorJMenuItem
            // is selected
            public void actionPerformed( ActionEvent event )
            {
               paintColorJMenuItemActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
            
      // set up paintSizeJMenu
      paintSizeJMenu = new JMenu();                             
      paintSizeJMenu.setText( "Paint Size" );
      paintSizeJMenu.setMnemonic( KeyEvent.VK_S );
      paintJMenu.add( paintSizeJMenu );

      // set up paintSizeItems
      paintSizeItems = new JRadioButtonMenuItem[ paintSizes.length ];
      paintSizeButtonGroup = new ButtonGroup();
      
      for ( int count = 0; count < paintSizes.length; count ++ )
      {
         paintSizeItems[ count ] = 
            new JRadioButtonMenuItem( paintSizes[ count ] );
         paintSizeJMenu.add( paintSizeItems[ count ] );
         paintSizeButtonGroup.add( paintSizeItems[ count ] );
         paintSizeItems[ count ].addActionListener( 
         
            new ActionListener() // anonymous inner class
            {
               // event handler called when a sizeItem is selected
               public void actionPerformed( ActionEvent event )
               {
                  sizeJMenuActionPerformed( event );
               }
               
            } // end anonymous inner class
            
         ); // end call to addActionListener
      
      } // end for     
      
      // set up textColorJMenuItem
      textColorJMenuItem = new JMenuItem();         
      textColorJMenuItem.setText( "Text Color..." );
      textColorJMenuItem.setMnemonic( KeyEvent.VK_C );
      textJMenu.add( textColorJMenuItem );
      textColorJMenuItem.addActionListener(
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when textColorJMenuItem
            // is selected
            public void actionPerformed( ActionEvent event )
            {
               textColorJMenuItemActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set up formatJMenu
      formatJMenu = new JMenu();      
      formatJMenu.setText( "Format" );
      formatJMenu.setMnemonic( KeyEvent.VK_F );
      textJMenu.add( formatJMenu );   
      
      // set up styleJMenu
      styleJMenu = new JMenu();     
      styleJMenu.setText( "Style" );
      styleJMenu.setMnemonic( KeyEvent.VK_S );
      formatJMenu.add( styleJMenu );

      // set up styleItems
      styleItems = new JCheckBoxMenuItem[ styles.length ];

      for ( int count = 0; count < styleItems.length; count++ )
      {
         styleItems[ count ] = new JCheckBoxMenuItem(
            styles[ count ] );                   
         styleJMenu.add( styleItems[ count ] );      
         styleItems[ count ].addItemListener(        

            new ItemListener() // anonymous inner class
            {
               // event handler called when a style item is selected
               public void itemStateChanged( ItemEvent event )   
               {
                  styleItemsStateChanged( event );
               }

            } // end anonymous inner class

         ); // end call to addItemListener

      } // end for

      // set up sizeJMenu
      sizeJMenu = new JMenu();     
      sizeJMenu.setText( "Size" ); 
      sizeJMenu.setMnemonic( KeyEvent.VK_Z );
      formatJMenu.add( sizeJMenu );

      // set up sizeItems
      sizeItems = new JRadioButtonMenuItem[ fontSizes.length ];
      sizeButtonGroup = new ButtonGroup();

      for ( int count = 0; count < sizeItems.length; count++ )
      {
         sizeItems[ count ] = new JRadioButtonMenuItem(
            fontSizes[ count ] );                      
         sizeJMenu.add( sizeItems[ count ] );      
         sizeButtonGroup.add( sizeItems[ count ] );     
         sizeItems[ count ].addActionListener(         

            new ActionListener()  // anonymous inner class 
            {
               // event handler called when a sizeItem is selected                    
               public void actionPerformed( ActionEvent event )
               {
                  fontSizeItemsActionPerformed( event );        
               }

            } // end anonymous inner class  

         ); // end call to addActionListener

      } // end for
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 16, 16, 300, 75 );
      displayJTextArea.setLineWrap( true );
      displayFont = displayJTextArea.getFont();
      contentPane.add( displayJTextArea );
      
      // set up myPainterJPanel
      myPainterJPanel = new PainterJPanel( Color.BLACK, 8 );
      myPainterJPanel.setBounds( 16, 100, 300, 200 );
      contentPane.add( myPainterJPanel );

      // set properties of application's window
      setTitle( "Painter" ); // set title bar string
      setSize( 340, 350 );   // set window size
      setVisible( true );    // display window

   } // end method createUserInterface
   
   // change the painting color
   private void paintColorJMenuItemActionPerformed( 
      ActionEvent event )
   {

   } // end method paintColorJMenuItemActionPerformed
   
   // method to change the text color       
   private void textColorJMenuItemActionPerformed( 
      ActionEvent event )                          
   {
      Color textColor = JColorChooser.showDialog( 
         this, "Choose a color", displayJTextArea.getForeground() );
       
      // set text color
      if ( textColor != null )   
      {
         displayJTextArea.setForeground( textColor ); 
      }
      
   } //  end method textItemActionPerformed

   // update the font style
   private void styleItemsStateChanged( ItemEvent event )
   {
      int style = Font.PLAIN;

      // check for bold selection
      if ( styleItems[ 0 ].isSelected() )
      {
         style += Font.BOLD;
      }

      // check for italic selection
      if ( styleItems[ 1 ].isSelected() )
      {
         style += Font.ITALIC;
      }

      // create a new Font with the specified style
      displayFont = new Font( displayFont.getName(), style, 
         displayFont.getSize() );

      displayJTextArea.setFont( displayFont ); // set the font

   } // end method styleItemsStateChanged     

   // update the font size
   private void fontSizeItemsActionPerformed( ActionEvent event )
   {

   } // end method sizeItemsActionPerformed

   // change the painting size
   private void sizeJMenuActionPerformed( ActionEvent event)
   {
      JRadioButtonMenuItem sizeMenuItem = 
         ( JRadioButtonMenuItem ) event.getSource();

      myPainterJPanel.setDiameter( Integer.parseInt( 
         sizeMenuItem.getText() ) );

   } // end method sizeJMenuActionPerformed

   // main method
   public static void main( String[] args )
   {
      Painter application = new Painter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Painter

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