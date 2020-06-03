import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.Robot.*;
import java.awt.image.*;
import java.awt.image.BufferedImage.*;
import com.sun.image.codec.jpeg.*;
public class infoimpl extends UnicastRemoteObject implements infointf
{
	Robot serverRobot;
	BufferedImage imgbuf;
	boolean flag=true;

public infoimpl()throws RemoteException

{
	}


	public byte[] screen() throws RemoteException
	{
		try
		{
			serverRobot=new Robot();
			imgbuf=serverRobot.createScreenCapture(new Rectangle(800,600));
			ByteArrayOutputStream outs=new ByteArrayOutputStream();
			JPEGImageEncoder jpe=com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(outs);

			jpe.encode(imgbuf);

			return outs.toByteArray();
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+e);
		}
		return null;
		}


	}


