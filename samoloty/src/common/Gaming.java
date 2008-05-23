/**
 * 
 */
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Represents methods that can be called locally and remotely 
 * 
 * @author Piotr
 *
 */
public interface Gaming extends Remote {
	/**
	 * 
	 * @param nick players name
	 * @return as for now its Player, should be changed to interface Playing/Player
	 * @throws RemoteException 
	 */
	Player getPlayer(String nick)
		throws RemoteException;
	Player getPlayer(Player nick)
		throws RemoteException;
	Player removePlayer(Player player) 
		throws RemoteException;
	Player removePlayer(String nick) 
		throws RemoteException;
	Player join(String nick)
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
	void start()
		throws RemoteException;
	void stop()
		throws RemoteException;
}
