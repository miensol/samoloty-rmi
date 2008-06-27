/**
 * 
 */
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

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
	void setScore(Integer s) throws RemoteException;
	Piloting getPlane() throws RemoteException;
	public Date getLastSeen() throws RemoteException;
	public void setLastSeen(Date d) throws RemoteException;
}
