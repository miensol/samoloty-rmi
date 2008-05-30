/**
 * 
 */
package core;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Template of an interface of flying objects
 * 
 * @param U
 *            sets type of angle
 * @param T
 *            sets type of coordinates
 * @author Piotr
 * 
 */
public interface Flying<U, T> extends Moving<T>, Remote {
	void setAngle(U angle) throws RemoteException;

	U getAngle() throws RemoteException;;

	void turnLeft(U angle) throws RemoteException;

	void turnRight(U angle) throws RemoteException;
}
