/**
 * 
 */
package game;

import java.rmi.RemoteException;

import common.Gaming;
import common.Player;

/**
 * @author Piotr
 *
 */
public class PlaneGame extends Game implements Gaming{
	/**
	 * Contains an interface to this games
	 */
	
	protected String url; 
	protected String name = "PlaneGame";
	public PlaneGame(String nick) throws RemoteException{
		super(nick);
		
		this.url = Game.URL_BASE + "/PlaneGame";
		
		// should place try catch here ?
		this.registry.rebind(this.name, this);	
	
	}
	
	@Override
	public void start() throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("Game started");
	}
	
	@Override
	public void stop() throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("Game stopped");
	}
	
	@Override
	public Gaming getGame(String url) throws RemoteException {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public Player getPlayer(String nick) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "PlaneGame adress: " + this.url + " Owner: " +this.nick;	
	}
}
