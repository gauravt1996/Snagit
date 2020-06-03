import java.rmi.*;
import java.rmi.server.*;
public interface infointf extends Remote
{
	public byte[] screen()throws RemoteException,IllegalArgumentException;

}