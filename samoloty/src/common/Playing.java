/**
 * 
 */
package common;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Its not pretty should be fixed in future
 * @author Piotr
 *
 */
public interface Playing extends Remote {
	String getNick()
		throws RemoteException;
	void setNick(String nick)
		throws RemoteException;
	// this method isn't pretty written here
	Integer getScore()
		throws RemoteException;
	BasePlane getPlane()
		throws RemoteException;
	
}
