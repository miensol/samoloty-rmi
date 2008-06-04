/**
 * 
 */
package game;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
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
	public static String HOST = "rmi://localhost";
	public static String URL_BASE = Game.HOST + ":" + Game.PORT;

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

	protected void unbindAll() {
		try{
			for(String s:this.registry.list()){
				System.out.print("Unbinding : " + s );
				this.registry.unbind(s);
				System.out.println("\tDone!");
			}
		}catch(NotBoundException e){
			System.out.println("dziwaczny blad nie powinen sie pojawic");		
		}catch(AccessException e){
			System.out.println("Blad dostepu podczas usuwania obiektow z rejestru!");
			e.printStackTrace(System.out);
		}catch(RemoteException e){
			System.err.println("Ten blad nie moze wystapic");
			e.printStackTrace();
		}
	}
	@Override
	protected void finalize() throws Throwable {
		this.unbindAll();
		super.finalize();
	}
}
