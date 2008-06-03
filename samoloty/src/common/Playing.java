/**
 * 
 */
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Its not pretty should be fixed in future
 * 
 * @author Piotr
 * 
 */
public interface Playing extends Remote {
	String getNick() throws RemoteException;

	void setNick(String nick) throws RemoteException;

	// this method isn't pretty written here
	Integer getScore() throws RemoteException;

	Piloting getPlane() throws RemoteException;

}
