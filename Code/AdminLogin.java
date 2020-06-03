import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



class AdminLogin extends JFrame implements ActionListener
{
	JLabel title,uname,pwd;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;

	Container c;
	BufferedImage image=null;
	GridBagLayout gb=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	Icon ic=new ImageIcon("bg2.jpg");
	JLabel l=new JLabel(ic);


	public AdminLogin()
	{
		super("ADMIN LOGIN FORM");

		c=getContentPane();
		c.setLayout(gb);
		c.add(l);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		title=new JLabel("Admin Login Form");
		uname=new JLabel("USER NAME");

		t1=new JTextField(20);
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char ch=e.getKeyChar();
				if(!((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')||(ch=='@')||(ch=='.')))
				e.consume();
				}
			});

			pwd=new JLabel("PASSWORD");
			t2=new JPasswordField(20);
			t2.setEchoChar('.');
			t2.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					char ch=e.getKeyChar();
					if(!((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')))
					e.consume();
					}
			});

			b1=new JButton("Login");
			b2=new JButton("Security Login");
			Font f=new Font("Monotype Corsiva",Font.BOLD,35);
			title.setFont(f);
			title.setForeground(Color.cyan);
			title.setBounds(380,120,600,100);

			Font f2=new Font("Monotype Corsiva",Font.BOLD,35);
			uname.setFont(f2);
			uname.setForeground(Color.red);
			uname.setBounds(265,280,300,35);
			t1.setBounds(510,280,220,30);

			pwd.setFont(f2);
			pwd.setForeground(Color.red);
			pwd.setBounds(265,350,300,35);
			t2.setBounds(510,350,220,30);

			Font f3=new Font("Monotype Corsiva",Font.BOLD,25);
			b1.setFont(f3);
			b2.setFont(f3);
			b1.setBounds(320,420,110,55);
			b2.setBounds(510,420,220,55);

			l.add(title);
			l.add(uname);
			l.add(t1);
			l.add(pwd);
			l.add(t2);
			l.add(b1);
			l.add(b2);

			b1.addActionListener(this);
			b2.addActionListener(this);

			setSize(1000,700);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent o)
		{
			if(o.getSource()==b1)
			{
				String aid=t1.getText();
				String pass=t2.getText();
				try
				{
					if(aid.equals("admin")&&pass.equals("admin"))
					{
						JOptionPane.showMessageDialog(null,"W E L C O M E","Message",JOptionPane.WARNING_MESSAGE);
						AdminHome a=new AdminHome();

						this.dispose();
						}
						else
						{
							t2.setText(null);
							JOptionPane.showMessageDialog(null,"U N A U T H O R I S E D     U S E R","Message",JOptionPane.WARNING_MESSAGE);
							}
					}
				catch(Exception e)
				{
					System.out.println(e);
					}
				}
				if(o.getSource()==b2)
				{
					SecurityLogin sl=new SecurityLogin();
					}
			}
			public static void main(String args[])
			{
				AdminLogin f=new AdminLogin();
				f.setSize(1000,700);
				f.setResizable(false);
				f.setVisible(true);
				}
	}