/**
 * 
 */
package core;

/**
 * Represents an object having coordinates
 * 
 * @author Piotr
 * 
 */
public abstract class MapElement<T> {
	
	protected T x;
	protected T y;

	public MapElement(T x, T y) {
	
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

	
}