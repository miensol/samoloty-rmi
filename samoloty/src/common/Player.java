package common;

import game.PlaneGame;

import java.io.Serializable;
import java.rmi.RemoteException;

import core.APlayer;
/**
 * Represents Player
 * @author Piotr
 *
 */
public class Player extends APlayer<Integer> implements Playing, Serializable {

	protected BasePlane plane;
	protected PlaneGame game;

	public Player(String nick, PlaneGame game) throws RemoteException {
		super(nick);
		this.plane = new BasePlane(nick);

	}

	public Piloting getPlane() throws RemoteException {
		return this.plane;
	}

	/**
	 * There should not be to Players with the same nick
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof Player)
				return ((Player) obj).getNick() == this.getNick();
		} catch (Exception e) {
			System.err.println("Error! " + e.getMessage());
		}

		return super.equals(obj);

	}
}
