/**
 * 
 */
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Represents methods that can be called locally and remotely 
 * that class Game should implement
 * @author Piotr
 *
 */
public interface Gaming extends Remote {
	/**
	 * 
	 * @param nick players name
	 * @return as for now its Player, should be changed to interface Playing
	 * @throws RemoteException when player with nick can't be found
	 */
	Player getPlayer(String nick)
		throws RemoteException;
	/**
	 * Finds Game object in a remote location specified in url
	 * Should be implemented as static method of a Game
	 * @param url full address of a Game server 
	 * @return Gaming interface 
	 * @throws RemoteException
	 */
	Gaming getGame(String url)
		throws RemoteException;
	void start();
	void stop();
}
