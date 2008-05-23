/**
 * 
 */
package core;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 * Represents an object having coordinates
 * 
 * @author Piotr
 * 
 */
public abstract class MapElement<T> extends UnicastRemoteObject{
	
	protected T x;
	protected T y;

	public MapElement(T x, T y) throws RemoteException {
	
		this.x = x;
		this.y = y;
	}

	public T getX() throws RemoteException{
		return x;
	}

	public void setX(T x)  throws RemoteException{
		this.x = x;
	}

	public T getY()  throws RemoteException{
		return y;
	}

	public void setY(T y)  throws RemoteException{
		this.y = y;
	}

	
}
