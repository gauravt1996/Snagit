import java.rmi.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class desktop extends JFrame implements ActionListener
{
JButton b1,b2,b3,b4;
JLabel l1,l2,l3,l4;
Image im;
ImageIcon ic;
public desktop()
{

	super("Smart  Vedio Capture [Client Module]");

	try{
	Container cn=getContentPane();

	cn.setLayout(new GridLayout(2,2));
	b1=new JButton("User One");b1.setSize(10,10);
	b2=new JButton("User Two");b2.setSize(10,10);
	b3=new JButton("User Three");b3.setSize(10,10);
	b4=new JButton("User Four");b4.setSize(10,10);
   im=Toolkit.getDefaultToolkit().createImage("users.jpg");
   Icon ic=new ImageIcon(im);
   b1.setIcon(ic);
   b2.setIcon(ic);
   b3.setIcon(ic);
   b4.setIcon(ic);

cn.add(b1);
cn.add(b2);
cn.add(b3);
cn.add(b4);
b1.addActionListener(this);

setVisible(true);
setSize(500,500);
}catch(Exception e){}
}

public void actionPerformed(ActionEvent e)
{ if(e.getSource()==b1)
	{userdesk u=new userdesk("user1");
u.start();}
else if(e.getSource()==b2)
	{userdesk u=new userdesk("user2");
u.start();}
else if(e.getSource()==b3)
	{userdesk u=new userdesk("user3");
u.start();}
else if(e.getSource()==b4)
	{userdesk u=new userdesk("user4");
u.start();}

	}


class userdesk extends Thread
{  String u=new String();
   public userdesk(String u)
   {this.u=u;

	   }
	public void run()
		{
			while(true)
			{
		try
			{
				String url="rmi://127.0.0.1/"+u;
				infointf asin=(infointf)Naming.lookup(url);
				byte[] filedata=asin.screen();
				File file=new File("user.jpg");
				BufferedOutputStream output=new BufferedOutputStream(new FileOutputStream(file.getName()));
				output.write(filedata,0,filedata.length);
				output.flush();
				output.close();
				 im=Toolkit.getDefaultToolkit().createImage("user.jpg");

				ic=new ImageIcon(im);
				//System.out.println("dharmesh"+i+".jpg");

				b1.setIcon(ic);

				//im=new ImageIcon(im1);
				sleep(10);
			  }
			catch(Exception e)
			{
				System.out.println(e);
			}


}

	}}

public static void main(String[] s)
{
	desktop d=new desktop();
}
}