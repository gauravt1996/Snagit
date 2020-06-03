import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AdminHome implements ActionListener
{
	Container c;
	BufferedImage image=null;
	Icon ic2=new ImageIcon("1.png");
	GridBagLayout gb=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	Icon ic=new ImageIcon("home.png");
	JLabel l=new JLabel(ic);

	public AdminHome()
	{
		System.out.println("Hello........Admin");

		JFrame frame=new JFrame("Admin Home Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menubar=new JMenuBar();
		JMenu filemenu=new JMenu("File");
		filemenu.add(new JSeparator());
		JMenuItem fileItem1=new JMenuItem("Security Registration");
		fileItem1.add(new JSeparator());
		JMenuItem fileItem2=new JMenuItem("Exit");
		fileItem2.add(new JSeparator());

		filemenu.add(fileItem1);
		filemenu.add(fileItem2);
		fileItem1.addActionListener(this);
		fileItem2.addActionListener(this);
		menubar.add(filemenu);

		frame.setJMenuBar(menubar);
		frame.setSize(700,700);
		frame.setResizable(true);
		frame.setVisible(true);
		}
		public void actionPerformed(ActionEvent a)
		{
			String arg=(String)a.getActionCommand();
			if(arg.equals("Security Registration"))
			{
				SecurityRegistration f=new SecurityRegistration();
				f.setSize(700,700);
				f.setVisible(true);
				}
			else if(arg.equals("Exit"))
			{
				System.exit(0);
				}
			}
		public static void main(String args[])
		{
			AdminHome a=new AdminHome();
			}
	}