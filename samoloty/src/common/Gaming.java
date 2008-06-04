/**
 * 
 */
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * Represents methods that can be called locally and remotely
 * 
 * @author Piotr
 * 
 */
public interface Gaming extends Remote, Iterable<Map.Entry<String, Playing>> {
	/**
	 * 
	 * @param nick
	 *            players name
	 * @return as for now its Player, should be changed to interface
	 *         Playing/Player
	 * @throws RemoteException
	 */
	Playing getPlayer(String nick) throws RemoteException;

	Playing getPlayer(Player nick) throws RemoteException;

	Playing removePlayer(Player player) throws RemoteException;

	Playing removePlayer(String nick) throws RemoteException;

	Playing join(String nick) throws RemoteException;

	/**
	 * Finds Game object in a remote location specified in url Should be
	 * implemented as static method of a Game
	 * 
	 * @param url
	 *            full address of a Game server
	 * @return Gaming interface
	 * @throws RemoteException
	 */
	Gaming getGame(String url) throws RemoteException;

	void start() throws RemoteException;

	void stop() throws RemoteException;
}
