import java.sql.*;
import  java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class SecurityRegistration extends JFrame implements ActionListener
{
     JLabel sname,sadd,sdob,spass,rpass,scont,sgender;
     JTextField t1,t2,t3,t6;
     JPasswordField t4,t5;
     JRadioButton rb1,rb2;
     ButtonGroup bg;
     JButton b1,b2;

    Container c;
	Icon ic2=new ImageIcon();
	BufferedImage image=null;
	GridBagLayout gb=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	Icon ic=new ImageIcon("bg.png");
    JLabel l= new JLabel (ic);

	public SecurityRegistration()
	{
		super("SECURITY REGISTRATION FORM");
		try {
			            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        image = ImageIO.read(this.getClass().getResource("1.png"));
			        } catch (Exception e) {
			            e.printStackTrace();
		        }

			   c=getContentPane();
			   c.setLayout(gb);

	   add(l);



		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

           sname=new JLabel("Name");
           t1=new JTextField(20);

           sadd=new JLabel("Address");
           t2=new JTextField(20);

           sdob=new JLabel("Date Of Birth");
           t3=new JTextField(20);

           spass=new JLabel("Password");
           t4=new JPasswordField(20);
           t4.setEchoChar('*');

           rpass=new JLabel("Re-Password");
           t5=new JPasswordField(20);
           t5.setEchoChar('*');

           scont=new JLabel("Contact No.");
           t6=new JTextField(20);

           sgender=new JLabel("Gender");
           bg=new ButtonGroup();
           rb1=new JRadioButton("Male",true);
           rb2=new JRadioButton("Female",false);
           bg.add(rb1);
           bg.add(rb2);

           b1=new JButton("Save");
           b2=new JButton("Exit");

            Font f2=new Font("Monotype Corsiva",Font.BOLD,20);
		    sname.setFont(f2);
		    sname.setBounds(125,150,200,30);
		    t1.setBounds(275,150,200,25);

            sadd.setFont(f2);
			sadd.setBounds(125,190,200,30);
		    t2.setBounds(275,190,200,25);

		    sdob.setFont(f2);
			sdob.setBounds(125,230,200,30);
		    t3.setBounds(275,230,200,25);

            spass.setFont(f2);
	        spass.setBounds(125,270,100,30);
	        t4.setBounds(275,270,200,25);

	        rpass.setFont(f2);
			rpass.setBounds(125,310,150,30);
	        t5.setBounds(275,310,200,25);

	        scont.setFont(f2);
			scont.setBounds(125,350,150,30);
	        t6.setBounds(275,350,200,25);

	        sgender.setFont(f2);
			sgender.setBounds(125,390,150,30);
	        rb1.setBounds(275,390,70,25);
	        rb2.setBounds(365,390,90,25);


     Font f3=new Font("Monotype Corsiva",Font.BOLD,25);
		    b1.setFont(f3);
		    b1.setBounds(125,480,120,25);
		    b2.setFont(f3);
            b2.setBounds(275,480,120,25);

                  	l.add(sname);
					l.add(t1);

					l.add(sadd);
					l.add(t2);

					l.add(sdob);
					l.add(t3);

					l.add(spass);
					l.add(t4);

					l.add(rpass);
					l.add(t5);

					l.add(scont);
					l.add(t6);

					l.add(sgender);
			        l.add(rb1);
					l.add(rb2);

					l.add(b1);

				    l.add(b2);

                    b1.addActionListener(this);
                    b2.addActionListener(this);

   t1.addKeyListener(new KeyAdapter()
   {
	  public void keyTyped(KeyEvent e)
	  {
			 char ch=e.getKeyChar();
		     if(!((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch==' ') ||(ch=='.')))
	     	 e.consume();
	  }
   });

	t2.addKeyListener(new KeyAdapter()
		{
		 	  public void keyTyped(KeyEvent e)
			  {
				    char ch=e.getKeyChar();
					if(!((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch==' ') ||(ch=='.') ||(ch=='/') ||(ch=='-') ||(ch>='0' && ch<='9')))
		     	   	e.consume();
			  }
	});

	t3.addKeyListener(new KeyAdapter()
			{
			 	  public void keyTyped(KeyEvent e)
				  {
					    char ch=e.getKeyChar();
						if(!((ch=='/') ||(ch=='-') ||(ch>='0' && ch<='9')))
			     	   	e.consume();
				  }
	});

	t6.addKeyListener(new KeyAdapter()
				{
				 	  public void keyTyped(KeyEvent e)
					  {
						    char ch=e.getKeyChar();
							if(!((ch=='-') ||(ch>='0' && ch<='9')))
				     	   	e.consume();
					  }
	});
}

		public void actionPerformed(ActionEvent o)
		{
         		if(o.getSource()==b1)
				{
				  String sname=t1.getText();
				  String sadd=t2.getText();
				  String sdob=t3.getText();
				  String spass=t4.getText();
                  String rpass=t5.getText();
				  String scont=t6.getText();
                  String sgender;
				  if(rb1.getText()!=null)
			   	  {
			   	      sgender=rb1.getText();
        			  }
			   	   else
			   	   {
					  sgender=rb2.getText();
                       }

				  if(sname.equals("")|| sadd.equals("") || sdob.equals("")|| spass.equals("") || rpass.equals("") || scont.equals("") || sgender.equals(""))
				  {
					   JOptionPane.showMessageDialog(null,"Please fill all entries"," Message",JOptionPane.WARNING_MESSAGE);
		          }
				  else
				  {
					try
					{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/network_monitoring","root","1234");
						Statement smt=cn.createStatement();
						if(spass.equals(rpass))
						{
							String query="Insert into securityreg(sname,sadd,sdob,sgender,spass,scont) values('"+sname+"','"+sadd+"','"+sdob+"','"+sgender+"','"+spass+"','"+scont+"')";
							int x=smt.executeUpdate(query);
							if (x>0)
							{
								JOptionPane.showMessageDialog(null,"Record inserted successfully with Name "+sname," Message",JOptionPane.WARNING_MESSAGE);
							}
							else
							{
								t1.requestFocus();
						        JOptionPane.showMessageDialog(null,"Please enter correct values"," Message",JOptionPane.WARNING_MESSAGE);
						    }


				        }
				        else
				        {
							JOptionPane.showMessageDialog(null,"Re-Password does not match"," Message",JOptionPane.WARNING_MESSAGE);
							 t4.setText("");
							t5.setText("");
						}

    					cn.close();
					}
      			   catch(Exception e)
				   {
						System.out.println(e);
						e.printStackTrace();
				   }
			   }
			}


				if(o.getSource()==b2)
				{
					dispose();
				}
}

	public static void main(String args[])
		{
		    	SecurityRegistration f=new SecurityRegistration();
		        f.setSize(700,700);
		        f.setResizable(false);
		    	f.setVisible(true);
		}

}
