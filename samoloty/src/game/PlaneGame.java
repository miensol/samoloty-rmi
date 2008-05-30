/**
 * 
 */
package game;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import common.Gaming;
import common.Player;

/**
 * @author Piotr
 * 
 */
public class PlaneGame extends Game implements Gaming {
	/**
	 * Contains an interface to this games
	 */
	protected Map<String, Player> players;
	protected String url;
	protected String name = "PlaneGame";

	public PlaneGame(String nick) throws RemoteException {

		super(nick);

		this.url = Game.URL_BASE + "/PlaneGame";

		// should it be placed in Game ?
		this.registry.rebind(this.name, this);

		// map with game players
		this.players = Collections
				.synchronizedMap(new HashMap<String, Player>());

	}

	@Override
	public void start() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Game started");
	}

	@Override
	public void stop() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Game stopped");
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
	public Player getPlayer(String nick) throws RemoteException {
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
	public Player getPlayer(Player player) throws RemoteException {
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
	public Player removePlayer(Player player) throws RemoteException {
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
	public Player removePlayer(String nick) throws RemoteException {
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
	public Player join(String nick) throws RemoteException {
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
}
