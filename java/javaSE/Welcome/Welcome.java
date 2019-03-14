// Tutorial 2: Welcome.java
// This application welcomes the user to Java programming.
import java.awt.*;
import javax.swing.*;

public class Welcome extends JFrame
{
	private JLabel textJLabel;
	private JLabel pictureJLabel;
	
	//无参构造函数
	public Welcome()
	{
		createUserInterface();
	}
	
	//事件控件
	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setLayout(null);
		
		//set up textJLabel
		textJLabel = new JLabel();
		textJLabel.setText("Welcome to Java Programming!" );
		textJLabel.setLocation( 35, 0 );
		textJLabel.setSize( 550, 88 );
		textJLabel.setFont( new Font( "SansSerif", Font.PLAIN, 36 ) );
		textJLabel.setHorizontalAlignment( JLabel.CENTER );
		contentPane.add(textJLabel);
		
		//set up pictureJLabel
		pictureJLabel = new JLabel();
		pictureJLabel.setIcon(new ImageIcon("bug.png"));
		pictureJLabel.setBounds( 54, 120, 500, 250 );
		pictureJLabel.setHorizontalAlignment( JLabel.CENTER );
		contentPane.add(pictureJLabel);
		
		//set properties of application's window
		setTitle("welcome");
		setSize( 608, 413 );   // set width and height of JFrame
	    setVisible( true );  
		
		
		
	}
	
	//主函数
	public static void main(String[] args)
	{
		Welcome application = new Welcome();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
}

