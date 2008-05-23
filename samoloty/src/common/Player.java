package common;

import java.rmi.RemoteException;

import core.APlayer;

public class Player extends APlayer<Integer> implements Playing {

	protected BasePlane plane;
	
	public Player(String nick) throws RemoteException{
		super(nick);
		this.plane = new BasePlane(nick);
	}

	public BasePlane getPlane() throws RemoteException{
		return this.plane;
	}
	/**
	 * There should not be to Players with the same nick
	 */
	@Override
	public boolean equals(Object obj) {
		
		if( obj instanceof Player)
			return ((Player)obj).getNick() == this.getNick();
		
		return super.equals(obj);
	}
}
