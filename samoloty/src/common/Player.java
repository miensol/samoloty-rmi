package common;

import game.PlaneGame;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

import core.APlayer;
/**
 * Represents Player
 * @author Piotr
 *
 */
public class Player extends APlayer<Integer> implements Playing, Serializable {

	protected BasePlane plane;
	protected PlaneGame game;
	protected Date lastSeen;
	public Player(String nick, PlaneGame game) throws RemoteException {
		super(nick);
		this.plane = new BasePlane(nick);
		this.score = 0;
	}

	public Piloting getPlane() throws RemoteException {
		return this.plane;
	}
	public Date getLastSeen() throws RemoteException{
		return this.lastSeen;
	}
	public void setLastSeen(Date d) throws RemoteException{
		this.lastSeen = d;
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
	@Override
	public void setScore(Integer s) throws RemoteException {
		// TODO Auto-generated method stub
		this.score = s;
	}
}
