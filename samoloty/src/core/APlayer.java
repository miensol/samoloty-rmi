/**
 * 
 */
package core;

/**
 * Represents basic information about player
 * @param <T> represents type of player's score 
 * @author Piotr
 *
 */
public abstract class APlayer <T>{
	protected String nick;
	
	protected T score;
	
	protected String url;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public T getScore() {
		return score;
	}

	public void setScore(T score) {
		this.score = score;
	}
}
