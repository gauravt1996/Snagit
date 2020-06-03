import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
public class infoserver
{
	public static void main(String arg[])throws Exception
	{
		try{
			infoimpl x=new infoimpl();
			System.out.println("Initializing server.........");
			Naming.rebind("user1",x);
			System.out.println("user1 is registered");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
