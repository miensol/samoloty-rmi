/**
 * 
 */
package core;

import java.rmi.RemoteException;

/**
 * Represents an abstract class of movable objects in a game
 * 
 * @author Piotr
 * 
 */
public abstract class Movable<T> extends MapElement<T> implements Moving<T> {

	protected T speedX;
	protected T speedY;
	protected T minSpeed;
	protected T maxSpeed;
	/***************************************************************************
	 * 
	 * @param px
	 *            initial x coordinate
	 * @param py
	 *            initial y coordinate
	 * @param pspeedX
	 *            initial horizontal speed
	 * @param pspeedY
	 *            initial vertical speed
	 */
	public Movable(T px, T py, T pspeedX, T pspeedY) throws RemoteException {
		super(px, py);
		this.speedX = pspeedX;
		this.speedY = pspeedY;
	}

	public T getSpeedX() {
		return speedX;
	}

	public void setSpeedX(T speedX) {
		this.speedX = speedX;
	}

	public T getSpeedY() {
		return speedY;
	}

	public void setSpeedY(T speedY) {
		this.speedY = speedY;
	}
	/*
	 * // @Override protected void move() { this.x+=this.speedX;
	 * this.y+=this.speedY; }
	 */
}
