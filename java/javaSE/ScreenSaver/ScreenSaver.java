import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenSaver extends JFrame
{
	// JButton to clear drawingJPanel
   private JButton clearJButton;

   // DrawJPanel for displaying rectangles
   private DrawJPanel drawingJPanel;

   // no-argument constructor
   public ScreenSaver()
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

	      // set up clearJButton
	      clearJButton = new JButton();
	      clearJButton.setBounds( 189, 16, 72, 23 );
	      clearJButton.setText( "Clear" );
	      contentPane.add( clearJButton );
	      clearJButton.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // method called when clearJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	               clearJButtonActionPerformed( event );
	            }
	            
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener

	      // set up drawingJPanel
	      drawingJPanel = new DrawJPanel();
	      drawingJPanel.setBounds( 0, 40, 450, 450 );
	      contentPane.add( drawingJPanel );

	      // set properties of application's window
	      setTitle( "Screen Saver" ); // set title bar text
	      setSize( 500, 500 );        // set window size
	      setVisible( true );         // display window
   }
   
   private void clearJButtonActionPerformed( ActionEvent event )
   {
      drawingJPanel.clear();

   } // end method clearJButtonActionPerformed


	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		ScreenSaver application = new ScreenSaver();
	    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


	}

}
