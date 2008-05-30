/**
 * 
 */
package game;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Represents server of a game, creates registry doesn't create any service
 * 
 * @author Piotr
 * 
 */
public class Game extends UnicastRemoteObject {
	/**
	 * 
	 */
	protected Registry registry;
	protected SecurityManager securtityManager;
	/**
	 * Game owner's nick
	 */
	protected String nick;
	public final static int PORT = 10002;
	public final static String HOST = "rmi://localhost";
	public final static String URL_BASE = Game.HOST + ":" + Game.PORT;

	/**
	 * Create game
	 * 
	 * @throws RemoteException
	 */
	public Game(String nick) throws RemoteException {
		this.nick = nick;
		this.checkSecurityManager();
		this.registry = this.createRegistry();
	}

	/**
	 * Checks whatever SecurityManager has been set
	 */
	private void checkSecurityManager() {
		if (System.getSecurityManager() == null) {
			this.securtityManager = new RMISecurityManager();
			System.setSecurityManager(this.securtityManager);
		} else
			this.securtityManager = System.getSecurityManager();
	}

	protected Registry createRegistry() throws RemoteException {

		if (LocateRegistry.getRegistry(Game.PORT) == null) {
			LocateRegistry.createRegistry(Game.PORT);
		}

		return LocateRegistry.getRegistry(Game.PORT);
	}

}
