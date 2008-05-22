package common;

import java.rmi.RemoteException;

import core.APlayer;

public class Player extends APlayer<Integer> {

	public Player(String nick) throws RemoteException{
		super(nick);
	}
}
