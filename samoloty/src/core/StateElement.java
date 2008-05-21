/**
 * 
 */
package core;

/**
 * Represents an object having state and coordinates
 * 
 * @author Piotr
 * 
 */
public abstract class StateElement<T> {
	/**
	 * Represents all states that object can have
	 * @author Piotr
	 *
	 */
	protected static enum State  {
		Exists
	};
	protected State state;
	protected T x;
	protected T y;

	public StateElement(State state, T x, T y) {
		this.state = state;
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
