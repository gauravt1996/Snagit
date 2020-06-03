import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class SecurityLogin extends JFrame implements ActionListener
{
	JLabel title,uname,pwd;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;

	Container c;
	BufferedImage image=null;
	GridBagLayout gb=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	Icon ic=new ImageIcon("sbg.jpg");
	JLabel l=new JLabel(ic);


	public SecurityLogin()
	{
		super("SECURITY LOGIN FORM");

		c=getContentPane();
		c.setLayout(gb);
		c.add(l);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		title=new JLabel("Security Login Form");
		uname=new JLabel("USER NAME");

		t1=new JTextField(20);
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char ch=e.getKeyChar();
				if(!((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')||(ch==' ')))
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
			b2=new JButton("Admin Login");
			Font f=new Font("Monotype Corsiva",Font.BOLD,35);
			title.setFont(f);
			title.setForeground(Color.cyan);
			title.setBounds(380,160,600,100);

			Font f2=new Font("Monotype Corsiva",Font.BOLD,35);
			uname.setFont(f2);
			uname.setForeground(Color.white);
			uname.setBounds(265,280,300,35);
			t1.setBounds(510,280,220,30);

			pwd.setFont(f2);
			pwd.setBounds(265,350,300,35);
			pwd.setForeground(Color.white);
			t2.setBounds(510,350,220,30);

			Font f3=new Font("Monotype Corsiva",Font.BOLD,25);
			b1.setFont(f3);
			b2.setFont(f3);
			b1.setBounds(350,420,110,55);
			b2.setBounds(510,420,170,55);

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
				String sname=t1.getText();
				String pass=t2.getText();
				try
				{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/network_monitoring","root","1234");
						Statement smt=cn.createStatement();
						String q="select * from securityreg where sname='"+sname+"'and spass='"+pass+"'";
						ResultSet rs=smt.executeQuery(q);
					if(rs.next())
					{

						JOptionPane.showMessageDialog(null,"W E L C O M E","Message",JOptionPane.WARNING_MESSAGE);
						desktop s=new desktop();

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
					AdminLogin al=new AdminLogin();
					}
			}
			public static void main(String args[])
			{
				SecurityLogin f=new SecurityLogin();
				f.setSize(1000,700);
				f.setResizable(false);
				f.setVisible(true);
				}
	}