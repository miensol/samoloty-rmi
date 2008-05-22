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
	public PlaneGame(String nick) throws RemoteException{
		super(nick);
		
		this.url = Game.URL_BASE + "/PlaneGame";
		// should place try catch here ?
		this.registry.rebind(this.url, this);	
	
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Gaming getGame(String url) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Player getPlayer(String nick) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
