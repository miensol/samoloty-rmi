/**
 * 
 */
package core;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Represents basic information about player
 * @param <T> represents type of player's score 
 * @author Piotr
 *
 */
public abstract class APlayer <T> extends UnicastRemoteObject{
	protected String nick;
	
	protected T score;
	
	protected String url;

	public APlayer(String nick) throws RemoteException {
		this.nick = nick;
	}
	public String getNick() throws RemoteException {
		return nick;
	}

	public void setNick(String nick)throws RemoteException {
		this.nick = nick;
	}

	public T getScore() throws RemoteException{
		return score;
	}

	public void setScore(T score) throws RemoteException{
		this.score = score;
	}
	
}
