package core;

import java.rmi.Remote;
import java.rmi.RemoteException;
/***
 * Interface template of movable object in game
 * @author Piotr
 * 
 * @param <T> type of coordinates and speed
 */
public interface Moving <T> extends Remote{
	T getX()
		throws RemoteException;
	T getY()
		throws RemoteException;
	void setX(T x)
		throws RemoteException;
	void setY(T y)
		throws RemoteException;
	T getSpeedX()
		throws RemoteException;
	void setSpeedX(T speed)
		throws RemoteException;
	T getSpeedY()
		throws RemoteException;
	void setSpeedY(T speed)
		throws RemoteException;
	/**
	 * performs of object, affects coordinates
	 */
		void move()
	throws RemoteException;
}
