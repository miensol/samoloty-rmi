/**
 * 
 */
package common;

import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 * Represents methods that can be called locally and remotely
 * 
 * @author Piotr
 * 
 */
public interface Gaming extends Remote {
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
	 * Finds Game object in a remote location specified in gameUrl Should be
	 * implemented as static method of a Game
	 * 
	 * @param gameUrl
	 *            full address of a Game server
	 * @return Gaming interface
	 * @throws RemoteException
	 */
	Gaming getGame(String url) throws RemoteException;

	void start() throws RemoteException;

	void stop() throws RemoteException;
	/*
	Playing next() throws RemoteException;
	boolean hasNext() throws RemoteException;*/
	
	boolean isStopped() throws RemoteException;
	boolean isWaitForPlayers() throws RemoteException;
	
	int getPlayerCount() throws RemoteException;
	
	void sendEvent(String nick,KeyEvent e) throws RemoteException;
	
	Vector<BaseWeapon> getBullets() throws RemoteException;
	Map<String,Playing> getPlayers() throws RemoteException;
	Vector<Point> getBulletsCoords() throws RemoteException;
}
