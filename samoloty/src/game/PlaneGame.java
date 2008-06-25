/**
 * 
 */
package game;

import java.awt.Event;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import common.Gaming;
import common.Piloting;
import common.Player;
import common.Playing;

/**
 * @author Piotr
 * 
 */
public class PlaneGame extends Game implements Gaming,
		Iterable<Map.Entry<String, Playing>>,
		Runnable {
	/**
	 * Contains an interface to this games
	 */
	protected Map<String, Playing> players;
	protected String url;
	protected String name = "PlaneGame";
	protected Thread actions;
	private boolean stopped = true;
	protected boolean waitForPlayers = true;
	public PlaneGame(String nick) throws RemoteException {

		super(nick);

		this.url = Game.URL_BASE + "/PlaneGame";

		// should it be placed in Game ?
		this.registry.rebind(this.name, this);

		// map with game players
		this.players = Collections
				.synchronizedMap(new HashMap<String, Playing>());
		
		
	}

	@Override
	public Iterator<Entry<String, Playing>> iterator() {
		return this.players.entrySet().iterator();
	}
	

	@Override
	public void start() throws RemoteException {
		// TODO Auto-generated method stub
		this.waitForPlayers = false;
		if( this.actions !=null && this.actions.isAlive() )
			throw new RemoteException("Gra zostala juz rozpoczeta");
		this.stopped = false;
		this.actions = new Thread(this);
		this.actions.start();
		System.out.println("Game started");
		
		
	}

	@Override
	public void stop() throws RemoteException {
		// TODO Auto-generated method stub
		this.stopped = true;
		//this.actinos.interrupt();
		//this.unbindAll();
		System.out.println("Game stopped");
		this.waitForPlayers = true;
	}

	@Override
	public Gaming getGame(String url) throws RemoteException {
		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * Returns Player if player with nick exists otherwise null
	 */
	@Override
	public Playing getPlayer(String nick) throws RemoteException {
		return this.players.get(nick);
	}

	/**
	 * If possible use
	 * 
	 * @see {@link PlaneGame} getPlayer(String nick)
	 * @param player
	 * @return Player if found
	 * @throws RemoteException
	 */
	public Playing getPlayer(Player player) throws RemoteException {
		return this.players.get(player);
	}

	/**
	 * Removes player from game
	 * 
	 * @param player
	 *            to remove
	 * @return removed player or null if such didn't exist
	 * @throws RemoteException
	 */
	public Playing removePlayer(Player player) throws RemoteException {
		System.out.println("Player " + player.getNick() + " quited the game!");
		this.unbindPlayer(nick);
		return this.players.remove(player.getNick());
	}

	/**
	 * Removes player from game
	 * 
	 * @param nick
	 *            of player to remove from game
	 * @return removed player or null if such didn't exist
	 * @throws RemoteException
	 */
	public Playing removePlayer(String nick) throws RemoteException {
		System.out.println("Player " + nick + " quited the game!");
		this.unbindPlayer(nick);
		return this.players.remove(nick);
	}

	private void unbindPlayer(String nick) throws RemoteException {
		try {
			this.registry.unbind(nick + "/plane");
			this.registry.unbind(nick);
		} catch (NotBoundException e) {
			System.err.println("Error while unbind player " + nick);
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (AccessException e) {
			System.err.println("Error while unbind player " + nick);
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public int getPlayerCount() throws RemoteException {
		return this.players.size();
	}
	@Override
	public Playing join(String nick) throws RemoteException {
		if (nick == null || this.players.containsKey(nick))
			throw new RemoteException("Player with nick " + nick
					+ " already exists");

		Player newPlayer = new Player(nick, this);

		this.registry.rebind(nick, newPlayer);
		// as for now adding plane is here, I guess it should be placed in
		// Player constructor
		this.registry.rebind(nick + "/plane", newPlayer.getPlane());
		System.out.println("Player " + nick + " joined the game!");
		return this.players.put(nick, newPlayer);
	}

	@Override
	public String toString() {
		return "PlaneGame adress: " + this.url + " Owner: " + this.nick;
	}

	public void moveAll() throws RemoteException {
		//System.out.println("Jestem w moveAll!");
		for(Map.Entry<String, Playing> k : this ){
			System.out.println("Ruszam gracza : " + k.getKey());
			Piloting plane = k.getValue().getPlane();
			plane.move();
		}
	}
	@Override
	public void run() {
		try{
			
			do{
				Thread.sleep(500);
				this.moveAll();
			}while(!this.stopped);
			
		}catch(InterruptedException e){
			System.out.println("Watek actions w Grze zostal zatrzymany!");
		}catch( RemoteException e){
			System.err.println("Dziwaczny blad nie powinien sie pojawic");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @return the stopped
	 */
	public boolean isStopped() {
		return stopped;
	}

	/**
	 * @return the waitForPlayers
	 */
	public boolean isWaitForPlayers() {
		return waitForPlayers;
	}
	
	@Override
	public void sendEvent(String nick, Event e) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
